/*
 * dcs Java Connector
 * Shipping information response model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Response model containing card shipping information.
 * 
 * <p>This class represents the response data for card shipping information queries.
 * It provides basic tracking information for physical cards that have been shipped.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ShippingInfoResponse {

    /**
     * Unique identifier for the card being shipped.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Tracking number provided by the shipping carrier.
     */
    @SerializedName("trackingNumber")
    private String trackingNumber;

    /**
     * Name of the shipping carrier/courier service.
     */
    @SerializedName("trackingCompanyName")
    private String trackingCompanyName;

    /**
     * Default constructor.
     */
    public ShippingInfoResponse() {
    }

    /**
     * Gets the card ID.
     *
     * @return the unique card identifier
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the card ID.
     *
     * @param cardId the card ID to set
     * @return this ShippingInfoResponse instance for method chaining
     */
    public ShippingInfoResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the tracking number.
     *
     * @return the carrier tracking number
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the tracking number.
     *
     * @param trackingNumber the tracking number to set
     * @return this ShippingInfoResponse instance for method chaining
     */
    public ShippingInfoResponse setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    /**
     * Gets the tracking company name.
     *
     * @return the shipping company name
     */
    public String getTrackingCompanyName() {
        return trackingCompanyName;
    }

    /**
     * Sets the tracking company name.
     *
     * @param trackingCompanyName the company name to set
     * @return this ShippingInfoResponse instance for method chaining
     */
    public ShippingInfoResponse setTrackingCompanyName(String trackingCompanyName) {
        this.trackingCompanyName = trackingCompanyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingInfoResponse that = (ShippingInfoResponse) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(trackingNumber, that.trackingNumber) &&
                Objects.equals(trackingCompanyName, that.trackingCompanyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, trackingNumber, trackingCompanyName);
    }

    @Override
    public String toString() {
        return "ShippingInfoResponse{" +
                "cardId='" + cardId + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", trackingCompanyName='" + trackingCompanyName + '\'' +
                '}';
    }
}
