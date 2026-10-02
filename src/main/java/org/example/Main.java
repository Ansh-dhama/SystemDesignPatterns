package org.example;

import org.example.Projects.Zomato.DeliveryOrder;
import org.example.Projects.Zomato.Interfaces.Order;
import org.example.Projects.Zomato.PickupOrder;
import org.example.Projects.Zomato.RestaurantManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RestaurantManager r1 = RestaurantManager.getInstance();
        RestaurantManager r2 = RestaurantManager.getInstance();
        System.out.println(r1==r2);

        Order o1 = new DeliveryOrder();
        Order o2 = new PickupOrder();
        System.out.println(o1==o2);
        }
    }
