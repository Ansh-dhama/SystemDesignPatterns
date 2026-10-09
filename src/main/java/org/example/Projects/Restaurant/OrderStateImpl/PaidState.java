package org.example.Projects.Restaurant.OrderStateImpl;

import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;
import org.example.Projects.Restaurant.model.Order;

// Paid State (Terminal)
public class PaidState implements OrderState {
    @Override public void addItem(Order order, MenuItem item) { throw new IllegalStateException("Order closed."); }
    @Override public void startPreparation(Order order) { throw new IllegalStateException("Order closed."); }
    @Override public void serveOrder(Order order) { throw new IllegalStateException("Order closed."); }
    @Override public void payOrder(Order order) { throw new IllegalStateException("Already paid."); }
    @Override public void cancelOrder(Order order) { throw new IllegalStateException("Cannot cancel paid order."); }
    @Override public String getStatus() { return "PAID"; }
}