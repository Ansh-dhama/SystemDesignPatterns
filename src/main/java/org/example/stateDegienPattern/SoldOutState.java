package org.example.stateDegienPattern;

public class SoldOutState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Machine SOLD OUT! Returning inserted coin: ₹" + coin);
        return this;
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Machine SOLD OUT!");
        return this;
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Machine SOLD OUT!");
        return this;
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("No balance available to return.");
        return this;
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.incrementItemCount(quantity);
        System.out.println("Refilled " + quantity + " items. Machine active now.");
        return machine.getNoCoinState(); // State Transition -> NoCoinState
    }

    @Override
    public String getStateName() {
        return "SOLD_OUT_STATE";
    }
}