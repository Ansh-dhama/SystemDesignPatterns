package org.example.ObserverPattern.Interrface;

import java.util.Observer;

public interface Channel {
    void add(Isubscriber isub);
    void remove(Isubscriber isub);
    void notifyObservers();
}
