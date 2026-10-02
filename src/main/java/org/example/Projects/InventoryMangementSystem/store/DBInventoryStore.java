package org.example.Projects.InventoryMangementSystem.store;

import org.example.Projects.InventoryMangementSystem.models.Product;

import java.util.*;

public class DBInventoryStore extends InventoryStore {
    private final Map<Integer, Integer> stocks = new HashMap<>(); // SKU -> Quantity
    private final Map<Integer, Product> products = new HashMap<>(); // SKU -> Product

    @Override
    public synchronized void addProduct(Product product, int quantity) {
        int sku = product.getSku();
        products.put(sku, product);
        stocks.put(sku, stocks.getOrDefault(sku, 0) + quantity);
    }

    @Override
    public synchronized void removeProduct(int sku, int quantity) {
        if (stocks.containsKey(sku)) {
            int current = stocks.get(sku);
            int remaining = current - quantity;
            if (remaining <= 0) {
                stocks.remove(sku);
            } else {
                stocks.put(sku, remaining);
            }
        }
    }

    @Override
    public synchronized int checkStock(int sku) {
        return stocks.getOrDefault(sku, 0);
    }

    @Override
    public synchronized List<Product> listAvailableProducts() {
        List<Product> available = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : stocks.entrySet()) {
            if (entry.getValue() > 0 && products.containsKey(entry.getKey())) {
                available.add(products.get(entry.getKey()));
            }
        }
        return available;
    }
}