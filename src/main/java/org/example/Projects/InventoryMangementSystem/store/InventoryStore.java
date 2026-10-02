package org.example.Projects.InventoryMangementSystem.store;

import org.example.Projects.InventoryMangementSystem.models.Product;

import java.util.List;

public abstract class InventoryStore {
    public abstract void addProduct(Product product, int quantity);
    public abstract void removeProduct(int sku, int quantity);
    public abstract int checkStock(int sku);
    public abstract List<Product> listAvailableProducts();
}