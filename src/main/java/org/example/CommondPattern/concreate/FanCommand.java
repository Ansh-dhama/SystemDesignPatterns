package org.example.CommondPattern.concreate;

import org.example.CommondPattern.Fan;
import org.example.CommondPattern.Inteface.ICommond;

public class FanCommand implements ICommond {
    private Fan fan;

    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}