package com.dicard.connector.client.qrpay.model;

import com.google.gson.annotations.SerializedName;

public class QrPayDecodeRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("qrCodeValue") private String qrCodeValue;
    @SerializedName("clientIP") private String clientIP;

    public QrPayDecodeRequest() {}

    public String getExternalUserId() { return externalUserId; } public QrPayDecodeRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public String getQrCodeValue() { return qrCodeValue; } public QrPayDecodeRequest setQrCodeValue(String v) { this.qrCodeValue = v; return this; }
    public String getClientIP() { return clientIP; } public QrPayDecodeRequest setClientIP(String v) { this.clientIP = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (qrCodeValue == null || qrCodeValue.trim().isEmpty()) throw new IllegalArgumentException("qrCodeValue is required");
        if (clientIP == null || clientIP.trim().isEmpty()) throw new IllegalArgumentException("clientIP is required");
    }

    @Override public String toString() { return "QrPayDecodeRequest{externalUserId='" + externalUserId + "'}"; }
}
