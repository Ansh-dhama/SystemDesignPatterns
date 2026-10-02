package org.example.StrategyPattern;

import org.example.StrategyPattern.Interface.Flyable;
import org.example.StrategyPattern.Interface.Walkable;

public class noFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("robot is not flying");
    }
}
