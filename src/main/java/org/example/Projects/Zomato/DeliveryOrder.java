package org.example.Projects.Zomato;

import org.example.Projects.Zomato.Interfaces.Order;

public class DeliveryOrder extends Order {
    private String userAddress;

    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    @Override
    public String getType() {
        return "DELIVERY";
    }
}

