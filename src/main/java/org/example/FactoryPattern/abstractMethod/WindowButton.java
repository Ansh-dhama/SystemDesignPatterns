package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Button;

public class WindowButton implements Button {
    @Override
    public void rendor() {
        System.out.println("WindowButton.rendor");
    }
}
