package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

public class main {
    public static void main(String[] args) {
        LogicticsFactory logicticsFactory = new Road();
        logicticsFactory.planDelivery();
    }
}
