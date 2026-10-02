package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;
import org.example.Projects.DiscountCoupons.model.CartItem;
import org.example.Projects.DiscountCoupons.model.Category;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategy;
import org.example.Projects.DiscountCoupons.strategydiscount.DiscountStrategyManager;
import org.example.Projects.DiscountCoupons.strategydiscount.StrategyType;
public class BankCoupon extends Coupon {
    private final String requiredBank;
    private final double minSpend;
    private final DiscountStrategy strategy;

    public BankCoupon(String requiredBank, double minSpend, double percentage, double cap) {
        this.requiredBank = requiredBank;
        this.minSpend = minSpend;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT_WITH_CAP, percentage, cap);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getPaymentBank().equalsIgnoreCase(requiredBank) 
                && cart.getCurrentTotal() >= minSpend;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String getName() {
        return requiredBank + " Bank Offer";
    }
}