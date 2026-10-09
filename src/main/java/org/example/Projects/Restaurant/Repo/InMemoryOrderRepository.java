package org.example.Projects.Restaurant.Repo;

import org.example.Projects.Restaurant.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements OrderRepository {
    // Primary index: orderId -> Order
    private final Map<String, Order> orderStore = new ConcurrentHashMap<>();

    // Secondary index: tableNumber -> activeOrderId
    private final Map<Integer, String> tableToActiveOrderIndex = new ConcurrentHashMap<>();

    private static final Set<String> TERMINAL_STATES = Set.of("PAID", "CANCELLED");

    @Override
    public Order save(Order order) {
        if (order == null) throw new IllegalArgumentException("Order cannot be null");

        String orderId = order.getOrderId();
        int tableNumber = order.getTable().getTableNumber();

        // 1. Store primary record atomically
        orderStore.put(orderId, order);

        // 2. Synchronize secondary table index
        if (TERMINAL_STATES.contains(order.getOrderState())) {
            // Remove mapping only if it still points to this order (prevents clobbering new orders)
            tableToActiveOrderIndex.remove(tableNumber, orderId);
        } else {
            tableToActiveOrderIndex.put(tableNumber, orderId);
        }

        return order;
    }

    @Override
    public Optional<Order> findById(String orderId) {
        if (orderId == null) return Optional.empty();
        return Optional.ofNullable(orderStore.get(orderId));
    }

    @Override
    public Optional<Order> findActiveOrderByTableId(int tableNumber) {
        String activeOrderId = tableToActiveOrderIndex.get(tableNumber);
        if (activeOrderId == null) return Optional.empty();

        Order order = orderStore.get(activeOrderId);
        if (order != null && !TERMINAL_STATES.contains(order.getOrderState())) {
            return Optional.of(order);
        }

        // Clean up stale dangling pointer
        tableToActiveOrderIndex.remove(tableNumber, activeOrderId);
        return Optional.empty();
    }

    @Override
    public List<Order> findAllActiveOrders() {
        return orderStore.values().stream()
                .filter(order -> !TERMINAL_STATES.contains(order.getOrderState()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void delete(String orderId) {
        if (orderId == null) return;
        Order removed = orderStore.remove(orderId);
        if (removed != null) {
            tableToActiveOrderIndex.remove(removed.getTable().getTableNumber(), orderId);
        }
    }
}