package org.example.Projects.InventoryMangementSystem;

import org.example.Projects.InventoryMangementSystem.manager.OrderManager;
import org.example.Projects.InventoryMangementSystem.models.Order;
import org.example.Projects.InventoryMangementSystem.models.User;

public class Main {
    public static void main(String[] args) {
        // Step 1: Initialize System Dark Stores
        Zepto.initializeStores();

        // Step 2: User Enters App
        User user = new User("Ansh", 1.5, 1.5);
        Zepto.showAvailableProducts(user);

        // Step 3: Add Items to Cart (Requires order splitting across stores)
        System.out.println("\nAdding items to cart...");
        user.getCart().addItem(1001, 4); // 4 Apples
        user.getCart().addItem(1002, 3); // 3 Bananas
        user.getCart().addItem(1003, 2); // 2 Chocolates

        // Step 4: Place Order
        System.out.println("\nPlacing Quick-Commerce Order...");
        Order order = OrderManager.getInstance().placeOrder(user);

        if (order != null) {
            order.printSummary();
        }
    }
}