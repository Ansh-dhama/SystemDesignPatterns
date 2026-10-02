package org.example.Projects.paymentGateway.provider;

import org.example.Projects.paymentGateway.Request;

public interface PaymentProvider {
    void pay(Request pay);

    PaymentProvider getProvider();
}
