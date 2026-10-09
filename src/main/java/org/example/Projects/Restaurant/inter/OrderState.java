package org.example.Projects.Restaurant.inter;

import org.example.Projects.Restaurant.model.Order;

public interface OrderState {
    void addItem(Order order, MenuItem item);
    void startPreparation(Order order);
    void serveOrder(Order order);
    void payOrder(Order order);
    void cancelOrder(Order order);
    String getStatus();
}