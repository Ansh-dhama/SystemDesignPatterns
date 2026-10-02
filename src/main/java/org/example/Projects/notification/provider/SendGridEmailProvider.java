package org.example.Projects.notification.provider;

public class SendGridEmailProvider implements EmailProvider {
    @Override
    public void send(String email, String message) {
        System.out.println("Sending email to: " + email + " with message: " + message);
    }

}
