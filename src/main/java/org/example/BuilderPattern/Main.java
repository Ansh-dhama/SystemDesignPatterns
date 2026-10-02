package org.example.BuilderPattern;

import org.example.BuilderPattern.BuilderwithDirector.HttpRequestDirector;
import org.example.BuilderPattern.ClassicBuilder.HttpRequest;
import org.example.BuilderPattern.StepBuilder.HttpRequestStep;

public class Main {
    public static void main(String[] args) {
        // 1. Classic Builder Demo
        HttpRequest classicRequest = new HttpRequest.HttpRequestBuilder()
                .withUrl("https://api.example.com/data")
                .withMethod("POST")
                .withHeader("Authorization", "Bearer token123")
                .withQueryParam("page", "1")
                .withBody("{\"key\":\"value\"}")
                .withTimeout(60)
                .build();
        classicRequest.execute();

        // 2. Director Demo
        HttpRequest directorGet = HttpRequestDirector.createGetRequest("https://api.example.com/users");
        directorGet.execute();

        HttpRequest directorPost = HttpRequestDirector.createJsonPostRequest(
                "https://api.example.com/users", 
                "{\"name\":\"Ansh\"}"
        );
        directorPost.execute();

        // 3. Step Builder Demo (Enforces Url -> Method -> Header -> Optional/Build)
        HttpRequestStep stepRequest = HttpRequestStep.start()
                .withUrl("https://api.example.com/orders")
                .withMethod("POST")
                .withHeader("Content-Type", "application/json")
                .withBody("{\"orderId\": 101}")
                .withTimeout(45)
                .build();
        stepRequest.execute();
    }
}