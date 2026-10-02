package org.example.Projects.Zomato.Interfaces;

import org.example.Projects.Zomato.Models.MenuItem;
import org.example.Projects.Zomato.Models.Restaurant;
import org.example.Projects.Zomato.Models.User;
import org.example.Projects.Zomato.Payment.Payment;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Restaurant restaurant, List<MenuItem> items,
                      Payment paymentStrategy, String orderType, double totalCost);
}

