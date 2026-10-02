package org.example.Projects.InventoryMangementSystem.factory;


import org.example.Projects.InventoryMangementSystem.models.Product;

public class ProductFactory {
    public static Product createProduct(int sku) {
        switch (sku) {
            case 1001: return new Product(1001, "Apple", 20.0);
            case 1002: return new Product(1002, "Banana", 10.0);
            case 1003: return new Product(1003, "Chocolate", 50.0);
            case 2001: return new Product(2001, "T-Shirt", 500.0);
            case 2002: return new Product(2002, "Jeans", 1000.0);
            default: return new Product(sku, "Item-" + sku, 100.0);
        }
    }
}