package org.example.Projects.paymentGateway.gateway;

import org.example.Projects.paymentGateway.Request;
import org.example.Projects.paymentGateway.provider.PaymentProvider;

public class UpiGateway implements PaymentGatewayStrategy {

    private PaymentProvider provider;

    public UpiGateway(PaymentProvider provider) {
        this.provider = provider;
    }

    @Override
    public void pay(Request pay) {
        provider.pay(pay);
    }
}
