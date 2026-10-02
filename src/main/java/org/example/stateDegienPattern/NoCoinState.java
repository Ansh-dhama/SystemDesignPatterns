package org.example.stateDegienPattern;

public class NoCoinState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.setInsertedCoins(machine.getInsertedCoins() + coin);
        System.out.println("Coin inserted: ₹" + coin + ". Total balance: ₹" + machine.getInsertedCoins());
        return machine.getHasCoinState(); // State Transition -> HasCoinState
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please insert coin first!");
        return this; // Remain in NoCoinState
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Dispense not allowed. Please insert coin and select item first.");
        return this;
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("No coin inserted to return!");
        return this;
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.incrementItemCount(quantity);
        System.out.println("Item refilled. Total items: " + machine.getItemCount());
        return this;
    }

    @Override
    public String getStateName() {
        return "NO_COIN_STATE";
    }
}