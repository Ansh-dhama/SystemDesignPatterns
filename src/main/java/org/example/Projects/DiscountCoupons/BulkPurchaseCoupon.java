package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategy;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategyManager;
import org.example.Projects.DiscountCoupons.strategydiscount.StrategyType;

public class BulkPurchaseCoupon extends Coupon {
    private final double minThreshold;
    private final DiscountStrategy strategy;

    public BulkPurchaseCoupon(double minThreshold, double flatDiscount) {
        this.minThreshold = minThreshold;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.FLAT, flatDiscount, null);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getCurrentTotal() >= minThreshold;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String getName() {
        return "Bulk Purchase Discount";
    }
}