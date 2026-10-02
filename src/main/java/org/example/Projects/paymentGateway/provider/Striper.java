package org.example.Projects.paymentGateway.provider;

import org.example.Projects.paymentGateway.Request;

public class Striper implements PaymentProvider {
    @Override
    public PaymentProvider getProvider() {
        return new RazorpayGateway();
    }
    public void pay(Request pay) {
        System.out.println("Striper pay");
        System.out.println("Payment ID: " + pay.getId() + " is pay by "+ pay.getUserId());
    }

}
