package org.example.Projects.notification.channel;

import org.example.Projects.notification.ChannelType;
import org.example.Projects.notification.User;

public interface NotificationChannel {

    void send(
        User user,
        String message
    );

    ChannelType getType();
}