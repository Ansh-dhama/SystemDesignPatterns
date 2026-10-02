package org.example.FactoryPattern.factoryMethod;

import org.example.FactoryPattern.factoryMethod.Interface.Dilevery;

public class Air extends LogicticsFactory {

    @Override
    protected Dilevery dilevery() {
        return new ByAir();
    }
}
