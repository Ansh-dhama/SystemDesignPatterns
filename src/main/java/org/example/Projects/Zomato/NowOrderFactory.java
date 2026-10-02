package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;
import org.example.Projects.Zomato.Interfaces.OrderFactory;
import org.example.Projects.Zomato.Models.MenuItem;
import org.example.Projects.Zomato.Models.Restaurant;
import org.example.Projects.Zomato.Models.User;
import org.example.Projects.Zomato.Payment.Payment;

import java.util.List;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Restaurant restaurant, List<MenuItem> items,
                             Payment paymentStrategy, String orderType, double totalCost) {
        Order order;
        if ("DELIVERY".equalsIgnoreCase(orderType)) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(items);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotalAmount(totalCost);
        order.setScheduledTime("IMMEDIATE");

        return order;
    }
}
