package org.example.Projects.Zomato.Payment;

public class NetBanking implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Pay by NetBanking"+ amount);
        return true;
    }
}
