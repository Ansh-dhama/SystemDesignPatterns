package org.example.FactoryPattern.simpleFactory;

import org.example.FactoryPattern.simpleFactory.inteface.Burger;

public class basic implements Burger {
    @Override
    public void prepare() {
        System.out.println("basic prepare");
    }
}
