package org.example.Projects.Restaurant.OrderStateImpl;

import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;
import org.example.Projects.Restaurant.model.Order;

// Preparing State
public class PreparingState implements OrderState {
    @Override
    public void addItem(Order order, MenuItem item) {
        throw new IllegalStateException("Kitchen is already preparing. Cannot modify items.");
    }

    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Order is already preparing.");
    }

    @Override
    public void serveOrder(Order order) {
        order.setState(new ServedState());
    }

    @Override
    public void payOrder(Order order) {
        throw new IllegalStateException("Payment can only be done after serving.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
    }

    @Override
    public String getStatus() { return "PREPARING"; }
}
