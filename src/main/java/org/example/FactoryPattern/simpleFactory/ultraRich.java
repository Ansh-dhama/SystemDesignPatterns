package org.example.FactoryPattern.simpleFactory;

import org.example.FactoryPattern.simpleFactory.inteface.Burger;

public class ultraRich implements Burger {
    @Override
    public void prepare() {
        System.out.println("Ultra rich prepare");
    }
}
