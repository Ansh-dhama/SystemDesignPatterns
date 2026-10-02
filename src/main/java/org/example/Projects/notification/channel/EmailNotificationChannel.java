package org.example.Projects.notification.channel;

import org.example.Projects.notification.ChannelType;
import org.example.Projects.notification.User;
import org.example.Projects.notification.provider.EmailProvider;

public class EmailNotificationChannel implements NotificationChannel {
      private EmailProvider provider;

    public EmailNotificationChannel(EmailProvider provider) {
        this.provider = provider;
    }
    @Override
    public void send(User user, String message) {
        provider.send(user.getEmail() ,message);
    }

    @Override
    public ChannelType getType() {
        return  ChannelType.EMAIL;
    }
}
