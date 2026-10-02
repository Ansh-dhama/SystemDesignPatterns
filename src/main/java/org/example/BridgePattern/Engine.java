package org.example.BridgePattern;

// Low-Level Implementor Interface
interface Engine {
    void start();
}

// Concrete Implementor 1
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine starting with ignition spark...");
    }
}

// Concrete Implementor 2
class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel engine starting with high compression...");
    }
}

// Concrete Implementor 3
class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric motor powering up silently...");
    }
}