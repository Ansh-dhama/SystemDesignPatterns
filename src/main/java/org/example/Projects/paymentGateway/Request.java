package org.example.Projects.paymentGateway;

import org.example.Projects.paymentGateway.provider.PaymentProvider;

public class Request {
    private String id;
    private String amount;
    private String userId;
private PaymentProvider provider;

    public PaymentProvider getProvider() {
        return provider;
    }

    public void setProvider(PaymentProvider provider) {
        this.provider = provider;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
