package org.example.Projects.Restaurant.DiscountStrategy;

import org.example.Projects.Restaurant.inter.DiscountStrategy;

public class FlatDiscount implements DiscountStrategy {
    int flatDiscount;
    public FlatDiscount(int flatDiscount) {
        this.flatDiscount = flatDiscount;
    }
    @Override
    public double calculate(double price) {
        return price - flatDiscount;
    }
}
