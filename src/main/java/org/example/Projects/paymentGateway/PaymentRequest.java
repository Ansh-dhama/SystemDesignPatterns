package org.example.Projects.paymentGateway;

public class PaymentRequest {

    private final String orderId;

    private final Money amount;

    private final PaymentMethodType paymentMethod;

    private final PaymentProviderType provider;

    private final PaymentMethodDetails paymentDetails;

    private final String idempotencyKey;

    public PaymentRequest(
            String orderId,
            Money amount,
            PaymentMethodType paymentMethod,
            PaymentProviderType provider,
            PaymentMethodDetails paymentDetails,
            String idempotencyKey
    ) {

        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.provider = provider;
        this.paymentDetails = paymentDetails;
        this.idempotencyKey = idempotencyKey;
    }

    public String getOrderId() {
        return orderId;
    }

    public Money getAmount() {
        return amount;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentProviderType getProvider() {
        return provider;
    }

    public PaymentMethodDetails getPaymentDetails() {
        return paymentDetails;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }
}