package org.example.Projects.InventoryMangementSystem.store;

import org.example.Projects.InventoryMangementSystem.manager.InventoryManager;
import org.example.Projects.InventoryMangementSystem.models.Product;
import org.example.Projects.InventoryMangementSystem.stragegy.ReplenishStrategy;

import java.util.List;
import java.util.Map;

public class DarkStore {
    private final String name;
    private final double x;
    private final double y;
    private final InventoryManager inventoryManager;
    private ReplenishStrategy replenishStrategy;

    public DarkStore(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.inventoryManager = new InventoryManager(new DBInventoryStore());
    }

    public double distanceTo(double userX, double userY) {
        return Math.sqrt(Math.pow(this.x - userX, 2) + Math.pow(this.y - userY, 2));
    }

    public void setReplenishStrategy(ReplenishStrategy strategy) {
        this.replenishStrategy = strategy;
    }

    public void runReplenishment(Map<Integer, Integer> itemsToReplenish) {
        if (replenishStrategy != null) {
            replenishStrategy.replenish(inventoryManager, itemsToReplenish);
        }
    }

    public String getName() { return name; }
    public InventoryManager getInventoryManager() { return inventoryManager; }
    public void addStock(int sku, int quantity) { inventoryManager.addStock(sku, quantity); }
    public void removeStock(int sku, int quantity) { inventoryManager.removeStock(sku, quantity); }
    public int checkStock(int sku) { return inventoryManager.checkStock(sku); }
    public List<Product> getAvailableProducts() { return inventoryManager.getAvailableProducts(); }
}