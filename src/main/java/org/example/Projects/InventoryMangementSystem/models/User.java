package org.example.Projects.InventoryMangementSystem.models;

public class User {
    private final String name;
    private final double x;
    private final double y;
    private final Cart cart;

    public User(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.cart = new Cart();
    }

    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
    public Cart getCart() { return cart; }
}