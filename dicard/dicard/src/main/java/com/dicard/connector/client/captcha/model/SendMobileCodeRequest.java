package com.dicard.connector.client.captcha.model;

import com.google.gson.annotations.SerializedName;

public class SendMobileCodeRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("mobileCode") private String mobileCode;
    @SerializedName("mobile") private String mobile;
    @SerializedName("behavioral") private String behavioral;

    public SendMobileCodeRequest() {}

    public String getExternalUserId() { return externalUserId; } public SendMobileCodeRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public String getMobileCode() { return mobileCode; } public SendMobileCodeRequest setMobileCode(String v) { this.mobileCode = v; return this; }
    public String getMobile() { return mobile; } public SendMobileCodeRequest setMobile(String v) { this.mobile = v; return this; }
    public String getBehavioral() { return behavioral; } public SendMobileCodeRequest setBehavioral(String v) { this.behavioral = v; return this; }

    @Override public String toString() { return "SendMobileCodeRequest{externalUserId='" + externalUserId + "'}"; }
}
