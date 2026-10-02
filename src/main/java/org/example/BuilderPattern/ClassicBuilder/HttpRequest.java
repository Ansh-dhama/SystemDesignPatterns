    package org.example.BuilderPattern.ClassicBuilder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    private HttpRequest(HttpRequestBuilder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    public void execute() {
        System.out.println("Executing " + method + " request to " + url);
        System.out.println("Headers: " + headers);
        System.out.println("Query Params: " + queryParams);
        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout + "s\n");
    }

    public static class HttpRequestBuilder {
        private String url;
        private String method = "GET";
        private final Map<String, String> headers = new HashMap<>();
        private final Map<String, String> queryParams = new HashMap<>();
        private String body;
        private int timeout = 30;

        public HttpRequestBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public HttpRequestBuilder withMethod(String method) {
            this.method = method;
            return this;
        }

        public HttpRequestBuilder withHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequestBuilder withQueryParam(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }

        public HttpRequestBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public HttpRequestBuilder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("URL cannot be null or empty");
            }
            return new HttpRequest(this);
        }
    }
}