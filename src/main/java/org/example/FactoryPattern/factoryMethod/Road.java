package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

public class Road extends LogicticsFactory {

    @Override
    protected Dilevery dilevery() {
        return new ByRoad();
    }
}
