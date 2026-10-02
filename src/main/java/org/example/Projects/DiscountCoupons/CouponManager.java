package org.example.Projects.DiscountCoupons;

import org.example.Projects.DiscountCoupons.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class CouponManager {
    private static CouponManager instance;
    private Coupon head;
    private final ReentrantLock lock = new ReentrantLock();

    private CouponManager() {}

    public static synchronized CouponManager getInstance() {
        if (instance == null) {
            instance = new CouponManager();
        }
        return instance;
    }

    public void registerCoupon(Coupon coupon) {
        lock.lock();
        try {
            if (head == null) {
                head = coupon;
            } else {
                Coupon current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(coupon);
            }
        } finally {
            lock.unlock();
        }
    }

    public List<String> getApplicableCoupons(Cart cart) {
        lock.lock();
        try {
            List<String> applicableList = new ArrayList<>();
            Coupon current = head;
            while (current != null) {
                if (current.isApplicable(cart)) {
                    applicableList.add(current.getName());
                }
                current = current.getNext();
            }
            return applicableList;
        } finally {
            lock.unlock();
        }
    }

    public double applyAllCoupons(Cart cart) {
        lock.lock();
        try {
            if (head != null) {
                head.applyDiscount(cart);
            }
            return cart.getCurrentTotal();
        } finally {
            lock.unlock();
        }
    }
}