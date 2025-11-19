/*
 * dcs Java Connector
 * Card order response model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Card order response model.
 * 
 * <p>This class represents the response data for card order-related API calls.
 * It contains comprehensive information about a card order including its status,
 * associated card details, and processing information.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CardOrderResponse {

    /**
     * Card order ID
     */
    @SerializedName("cardOrderId")
    private String cardOrderId;

    /**
     * Card configuration ID
     */
    @SerializedName("profileId")
    private String profileId;

    /**
     * Card type
     * eg: VIRTUAL/VIRTUAL_TO_PHYSICAL/REPLACEMENT
     */
    @SerializedName("type")
    private String type;

    /**
     * Customer ID
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * Card ID
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Card order status
     * 
     * type=VIRTUAL:PENDING/CUSTOMER_PASS/KYC_PASS/CHANNEL_CUSTOMER_PASS/SUCCEED/FAILED
     * type=VIRTUAL_TO_PHYSICAL:PENDING/PHYSICAL_SETTING_COMPLETED/SUCCEED/FAILED
     * type=REPLACEMENT:PENDING/SUCCEED/FAILED
     */
    @SerializedName("status")
    private String status;

    /**
     * Error code
     */
    @SerializedName("errorCode")
    private String errorCode;

    /**
     * Error reason
     */
    @SerializedName("errorReason")
    private String errorReason;

    /**
     * Card order idempotency field
     */
    @SerializedName("cardOrderRef")
    private String cardOrderRef;

    /**
     * Need additional EDD upload
     * eg: true:need;false:not need
     * type=VIRTUAL, use this field
     */
    @SerializedName("needEddFile")
    private Boolean needEddFile;

    /**
     * Replace card ID
     * type=VIRTUAL_TO_PHYSICAL/REPLACEMENT, use this field
     */
    @SerializedName("replaceCardId")
    private String replaceCardId;

    /**
     * Creation time
     * eg: yyyy-MM-dd'T'HH:mm:ss+08:00
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * Last update time
     * eg: yyyy-MM-dd'T'HH:mm:ss+08:00
     */
    @SerializedName("modifyTime")
    private String modifyTime;

    /**
     * Default constructor.
     */
    public CardOrderResponse() {
    }

    /**
     * Gets the card order ID.
     *
     * @return the card order ID
     */
    public String getCardOrderId() {
        return cardOrderId;
    }

    /**
     * Sets the card order ID.
     *
     * @param cardOrderId the card order ID to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setCardOrderId(String cardOrderId) {
        this.cardOrderId = cardOrderId;
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
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setProfileId(String profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * Gets the order type.
     *
     * @return the order type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the order type.
     *
     * @param type the order type to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setType(String type) {
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
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
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
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the order status.
     *
     * @return the order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the order status.
     *
     * @param status the order status to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     *
     * @param errorCode the error code to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Gets the error reason.
     *
     * @return the error reason
     */
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * Sets the error reason.
     *
     * @param errorReason the error reason to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setErrorReason(String errorReason) {
        this.errorReason = errorReason;
        return this;
    }

    /**
     * Gets the card order reference.
     *
     * @return the card order reference
     */
    public String getCardOrderRef() {
        return cardOrderRef;
    }

    /**
     * Sets the card order reference.
     *
     * @param cardOrderRef the card order reference to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setCardOrderRef(String cardOrderRef) {
        this.cardOrderRef = cardOrderRef;
        return this;
    }

    /**
     * Gets whether EDD file is needed.
     *
     * @return true if EDD file is needed, false otherwise
     */
    public Boolean getNeedEddFile() {
        return needEddFile;
    }

    /**
     * Sets whether EDD file is needed.
     *
     * @param needEddFile whether EDD file is needed
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setNeedEddFile(Boolean needEddFile) {
        this.needEddFile = needEddFile;
        return this;
    }

    /**
     * Gets the replace card ID.
     *
     * @return the replace card ID
     */
    public String getReplaceCardId() {
        return replaceCardId;
    }

    /**
     * Sets the replace card ID.
     *
     * @param replaceCardId the replace card ID to set
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setReplaceCardId(String replaceCardId) {
        this.replaceCardId = replaceCardId;
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
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setCreateTime(String createTime) {
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
     * @return this CardOrderResponse instance for method chaining
     */
    public CardOrderResponse setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardOrderResponse that = (CardOrderResponse) o;
        return Objects.equals(cardOrderId, that.cardOrderId) &&
                Objects.equals(profileId, that.profileId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(errorReason, that.errorReason) &&
                Objects.equals(cardOrderRef, that.cardOrderRef) &&
                Objects.equals(needEddFile, that.needEddFile) &&
                Objects.equals(replaceCardId, that.replaceCardId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardOrderId, profileId, type, customerId, cardId, 
                          status, errorCode, errorReason, cardOrderRef, 
                          needEddFile, replaceCardId, createTime, modifyTime);
    }

    @Override
    public String toString() {
        return "CardOrderResponse{" +
                "cardOrderId='" + cardOrderId + '\'' +
                ", profileId='" + profileId + '\'' +
                ", type='" + type + '\'' +
                ", customerId='" + customerId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorReason='" + errorReason + '\'' +
                ", cardOrderRef='" + cardOrderRef + '\'' +
                ", needEddFile=" + needEddFile +
                ", replaceCardId='" + replaceCardId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
