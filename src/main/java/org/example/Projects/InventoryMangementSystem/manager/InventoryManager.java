package org.example.Projects.InventoryMangementSystem.manager;

import org.example.Projects.InventoryMangementSystem.factory.ProductFactory;
import org.example.Projects.InventoryMangementSystem.models.Product;
import org.example.Projects.InventoryMangementSystem.store.InventoryStore;

import java.util.List;

public class InventoryManager {
    private final InventoryStore store;

    public InventoryManager(InventoryStore store) {
        this.store = store;
    }

    public void addStock(int sku, int quantity) {
        Product product = ProductFactory.createProduct(sku);
        store.addProduct(product, quantity);
    }

    public void removeStock(int sku, int quantity) {
        store.removeProduct(sku, quantity);
    }

    public int checkStock(int sku) {
        return store.checkStock(sku);
    }

    public List<Product> getAvailableProducts() {
        return store.listAvailableProducts();
    }
}