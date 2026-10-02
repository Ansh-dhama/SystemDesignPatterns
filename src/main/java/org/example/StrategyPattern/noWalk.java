package org.example.StrategyPattern;

import org.example.StrategyPattern.Interface.Walkable;

public class noWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("robot is no walking");
    }
}
