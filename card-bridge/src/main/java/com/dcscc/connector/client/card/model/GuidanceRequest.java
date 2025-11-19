/*
 * dcs Java Connector
 * Guidance request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for generating guidance page links.
 * 
 * <p>This class represents the request parameters for generating
 * guidance page URLs that redirect users to appropriate card
 * management interfaces.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class GuidanceRequest {

    /**
     * Card ID for the guidance operation.
     */
    @SerializedName("cardId")
    private String cardId;

    /**
     * Customer ID for the guidance operation.
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * Type of guidance operation.
     */
    @SerializedName("type")
    private String type;

    /**
     * OTP verification status.
     * 0: Channel has pre-verified user identity
     * 1: Channel has not verified, DCS needs to verify
     */
    @SerializedName("otpStatus")
    private String otpStatus;

    /**
     * Language for the guidance page.
     */
    @SerializedName("language")
    private String language;

    /**
     * Theme for the guidance page.
     */
    @SerializedName("theme")
    private String theme;

    /**
     * Mode for the guidance page.
     */
    @SerializedName("mode")
    private String mode;

    /**
     * User agent string.
     */
    @SerializedName("userAgent")
    private String userAgent;

    /**
     * URL to redirect to after successful operation (optional).
     */
    @SerializedName("successfulRedirectUrl")
    private String successfulRedirectUrl;

    /**
     * Default constructor.
     */
    public GuidanceRequest() {
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
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setCardId(String cardId) {
        this.cardId = cardId;
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
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Gets the guidance type.
     *
     * @return the guidance type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the guidance type.
     *
     * @param type the guidance type to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the guidance type using enum.
     *
     * @param guidanceType the guidance type enum
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setType(GuidanceType guidanceType) {
        this.type = guidanceType.getCode();
        return this;
    }

    /**
     * Gets the OTP status.
     *
     * @return the OTP status
     */
    public String getOtpStatus() {
        return otpStatus;
    }

    /**
     * Sets the OTP status.
     *
     * @param otpStatus the OTP status to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setOtpStatus(String otpStatus) {
        this.otpStatus = otpStatus;
        return this;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language the language to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Sets the language using enum.
     *
     * @param language the language enum
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setLanguage(Language language) {
        this.language = language.getCode();
        return this;
    }

    /**
     * Gets the theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the theme.
     *
     * @param theme the theme to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Gets the mode.
     *
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the mode.
     *
     * @param mode the mode to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setMode(String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Gets the user agent.
     *
     * @return the user agent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets the user agent.
     *
     * @param userAgent the user agent to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * Gets the successful redirect URL.
     *
     * @return the successful redirect URL
     */
    public String getSuccessfulRedirectUrl() {
        return successfulRedirectUrl;
    }

    /**
     * Sets the successful redirect URL.
     *
     * @param successfulRedirectUrl the successful redirect URL to set
     * @return this GuidanceRequest instance for method chaining
     */
    public GuidanceRequest setSuccessfulRedirectUrl(String successfulRedirectUrl) {
        this.successfulRedirectUrl = successfulRedirectUrl;
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

        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }

        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        if (otpStatus == null || otpStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("OTP status cannot be null or empty");
        }

        if (language == null || language.trim().isEmpty()) {
            throw new IllegalArgumentException("Language cannot be null or empty");
        }

        if (theme == null || theme.trim().isEmpty()) {
            throw new IllegalArgumentException("Theme cannot be null or empty");
        }

        if (mode == null || mode.trim().isEmpty()) {
            throw new IllegalArgumentException("Mode cannot be null or empty");
        }

        if (userAgent == null || userAgent.trim().isEmpty()) {
            throw new IllegalArgumentException("User agent cannot be null or empty");
        }

        // Validate enum values
        try {
            GuidanceType.fromCode(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid guidance type: " + type);
        }

        // Validate OTP status (0 or 1)
        if (!otpStatus.equals("0") && !otpStatus.equals("1")) {
            throw new IllegalArgumentException("Invalid OTP status: " + otpStatus + ". Must be 0 or 1");
        }

        try {
            Language.fromCode(language);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid language: " + language);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuidanceRequest that = (GuidanceRequest) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(otpStatus, that.otpStatus) &&
                Objects.equals(language, that.language) &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(mode, that.mode) &&
                Objects.equals(userAgent, that.userAgent) &&
                Objects.equals(successfulRedirectUrl, that.successfulRedirectUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, customerId, type, otpStatus, language, theme, mode, userAgent, successfulRedirectUrl);
    }

    @Override
    public String toString() {
        return "GuidanceRequest{" +
                "cardId='" + cardId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", type='" + type + '\'' +
                ", otpStatus='" + otpStatus + '\'' +
                ", language='" + language + '\'' +
                ", theme='" + theme + '\'' +
                ", mode='" + mode + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", successfulRedirectUrl='" + successfulRedirectUrl + '\'' +
                '}';
    }
}
