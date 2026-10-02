package org.example.stateDegienPattern;

public class DispenseState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Please wait! Currently dispensing item.");
        return this;
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please wait! Currently dispensing item.");
        return this;
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        machine.decrementItemCount();
        System.out.println("Item dispensed successfully!");

        if (machine.getItemCount() > 0) {
            return machine.getNoCoinState(); // State Transition -> NoCoinState
        } else {
            System.out.println("Machine is now out of stock!");
            return machine.getSoldOutState(); // State Transition -> SoldOutState
        }
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("Cannot return coin. Item already dispensed!");
        return this;
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println("Cannot refill during dispensation!");
        return this;
    }

    @Override
    public String getStateName() {
        return "DISPENSE_STATE";
    }
}