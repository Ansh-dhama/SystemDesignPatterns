package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;
import org.example.Projects.DiscountCoupons.model.CartItem;
import org.example.Projects.DiscountCoupons.model.Category;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategy;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategyManager;
import org.example.Projects.DiscountCoupons.strategydiscount.StrategyType;
public class LoyaltyCoupon extends Coupon {
    private final DiscountStrategy strategy;

    public LoyaltyCoupon(double percentage) {
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT, percentage, null);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.isLoyaltyMember();
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String getName() {
        return "Loyalty Member Offer";
    }
}