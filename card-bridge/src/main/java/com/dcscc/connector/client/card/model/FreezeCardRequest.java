/*
 * dcs Java Connector
 * Freeze card request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for freezing or unfreezing a card.
 *
 * <p>This class represents the request parameters for the freeze/unfreeze card operation.
 * It allows you to temporarily disable a card (freeze) or re-enable a previously
 * frozen card (unfreeze).
 *
 * <p>Example usage:
 * <pre>{@code
 * // Freeze a card
 * FreezeCardRequest freezeRequest = new FreezeCardRequest();
 * freezeRequest.setCardId("card_123456789");
 * freezeRequest.setFreeze(true);
 * freezeRequest.setFreezeReason("Suspicious activity detected");
 *
 * // Unfreeze a card
 * FreezeCardRequest unfreezeRequest = new FreezeCardRequest();
 * unfreezeRequest.setCardId("card_123456789");
 * unfreezeRequest.setFreeze(false);
 * }</pre>
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class FreezeCardRequest {

    /**
     * The unique identifier of the card to freeze/unfreeze.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Whether to freeze (true) or unfreeze (false) the card.
     */
    @SerializedName("freeze")
    private Boolean freeze;

    /**
     * Reason for freezing the card (optional, only used when freeze=true).
     *
     * <p>Common reasons include:
     * <ul>
     *   <li>"NORMAL"</li>
     *   <li>"USER_FREEZE"</li>
     * </ul>
     */
    @SerializedName("freezeReason")
    private String freezeReason;

    /**
     * Default constructor.
     */
    public FreezeCardRequest() {
    }

    /**
     * Constructor with required parameters.
     *
     * @param cardId the card ID
     * @param freeze whether to freeze the card
     */
    public FreezeCardRequest(String cardId, Boolean freeze) {
        this.cardId = cardId;
        this.freeze = freeze;
    }

    /**
     * Constructor with all parameters.
     *
     * @param cardId       the card ID
     * @param freeze       whether to freeze the card
     * @param freezeReason the reason for freezing (optional)
     */
    public FreezeCardRequest(String cardId, Boolean freeze, String freezeReason) {
        this.cardId = cardId;
        this.freeze = freeze;
        this.freezeReason = freezeReason;
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
     * @return this FreezeCardRequest instance for method chaining
     */
    public FreezeCardRequest setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the freeze flag.
     *
     * @return true if the card should be frozen, false if it should be unfrozen
     */
    public Boolean getFreeze() {
        return freeze;
    }

    /**
     * Sets the freeze flag.
     *
     * @param freeze true to freeze the card, false to unfreeze it
     * @return this FreezeCardRequest instance for method chaining
     */
    public FreezeCardRequest setFreeze(Boolean freeze) {
        this.freeze = freeze;
        return this;
    }

    /**
     * Gets the freeze reason.
     *
     * @return the freeze reason
     */
    public String getFreezeReason() {
        return freezeReason;
    }

    /**
     * Sets the freeze reason.
     *
     * @param freezeReason the reason for freezing the card
     * @return this FreezeCardRequest instance for method chaining
     */
    public FreezeCardRequest setFreezeReason(String freezeReason) {
        this.freezeReason = freezeReason;
        return this;
    }

    /**
     * Sets the freeze reason using enum.
     *
     * @param freezeReason the freeze reason enum
     * @return this FreezeCardRequest instance for method chaining
     */
    public FreezeCardRequest setFreezeReason(FreezeReason freezeReason) {
        this.freezeReason = freezeReason.getCode();
        return this;
    }

    /**
     * Validates the request parameters.
     *
     * @throws IllegalArgumentException if the request is invalid
     */
    public void validate() {
        if (cardId == null || cardId.trim().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty");
        }

        if (freeze == null) {
            throw new IllegalArgumentException("Freeze flag cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreezeCardRequest that = (FreezeCardRequest) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(freeze, that.freeze) &&
                Objects.equals(freezeReason, that.freezeReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, freeze, freezeReason);
    }

    @Override
    public String toString() {
        return "FreezeCardRequest{" +
                "cardId='" + cardId + '\'' +
                ", freeze=" + freeze +
                ", freezeReason='" + freezeReason + '\'' +
                '}';
    }
}
