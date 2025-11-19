/*
 * dcs Java Connector
 * API exception class for dcs API errors
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.exception;

import java.util.List;
import java.util.Map;

/**
 * Exception class for dcs API errors.
 * 
 * <p>This exception is thrown when API calls fail due to various reasons such as:
 * <ul>
 *   <li>HTTP errors (4xx, 5xx status codes)</li>
 *   <li>Network connectivity issues</li>
 *   <li>Authentication failures</li>
 *   <li>Request/response parsing errors</li>
 *   <li>Invalid parameters</li>
 * </ul>
 * 
 * <p>The exception provides detailed information about the error including:
 * <ul>
 *   <li>HTTP status code (if applicable)</li>
 *   <li>Response headers</li>
 *   <li>Response body</li>
 *   <li>Error message</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>{@code
 * try {
 *     ApiResponse<CardResponse> response = cardApi.getCard("card-id");
 * } catch (ApiException e) {
 *     System.err.println("API call failed: " + e.getMessage());
 *     System.err.println("HTTP Status: " + e.getCode());
 *     System.err.println("Response Body: " + e.getResponseBody());
 * }
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /** HTTP status code (0 if not applicable) */
    private final int code;
    
    /** HTTP response headers */
    private final Map<String, List<String>> responseHeaders;
    
    /** HTTP response body */
    private final String responseBody;

    /**
     * Constructs a new ApiException with the specified message.
     *
     * @param message the error message
     */
    public ApiException(String message) {
        super(message);
        this.code = 0;
        this.responseHeaders = null;
        this.responseBody = null;
    }

    /**
     * Constructs a new ApiException with the specified message and cause.
     *
     * @param message the error message
     * @param cause the underlying cause of the exception
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.code = 0;
        this.responseHeaders = null;
        this.responseBody = null;
    }

    /**
     * Constructs a new ApiException with HTTP response details.
     *
     * @param message the error message
     * @param code the HTTP status code
     * @param responseHeaders the HTTP response headers
     * @param responseBody the HTTP response body
     */
    public ApiException(String message, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message);
        this.code = code;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    /**
     * Constructs a new ApiException with HTTP response details and cause.
     *
     * @param message the error message
     * @param cause the underlying cause of the exception
     * @param code the HTTP status code
     * @param responseHeaders the HTTP response headers
     * @param responseBody the HTTP response body
     */
    public ApiException(String message, Throwable cause, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message, cause);
        this.code = code;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    /**
     * Gets the HTTP status code.
     *
     * @return the HTTP status code, or 0 if not applicable
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the HTTP response headers.
     *
     * @return the response headers, or null if not available
     */
    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * Gets the HTTP response body.
     *
     * @return the response body, or null if not available
     */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     * Checks if this exception represents an HTTP error.
     *
     * @return true if this exception has an HTTP status code
     */
    public boolean isHttpError() {
        return code > 0;
    }

    /**
     * Checks if this exception represents a client error (4xx status codes).
     *
     * @return true if the status code is in the 4xx range
     */
    public boolean isClientError() {
        return code >= 400 && code < 500;
    }

    /**
     * Checks if this exception represents a server error (5xx status codes).
     *
     * @return true if the status code is in the 5xx range
     */
    public boolean isServerError() {
        return code >= 500 && code < 600;
    }

    /**
     * Checks if this exception represents an authentication error (401 status code).
     *
     * @return true if the status code is 401
     */
    public boolean isAuthenticationError() {
        return code == 401;
    }

    /**
     * Checks if this exception represents an authorization error (403 status code).
     *
     * @return true if the status code is 403
     */
    public boolean isAuthorizationError() {
        return code == 403;
    }

    /**
     * Checks if this exception represents a not found error (404 status code).
     *
     * @return true if the status code is 404
     */
    public boolean isNotFoundError() {
        return code == 404;
    }

    /**
     * Checks if this exception represents a rate limit error (429 status code).
     *
     * @return true if the status code is 429
     */
    public boolean isRateLimitError() {
        return code == 429;
    }

    /**
     * Gets a specific response header value.
     *
     * @param headerName the name of the header
     * @return the first value of the header, or null if not found
     */
    public String getResponseHeader(String headerName) {
        if (responseHeaders == null || headerName == null) {
            return null;
        }
        
        List<String> values = responseHeaders.get(headerName);
        return (values != null && !values.isEmpty()) ? values.get(0) : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiException{");
        sb.append("message='").append(getMessage()).append('\'');
        
        if (code > 0) {
            sb.append(", code=").append(code);
        }
        
        if (responseBody != null && !responseBody.isEmpty()) {
            sb.append(", responseBody='").append(responseBody).append('\'');
        }
        
        sb.append('}');
        return sb.toString();
    }
}
