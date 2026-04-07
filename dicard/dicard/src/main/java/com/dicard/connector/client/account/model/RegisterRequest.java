package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * User registration request.
 */
public class RegisterRequest {

    @SerializedName("mobileCode")
    private String mobileCode;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("smsCode")
    private String smsCode;

    public RegisterRequest() {}

    public String getMobileCode() { return mobileCode; }
    public RegisterRequest setMobileCode(String mobileCode) { this.mobileCode = mobileCode; return this; }
    public String getMobile() { return mobile; }
    public RegisterRequest setMobile(String mobile) { this.mobile = mobile; return this; }
    public String getSmsCode() { return smsCode; }
    public RegisterRequest setSmsCode(String smsCode) { this.smsCode = smsCode; return this; }

    public void validate() {
        if (mobileCode == null || mobileCode.trim().isEmpty()) {
            throw new IllegalArgumentException("mobileCode is required");
        }
        if (mobile == null || mobile.trim().isEmpty()) {
            throw new IllegalArgumentException("mobile is required");
        }
        if (smsCode == null || smsCode.trim().isEmpty()) {
            throw new IllegalArgumentException("smsCode is required");
        }
    }

    @Override
    public String toString() {
        return "RegisterRequest{mobileCode='" + mobileCode + "', mobile='***'}";
    }
}
