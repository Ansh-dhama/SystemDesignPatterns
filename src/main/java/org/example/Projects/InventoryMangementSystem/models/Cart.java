package org.example.Projects.InventoryMangementSystem.models;

import org.example.Projects.InventoryMangementSystem.factory.ProductFactory;

import java.util.*;

public class Cart {
    private final Map<Integer, Integer> items = new HashMap<>(); // SKU -> Quantity

    public void addItem(int sku, int quantity) {
        items.put(sku, items.getOrDefault(sku, 0) + quantity);
    }

    public Map<Integer, Integer> getItems() { return items; }

    public double getTotalAmount() {
        double total = 0.0;
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            Product p = ProductFactory.createProduct(entry.getKey());
            total += p.getPrice() * entry.getValue();
        }
        return total;
    }
}