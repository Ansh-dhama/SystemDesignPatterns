package org.example.ObserverPattern;

import org.example.ObserverPattern.Interrface.Channel;
import org.example.ObserverPattern.Interrface.Isubscriber;


public class Subscriber implements Isubscriber {
    private String name;
    private youtube channel; // Has-A relationship to fetch details on notification

    public Subscriber(String name, youtube channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        // Fetches data directly from the observable upon notification
        String videoData = channel.getVideoData();
        System.out.println("Hey " + name + "! " + videoData);
    }
}