package org.example.Projects.Restaurant.Repo;

import org.example.Projects.Restaurant.model.Order;

import java.util.*;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
    Optional<Order> findActiveOrderByTableId(int tableNumber);
    List<Order> findAllActiveOrders();
    void delete(String orderId);
}
