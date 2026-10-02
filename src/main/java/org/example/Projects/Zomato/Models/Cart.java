package org.example.Projects.Zomato.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private  Restaurant restaurant;
    List<MenuItem> menuItems;
    public Cart( ) {
        menuItems = new ArrayList<>();
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public double getTotalPrice() {

        double totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }
    public boolean isEmpty() {
        return menuItems.isEmpty();
    }

    public void clear() {
        this.restaurant = null;
        this.menuItems.clear();
    }

    // Getters
    public Restaurant getRestaurant() { return restaurant; }
    public List<MenuItem> getItems() { return menuItems; }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }
}
