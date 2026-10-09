package org.example.Projects.Restaurant.Dishs;

import org.example.Projects.Restaurant.inter.MenuItem;

public class nonVeg implements MenuItem {
private  String name;
private double price;

public nonVeg(String name, double price) {
    this.name = name;
    this.price = price;
}

    @Override
    public String getDescription() {
        return "Non Veg" + name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
