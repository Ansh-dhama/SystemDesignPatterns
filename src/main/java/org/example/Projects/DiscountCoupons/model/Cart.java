package org.example.Projects.DiscountCoupons.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    private double originalTotal = 0.0;
    private double currentTotal = 0.0;
    private boolean isLoyaltyMember = false;
    private String paymentBank = "";

    public void addProduct(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        items.add(item);
        originalTotal += item.getItemTotal();
        currentTotal += item.getItemTotal();
    }

    public void applyDiscountAmount(double discountAmount) {
        currentTotal -= discountAmount;
        if (currentTotal < 0) {
            currentTotal = 0;
        }
    }

    public List<CartItem> getItems() { 
        return items; 
    }

    public double getOriginalTotal() { 
        return originalTotal; 
    }

    public double getCurrentTotal() { 
        return currentTotal; 
    }

    public boolean isLoyaltyMember() { 
        return isLoyaltyMember; 
    }

    public void setLoyaltyMember(boolean loyaltyMember) { 
        isLoyaltyMember = loyaltyMember; 
    }

    public String getPaymentBank() { 
        return paymentBank; 
    }

    public void setPaymentBank(String paymentBank) { 
        this.paymentBank = paymentBank; 
    }
}