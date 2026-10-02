package org.example.Projects.notification;

import org.example.Projects.notification.NotificationStatus;

public class Notification {

    private String id;

    private String userId;

    private ChannelType channel;

    private String message;

    private NotificationStatus status;

    private int retryCount;


    public Notification() {
    }


    public Notification(
            String id,
            String userId,
            ChannelType channel,
            String message,
            NotificationStatus status,
            int retryCount
    ) {
        this.id = id;
        this.userId = userId;
        this.channel = channel;
        this.message = message;
        this.status = status;
        this.retryCount = retryCount;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public ChannelType getChannel() {
        return channel;
    }

    public void setChannel(ChannelType channel) {
        this.channel = channel;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }


    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }


    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", channel=" + channel +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", retryCount=" + retryCount +
                '}';
    }
}