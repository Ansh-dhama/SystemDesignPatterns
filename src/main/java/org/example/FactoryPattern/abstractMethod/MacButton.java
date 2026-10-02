package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Button;

public class MacButton implements Button {
    @Override
    public void rendor() {
        System.out.println("Mac Render Button");
    }
}
