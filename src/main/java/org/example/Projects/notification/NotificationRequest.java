package org.example.Projects.notification;

import java.util.Map;

public class NotificationRequest {

    private String userId;
    private String templateId;
    private Map<String, String> parameters;

    public NotificationRequest(
            String userId,
            String templateId,
            Map<String, String> parameters
    ) {
        this.userId = userId;
        this.templateId = templateId;
        this.parameters = parameters;
    }

    public String getUserId() {
        return userId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}