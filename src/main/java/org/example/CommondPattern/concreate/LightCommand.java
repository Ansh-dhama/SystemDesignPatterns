package org.example.CommondPattern.concreate;

import org.example.CommondPattern.Inteface.ICommond;
import org.example.CommondPattern.Light;

public class LightCommand implements ICommond {
    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}