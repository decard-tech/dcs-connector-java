package com.dicard.connector.client.common;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Common response wrapper for all dicard API responses.
 *
 * <p>All dicard API endpoints return responses wrapped in this common format
 * which includes status information and the actual data payload.
 *
 * @param <T> the type of the data payload
 */
public class CommonRet<T> {

    @SerializedName("code")
    private String code;

    @SerializedName("data")
    private T data;

    @SerializedName("success")
    private Boolean success;

    @SerializedName("message")
    private String message;

    public CommonRet() {
    }

    public CommonRet(String code, T data, Boolean success, String message) {
        this.code = code;
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public CommonRet<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonRet<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public CommonRet<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonRet<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isSuccessful() {
        return Boolean.TRUE.equals(success) && "SYS_SUCCESS".equals(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonRet<?> commonRet = (CommonRet<?>) o;
        return Objects.equals(code, commonRet.code)
                && Objects.equals(data, commonRet.data)
                && Objects.equals(success, commonRet.success)
                && Objects.equals(message, commonRet.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data, success, message);
    }

    @Override
    public String toString() {
        return "CommonRet{"
                + "code='" + code + '\''
                + ", data=" + data
                + ", success=" + success
                + ", message='" + message + '\''
                + '}';
    }
}
