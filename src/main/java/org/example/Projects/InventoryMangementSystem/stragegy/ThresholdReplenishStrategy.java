package org.example.Projects.InventoryMangementSystem.stragegy;

import org.example.Projects.InventoryMangementSystem.manager.InventoryManager;

import java.util.Map;

public class ThresholdReplenishStrategy implements ReplenishStrategy {
    private final int threshold;

    public ThresholdReplenishStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish) {
        for (Map.Entry<Integer, Integer> entry : itemsToReplenish.entrySet()) {
            int sku = entry.getKey();
            int quantityToAdd = entry.getValue();
            if (manager.checkStock(sku) < threshold) {
                manager.addStock(sku, quantityToAdd);
                System.out.println("[Replenish] Added " + quantityToAdd + " units of SKU: " + sku);
            }
        }
    }
}