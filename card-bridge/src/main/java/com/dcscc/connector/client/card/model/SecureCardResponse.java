/*
 * dcs Java Connector
 * Secure card response model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Response model containing secure card information.
 * 
 * <p>This class represents the response data for secure card information retrieval.
 * It contains sensitive card details that are typically encrypted or masked
 * for security purposes. This information should be handled with extreme care
 * and never logged or stored in plain text.
 * 
 * <p>The response includes the full card number (PAN), expiration date, CVV2,
 * and initialization vector (IV) for encryption/decryption operations.
 * 
 * <p><strong>Security Notice:</strong> This class contains sensitive financial data.
 * Ensure proper security measures are in place when handling this information,
 * including:
 * <ul>
 *   <li>Secure transmission (HTTPS/TLS)</li>
 *   <li>Proper encryption at rest</li>
 *   <li>Access logging and monitoring</li>
 *   <li>Compliance with PCI DSS standards</li>
 * </ul>
 * 
 * <p>Example JSON response:
 * <pre>{@code
 * {
 *   "cardId": "card_123456789",
 *   "pan": "4111111111111111",
 *   "expireDate": "12/25",
 *   "cvv2": "123",
 *   "iv": "base64encodediv=="
 * }
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class SecureCardResponse {

    /**
     * Unique identifier for the card.
     * This matches the card ID used in other API operations.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Primary Account Number (PAN) - the full card number.
     * 
     * <p><strong>Security Warning:</strong> This field contains the complete
     * card number and must be handled according to PCI DSS requirements.
     * Typically 13-19 digits for most card networks.
     * 
     * <p>Format examples:
     * <ul>
     *   <li>Visa: 4111111111111111 (16 digits)</li>
     *   <li>Mastercard: 5555555555554444 (16 digits)</li>
     *   <li>American Express: 378282246310005 (15 digits)</li>
     * </ul>
     */
    @SerializedName("pan")
    private String pan;

    /**
     * Card expiration date in MM/YY format.
     * 
     * <p>Examples:
     * <ul>
     *   <li>"12/25" - December 2025</li>
     *   <li>"01/30" - January 2030</li>
     * </ul>
     * 
     * <p>Note: The card is valid through the last day of the expiration month.
     */
    @SerializedName("expireDate")
    private String expireDate;

    /**
     * Card Verification Value 2 (CVV2) - the security code.
     * 
     * <p><strong>Security Warning:</strong> This is highly sensitive data
     * that must never be stored after authorization.
     * 
     * <p>Format:
     * <ul>
     *   <li>Visa/Mastercard: 3 digits on the back of the card</li>
     *   <li>American Express: 4 digits on the front of the card</li>
     * </ul>
     */
    @SerializedName("cvv2")
    private String cvv2;

    /**
     * Initialization Vector (IV) used for encryption/decryption operations.
     * 
     * <p>This is a cryptographic parameter used in conjunction with encryption
     * algorithms to ensure that identical plaintext blocks produce different
     * ciphertext blocks. Typically base64 encoded.
     * 
     * <p>The IV is used when the card data is encrypted and needs to be
     * provided for proper decryption on the client side.
     */
    @SerializedName("iv")
    private String iv;

    /**
     * Default constructor.
     */
    public SecureCardResponse() {
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
     * @return this SecureCardResponse instance for method chaining
     */
    public SecureCardResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the Primary Account Number (PAN).
     * 
     * <p><strong>Security Warning:</strong> Handle this sensitive data carefully.
     *
     * @return the full card number
     */
    public String getPan() {
        return pan;
    }

    /**
     * Sets the Primary Account Number (PAN).
     *
     * @param pan the card number to set
     * @return this SecureCardResponse instance for method chaining
     */
    public SecureCardResponse setPan(String pan) {
        this.pan = pan;
        return this;
    }

    /**
     * Gets the card expiration date.
     *
     * @return the expiration date in MM/YY format
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the card expiration date.
     *
     * @param expireDate the expiration date in MM/YY format
     * @return this SecureCardResponse instance for method chaining
     */
    public SecureCardResponse setExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    /**
     * Gets the CVV2 security code.
     * 
     * <p><strong>Security Warning:</strong> This is highly sensitive data.
     *
     * @return the CVV2 code
     */
    public String getCvv2() {
        return cvv2;
    }

    /**
     * Sets the CVV2 security code.
     *
     * @param cvv2 the CVV2 code to set
     * @return this SecureCardResponse instance for method chaining
     */
    public SecureCardResponse setCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    /**
     * Gets the initialization vector (IV).
     *
     * @return the base64 encoded IV
     */
    public String getIv() {
        return iv;
    }

    /**
     * Sets the initialization vector (IV).
     *
     * @param iv the base64 encoded IV to set
     * @return this SecureCardResponse instance for method chaining
     */
    public SecureCardResponse setIv(String iv) {
        this.iv = iv;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecureCardResponse that = (SecureCardResponse) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(pan, that.pan) &&
                Objects.equals(expireDate, that.expireDate) &&
                Objects.equals(cvv2, that.cvv2) &&
                Objects.equals(iv, that.iv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, pan, expireDate, cvv2, iv);
    }

    @Override
    public String toString() {
        return "SecureCardResponse{" +
                "cardId='" + cardId + '\'' +
                ", pan='***'" +
                ", expireDate='***'" +
                ", cvv2='***'" +
                ", iv='***'" +
                '}';
    }
}
