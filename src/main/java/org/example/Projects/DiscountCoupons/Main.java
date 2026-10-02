package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;
import org.example.Projects.DiscountCoupons.model.Category;
import org.example.Projects.DiscountCoupons.model.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize Manager and register coupon chain
        CouponManager manager = CouponManager.getInstance();
        
        manager.registerCoupon(new SeasonalCoupon(Category.CLOTHING, 10.0));
        manager.registerCoupon(new LoyaltyCoupon(5.0));
        manager.registerCoupon(new BulkPurchaseCoupon(1000.0, 100.0));
        manager.registerCoupon(new BankCoupon("ABC_BANK", 2000.0, 15.0, 500.0));

        // Create Products
        Product jacket = new Product("Winter Jacket", Category.CLOTHING, 1000.0);
        Product phone = new Product("Smartphone", Category.ELECTRONICS, 20000.0);
        Product headphones = new Product("Headphones", Category.ELECTRONICS, 2000.0);

        // Build Cart
        Cart cart = new Cart();
        cart.addProduct(jacket, 1);
        cart.addProduct(phone, 1);
        cart.addProduct(headphones, 1);
        cart.setLoyaltyMember(true);
        cart.setPaymentBank("ABC_BANK");

        System.out.println("================ ORIGINAL CART ================");
        System.out.println("Original Total: ₹" + cart.getOriginalTotal());

        System.out.println("\n================ APPLICABLE COUPONS ================");
        List<String> applicableCoupons = manager.getApplicableCoupons(cart);
        for (String coupon : applicableCoupons) {
            System.out.println("- " + coupon);
        }

        System.out.println("\n================ APPLYING COUPONS ================");
        double finalPrice = manager.applyAllCoupons(cart);

        System.out.println("\n================ SUMMARY ================");
        System.out.println("Final Pay Amount: ₹" + finalPrice);
        System.out.println("Total Saved: ₹" + (cart.getOriginalTotal() - finalPrice));
    }
}