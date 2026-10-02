package org.example.Projects.notification;

import java.util.Map;

public class TemplateService {

    public String render(
            NotificationTemplate template,
            Map<String, String> values
    ) {

        String message = template.getContent();

        for (var entry : values.entrySet()) {

            message = message.replace(
                "{" + entry.getKey() + "}",
                entry.getValue()
            );
        }

        return message;
    }
}