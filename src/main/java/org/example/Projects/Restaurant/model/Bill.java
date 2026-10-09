package org.example.Projects.Restaurant.model;

import org.example.Projects.Restaurant.inter.DiscountStrategy;
import org.example.Projects.Restaurant.inter.MenuItem;

public class Bill {
    private String billId;
    private Order order;
    private DiscountStrategy discountStrategy;

    public Bill(String billId, Order order, DiscountStrategy discountStrategy) {
        this.billId = billId;
        this.order = order;
        this.discountStrategy = discountStrategy;
    }
    public double calculateSum(){
       return order.getMenuItems().stream().mapToDouble(MenuItem::getPrice).sum();
    }
    public double calculate() {
        double calculatedAmount = calculateSum();
        double discountAmount = discountStrategy.calculate(calculatedAmount);
        return discountAmount;
    }

    public void printReceipt() {
        System.out.println("--- Receipt [" + billId + "] Table #" + order.getTable().getTableNumber() + " ---");
        for (MenuItem item : order.getMenuItems()) {
            System.out.printf("%-35s ₹%.2f%n", item.getDescription(), item.getPrice());
        }
        double subtotal = calculateSum();
        double total = calculate();
        System.out.println("----------------------------------------------");
        System.out.printf("Subtotal:  ₹%.2f%n", subtotal);
        System.out.printf("Total Due: ₹%.2f (incl. tax & discount)%n", total);
    }
}
