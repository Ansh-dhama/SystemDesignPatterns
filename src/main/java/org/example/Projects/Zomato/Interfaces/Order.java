package org.example.Projects.Zomato.Interfaces;

import org.example.Projects.Zomato.Models.MenuItem;
import org.example.Projects.Zomato.Models.Restaurant;
import org.example.Projects.Zomato.Models.User;
import org.example.Projects.Zomato.Payment.Payment;

import java.util.List;

public abstract class Order {
     private static int nextOrderId = 0;
     protected int orderId;
     protected User user;
     protected Restaurant restaurant;
     protected List<MenuItem> items;
     protected Payment paymentStrategy;
     protected double totalAmount;
     protected String scheduledTime;
     public Order() {
          this.orderId = ++nextOrderId;
     }
     public boolean processPayment() {
          if (paymentStrategy != null) {
               return paymentStrategy.pay(totalAmount);
          }
          System.out.println("Please choose a payment mode first!");
          return false;
     }

     public abstract String getType();

     // Getters & Setters
     public int getOrderId() { return orderId; }
     public User getUser() { return user; }
     public Restaurant getRestaurant() { return restaurant; }
     public List<MenuItem> getItems() { return items; }
     public double getTotalAmount() { return totalAmount; }
     public String getScheduledTime() { return scheduledTime; }

     public void setUser(User user) { this.user = user; }
     public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
     public void setItems(List<MenuItem> items) { this.items = items; }
     public void setPaymentStrategy(Payment paymentStrategy) { this.paymentStrategy = paymentStrategy; }
     public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
     public void setScheduledTime(String scheduledTime) { this.scheduledTime = scheduledTime; }
}
