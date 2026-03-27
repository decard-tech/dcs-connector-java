package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class CreateUserRequest {
    @SerializedName("userRef") private String userRef;
    @SerializedName("mobilePhone") private String mobilePhone;
    @SerializedName("mobileAreaCode") private String mobileAreaCode;
    @SerializedName("email") private String email;

    public CreateUserRequest() {}
    public String getUserRef() { return userRef; }
    public CreateUserRequest setUserRef(String userRef) { this.userRef = userRef; return this; }
    public String getMobilePhone() { return mobilePhone; }
    public CreateUserRequest setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; return this; }
    public String getMobileAreaCode() { return mobileAreaCode; }
    public CreateUserRequest setMobileAreaCode(String mobileAreaCode) { this.mobileAreaCode = mobileAreaCode; return this; }
    public String getEmail() { return email; }
    public CreateUserRequest setEmail(String email) { this.email = email; return this; }

    public void validate() {
        if (userRef == null || userRef.trim().isEmpty()) throw new IllegalArgumentException("userRef is required");
        if (mobilePhone == null || mobilePhone.trim().isEmpty()) throw new IllegalArgumentException("mobilePhone is required");
        if (mobileAreaCode == null || mobileAreaCode.trim().isEmpty()) throw new IllegalArgumentException("mobileAreaCode is required");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("email is required");
    }

    @Override public String toString() { return "CreateUserRequest{userRef='" + userRef + "', email='" + email + "'}"; }
}
