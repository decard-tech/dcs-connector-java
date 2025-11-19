/*
 * dcs Java Connector
 * Retrieve secure card request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for retrieving secure card information.
 * 
 * <p>This class represents the request parameters for retrieving sensitive
 * card information including the full PAN, expiration date, and CVV2.
 * This operation requires proper authentication and authorization.
 * 
 * <p><strong>Security Notice:</strong> This request will return highly
 * sensitive financial data. Ensure that:
 * <ul>
 *   <li>The request is made over secure channels (HTTPS/TLS)</li>
 *   <li>Proper authentication is in place</li>
 *   <li>The requesting system has appropriate authorization</li>
 *   <li>Audit logging is enabled for compliance</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>{@code
 * RetrieveSecureCardRequest request = new RetrieveSecureCardRequest();
 * request.setCardId("card_123456789");
 * 
 * // Or using constructor
 * RetrieveSecureCardRequest request = new RetrieveSecureCardRequest("card_123456789");
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class RetrieveSecureCardRequest {

    /**
     * The unique identifier of the card for which to retrieve secure information.
     * 
     * <p>This must be a valid card ID that exists in the system and is
     * associated with the authenticated user or enterprise.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Default constructor.
     */
    public RetrieveSecureCardRequest() {
    }

    /**
     * Constructor with card ID.
     *
     * @param cardId the unique identifier of the card
     */
    public RetrieveSecureCardRequest(String cardId) {
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
     * @return this RetrieveSecureCardRequest instance for method chaining
     * @throws IllegalArgumentException if cardId is null or empty
     */
    public RetrieveSecureCardRequest setCardId(String cardId) {
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
            throw new IllegalArgumentException("Card ID is required for retrieving secure card information");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetrieveSecureCardRequest that = (RetrieveSecureCardRequest) o;
        return Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }

    @Override
    public String toString() {
        return "RetrieveSecureCardRequest{" +
                "cardId='" + cardId + '\'' +
                '}';
    }
}
