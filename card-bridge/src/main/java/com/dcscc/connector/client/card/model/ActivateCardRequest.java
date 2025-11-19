/*
 * dcs Java Connector
 * Activate card request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for activating a physical card.
 * 
 * <p>This class represents the request parameters for activating a physical card
 * that has been issued and delivered to the cardholder. Card activation is typically
 * required before the card can be used for transactions.
 * 
 * <p>The activation process:
 * <ul>
 *   <li>Validates that the card exists and is in WAITING_ACTIVE status</li>
 *   <li>Changes the card status from WAITING_ACTIVE to ACTIVATED</li>
 *   <li>Enables the card for transaction processing</li>
 *   <li>May trigger notifications to the cardholder</li>
 * </ul>
 * 
 * <p><strong>Note:</strong> Virtual cards are typically activated automatically
 * upon creation and do not require this activation step.
 * 
 * <p>Example usage:
 * <pre>{@code
 * ActivateCardRequest request = new ActivateCardRequest();
 * request.setCardId("card_123456789");
 * 
 * // Or using constructor
 * ActivateCardRequest request = new ActivateCardRequest("card_123456789");
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ActivateCardRequest {

    /**
     * The unique identifier of the card to activate.
     * 
     * <p>The card must be in WAITING_ACTIVE status and must be a physical card
     * that has been successfully delivered to the cardholder.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Default constructor.
     */
    public ActivateCardRequest() {
    }

    /**
     * Constructor with card ID.
     *
     * @param cardId the unique identifier of the card to activate
     */
    public ActivateCardRequest(String cardId) {
        this.cardId = cardId;
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
     * @return this ActivateCardRequest instance for method chaining
     * @throws IllegalArgumentException if cardId is null or empty
     */
    public ActivateCardRequest setCardId(String cardId) {
        if (cardId == null || cardId.trim().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty");
        }
        this.cardId = cardId;
        return this;
    }

    /**
     * Validates the request parameters.
     *
     * @throws IllegalArgumentException if the request is invalid
     */
    public void validate() {
        if (cardId == null || cardId.trim().isEmpty()) {
            throw new IllegalArgumentException("Card ID is required for card activation");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivateCardRequest that = (ActivateCardRequest) o;
        return Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }

    @Override
    public String toString() {
        return "ActivateCardRequest{" +
                "cardId='" + cardId + '\'' +
                '}';
    }
}
