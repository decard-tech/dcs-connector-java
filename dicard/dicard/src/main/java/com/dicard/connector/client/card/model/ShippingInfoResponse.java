package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Physical card shipping information response.
 */
public class ShippingInfoResponse {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("status")
    private String status;

    @SerializedName("trackingNumber")
    private String trackingNumber;

    @SerializedName("trackingCompanyName")
    private String trackingCompanyName;

    public ShippingInfoResponse() {}

    public String getExternalUserId() { return externalUserId; }
    public ShippingInfoResponse setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public ShippingInfoResponse setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public String getStatus() { return status; }
    public ShippingInfoResponse setStatus(String status) { this.status = status; return this; }
    public String getTrackingNumber() { return trackingNumber; }
    public ShippingInfoResponse setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; return this; }
    public String getTrackingCompanyName() { return trackingCompanyName; }
    public ShippingInfoResponse setTrackingCompanyName(String trackingCompanyName) { this.trackingCompanyName = trackingCompanyName; return this; }

    @Override
    public String toString() {
        return "ShippingInfoResponse{externalUserId='" + externalUserId + "', status='" + status + "', trackingNumber='" + trackingNumber + "'}";
    }
}
