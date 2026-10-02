package org.example.Projects.DiscountCoupons.model;

import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategy;

public class PercentageWithCapStrategy implements DiscountStrategy {
    private final double percentage;
    private final double capValue;

    public PercentageWithCapStrategy(double percentage, double capValue) {
        this.percentage = percentage;
        this.capValue = capValue;
    }

    @Override
    public double calculate(double baseAmount) {
        double discount = (percentage / 100.0) * baseAmount;
        return Math.min(discount, capValue);
    }
}