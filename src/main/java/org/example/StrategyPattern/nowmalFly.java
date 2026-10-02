package org.example.StrategyPattern;

import org.example.StrategyPattern.Interface.Flyable;

public class nowmalFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("robot is flying");
    }
}
