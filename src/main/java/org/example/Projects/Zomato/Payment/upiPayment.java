package org.example.Projects.Zomato.Payment;

public class upiPayment implements Payment {

    @Override
    public boolean pay(double amount) {
        System.out.println("Pay by upi"+ amount);
        return true;
    }
}
