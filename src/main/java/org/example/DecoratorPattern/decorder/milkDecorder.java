package org.example.DecoratorPattern.decorder;

import org.example.DecoratorPattern.Interface.Coffee;

public class milkDecorder extends CoffeeDecorder {

    public milkDecorder(Coffee coffee) {
        super(coffee);
    }


    @Override
    public String getDescription() {
        return coffee.getDescription() + "add milk";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice()+10;
    }
}
