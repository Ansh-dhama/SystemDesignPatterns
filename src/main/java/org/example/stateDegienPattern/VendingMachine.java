package org.example.stateDegienPattern;

public class VendingMachine {
    private VendingMachineState currentState;

    // Shared State Instances
    private final VendingMachineState noCoinState;
    private final VendingMachineState hasCoinState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState soldOutState;

    private int itemCount;
    private final int itemPrice;
    private int insertedCoins;

    public VendingMachine(int itemCount, int itemPrice) {
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.insertedCoins = 0;

        this.noCoinState = new NoCoinState();
        this.hasCoinState = new HasCoinState();
        this.dispenseState = new DispenseState();
        this.soldOutState = new SoldOutState();

        if (itemCount > 0) {
            this.currentState = noCoinState;
        } else {
            this.currentState = soldOutState;
        }
    }

    // Delegation Methods
    public void insertCoin(int coin) {
        this.currentState = currentState.insertCoin(this, coin);
    }

    public void selectItem() {
        this.currentState = currentState.selectItem(this);
    }

    public void dispense() {
        this.currentState = currentState.dispense(this);
    }

    public void returnCoin() {
        this.currentState = currentState.returnCoin(this);
    }

    public void refill(int quantity) {
        this.currentState = currentState.refill(this, quantity);
    }

    public void printStatus() {
        System.out.println("\n--- Vending Machine Status ---");
        System.out.println("Current State   : " + currentState.getStateName());
        System.out.println("Items Remaining : " + itemCount);
        System.out.println("Inserted Coins  : ₹" + insertedCoins);
        System.out.println("------------------------------\n");
    }

    // Getters and Mutators used by State Classes
    public VendingMachineState getNoCoinState() { return noCoinState; }
    public VendingMachineState getHasCoinState() { return hasCoinState; }
    public VendingMachineState getDispenseState() { return dispenseState; }
    public VendingMachineState getSoldOutState() { return soldOutState; }

    public int getItemCount() { return itemCount; }
    public void incrementItemCount(int quantity) { this.itemCount += quantity; }
    public void decrementItemCount() { if (this.itemCount > 0) this.itemCount--; }

    public int getItemPrice() { return itemPrice; }
    public int getInsertedCoins() { return insertedCoins; }
    public void setInsertedCoins(int insertedCoins) { this.insertedCoins = insertedCoins; }
}