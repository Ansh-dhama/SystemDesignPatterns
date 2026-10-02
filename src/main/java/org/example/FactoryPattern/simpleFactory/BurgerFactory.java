package org.example.FactoryPattern.simpleFactory;

import org.example.FactoryPattern.simpleFactory.inteface.Burger;

public class BurgerFactory {
    Burger burger;
    public void createBurger(String type) {
        if (type.equalsIgnoreCase("Basic")) {
            burger = new basic();
        }else if (type.equalsIgnoreCase("permium")) {
            burger = new permium();
        }
        else if (type.equalsIgnoreCase("ultraRich")) {
            burger = new ultraRich();
        }
         burger.prepare();
    }
}
