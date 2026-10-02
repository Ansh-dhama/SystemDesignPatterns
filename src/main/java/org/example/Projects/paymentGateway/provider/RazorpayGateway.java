package org.example.Projects.paymentGateway.provider;

import org.example.Projects.paymentGateway.Request;

public class RazorpayGateway implements PaymentProvider {

    @Override
    public void pay(Request pay) {
        System.out.println("Razorpay Payment Provider");
        System.out.println(pay.getAmount() +" is paid by " + pay.getId());
    }
    public PaymentProvider getProvider() {
        return new RazorpayGateway();
    }

}
