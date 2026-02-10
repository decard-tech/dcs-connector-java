package com.dicard.connector.client.common.exception;

import java.util.List;
import java.util.Map;

/**
 * Exception class for dicard API errors.
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int code;
    private final Map<String, List<String>> responseHeaders;
    private final String responseBody;

    public ApiException(String message) {
        super(message);
        this.code = 0;
        this.responseHeaders = null;
        this.responseBody = null;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.code = 0;
        this.responseHeaders = null;
        this.responseBody = null;
    }

    public ApiException(String message, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message);
        this.code = code;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    public ApiException(
            String message, Throwable cause, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message, cause);
        this.code = code;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    public int getCode() {
        return code;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }
}

