/*
 * dcs Java Connector
 * Card response model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Card information response model.
 * 
 * <p>This class represents the response data for card-related API calls.
 * It contains comprehensive information about a card including its status,
 * type, and configuration details.
 * 
 * <p>Example JSON response:
 * <pre>{@code
 * {
 *   "cardId": "card_123456789",
 *   "enterpriseId": "enterprise_123",
 *   "profileId": "profile_456",
 *   "type": "VIRTUAL",
 *   "customerId": "customer_987654321",
 *   "status": "ACTIVATED",
 *   "statusReason": "NORMAL",
 *   "panFirst6": "123456",
 *   "panLast4": "1234",
 *   "createTime": "2023-01-15T10:30:00+08:00",
 *   "modifyTime": "2023-01-15T11:00:00+08:00"
 * }
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CardResponse {

    /**
     * Unique identifier for the card.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Enterprise ID that owns this card.
     */
    @SerializedName("enterpriseId")
    private String enterpriseId;

    /**
     * Card profile ID that defines the card configuration.
     */
    @SerializedName("profileId")
    private String profileId;

    /**
     * Type of the card (PHYSICAL, VIRTUAL).
     */
    @SerializedName("type")
    private String type;

    /**
     * Customer ID associated with this card.
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * Current status of the card (WAITING_ACTIVE/ACTIVATED/FROZEN/BLOCKED/INVALID).
     */
    @SerializedName("status")
    private String status;

    /**
     * Reason for the current status (NORMAL/USER_FREEZE).
     */
    @SerializedName("statusReason")
    private String statusReason;

    /**
     * First 6 digits of the card number.
     */
    @SerializedName("panFirst6")
    private String panFirst6;

    /**
     * Last 4 digits of the card number.
     */
    @SerializedName("panLast4")
    private String panLast4;

    /**
     * Card creation timestamp (yyyy-MM-dd'T'HH:mm:ss+08:00).
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * Card last modification timestamp (yyyy-MM-dd'T'HH:mm:ss+08:00).
     */
    @SerializedName("modifyTime")
    private String modifyTime;

    /**
     * Default constructor.
     */
    public CardResponse() {
    }

    /**
     * Gets the card ID.
     *
     * @return the card ID
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the card ID.
     *
     * @param cardId the card ID to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the enterprise ID.
     *
     * @return the enterprise ID
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * Sets the enterprise ID.
     *
     * @param enterpriseId the enterprise ID to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    /**
     * Gets the profile ID.
     *
     * @return the profile ID
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Sets the profile ID.
     *
     * @param profileId the profile ID to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setProfileId(String profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the card type.
     *
     * @param type the card type to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets the customer ID.
     *
     * @return the customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId the customer ID to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Gets the card status.
     *
     * @return the card status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the card status.
     *
     * @param status the card status to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the status reason.
     *
     * @return the status reason
     */
    public String getStatusReason() {
        return statusReason;
    }

    /**
     * Sets the status reason.
     *
     * @param statusReason the status reason to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setStatusReason(String statusReason) {
        this.statusReason = statusReason;
        return this;
    }

    /**
     * Gets the first 6 digits of the card number.
     *
     * @return the first 6 digits
     */
    public String getPanFirst6() {
        return panFirst6;
    }

    /**
     * Sets the first 6 digits of the card number.
     *
     * @param panFirst6 the first 6 digits to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setPanFirst6(String panFirst6) {
        this.panFirst6 = panFirst6;
        return this;
    }

    /**
     * Gets the last 4 digits of the card number.
     *
     * @return the last 4 digits
     */
    public String getPanLast4() {
        return panLast4;
    }

    /**
     * Sets the last 4 digits of the card number.
     *
     * @param panLast4 the last 4 digits to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setPanLast4(String panLast4) {
        this.panLast4 = panLast4;
        return this;
    }

    /**
     * Gets the creation time.
     *
     * @return the creation time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the creation time.
     *
     * @param createTime the creation time to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Gets the modification time.
     *
     * @return the modification time
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * Sets the modification time.
     *
     * @param modifyTime the modification time to set
     * @return this CardResponse instance for method chaining
     */
    public CardResponse setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardResponse that = (CardResponse) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(enterpriseId, that.enterpriseId) &&
                Objects.equals(profileId, that.profileId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(statusReason, that.statusReason) &&
                Objects.equals(panFirst6, that.panFirst6) &&
                Objects.equals(panLast4, that.panLast4) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, enterpriseId, profileId, type, customerId, 
                          status, statusReason, panFirst6, panLast4, 
                          createTime, modifyTime);
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "cardId='" + cardId + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", profileId='" + profileId + '\'' +
                ", type='" + type + '\'' +
                ", customerId='" + customerId + '\'' +
                ", status='" + status + '\'' +
                ", statusReason='" + statusReason + '\'' +
                ", panFirst6='" + panFirst6 + '\'' +
                ", panLast4='" + panLast4 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
