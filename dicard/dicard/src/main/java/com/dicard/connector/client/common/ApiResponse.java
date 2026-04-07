package com.dicard.connector.client.common;

import java.util.List;
import java.util.Map;

/**
 * Wrapper class for API responses from dicard.
 *
 * @param <T> the type of the response data
 */
public class ApiResponse<T> {

    private final int statusCode;
    private final Map<String, List<String>> headers;
    private final T data;

    public ApiResponse(int statusCode, Map<String, List<String>> headers, T data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public T getData() {
        return data;
    }
}

