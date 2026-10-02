package org.example.FactoryPattern.abstractMethod;

import org.example.FactoryPattern.abstractMethod.Interface.Button;
import org.example.FactoryPattern.abstractMethod.Interface.Checkbox;
import org.example.FactoryPattern.abstractMethod.Interface.UIFactory;

public class main {
    public static void main(String[] args) {
        UIFactory ui= new MacFactory();
       Button b =  ui.createButton();
       Checkbox c =  ui.createCheckbox();
       b.rendor();
       c.rendor();
    }
}
