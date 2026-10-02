package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;
import org.example.Projects.Zomato.Interfaces.OrderFactory;
import org.example.Projects.Zomato.Models.Cart;
import org.example.Projects.Zomato.Models.MenuItem;
import org.example.Projects.Zomato.Models.Restaurant;
import org.example.Projects.Zomato.Models.User;
import org.example.Projects.Zomato.Payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class TomatoApp {
    private RestaurantManager restaurantManager;
    private OrderManager orderManager;
    private NotificationService notificationService;

    public TomatoApp() {
        this.restaurantManager = RestaurantManager.getInstance();
        this.orderManager = OrderManager.getInstance();
        this.notificationService = new NotificationService();
    }

    public List<Restaurant> searchRestaurant(String location) {
        return restaurantManager.searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant) {
        user.getCart().setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode) {
        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first!");
            return;
        }

        for (MenuItem item : restaurant.getMenuItems()) {

            if (item.getId().equalsIgnoreCase(itemCode)) {
                System.out.println("get");
                cart.addItem(item);
                System.out.println("Added " + item.getName() + " to cart.");
                return;
            }
        }
        System.out.println("Item not found in menu!");
    }

    public Order checkoutNow(User user, Payment paymentStrategy, String orderType) {
        OrderFactory factory = new NowOrderFactory();
        return processCheckout(user, paymentStrategy, orderType, factory);
    }

    public Order checkoutScheduled(User user, Payment paymentStrategy, String orderType, String time) {
        OrderFactory factory = new ScheduledOrderFactory(time);
        return processCheckout(user, paymentStrategy, orderType, factory);
    }

    private Order processCheckout(User user, Payment paymentStrategy, String orderType, OrderFactory factory) {
        Cart cart = user.getCart();
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return null;
        }

        Order order = factory.createOrder(
                user,
                cart.getRestaurant(),
                new ArrayList<>(cart.getItems()),
                paymentStrategy,
                orderType,
                cart.getTotalPrice()
        );

        orderManager.addOrder(order);
        return order;
    }

    public boolean payForOrder(Order order) {
        if (order == null) return false;
        boolean success = order.processPayment();
        if (success) {
            notificationService.notify(order);
            order.getUser().getCart().clear();
        }
        return success;
    }
}