/*
 * dcs Java Connector
 * Terminate card request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for terminating a card.
 *
 * <p>This class represents the request parameters for permanently terminating a card.
 * Once terminated, a card cannot be reactivated and becomes unusable for all transactions.
 * This is a destructive operation that should be used with caution.
 * 
 * <p>Card termination is typically used in the following scenarios:
 * <ul>
 *   <li>Card has been compromised or stolen</li>
 *   <li>Cardholder account is being closed</li>
 *   <li>Card has reached end of life</li>
 *   <li>Regulatory or compliance requirements</li>
 *   <li>Fraud prevention measures</li>
 * </ul>
 * 
 * <p><strong>Warning:</strong> This operation is irreversible. Once a card is
 * terminated, it cannot be reactivated. Consider using freeze/unfreeze operations
 * for temporary card suspension.
 * 
 * <p>Example usage:
 * <pre>{@code
 * TerminateCardRequest request = new TerminateCardRequest();
 * request.setCardId("card_123456789");
 * request.setInvalidateReason("Card compromised");
 * 
 * // Or using constructor
 * TerminateCardRequest request = new TerminateCardRequest("card_123456789", "Account closure");
 * 
 * // Using enum for reason
 * request.setInvalidateReason(TerminateReason.CARD_COMPROMISED);
 * }</pre>
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class TerminateCardRequest {

    /**
     * The unique identifier of the card to terminate.
     * 
     * <p>The card must exist in the system and be in a valid state for termination.
     * Cards that are already terminated cannot be terminated again.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * The reason for terminating the card.
     * 
     * <p>This field is used for audit purposes and compliance reporting.
     * It helps track why cards are being terminated and can be useful for
     * fraud analysis and regulatory reporting.
     * 
     * <p>Common reasons include:
     * <ul>
     *   <li>"Card compromised" - Security breach or suspected fraud</li>
     *   <li>"Account closure" - Customer account being closed</li>
     *   <li>"Card expired" - Card has reached expiration date</li>
     *   <li>"Customer request" - Cardholder requested termination</li>
     *   <li>"Regulatory requirement" - Compliance or legal requirement</li>
     * </ul>
     */
    @SerializedName("invalidateReason")
    private String invalidateReason;

    /**
     * Default constructor.
     */
    public TerminateCardRequest() {
    }

    /**
     * Constructor with card ID and invalidate reason.
     *
     * @param cardId the unique identifier of the card to terminate
     * @param invalidateReason the reason for termination
     */
    public TerminateCardRequest(String cardId, String invalidateReason) {
        this.cardId = cardId;
        this.invalidateReason = invalidateReason;
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
     * @return this TerminateCardRequest instance for method chaining
     */
    public TerminateCardRequest setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the invalidate reason.
     *
     * @return the reason for card termination
     */
    public String getInvalidateReason() {
        return invalidateReason;
    }

    /**
     * Sets the invalidate reason.
     *
     * @param invalidateReason the reason for termination
     * @return this TerminateCardRequest instance for method chaining
     */
    public TerminateCardRequest setInvalidateReason(String invalidateReason) {
        this.invalidateReason = invalidateReason;
        return this;
    }

    /**
     * Sets the invalidate reason using enum.
     *
     * @param terminateReason the terminate reason enum
     * @return this TerminateCardRequest instance for method chaining
     */
    public TerminateCardRequest setInvalidateReason(TerminateReason terminateReason) {
        this.invalidateReason = terminateReason.getCode();
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

        if (invalidateReason == null || invalidateReason.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalidate reason cannot be null or empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminateCardRequest that = (TerminateCardRequest) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(invalidateReason, that.invalidateReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, invalidateReason);
    }

    @Override
    public String toString() {
        return "TerminateCardRequest{" +
                "cardId='" + cardId + '\'' +
                ", invalidateReason='" + invalidateReason + '\'' +
                '}';
    }
}
