package org.example.Projects.InventoryMangementSystem.stragegy;

import org.example.Projects.InventoryMangementSystem.manager.InventoryManager;

import java.util.Map;

public interface ReplenishStrategy {
    void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish);
}