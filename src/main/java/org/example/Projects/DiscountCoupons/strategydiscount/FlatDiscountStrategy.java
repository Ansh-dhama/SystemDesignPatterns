package org.example.Projects.DiscountCoupons.strategydiscount;

public class FlatDiscountStrategy implements DiscountStrategy {
    private final double discountAmount;

    public FlatDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculate(double baseAmount) {
        return Math.min(discountAmount, baseAmount);
    }
}