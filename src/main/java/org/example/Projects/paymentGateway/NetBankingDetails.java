package org.example.Projects.paymentGateway;

public class NetBankingDetails implements PaymentMethodDetails {

    private final String bankCode;

    public NetBankingDetails(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }
}