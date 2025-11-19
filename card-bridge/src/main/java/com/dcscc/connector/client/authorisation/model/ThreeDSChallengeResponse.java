/*
 * dcs Java Connector
 * 3DS challenge response model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Response model for 3DS challenge authentication.
 * 
 * <p>This class represents the response data for 3DS challenge authentication
 * processing. It contains the authentication result, status information,
 * and related transaction details.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ThreeDSChallengeResponse {

    /**
     * Unique identifier for the 3DS challenge.
     */
    @SerializedName("challengeId")
    private String challengeId;

    /**
     * Challenge status (INIT/NOTICED/RECEIVED/APPROVED/REJECTED).
     */
    @SerializedName("status")
    private String status;

    /**
     * Card ID associated with this challenge.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Challenge expiry time.
     */
    @SerializedName("expiryTime")
    private String expiryTime;

    /**
     * Transaction currency.
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Transaction amount.
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Merchant ID.
     */
    @SerializedName("merchantId")
    private String merchantId;

    /**
     * Merchant name.
     */
    @SerializedName("merchantName")
    private String merchantName;

    /**
     * Merchant country.
     */
    @SerializedName("merchantCountry")
    private String merchantCountry;

    /**
     * Merchant category code.
     */
    @SerializedName("mcc")
    private String mcc;

    /**
     * Default constructor.
     */
    public ThreeDSChallengeResponse() {
    }

    /**
     * Gets the challenge ID.
     *
     * @return the challenge ID
     */
    public String getChallengeId() {
        return challengeId;
    }

    /**
     * Sets the challenge ID.
     *
     * @param challengeId the challenge ID to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setChallengeId(String challengeId) {
        this.challengeId = challengeId;
        return this;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the status to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setStatus(String status) {
        this.status = status;
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
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the expiry time.
     *
     * @return the expiry time
     */
    public String getExpiryTime() {
        return expiryTime;
    }

    /**
     * Sets the expiry time.
     *
     * @param expiryTime the expiry time to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency the currency to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the amount to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Gets the merchant ID.
     *
     * @return the merchant ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the merchant ID.
     *
     * @param merchantId the merchant ID to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    /**
     * Gets the merchant name.
     *
     * @return the merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the merchant name.
     *
     * @param merchantName the merchant name to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setMerchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    /**
     * Gets the merchant country.
     *
     * @return the merchant country
     */
    public String getMerchantCountry() {
        return merchantCountry;
    }

    /**
     * Sets the merchant country.
     *
     * @param merchantCountry the merchant country to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setMerchantCountry(String merchantCountry) {
        this.merchantCountry = merchantCountry;
        return this;
    }

    /**
     * Gets the merchant category code.
     *
     * @return the merchant category code
     */
    public String getMcc() {
        return mcc;
    }

    /**
     * Sets the merchant category code.
     *
     * @param mcc the merchant category code to set
     * @return this ThreeDSChallengeResponse instance for method chaining
     */
    public ThreeDSChallengeResponse setMcc(String mcc) {
        this.mcc = mcc;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreeDSChallengeResponse that = (ThreeDSChallengeResponse) o;
        return Objects.equals(challengeId, that.challengeId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(expiryTime, that.expiryTime) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(merchantId, that.merchantId) &&
                Objects.equals(merchantName, that.merchantName) &&
                Objects.equals(merchantCountry, that.merchantCountry) &&
                Objects.equals(mcc, that.mcc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(challengeId, status, cardId, expiryTime, currency, 
                          amount, merchantId, merchantName, merchantCountry, mcc);
    }

    @Override
    public String toString() {
        return "ThreeDSChallengeResponse{" +
                "challengeId='" + challengeId + '\'' +
                ", status='" + status + '\'' +
                ", cardId='" + cardId + '\'' +
                ", expiryTime='" + expiryTime + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", merchantId='" + merchantId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantCountry='" + merchantCountry + '\'' +
                ", mcc='" + mcc + '\'' +
                '}';
    }
}
