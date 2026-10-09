package org.example.Projects.Restaurant.Repo;


import org.example.Projects.Restaurant.DiscountStrategy.PercentageStrategy;
import org.example.Projects.Restaurant.Dishs.DishType;
import org.example.Projects.Restaurant.Dishs.MenuFactory;
import org.example.Projects.Restaurant.Payment.Payment;
import org.example.Projects.Restaurant.Payment.PaymentMethod;
import org.example.Projects.Restaurant.inter.DiscountStrategy;
import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.model.Bill;
import org.example.Projects.Restaurant.model.Order;
import org.example.Projects.Restaurant.model.Table;

public class RestaurantApplication {
    public static void main(String[] args) {
        // 1. Initialize Repositories and Services
        OrderRepository orderRepo = new InMemoryOrderRepository();
        TableRepository tableRepo = new TableRepository();

        // Seed 5 restaurant tables
        for (int i = 1; i <= 5; i++) {
            tableRepo.save(new Table(i));
        }

        RestaurantService restaurantService = new RestaurantService(orderRepo, tableRepo);

        System.out.println("--- 1. Customer arrives at Table #2 and opens Order ---");
        Order order = restaurantService.openOrder(2);
        System.out.println("Created Order ID: " + order.getOrderId() + " | State: " + order.getOrderState());

        System.out.println("\n--- 2. Building Menu Items via Factory & Decorators ---");
        // Factory items
        MenuItem starter = MenuFactory.createItem(DishType.VEG, "Paneer Tikka", 240.0);
        MenuItem drink = MenuFactory.createItem(DishType.BEVERAGE, "Fresh Lime Soda", 80.0);

        // Decorator customization: Base Burger + Extra Cheese + Extra Patty + Medium Spice
        MenuItem baseBurger = MenuFactory.createItem(DishType.NON_VEG, "Crispy Chicken Burger", 180.0);


        // Adding items
        restaurantService.addItemToOrder(order.getOrderId(), starter);
        restaurantService.addItemToOrder(order.getOrderId(), drink);

        System.out.println("Items added successfully. Total count: " + order.getMenuItems().size());

        System.out.println("\n--- 3. Kitchen Operations (State Transitions) ---");
        restaurantService.startPreparation(order.getOrderId());
        System.out.println("Status after sending to kitchen: " + order.getOrderState());

        // Verifying illegal state transition guard
        try {
            System.out.println("Attempting to add items while cooking...");
            restaurantService.addItemToOrder(order.getOrderId(), starter);
        } catch (IllegalStateException ex) {
            System.out.println("Caught Expected Guard: " + ex.getMessage());
        }

        restaurantService.markOrderServed(order.getOrderId());
        System.out.println("Status after delivery to table: " + order.getOrderState());

        System.out.println("\n--- 4. Billing & Dynamic Strategy Application ---");
        // 10% student/corporate discount policy + 5% GST
        DiscountStrategy corporateDiscount = new PercentageStrategy(10);
        Bill bill = restaurantService.generateBill(order.getOrderId(), corporateDiscount, 0.05);
        bill.printReceipt();

        System.out.println("--- 5. Payment Processing & Settlement ---");
        Payment payment = new Payment("PAY-TXN-9901", bill.calculate(), PaymentMethod.UPI);
        restaurantService.settleOrder(order.getOrderId(), bill, payment);

        System.out.println("Final Order Status: " + order.getOrderState());
        System.out.println("Table #2 Occupied Status: " + order.getTable().tryOccupy());

        // Verify active index cleanup in repository
        boolean hasActiveOrder = orderRepo.findActiveOrderByTableId(2).isPresent();
        System.out.println("Table #2 has active order in repo: " + hasActiveOrder);
    }
}