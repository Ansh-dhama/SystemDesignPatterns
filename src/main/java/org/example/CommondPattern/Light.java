package org.example.CommondPattern;

public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Light is ON");
    }

    public void off() {
        System.out.println(location + " Light is OFF");
    }
}