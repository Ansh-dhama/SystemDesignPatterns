package org.example.CommondPattern;

public class Fan {
    private String location;

    public Fan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Fan is ON");
    }

    public void off() {
        System.out.println(location + " Fan is OFF");
    }
}