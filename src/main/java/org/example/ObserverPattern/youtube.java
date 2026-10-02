package org.example.ObserverPattern;

import org.example.ObserverPattern.Interrface.Channel;
import org.example.ObserverPattern.Interrface.Isubscriber;

import java.util.ArrayList;
import java.util.List;

public class youtube implements Channel {
   private String channelName;
   private List<Isubscriber> subscribers;
   private String latestVideo;
   public youtube(String channelName) {
      this.channelName = channelName;
      this.subscribers = new ArrayList<>();
   }
    @Override
    public void add(Isubscriber isub) {
        if(subscribers.contains(isub))
            return;
        subscribers.add(isub);
    }

    @Override
    public void remove(Isubscriber isub) {
      if (subscribers.contains(isub)){
          subscribers.remove(isub);
      }
    }

    @Override
    public void notifyObservers() {
        for (Isubscriber isub : subscribers) {
            isub.update();
        }

    } // Business Logic Method
    public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println("\n[" + channelName + "] uploaded a new video: \"" + title + "\"");
        notifyObservers(); // Triggers update() on all subscribed observers
    }

    public String getVideoData() {
        return "Check out our new video: \"" + latestVideo + "\" on " + channelName;
    }

    public String getChannelName() {
        return channelName;
    }
}
