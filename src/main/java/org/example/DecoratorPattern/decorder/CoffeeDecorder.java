package org.example.DecoratorPattern.decorder;


import org.example.DecoratorPattern.Interface.Coffee;

public abstract class CoffeeDecorder implements Coffee {
    protected final Coffee coffee;
    public CoffeeDecorder(Coffee coffee) {
        this.coffee = coffee;
    }

}
