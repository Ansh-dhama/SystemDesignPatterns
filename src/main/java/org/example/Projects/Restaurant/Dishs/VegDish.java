package org.example.Projects.Restaurant.Dishs;

import org.example.Projects.Restaurant.inter.MenuItem;

public class VegDish implements MenuItem {
   private String name;
   private double price;

   VegDish(String name, double price) {
       this.name = name;
       this.price = price;
   }
    @Override
    public String getDescription() {
        return "Veg " + name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
