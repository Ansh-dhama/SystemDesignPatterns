package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Checkbox;

public class WindowCheckBox implements Checkbox {
    @Override
    public void rendor() {
        System.out.println("Window checkbox rendor");
    }
}
