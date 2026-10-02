package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;
import org.example.Projects.Zomato.Models.MenuItem;
import org.example.Projects.Zomato.Models.Restaurant;
import org.example.Projects.Zomato.Models.User;
import org.example.Projects.Zomato.Payment.Payment;
import org.example.Projects.Zomato.Payment.upiPayment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TomatoApp app = new TomatoApp();

        // 1. Setup Sample Restaurants
        Restaurant r1 = new Restaurant("Bikanervala", "Delhi");
        r1.addMenuItem(new MenuItem("M1", "Chole Bhature", 120.0));
        r1.addMenuItem(new MenuItem("M2", "Samosa", 15.0));

        RestaurantManager.getInstance().addRestaurant(r1);

        // 2. User arrives
        User user = new User(1001, "Ansh", "Delhi");

        // 3. Search & Select Restaurant
        List<Restaurant> found = app.searchRestaurant("Delhi");
        if (!found.isEmpty()) {
            app.selectRestaurant(user, found.get(0));
        }

        // 4. Add items to cart
        app.addToCart(user, "M1");
        app.addToCart(user, "M2");

        // 5. Checkout & Pay
        Payment upi = new upiPayment();
        Order order = app.checkoutNow(user, upi, "DELIVERY");
        app.payForOrder(order);
    }
}