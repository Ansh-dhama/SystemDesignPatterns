package org.example.Projects.notification.provider;

import org.example.Projects.notification.User;

public interface EmailProvider {
    void send(String email, String message);
}
