package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;

public class NotificationService {
    public void notify(Order order) {
        System.out.println(" [NOTIFICATION] Order #" + order.getOrderId() +
                " placed successfully for " + order.getUser().getName() +
                " at " + order.getRestaurant().getName() +
                " | Status: Scheduled for " + order.getScheduledTime());
    }
}