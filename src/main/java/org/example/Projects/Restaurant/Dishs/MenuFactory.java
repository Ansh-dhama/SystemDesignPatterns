package org.example.Projects.Restaurant.Dishs;

import org.example.Projects.Restaurant.inter.MenuItem;

public class MenuFactory {

    public static MenuItem createItem(DishType dishType , String name , double price) {
        return switch (dishType){
            case VEG -> new VegDish(name, price);
            case NON_VEG -> new nonVeg(name,price);
            case BEVERAGE -> new Beverage(name ,price);
        };
    }
}
