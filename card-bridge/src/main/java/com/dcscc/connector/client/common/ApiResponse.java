/*
 * dcs Java Connector
 * API response wrapper class
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common;

import java.util.List;
import java.util.Map;

/**
 * Wrapper class for API responses from dcs.
 * 
 * <p>This class encapsulates the HTTP response information including:
 * <ul>
 *   <li>HTTP status code</li>
 *   <li>Response headers</li>
 *   <li>Parsed response data</li>
 * </ul>
 * 
 * <p>The response data is automatically deserialized from JSON to the specified type.
 * 
 * @param <T> the type of the response data
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApiResponse<T> {

    /** HTTP status code */
    private final int statusCode;
    
    /** HTTP response headers */
    private final Map<String, List<String>> headers;
    
    /** Parsed response data */
    private final T data;

    /**
     * Constructs a new ApiResponse with the specified parameters.
     *
     * @param statusCode the HTTP status code
     * @param headers the HTTP response headers
     * @param data the parsed response data
     */
    public ApiResponse(int statusCode, Map<String, List<String>> headers, T data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }

    /**
     * Gets the HTTP status code.
     *
     * @return the HTTP status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets all HTTP response headers.
     *
     * @return a map of header names to header values
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * Gets the parsed response data.
     *
     * @return the response data, or null if no data was returned
     */
    public T getData() {
        return data;
    }

    /**
     * Gets a specific response header value.
     *
     * @param headerName the name of the header (case-insensitive)
     * @return the first value of the header, or null if not found
     */
    public String getHeader(String headerName) {
        if (headers == null || headerName == null) {
            return null;
        }
        
        // Try exact match first
        List<String> values = headers.get(headerName);
        if (values != null && !values.isEmpty()) {
            return values.get(0);
        }
        
        // Try case-insensitive match
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            if (headerName.equalsIgnoreCase(entry.getKey())) {
                List<String> headerValues = entry.getValue();
                if (headerValues != null && !headerValues.isEmpty()) {
                    return headerValues.get(0);
                }
            }
        }
        
        return null;
    }

    /**
     * Gets all values for a specific response header.
     *
     * @param headerName the name of the header (case-insensitive)
     * @return a list of header values, or null if not found
     */
    public List<String> getHeaderValues(String headerName) {
        if (headers == null || headerName == null) {
            return null;
        }
        
        // Try exact match first
        List<String> values = headers.get(headerName);
        if (values != null) {
            return values;
        }
        
        // Try case-insensitive match
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            if (headerName.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        
        return null;
    }

    /**
     * Checks if the response indicates success (2xx status codes).
     *
     * @return true if the status code is in the 2xx range
     */
    public boolean isSuccessful() {
        return statusCode >= 200 && statusCode < 300;
    }

    /**
     * Checks if the response indicates a client error (4xx status codes).
     *
     * @return true if the status code is in the 4xx range
     */
    public boolean isClientError() {
        return statusCode >= 400 && statusCode < 500;
    }

    /**
     * Checks if the response indicates a server error (5xx status codes).
     *
     * @return true if the status code is in the 5xx range
     */
    public boolean isServerError() {
        return statusCode >= 500 && statusCode < 600;
    }

    /**
     * Gets the request ID from the response headers.
     * 
     * <p>This is a convenience method that looks for common request ID headers
     * used by dcs API.
     *
     * @return the request ID, or null if not found
     */
    public String getRequestId() {
        String requestId = getHeader("X-Request-ID");
        if (requestId == null) {
            requestId = getHeader("Request-ID");
        }
        if (requestId == null) {
            requestId = getHeader("X-Trace-ID");
        }
        return requestId;
    }

    /**
     * Gets the rate limit information from response headers.
     *
     * @return the rate limit remaining count, or null if not available
     */
    public String getRateLimitRemaining() {
        return getHeader("X-RateLimit-Remaining");
    }

    /**
     * Gets the rate limit reset time from response headers.
     *
     * @return the rate limit reset timestamp, or null if not available
     */
    public String getRateLimitReset() {
        return getHeader("X-RateLimit-Reset");
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", headers=" + (headers != null ? headers.keySet() : null) +
                ", data=" + data +
                '}';
    }
}
