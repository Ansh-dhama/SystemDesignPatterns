package org.example.DecoratorPattern;

import org.example.DecoratorPattern.Interface.Coffee;
import org.example.ObserverPattern.Interrface.Channel;

public class BasicCoffee implements Coffee {


    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getPrice() {
        return 5;
    }
}
