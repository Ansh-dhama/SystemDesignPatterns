package org.example.BridgePattern;

public class Main {
    public static void main(String[] args) {
        // Instantiate different engines (Implementations)
        Engine petrolEngine = new PetrolEngine();
        Engine dieselEngine = new DieselEngine();
        Engine electricEngine = new ElectricEngine();

        // Pair any Car Type (Abstraction) with any Engine Type (Implementation)
        Car mySedan = new Sedan(petrolEngine);
        Car myElectricSUV = new SUV(electricEngine);
        Car myDieselSUV = new SUV(dieselEngine);

        // Drive the vehicles
        System.out.println("--- Testing Sedan ---");
        mySedan.drive();

        System.out.println("--- Testing Electric SUV ---");
        myElectricSUV.drive();

        System.out.println("--- Testing Diesel SUV ---");
        myDieselSUV.drive();
    }
}