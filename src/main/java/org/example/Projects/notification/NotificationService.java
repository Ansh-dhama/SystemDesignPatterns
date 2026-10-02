package org.example.Projects.notification;

import org.example.Projects.notification.*;
import org.example.Projects.notification.channel.NotificationChannel;
import org.example.Projects.notification.factory.NotificationChannelFactory;

import java.util.*;

public class NotificationService {

    private final Map<String, User> users;
    private final Map<String, NotificationPreference> preferences;
    private final Map<String, NotificationTemplate> templates;

    private final TemplateService templateService;
    private final NotificationChannelFactory channelFactory;
    private final RetryableNotificationSender retrySender;

    // Just to maintain notification history in memory
    private final List<Notification> notifications;


    public NotificationService(
            Map<String, User> users,
            Map<String, NotificationPreference> preferences,
            Map<String, NotificationTemplate> templates,
            TemplateService templateService,
            NotificationChannelFactory channelFactory,
            RetryableNotificationSender retrySender
    ) {

        this.users = users;
        this.preferences = preferences;
        this.templates = templates;

        this.templateService = templateService;
        this.channelFactory = channelFactory;
        this.retrySender = retrySender;

        this.notifications = new ArrayList<>();
    }


    public void send(NotificationRequest request) {

        // -----------------------------
        // 1. Find User
        // -----------------------------

        User user = users.get(
                request.getUserId()
        );

        if (user == null) {
            throw new IllegalArgumentException(
                    "User not found"
            );
        }


        // -----------------------------
        // 2. Find User Preference
        // -----------------------------

        NotificationPreference preference =
                preferences.get(user.getUserId());

        if (preference == null) {
            throw new IllegalArgumentException(
                    "Notification preference not found"
            );
        }


        // -----------------------------
        // 3. Find Template
        // -----------------------------

        NotificationTemplate template =
                templates.get(
                        request.getTemplateId()
                );

        if (template == null) {
            throw new IllegalArgumentException(
                    "Template not found"
            );
        }


        // -----------------------------
        // 4. Render Template
        // -----------------------------

        String message =
                templateService.render(
                        template,
                        request.getParameters()
                );


        // -----------------------------
        // 5. Send through enabled channels
        // -----------------------------

        for (ChannelType type :
                preference.getEnabledChannels()) {


            // Create notification
            Notification notification =
                    new Notification();

            notification.setId(
                    UUID.randomUUID().toString()
            );

            notification.setUserId(
                    user.getUserId()
            );

            notification.setChannel(type);

            notification.setMessage(message);

            notification.setStatus(
                    NotificationStatus.Pending
            );


            // Save in memory
            notifications.add(notification);


            // -----------------------------
            // Get correct channel
            // -----------------------------

            NotificationChannel channel =
                    channelFactory.getChannel(type);


            // -----------------------------
            // Send + retry
            // -----------------------------

            boolean success =
                    retrySender.send(
                            channel,
                            user,
                            message
                    );


            // -----------------------------
            // Update Status
            // -----------------------------

            if (success) {

                notification.setStatus(
                        NotificationStatus.Sent
                );

            } else {

                notification.setStatus(
                        NotificationStatus.Failed
                );
            }
        }
    }


    // View notification history
    public List<Notification> getNotifications() {

        return notifications;
    }
}