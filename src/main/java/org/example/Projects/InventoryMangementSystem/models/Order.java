    package org.example.Projects.InventoryMangementSystem.models;

import java.util.*;

public class Order {
    private static int nextId = 101;
    private final int orderId;
    private final User user;
    private final Map<Integer, Integer> items = new HashMap<>();
    private final List<DeliveryPartner> deliveryPartners = new ArrayList<>();
    private double totalAmount;

    public Order(User user) {
        this.orderId = nextId++;
        this.user = user;
    }

    public void addItem(int sku, int quantity) {
        items.put(sku, items.getOrDefault(sku, 0) + quantity);
    }

    public void addDeliveryPartner(DeliveryPartner partner) {
        deliveryPartners.add(partner);
    }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public void printSummary() {
        System.out.println("------------------------------------------");
        System.out.println("Order ID: " + orderId + " | Customer: " + user.getName());
        System.out.println("Items Delivered: " + items);
        System.out.println("Total Amount: ₹" + totalAmount);
        System.out.print("Assigned Partners: ");
        for (DeliveryPartner partner : deliveryPartners) {
            System.out.print("[" + partner.getName() + "] ");
        }
        System.out.println("\n------------------------------------------");
    }
}