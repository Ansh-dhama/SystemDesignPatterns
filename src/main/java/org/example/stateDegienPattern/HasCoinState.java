package org.example.stateDegienPattern;

public class HasCoinState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.setInsertedCoins(machine.getInsertedCoins() + coin);
        System.out.println("Additional coin inserted: ₹" + coin + ". Total balance: ₹" + machine.getInsertedCoins());
        return this; // Stay in HasCoinState
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        if (machine.getInsertedCoins() < machine.getItemPrice()) {
            int needed = machine.getItemPrice() - machine.getInsertedCoins();
            System.out.println("Incomplete balance. Please insert ₹" + needed + " more.");
            return this;
        }

        System.out.println("Item selected successfully.");
        int change = machine.getInsertedCoins() - machine.getItemPrice();
        if (change > 0) {
            System.out.println("Returning change: ₹" + change);
        }
        machine.setInsertedCoins(0);
        return machine.getDispenseState(); // State Transition -> DispenseState
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Please select an item first!");
        return this;
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("Returning balance: ₹" + machine.getInsertedCoins());
        machine.setInsertedCoins(0);
        return machine.getNoCoinState(); // State Transition -> NoCoinState
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println("Cannot refill while a transaction is in progress!");
        return this;
    }

    @Override
    public String getStateName() {
        return "HAS_COIN_STATE";
    }
}