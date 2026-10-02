package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Button;
import org.example.FactoryPattern.abstractMethod.Interface.Checkbox;
import org.example.FactoryPattern.abstractMethod.Interface.UIFactory;

public class MacFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
