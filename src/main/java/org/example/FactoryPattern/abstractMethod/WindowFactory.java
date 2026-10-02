package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Button;
import org.example.FactoryPattern.abstractMethod.Interface.Checkbox;
import org.example.FactoryPattern.abstractMethod.Interface.UIFactory;

public class WindowFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowCheckBox();
    }
}
