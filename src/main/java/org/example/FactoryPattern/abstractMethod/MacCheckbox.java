package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void rendor() {
        System.out.println("Mac Render Checkbox");
    }
}
