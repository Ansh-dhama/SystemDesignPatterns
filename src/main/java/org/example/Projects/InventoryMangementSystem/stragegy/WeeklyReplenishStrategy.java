package org.example.Projects.InventoryMangementSystem.stragegy;

import org.example.Projects.InventoryMangementSystem.manager.InventoryManager;

import java.util.Map;

public class WeeklyReplenishStrategy implements ReplenishStrategy {
    @Override
    public void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish) {
        System.out.println("[Weekly Replenish] Refilling weekly schedule items...");
        for (Map.Entry<Integer, Integer> entry : itemsToReplenish.entrySet()) {
            manager.addStock(entry.getKey(), entry.getValue());
        }
    }
}