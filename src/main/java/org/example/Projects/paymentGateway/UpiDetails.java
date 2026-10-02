package org.example.Projects.paymentGateway;

public class UpiDetails implements PaymentMethodDetails {

    private final String upiId;

    public UpiDetails(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }
}