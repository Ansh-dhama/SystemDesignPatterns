package org.example.Projects.InventoryMangementSystem.manager;

import org.example.Projects.InventoryMangementSystem.store.DarkStore;

import java.util.*;

public class DarkStoreManager {
    private static DarkStoreManager instance;
    private final List<DarkStore> darkStores = new ArrayList<>();

    private DarkStoreManager() {}

    public static synchronized DarkStoreManager getInstance() {
        if (instance == null) {
            instance = new DarkStoreManager();
        }
        return instance;
    }

    public void registerDarkStore(DarkStore store) {
        darkStores.add(store);
    }

    public List<DarkStore> getNearbyDarkStores(double userX, double userY, double maxDistance) {
        List<DarkStore> nearby = new ArrayList<>();
        for (DarkStore store : darkStores) {
            if (store.distanceTo(userX, userY) <= maxDistance) {
                nearby.add(store);
            }
        }
        nearby.sort(Comparator.comparingDouble(s -> s.distanceTo(userX, userY)));
        return nearby;
    }
}