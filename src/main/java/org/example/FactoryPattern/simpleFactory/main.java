package org.example.FactoryPattern.simpleFactory;

public class main {
    public static void main(String[] args) {
        BurgerFactory burgerFactory = new BurgerFactory();

        burgerFactory.createBurger("ultraRich");
    }
}
