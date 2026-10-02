package org.example.BridgePattern;

// High-Level Abstraction
abstract class Car {
    protected Engine engine; // Bridge Reference to Implementation

    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}

// Refined Abstraction 1
class Sedan extends Car {
    public Sedan(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving a smooth Sedan on the highway.\n");
    }
}

// Refined Abstraction 2
class SUV extends Car {
    public SUV(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving a powerful SUV off-road.\n");
    }
}