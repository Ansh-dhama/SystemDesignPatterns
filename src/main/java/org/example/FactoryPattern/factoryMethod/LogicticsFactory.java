package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

abstract class LogicticsFactory {
    protected abstract Dilevery dilevery();

    public void planDelivery(){
        Dilevery dilevery =  dilevery();
        System.out.println("prepare");
        dilevery.delivery();
    }
}
