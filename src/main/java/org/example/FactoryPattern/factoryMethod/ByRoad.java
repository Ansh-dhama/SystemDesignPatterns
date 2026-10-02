package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

public class ByRoad implements Dilevery {
    @Override
    public void delivery() {
        System.out.println("Delivery by Road");
    }
}
