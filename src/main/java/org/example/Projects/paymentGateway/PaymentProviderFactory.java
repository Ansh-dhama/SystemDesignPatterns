package org.example.Projects.paymentGateway;

import org.example.Projects.paymentGateway.provider.PaymentProvider;

public class PaymentProviderFactory {

    public PaymentProvider getProvider(Request pay) {

        PaymentProvider provider = pay.getProvider();

        return provider;
    }
}
