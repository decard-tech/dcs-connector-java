/*
 * dcs Java Connector
 * Common response wrapper
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Common response wrapper for all dcs API responses.
 * 
 * <p>All dcs API endpoints return responses wrapped in this common format
 * which includes status information and the actual data payload.
 * 
 * @param <T> the type of the data payload
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommonRet<T> {

    /**
     * Response code indicating the result of the operation.
     */
    @SerializedName("code")
    private String code;

    /**
     * The actual data payload of the response.
     */
    @SerializedName("data")
    private T data;

    /**
     * Boolean flag indicating whether the operation was successful.
     */
    @SerializedName("success")
    private Boolean success;

    /**
     * Optional error message if the operation failed.
     */
    @SerializedName("message")
    private String message;

    /**
     * Default constructor.
     */
    public CommonRet() {
    }

    /**
     * Constructor with all parameters.
     *
     * @param code the response code
     * @param data the data payload
     * @param success the success flag
     * @param message the error message (optional)
     */
    public CommonRet(String code, T data, Boolean success, String message) {
        this.code = code;
        this.data = data;
        this.success = success;
        this.message = message;
    }

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the response code.
     *
     * @param code the response code to set
     * @return this CommonRet instance for method chaining
     */
    public CommonRet<T> setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Gets the data payload.
     *
     * @return the data payload
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data payload.
     *
     * @param data the data payload to set
     * @return this CommonRet instance for method chaining
     */
    public CommonRet<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * Gets the success flag.
     *
     * @return true if the operation was successful, false otherwise
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Sets the success flag.
     *
     * @param success the success flag to set
     * @return this CommonRet instance for method chaining
     */
    public CommonRet<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     *
     * @param message the error message to set
     * @return this CommonRet instance for method chaining
     */
    public CommonRet<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Checks if the response indicates success.
     *
     * @return true if successful, false otherwise
     */
    public boolean isSuccessful() {
        return Boolean.TRUE.equals(success) && "SYS_SUCCESS".equals(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonRet<?> commonRet = (CommonRet<?>) o;
        return Objects.equals(code, commonRet.code) &&
                Objects.equals(data, commonRet.data) &&
                Objects.equals(success, commonRet.success) &&
                Objects.equals(message, commonRet.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data, success, message);
    }

    @Override
    public String toString() {
        return "CommonRet{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
