package org.example.DecoratorPattern.decorder;

import org.example.DecoratorPattern.Interface.Coffee;

public class sugurDecorder extends CoffeeDecorder{

    public sugurDecorder(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return  coffee.getDescription() + "added sugar";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 0.5;
    }
}
