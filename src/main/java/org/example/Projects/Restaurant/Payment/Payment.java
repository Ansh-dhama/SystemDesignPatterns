package org.example.Projects.Restaurant.Payment;

public class Payment {
    private final String paymentId;
    private final double amount;
    private final PaymentMethod method;

    public Payment(String paymentId, double amount, PaymentMethod method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    public boolean process() {
        System.out.println("Processed payment ID " + paymentId + " of ₹" + amount + " via " + method);
        return true;
    }
    public String getPaymentId() {
        return paymentId;
    }
    public double getAmount() {
        return amount;
    }
}