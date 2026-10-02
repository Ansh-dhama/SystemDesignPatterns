package org.example.CommondPattern;

import org.example.CommondPattern.Inteface.ICommond;
import org.example.CommondPattern.concreate.FanCommand;
import org.example.CommondPattern.concreate.LightCommand;
import org.example.CommondPattern.concreate.RemoteControl;

public class Main {
    public static void main(String[] args) {
        // 1. Receivers
        Light livingRoomLight = new Light("Living Room");
        Fan ceilingFan = new Fan("Ceiling");

        // 2. Concrete Commands
        ICommond lightCommand = new LightCommand(livingRoomLight);
        ICommond fanCommand = new FanCommand(ceilingFan);

        // 3. Invoker (Remote)
        RemoteControl remote = new RemoteControl();

        // 4. Assign commands to slots dynamically
        remote.setCommand(0, lightCommand);
        remote.setCommand(1, fanCommand);

        // 5. Test Remote Button Toggles
        System.out.println("--- Pressing Button 0 (Light) Twice ---");
        remote.pressButton(0); // Turns ON
        remote.pressButton(0); // Turns OFF (Undo)

        System.out.println("\n--- Pressing Button 1 (Fan) Twice ---");
        remote.pressButton(1); // Turns ON
        remote.pressButton(1); // Turns OFF (Undo)

        System.out.println("\n--- Pressing Unassigned Button 2 ---");
        remote.pressButton(2);
    }
}