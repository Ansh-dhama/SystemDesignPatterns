package org.example.stateDegienPattern;

public class Main {
    public static void main(String[] args) {
        // Initialize Vending Machine with 2 Items @ ₹20 each
        VendingMachine machine = new VendingMachine(2, 20);
        machine.printStatus();

        System.out.println("--- 1. Selecting Item without inserting coins ---");
        machine.selectItem();

        System.out.println("\n--- 2. Inserting ₹10 (Incomplete Balance) ---");
        machine.insertCoin(10);
        machine.selectItem();

        System.out.println("\n--- 3. Inserting ₹10 more & Dispensing Product 1 ---");
        machine.insertCoin(10);
        machine.selectItem();
        machine.dispense();
        machine.printStatus();

        System.out.println("--- 4. Buying Product 2 (Stock becomes 0) ---");
        machine.insertCoin(20);
        machine.selectItem();
        machine.dispense();
        machine.printStatus();

        System.out.println("--- 5. Attempting purchase when Sold Out ---");
        machine.insertCoin(20);

        System.out.println("\n--- 6. Refilling 5 Items ---");
        machine.refill(5);
        machine.printStatus();
    }
}