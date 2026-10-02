package org.example.Projects.Zomato.Models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
   private String address;
    private Cart cart;
    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
            return  cart;
    }
}
