package org.example.Projects.notification.provider;

public class TwilioSmsProvider implements SmsProvider {

    @Override
    public void send(String no, String message) {
        System.out.println("Sending SMS to " + no + "with message " + message);
    }
}
