package org.example.Projects.Restaurant.Repo;


import org.example.Projects.Restaurant.Payment.Payment;
import org.example.Projects.Restaurant.inter.DiscountStrategy;
import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.model.Bill;
import org.example.Projects.Restaurant.model.Order;
import org.example.Projects.Restaurant.model.Table;


import java.util.UUID;

public class RestaurantService {
    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;

    public RestaurantService(OrderRepository orderRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
    }

    public Order openOrder(int tableNumber) {
        Table table = tableRepository.findByNumber(tableNumber)
                .orElseThrow(() -> new IllegalArgumentException("Table #" + tableNumber + " does not exist."));

        // Atomic CAS occupation lock
        if (!table.tryOccupy()) {
            throw new IllegalStateException("Table #" + tableNumber + " is currently occupied!");
        }

        // Verify no active order exists in the secondary index
        if (orderRepository.findActiveOrderByTableId(tableNumber).isPresent()) {
            throw new IllegalStateException("Active order already registered for Table #" + tableNumber);
        }

        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Order newOrder = new Order(orderId, table);
        return orderRepository.save(newOrder);
    }

    public void addItemToOrder(String orderId, MenuItem item) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order " + orderId + " not found."));

        order.addItem(item);
        orderRepository.save(order);
    }

    public void startPreparation(String orderId) {
        Order order = getValidOrder(orderId);
        order.startPreparation();
        orderRepository.save(order);
    }

    public void markOrderServed(String orderId) {
        Order order = getValidOrder(orderId);
        order.serve();
        orderRepository.save(order);
    }

    public Bill generateBill(String orderId, DiscountStrategy strategy, double taxRate) {
        Order order = getValidOrder(orderId);
        String billId = "INV-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        return new Bill(billId, order, strategy);
    }

    public void settleOrder(String orderId, Bill bill, Payment payment) {
        Order order = getValidOrder(orderId);

        if (payment.getAmount() < bill.calculate()) {
            throw new IllegalArgumentException(String.format(
                    "Insufficient payment amount! Expected: %.2f, Provided: %.2f",
                    bill.calculate(), payment.getAmount()
            ));
        }

        if (payment.process()) {
            order.pay();                 // State transitions to PAID
            order.getTable().vacate();   // Releases atomic table lock
            orderRepository.save(order); // Purges table-to-order active index
        }
    }

    public void cancelOrder(String orderId) {
        Order order = getValidOrder(orderId);
        order.cancel();
        order.getTable().vacate();
        orderRepository.save(order);
    }

    private Order getValidOrder(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order " + orderId + " not found."));
    }
}