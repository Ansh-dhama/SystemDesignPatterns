package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

public class ByAir implements Dilevery {
    @Override
    public void delivery() {
        System.out.println("Delivery by Air");
    }
}
