package org.example.Projects.notification;

import org.example.ObserverPattern.Interrface.Channel;
import org.example.Projects.notification.channel.NotificationChannel;

public class RetryableNotificationSender {
    private int maxRetries;

    public RetryableNotificationSender(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public boolean send(NotificationChannel channel, User user , String messege) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try{
             channel.send(user, messege);
             return true;
            }catch(Exception e){
                attempts++;
            }
        }
        return false;
    }
}
