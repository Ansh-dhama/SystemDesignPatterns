package org.example.Projects.paymentGateway.gateway;

import org.example.Projects.paymentGateway.Request;

public interface PaymentGatewayStrategy {
    void pay(Request pay);
}
