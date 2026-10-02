package org.example.Projects.paymentGateway;

public class CardDetails implements PaymentMethodDetails {

    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryMonth;
    private final String expiryYear;
    private final String cvv;

    public CardDetails(
            String cardNumber,
            String cardHolderName,
            String expiryMonth,
            String expiryYear,
            String cvv
    ) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getCvv() {
        return cvv;
    }
}