package org.example.Projects.Restaurant.Dishs;

import org.example.Projects.Restaurant.inter.MenuItem;

public class Beverage implements MenuItem {
   private  String name;
   private double price;

   public Beverage(String name, double price) {
       this.name = name;
        this.price = price;
   }
    @Override
    public String getDescription() {
        return "Beverage " + name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
