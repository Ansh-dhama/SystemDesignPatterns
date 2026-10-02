package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;
    private List<Restaurant> restaurants;

    private RestaurantManager() {
        restaurants = new ArrayList<>();
    }

    public static synchronized RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }


    public List<Restaurant> searchByLocation(String location) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants) {
            if (r.getLocation().equalsIgnoreCase(location)) {
                result.add(r);
            }
        }
        return result;
    }
}