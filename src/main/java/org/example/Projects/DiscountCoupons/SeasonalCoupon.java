package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;
import org.example.Projects.DiscountCoupons.model.CartItem;
import org.example.Projects.DiscountCoupons.model.Category;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategy;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategyManager;
import org.example.Projects.DiscountCoupons.strategydiscount.StrategyType;

public class SeasonalCoupon extends Coupon {
    private final Category targetCategory;
    private final DiscountStrategy strategy;

    public SeasonalCoupon(Category targetCategory, double percentage) {
        this.targetCategory = targetCategory;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT, percentage, null);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getItems().stream()
                .anyMatch(item -> item.getProduct().getCategory() == targetCategory);
    }

    @Override
    public double getDiscount(Cart cart) {
        double applicableTotal = cart.getItems().stream()
                .filter(item -> item.getProduct().getCategory() == targetCategory)
                .mapToDouble(CartItem::getItemTotal)
                .sum();
        return strategy.calculate(applicableTotal);
    }

    @Override
    public String getName() {
        return "Seasonal " + targetCategory + " Discount";
    }
}