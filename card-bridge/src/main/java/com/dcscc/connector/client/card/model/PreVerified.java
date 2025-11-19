/*
 * dcs Java Connector
 * Pre-verification status enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of pre-verification status for user identity.
 * 
 * <p>This enum indicates whether the calling channel has already performed
 * user identity verification before making the request to DCS. This helps
 * optimize the user experience by avoiding duplicate verification steps.
 * 
 * <p>Pre-verification is commonly used in scenarios where:
 * <ul>
 *   <li>Users have already logged into a secure banking app</li>
 *   <li>Multi-factor authentication has been completed</li>
 *   <li>Biometric verification has been performed</li>
 *   <li>Strong customer authentication (SCA) has been satisfied</li>
 * </ul>
 * 
 * <p>The verification status affects the user flow in guidance pages:
 * <ul>
 *   <li>Pre-verified users may skip additional authentication steps</li>
 *   <li>Non-verified users will be prompted for identity verification</li>
 * </ul>
 * 
 * <p>Usage examples:
 * <pre>{@code
 * // User already authenticated in mobile app
 * GuidanceRequest request = new GuidanceRequest();
 * request.setPreVerified(PreVerified.YES);
 * 
 * // User accessing from public link
 * request.setPreVerified(PreVerified.NO);
 * 
 * // Converting from code
 * PreVerified status = PreVerified.fromCode("0");
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum PreVerified {
    
    /**
     * Channel has already verified user identity.
     * 
     * <p>This indicates that the calling system or channel has already
     * performed adequate user identity verification. The user should not
     * be prompted for additional authentication in the guidance flow.
     * 
     * <p>Examples of pre-verification include:
     * <ul>
     *   <li>User logged in with username/password + SMS OTP</li>
     *   <li>Biometric authentication (fingerprint, face ID)</li>
     *   <li>Hardware token or certificate-based authentication</li>
     *   <li>Multi-factor authentication completed</li>
     * </ul>
     * 
     * <p>Code value: "0"
     */
    @SerializedName("0")
    YES("0", "Channel has pre-verified user identity"),
    
    /**
     * Channel has not verified, DCS needs to verify.
     * 
     * <p>This indicates that the calling system has not performed user
     * identity verification, and DCS should prompt the user for authentication
     * before allowing access to sensitive operations.
     * 
     * <p>Common scenarios include:
     * <ul>
     *   <li>Anonymous or public access to guidance pages</li>
     *   <li>Direct links shared via email or SMS</li>
     *   <li>Session timeout requiring re-authentication</li>
     *   <li>First-time access without prior login</li>
     * </ul>
     * 
     * <p>DCS will typically prompt for:
     * <ul>
     *   <li>Card details (last 4 digits, expiry, CVV)</li>
     *   <li>Personal information verification</li>
     *   <li>SMS or email OTP verification</li>
     * </ul>
     * 
     * <p>Code value: "1"
     */
    @SerializedName("1")
    NO("1", "Channel has not verified, DCS needs to verify");

    private final String code;
    private final String description;

    PreVerified(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the verification code.
     *
     * @return the verification code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the verification description.
     *
     * @return the verification description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the PreVerified by code.
     *
     * @param code the verification code
     * @return the corresponding PreVerified
     * @throws IllegalArgumentException if the code is not valid
     */
    public static PreVerified fromCode(String code) {
        for (PreVerified preVerified : values()) {
            if (preVerified.code.equals(code)) {
                return preVerified;
            }
        }
        throw new IllegalArgumentException("Invalid pre-verified code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
