package org.example.Projects.notification;

import org.example.Projects.notification.channel.EmailNotificationChannel;
import org.example.Projects.notification.channel.NotificationChannel;
import org.example.Projects.notification.channel.SmsNotificationChannel;
import org.example.Projects.notification.factory.NotificationChannelFactory;
import org.example.Projects.notification.provider.EmailProvider;
import org.example.Projects.notification.provider.SendGridEmailProvider;
import org.example.Projects.notification.provider.SmsProvider;
import org.example.Projects.notification.provider.TwilioSmsProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main {
    public static void main(String[] args) {

      //1 create user
        Map<String , User> users = new HashMap<>();
        User user1 = new User(
                "U1",
                "Ansh",
                "ansh@gmail.com",
                "9876543210",
                "DEVICE_TOKEN_101"
        );

        users.put(
                user1.getUserId(),
                user1
        );

//2 create preference
        Map<String, NotificationPreference> preferences =
                new HashMap<>();

        NotificationPreference preference =
                new NotificationPreference(
                        "U1",
                        Set.of(
                                ChannelType.EMAIL,
                                ChannelType.SMS
                        )
                );

        preferences.put(
                "U1",
                preference
        );



        //3 create templ

        Map<String, NotificationTemplate> templates =
                new HashMap<>();

        NotificationTemplate orderTemplate =
                new NotificationTemplate(
                        "T1",
                        "Order Shipped",
                        "Hello {name}, your order {orderId} has been shipped."
                );

        templates.put(
                "T1",
                orderTemplate
        );


        //4- create provider

        EmailProvider emailProvider =
                new SendGridEmailProvider();

        SmsProvider smsProvider =
                new TwilioSmsProvider();



        //5 create email strategy
        NotificationChannel emailChannel =
                new EmailNotificationChannel(
                        emailProvider
                );

        NotificationChannel smsChannel =
                new SmsNotificationChannel(
                        smsProvider
                );


        //6 create  channel factory

        List<NotificationChannel> channels =
                List.of(
                        emailChannel,
                        smsChannel
                );

        NotificationChannelFactory factory = new NotificationChannelFactory(channels);

        // =====================================================
        // 7. CREATE TEMPLATE SERVICE
        // =====================================================

        TemplateService templateService =
                new TemplateService();


        // =====================================================
        // 8. CREATE RETRY SENDER
        // =====================================================

        RetryableNotificationSender retrySender =
                new RetryableNotificationSender(
                        3
                );



        // 9:- now create notificationService

        NotificationService notificationService =
                new NotificationService(
                        users,
                        preferences,
                        templates,
                        templateService,
                        factory,
                        retrySender
                );


        // 10. CREATE REQUEST PARAMETERS
        // =====================================================

        Map<String, String> parameters =
                new HashMap<>();

        parameters.put(
                "name",
                "Ansh"
        );

        parameters.put(
                "orderId",
                "ORD-101"
        );

         // 11- create  notification request

        NotificationRequest request =
                new NotificationRequest(
                        "U1",
                        "T1",
                        parameters
                );
        //12 - send notification

        notificationService.send(request);


        //13:- notification history
        System.out.println(
                "\n======= Notification History ======="
        );

        for (Notification notification :
                notificationService.getNotifications()) {

            System.out.println(
                    notification
            );
        }


    }
}
