package org.example.Projects.notification;

import java.util.Set;

class NotificationPreference {

    String userId;

    Set<ChannelType> enabledChannels;

    public NotificationPreference(String u1, Set<ChannelType> email) {
        userId = u1;
        enabledChannels = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<ChannelType> getEnabledChannels() {
        return enabledChannels;
    }

    public void setEnabledChannels(Set<ChannelType> enabledChannels) {
        this.enabledChannels = enabledChannels;
    }
}