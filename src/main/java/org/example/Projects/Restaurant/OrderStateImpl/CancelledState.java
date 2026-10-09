package org.example.Projects.Restaurant.OrderStateImpl;


import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;
import org.example.Projects.Restaurant.model.Order;

public class CancelledState implements OrderState {
    @Override public void addItem(Order order, MenuItem item) { throw new IllegalStateException("Order cancelled."); }
    @Override public void startPreparation(Order order) { throw new IllegalStateException("Order cancelled."); }
    @Override public void serveOrder(Order order) { throw new IllegalStateException("Order cancelled."); }
    @Override public void payOrder(Order order) { throw new IllegalStateException("Order cancelled."); }
    @Override public void cancelOrder(Order order) { throw new IllegalStateException("Already cancelled."); }

    @Override
    public String getStatus() {
        return  "CANCELLED";
    }


}