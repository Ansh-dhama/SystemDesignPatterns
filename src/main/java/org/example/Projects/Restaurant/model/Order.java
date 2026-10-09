package org.example.Projects.Restaurant.model;


import org.example.Projects.Restaurant.OrderStateImpl.CreatedState;
import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.inter.OrderState;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<MenuItem> menuItems;
    private OrderState state;
    private Table table;
    public Order(String orderId, Table table) {
        this.orderId = orderId;
        this.table = table;
        state = new CreatedState();
        menuItems = new ArrayList<>();
    }
    public String getOrderId() {
        return orderId;
    }
    public void setState(OrderState order) {
        this.state = order;
    }
    public String getOrderState() {
        return state.getStatus();
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public Table getTable() {
        return table;
    }

    public void addItem(MenuItem item) { state.addItem(this, item); }
    public void startPreparation() { state.startPreparation(this); }
    public void serve() { state.serveOrder(this); }
    public void pay() { state.payOrder(this); }
    public void cancel() { state.cancelOrder(this); }

}
