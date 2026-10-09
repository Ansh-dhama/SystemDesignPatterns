package org.example.Projects.Restaurant.OrderStateImpl;

import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;
import org.example.Projects.Restaurant.model.Order;

// Created State
public class CreatedState implements OrderState {
    @Override
    public void addItem(Order order, MenuItem item) {
        order.getMenuItems().add(item);
    }

    @Override
    public void startPreparation(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public void serveOrder(Order order) {
        throw new IllegalStateException("Cannot serve an order before preparing.");
    }

    @Override
    public void payOrder(Order order) {
        throw new IllegalStateException("Cannot pay for an order that has not been served.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
    }

    @Override
    public String getStatus() { return "CREATED"; }
}
