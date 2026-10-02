package org.example.CommondPattern.concreate;

import org.example.CommondPattern.Inteface.ICommond;

public class RemoteControl {
    private static final int NUM_BUTTONS = 4;
    private ICommond[] buttons;
    private boolean[] buttonPressedState;

    public RemoteControl() {
        int numButtons = NUM_BUTTONS;
        this.buttons = new ICommond[numButtons];
        this.buttonPressedState = new boolean[NUM_BUTTONS];
    }

    public void setCommand(int slot, ICommond command) {
        if (slot >= 0 && slot < NUM_BUTTONS) {
            buttons[slot] = command;
            buttonPressedState[slot] = false; // Reset to OFF initial state
        }
    }

    public void pressButton(int slot) {
        if (slot < 0 || slot >= NUM_BUTTONS || buttons[slot] == null) {
            System.out.println("No command assigned at button slot " + slot);
            return;
        }

        // Toggle logic: execute if OFF, undo if ON
        if (!buttonPressedState[slot]) {
            buttons[slot].execute();
            buttonPressedState[slot] = true;
        } else {
            buttons[slot].undo();
            buttonPressedState[slot] = false;
        }
    }
}