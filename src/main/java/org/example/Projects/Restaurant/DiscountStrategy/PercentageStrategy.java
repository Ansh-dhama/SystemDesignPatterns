package org.example.Projects.Restaurant.DiscountStrategy;

import org.example.Projects.Restaurant.inter.DiscountStrategy;

public class PercentageStrategy implements DiscountStrategy {
    int  percentage;
    public PercentageStrategy(int percentage) {
        this.percentage = percentage;
    }
    @Override
    public double calculate(double price) {
        double discount = price * percentage;
        return price - discount;
    }
}
