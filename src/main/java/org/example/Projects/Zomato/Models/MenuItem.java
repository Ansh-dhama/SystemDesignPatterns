package org.example.Projects.Zomato.Models;

public class MenuItem {
     private String name;
     private String id;
    private double price;

    public  MenuItem(String id, String name, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public String getName() {
    return name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
