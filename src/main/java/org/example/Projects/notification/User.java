package org.example.Projects.notification;


public class User {
    String userId;
    String userName;
    String email;
    String phoneNumber;
    String deviceId;

    public User( String userId, String userName, String email, String phoneNumber, String deviceId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deviceId = deviceId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;

    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
