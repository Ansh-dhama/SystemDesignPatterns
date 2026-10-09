package org.example.Projects.Restaurant.OrderStateImpl;

import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;
import org.example.Projects.Restaurant.model.Order;

public class ServedState implements OrderState {
    @Override
    public void addItem(Order order, MenuItem item) {
        throw new IllegalStateException("Order served. Create a new order for additional items.");
    }

    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Already served.");
    }

    @Override
    public void serveOrder(Order order) {
        throw new IllegalStateException("Already served.");
    }

    @Override
    public void payOrder(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel an order that is already served.");
    }

    @Override
    public String getStatus() { return "SERVED"; }
}
