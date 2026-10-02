package org.example.DecoratorPattern;

import org.example.DecoratorPattern.Interface.Coffee;
import org.example.DecoratorPattern.decorder.milkDecorder;

public class main {
    public static void main(String[] args) {
        Coffee coffee =
                new milkDecorder(
                        new BasicCoffee()
                );

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getPrice());

    }
}
