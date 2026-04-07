package com.dicard.connector.client.qrpay.model;

import com.google.gson.annotations.SerializedName;

public class QrPayCreateRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("qrCodeValue") private String qrCodeValue;
    @SerializedName("clientIP") private String clientIP;
    @SerializedName("currency") private String currency;
    @SerializedName("amount") private String amount;

    public QrPayCreateRequest() {}

    public String getExternalUserId() { return externalUserId; } public QrPayCreateRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public String getQrCodeValue() { return qrCodeValue; } public QrPayCreateRequest setQrCodeValue(String v) { this.qrCodeValue = v; return this; }
    public String getClientIP() { return clientIP; } public QrPayCreateRequest setClientIP(String v) { this.clientIP = v; return this; }
    public String getCurrency() { return currency; } public QrPayCreateRequest setCurrency(String v) { this.currency = v; return this; }
    public String getAmount() { return amount; } public QrPayCreateRequest setAmount(String v) { this.amount = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (qrCodeValue == null || qrCodeValue.trim().isEmpty()) throw new IllegalArgumentException("qrCodeValue is required");
        if (clientIP == null || clientIP.trim().isEmpty()) throw new IllegalArgumentException("clientIP is required");
    }

    @Override public String toString() { return "QrPayCreateRequest{externalUserId='" + externalUserId + "'}"; }
}
