package org.example.Projects.notification.factory;

import org.example.Projects.notification.ChannelType;
import org.example.Projects.notification.channel.NotificationChannel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationChannelFactory {
    private final Map<ChannelType, NotificationChannel> channels;

    public NotificationChannelFactory(List<NotificationChannel> notificationChannels) {
            channels  = new HashMap<>();
            for (NotificationChannel channel : notificationChannels) {
                channels.put(channel.getType(), channel);
            }

    }
    public NotificationChannel getChannel(ChannelType channelType) {
        NotificationChannel channel = channels.get(channelType);

        if(channel == null) {
            throw new IllegalArgumentException("No such channel type: " + channelType);
        }
        return channel;
    }
}
