package org.example.Projects.DiscountCoupons.strategydiscount;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculate(double baseAmount) {
        return (percentage / 100.0) * baseAmount;
    }
}