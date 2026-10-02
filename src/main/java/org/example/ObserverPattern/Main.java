package org.example.ObserverPattern;

import org.example.ObserverPattern.Interrface.Channel;

import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {

        youtube coderArmy = new youtube("Coder Army");

        Subscriber sub1 = new Subscriber("Varun", coderArmy);
        Subscriber sub2 = new Subscriber("Tarun", coderArmy);

        coderArmy.add(sub1);
        coderArmy.add(sub2);

        coderArmy.uploadVideo("Observer Design Pattern Tutorial");

        System.out.println("\n--- Varun unsubscribes ---");
        coderArmy.remove(sub1);

        coderArmy.uploadVideo("Decorator Design Pattern Tutorial");
    }
}