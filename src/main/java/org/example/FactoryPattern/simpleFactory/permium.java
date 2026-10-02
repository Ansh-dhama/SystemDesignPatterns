package org.example.FactoryPattern.simpleFactory;

import org.example.FactoryPattern.simpleFactory.inteface.Burger;

public class permium implements Burger {
    @Override
    public void prepare() {
        System.out.println("permium prepare");
    }
}
