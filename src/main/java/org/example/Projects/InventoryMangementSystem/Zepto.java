package org.example.Projects.InventoryMangementSystem;

import org.example.Projects.InventoryMangementSystem.manager.DarkStoreManager;
import org.example.Projects.InventoryMangementSystem.models.Product;
import org.example.Projects.InventoryMangementSystem.models.User;
import org.example.Projects.InventoryMangementSystem.store.DarkStore;

import java.util.*;

public class Zepto {
    public static void initializeStores() {
        DarkStoreManager manager = DarkStoreManager.getInstance();

        DarkStore storeA = new DarkStore("DarkStore-A", 1.0, 1.0);
        storeA.addStock(1001, 5); // 5 Apples
        storeA.addStock(1002, 2); // 2 Bananas

        DarkStore storeB = new DarkStore("DarkStore-B", 2.0, 2.0);
        storeB.addStock(1001, 3); // 3 Apples
        storeB.addStock(1003, 10); // 10 Chocolates

        DarkStore storeC = new DarkStore("DarkStore-C", 3.0, 3.0);
        storeC.addStock(1002, 5); // 5 Bananas

        manager.registerDarkStore(storeA);
        manager.registerDarkStore(storeB);
        manager.registerDarkStore(storeC);
    }

    public static void showAvailableProducts(User user) {
        List<DarkStore> stores = DarkStoreManager.getInstance().getNearbyDarkStores(user.getX(), user.getY(), 5.0);
        System.out.println("\n--- Available Products Near " + user.getName() + " ---");
        Set<Integer> printedSkus = new HashSet<>();

        for (DarkStore store : stores) {
            for (Product product : store.getAvailableProducts()) {
                if (!printedSkus.contains(product.getSku())) {
                    System.out.println("SKU: " + product.getSku() + " | Name: " + product.getName() + " | Price: ₹" + product.getPrice());
                    printedSkus.add(product.getSku());
                }
            }
        }
    }
}