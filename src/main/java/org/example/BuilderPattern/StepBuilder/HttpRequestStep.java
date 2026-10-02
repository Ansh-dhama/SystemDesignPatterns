package org.example.BuilderPattern.StepBuilder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestStep {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;

    private HttpRequestStep(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    public void execute() {
        System.out.println("[StepBuilder] Executing " + method + " request to " + url);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout + "s\n");
    }

    // Sequential Step Interfaces
    public interface UrlStep {
        MethodStep withUrl(String url);
    }

    public interface MethodStep {
        HeaderStep withMethod(String method);
    }

    public interface HeaderStep {
        OptionalStep withHeader(String key, String value);
    }

    public interface OptionalStep {
        OptionalStep withBody(String body);
        OptionalStep withTimeout(int timeout);
        HttpRequestStep build();
    }

    public static UrlStep start() {
        return new Builder();
    }

    private static class Builder implements UrlStep, MethodStep, HeaderStep, OptionalStep {
        private String url;
        private String method;
        private final Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 30;

        @Override
        public MethodStep withUrl(String url) {
            this.url = url;
            return this;
        }

        @Override
        public HeaderStep withMethod(String method) {
            this.method = method;
            return this;
        }

        @Override
        public OptionalStep withHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        @Override
        public OptionalStep withBody(String body) {
            this.body = body;
            return this;
        }

        @Override
        public OptionalStep withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        @Override
        public HttpRequestStep build() {
            return new HttpRequestStep(this);
        }
    }
}