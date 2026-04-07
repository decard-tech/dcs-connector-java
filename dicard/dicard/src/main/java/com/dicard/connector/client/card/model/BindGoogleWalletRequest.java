package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to bind Google Wallet.
 */
public class BindGoogleWalletRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("clientCustomerId")
    private String clientCustomerId;

    @SerializedName("deviceId")
    private String deviceId;

    public BindGoogleWalletRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public BindGoogleWalletRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public BindGoogleWalletRequest setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public String getClientCustomerId() { return clientCustomerId; }
    public BindGoogleWalletRequest setClientCustomerId(String clientCustomerId) { this.clientCustomerId = clientCustomerId; return this; }
    public String getDeviceId() { return deviceId; }
    public BindGoogleWalletRequest setDeviceId(String deviceId) { this.deviceId = deviceId; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
    }

    @Override
    public String toString() {
        return "BindGoogleWalletRequest{externalUserId='" + externalUserId + "', cardMantissa='" + cardMantissa + "'}";
    }
}
