package com.dicard.connector.client.qrpay.model;

import com.google.gson.annotations.SerializedName;

public class QrPayConfirmRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("orderId") private String orderId;

    public QrPayConfirmRequest() {}

    public String getExternalUserId() { return externalUserId; } public QrPayConfirmRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public String getOrderId() { return orderId; } public QrPayConfirmRequest setOrderId(String v) { this.orderId = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (orderId == null || orderId.trim().isEmpty()) throw new IllegalArgumentException("orderId is required");
    }

    @Override public String toString() { return "QrPayConfirmRequest{externalUserId='" + externalUserId + "', orderId='" + orderId + "'}"; }
}
