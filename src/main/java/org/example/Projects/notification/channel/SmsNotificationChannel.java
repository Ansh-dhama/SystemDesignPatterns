package org.example.Projects.notification.channel;

import org.example.Projects.notification.ChannelType;
import org.example.Projects.notification.User;
import org.example.Projects.notification.provider.SmsProvider;

public class SmsNotificationChannel implements NotificationChannel {
     SmsProvider provider;
     public SmsNotificationChannel(SmsProvider provider) {
         this.provider = provider;
     }
    @Override
    public void send(User user, String message) {
        provider.send(user.getPhoneNumber(),message);
    }

    @Override
    public ChannelType getType() {
        return ChannelType.SMS;
    }
}
