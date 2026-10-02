package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;

public class PickupOrder extends Order {
    private String restaurantAddress;

    public String getRestaurantAddress() { return restaurantAddress; }
    public void setRestaurantAddress(String restaurantAddress) { this.restaurantAddress = restaurantAddress; }

    @Override
    public String getType() {
        return "PICKUP";
    }
}
