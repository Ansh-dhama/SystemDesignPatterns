package org.example.Projects.InventoryMangementSystem.manager;

import org.example.Projects.InventoryMangementSystem.models.DeliveryPartner;
import org.example.Projects.InventoryMangementSystem.models.Order;
import org.example.Projects.InventoryMangementSystem.models.User;
import org.example.Projects.InventoryMangementSystem.store.DarkStore;

import java.util.*;

public class OrderManager {
    private static OrderManager instance;
    private final List<Order> orders = new ArrayList<>();

    private OrderManager() {}

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public Order placeOrder(User user) {
        DarkStoreManager storeManager = DarkStoreManager.getInstance();
        List<DarkStore> nearbyStores = storeManager.getNearbyDarkStores(user.getX(), user.getY(), 5.0);

        if (nearbyStores.isEmpty()) {
            System.err.println("No dark store within 5 km range!");
            return null;
        }

        Map<Integer, Integer> remainingCart = new HashMap<>(user.getCart().getItems());
        Order order = new Order(user);
        int partnerCounter = 1;

        // Fulfill items across nearby dark stores
        for (DarkStore store : nearbyStores) {
            if (remainingCart.isEmpty()) break;

            boolean storeSuppliedAny = false;
            List<Integer> fulfilledSKUs = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : remainingCart.entrySet()) {
                int sku = entry.getKey();
                int neededQty = entry.getValue();
                int availableQty = store.checkStock(sku);

                if (availableQty > 0) {
                    int takenQty = Math.min(neededQty, availableQty);
                    store.removeStock(sku, takenQty);
                    order.addItem(sku, takenQty);

                    if (takenQty == neededQty) {
                        fulfilledSKUs.add(sku);
                    } else {
                        remainingCart.put(sku, neededQty - takenQty);
                    }
                    storeSuppliedAny = true;
                }
            }

            for (int sku : fulfilledSKUs) {
                remainingCart.remove(sku);
            }

            if (storeSuppliedAny) {
                order.addDeliveryPartner(new DeliveryPartner("Rider-" + partnerCounter++ + " (From " + store.getName() + ")"));
            }
        }

        if (!remainingCart.isEmpty()) {
            System.out.println("[Warning] Unfulfilled items due to stock unavailability: " + remainingCart);
        }

        order.setTotalAmount(order.toString() != null ? user.getCart().getTotalAmount() : 0.0);
        orders.add(order);
        return order;
    }
}