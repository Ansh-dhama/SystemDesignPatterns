package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;

public abstract class Coupon {
    protected Coupon next;

    public void setNext(Coupon next) {
        this.next = next;
    }

    public Coupon getNext() {
        return next;
    }

    // Template Method
    public void applyDiscount(Cart cart) {
        if (isApplicable(cart)) {
            double discountPrice = getDiscount(cart);
            cart.applyDiscountAmount(discountPrice);
            System.out.println("Applied Coupon [" + getName() + "] -> Saved ₹" + discountPrice);
            
            if (!isCombinable(cart)) {
                return; // Stop chain processing
            }
        }

        if (next != null) {
            next.applyDiscount(cart);
        }
    }

    public abstract boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public abstract String getName();
    
    public boolean isCombinable(Cart cart) {
        return true; // Default behavior
    }
}