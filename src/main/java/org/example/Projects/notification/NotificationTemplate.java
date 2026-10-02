package org.example.Projects.notification;

class NotificationTemplate {

    String id;
    String name;
    String content;
    NotificationTemplate(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    public void setName(String name) {
        this.name = name;
    }


}