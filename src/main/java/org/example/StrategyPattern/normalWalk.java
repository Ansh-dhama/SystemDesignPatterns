package org.example.StrategyPattern;

import org.example.StrategyPattern.Interface.Walkable;

public class normalWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("robot is walking");
    }
}
