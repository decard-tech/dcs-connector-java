/*
 * dcs Java Connector
 * Reset PIN request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.dcscc.connector.client.common.validator.Base64Validator;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for resetting a card's PIN.
 * 
 * <p>This class represents the request parameters for resetting a card's Personal
 * Identification Number (PIN). The PIN reset operation requires verification of
 * existing card details and provides a new encrypted PIN.
 * 
 * <p><strong>Security Notice:</strong> All sensitive data in this request must be
 * encrypted using AES encryption with the provided initialization vector (IV).
 * This ensures that sensitive information is protected during transmission.
 * 
 * <p>The PIN reset process involves:
 * <ul>
 *   <li>Verification of card ownership through encrypted card details</li>
 *   <li>Validation of the current card information (expiry, CVV2, last 4 digits)</li>
 *   <li>Setting the new encrypted PIN for the card</li>
 *   <li>Updating the card's PIN in the secure system</li>
 * </ul>
 * 
 * <p>Encryption requirements:
 * <ul>
 *   <li>Algorithm: AES-256-CBC</li>
 *   <li>IV: 16-byte initialization vector (base64 encoded)</li>
 *   <li>All encrypted fields must be base64 encoded</li>
 *   <li>Use the same IV for all encrypted fields in the request</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>{@code
 * ResetPinRequest request = new ResetPinRequest();
 * request.setCardId("card_123456789");
 * request.setEncryptedExpireDate("base64EncryptedExpiry==");
 * request.setEncryptedCvv2("base64EncryptedCvv==");
 * request.setEncryptedPanLast4("base64EncryptedLast4==");
 * request.setEncryptedNewPin("base64EncryptedNewPin==");
 * request.setIv("base64EncodedIV==");
 * 
 * // Validate before sending
 * request.validate();
 * }</pre>
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ResetPinRequest {

    /**
     * The unique identifier of the card for which to reset the PIN.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Encrypted card expiration date for verification.
     * 
     * <p>The expiration date should be in MM/YY format before encryption.
     * This field is used to verify that the requester has access to the
     * physical card or card details.
     * 
     * <p>Example plaintext: "12/25" (December 2025)
     * <p>Must be AES encrypted and base64 encoded.
     */
    @SerializedName("encryptedExpireDate")
    private String encryptedExpireDate;

    /**
     * Encrypted CVV2 security code for verification.
     * 
     * <p>The CVV2 is typically a 3-digit code (4 digits for American Express)
     * found on the card. This field is used to verify card possession.
     * 
     * <p><strong>Security Warning:</strong> CVV2 is highly sensitive data.
     * 
     * <p>Example plaintext: "123"
     * <p>Must be AES encrypted and base64 encoded.
     */
    @SerializedName("encryptedCvv2")
    private String encryptedCvv2;

    /**
     * Encrypted last 4 digits of the card number for verification.
     * 
     * <p>This field contains the last 4 digits of the Primary Account Number (PAN)
     * and is used as an additional verification step.
     * 
     * <p>Example plaintext: "1234"
     * <p>Must be AES encrypted and base64 encoded.
     */
    @SerializedName("encryptedPanLast4")
    private String encryptedPanLast4;

    /**
     * Encrypted new PIN to be set for the card.
     * 
     * <p>The new PIN should be 4-6 digits depending on card issuer requirements.
     * This will become the new PIN for ATM and point-of-sale transactions.
     * 
     * <p><strong>Security Requirements:</strong>
     * <ul>
     *   <li>PIN should be 4-6 digits</li>
     *   <li>Avoid sequential numbers (1234, 5678)</li>
     *   <li>Avoid repeated digits (1111, 2222)</li>
     *   <li>Should not match birth dates or other personal information</li>
     * </ul>
     * 
     * <p>Example plaintext: "5678"
     * <p>Must be AES encrypted and base64 encoded.
     */
    @SerializedName("encryptedNewPin")
    private String encryptedNewPin;

    /**
     * Initialization Vector (IV) used for AES encryption.
     * 
     * <p>This is a 16-byte random value used to ensure that identical plaintext
     * produces different ciphertext. The same IV must be used for all encrypted
     * fields in this request.
     * 
     * <p>Requirements:
     * <ul>
     *   <li>Must be exactly 16 bytes</li>
     *   <li>Should be cryptographically random</li>
     *   <li>Must be base64 encoded</li>
     *   <li>Should be unique for each request</li>
     * </ul>
     */
    @SerializedName("iv")
    private String iv;

    /**
     * Default constructor.
     */
    public ResetPinRequest() {
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
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Gets the encrypted expiration date.
     *
     * @return the base64 encoded encrypted expiration date
     */
    public String getEncryptedExpireDate() {
        return encryptedExpireDate;
    }

    /**
     * Sets the encrypted expiration date.
     *
     * @param encryptedExpireDate the encrypted expiration date (base64 encoded)
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setEncryptedExpireDate(String encryptedExpireDate) {
        this.encryptedExpireDate = encryptedExpireDate;
        return this;
    }

    /**
     * Gets the encrypted CVV2.
     *
     * @return the base64 encoded encrypted CVV2
     */
    public String getEncryptedCvv2() {
        return encryptedCvv2;
    }

    /**
     * Sets the encrypted CVV2.
     *
     * @param encryptedCvv2 the encrypted CVV2 (base64 encoded)
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setEncryptedCvv2(String encryptedCvv2) {
        this.encryptedCvv2 = encryptedCvv2;
        return this;
    }

    /**
     * Gets the encrypted last 4 digits of PAN.
     *
     * @return the base64 encoded encrypted last 4 digits
     */
    public String getEncryptedPanLast4() {
        return encryptedPanLast4;
    }

    /**
     * Sets the encrypted last 4 digits of PAN.
     *
     * @param encryptedPanLast4 the encrypted last 4 digits (base64 encoded)
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setEncryptedPanLast4(String encryptedPanLast4) {
        this.encryptedPanLast4 = encryptedPanLast4;
        return this;
    }

    /**
     * Gets the encrypted new PIN.
     *
     * @return the base64 encoded encrypted new PIN
     */
    public String getEncryptedNewPin() {
        return encryptedNewPin;
    }

    /**
     * Sets the encrypted new PIN.
     *
     * @param encryptedNewPin the encrypted new PIN (base64 encoded)
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setEncryptedNewPin(String encryptedNewPin) {
        this.encryptedNewPin = encryptedNewPin;
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
     * @param iv the base64 encoded IV (must be 16 bytes)
     * @return this ResetPinRequest instance for method chaining
     */
    public ResetPinRequest setIv(String iv) {
        this.iv = iv;
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

        if (encryptedExpireDate == null || encryptedExpireDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Encrypted expire date cannot be null or empty");
        }

        if (encryptedCvv2 == null || encryptedCvv2.trim().isEmpty()) {
            throw new IllegalArgumentException("Encrypted CVV2 cannot be null or empty");
        }

        if (encryptedPanLast4 == null || encryptedPanLast4.trim().isEmpty()) {
            throw new IllegalArgumentException("Encrypted PAN last 4 cannot be null or empty");
        }

        if (encryptedNewPin == null || encryptedNewPin.trim().isEmpty()) {
            throw new IllegalArgumentException("Encrypted new PIN cannot be null or empty");
        }

        if (iv == null || iv.trim().isEmpty()) {
            throw new IllegalArgumentException("IV cannot be null or empty");
        }

        // Validate Base64 format for encrypted fields
        if (!Base64Validator.isValidBase64(encryptedExpireDate)) {
            throw new IllegalArgumentException("Encrypted expire date must be valid Base64");
        }

        if (!Base64Validator.isValidBase64(encryptedCvv2)) {
            throw new IllegalArgumentException("Encrypted CVV2 must be valid Base64");
        }

        if (!Base64Validator.isValidBase64(encryptedPanLast4)) {
            throw new IllegalArgumentException("Encrypted PAN last 4 must be valid Base64");
        }

        if (!Base64Validator.isValidBase64(encryptedNewPin)) {
            throw new IllegalArgumentException("Encrypted new PIN must be valid Base64");
        }

        // Validate IV format (should be 16 bytes for AES)
        if (!Base64Validator.isValidBase64IV(iv)) {
            throw new IllegalArgumentException("IV must be valid Base64 encoded 16-byte value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResetPinRequest that = (ResetPinRequest) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(encryptedExpireDate, that.encryptedExpireDate) &&
                Objects.equals(encryptedCvv2, that.encryptedCvv2) &&
                Objects.equals(encryptedPanLast4, that.encryptedPanLast4) &&
                Objects.equals(encryptedNewPin, that.encryptedNewPin) &&
                Objects.equals(iv, that.iv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, encryptedExpireDate, encryptedCvv2, encryptedPanLast4, encryptedNewPin, iv);
    }

    @Override
    public String toString() {
        return "ResetPinRequest{" +
                "cardId='" + cardId + '\'' +
                ", encryptedExpireDate='***'" +
                ", encryptedCvv2='***'" +
                ", encryptedPanLast4='***'" +
                ", encryptedNewPin='***'" +
                ", iv='***'" +
                '}';
    }
}
