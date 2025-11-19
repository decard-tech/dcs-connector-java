/*
 * dcs Java Connector
 * Base64 format validator utility
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.validator;

import java.util.Base64;
import java.util.regex.Pattern;

/**
 * Utility class for validating Base64 encoded strings.
 * 
 * <p>This class provides methods to validate Base64 encoded data
 * commonly used for encrypted fields in the DCS API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Base64Validator {

    /**
     * Pattern for Base64 encoded strings (RFC 4648).
     * Allows standard Base64 characters: A-Z, a-z, 0-9, +, /, and padding with =
     */
    private static final Pattern BASE64_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+/]*={0,2}$"
    );

    /**
     * Pattern for URL-safe Base64 encoded strings (RFC 4648).
     * Uses - and _ instead of + and /
     */
    private static final Pattern BASE64_URL_SAFE_PATTERN = Pattern.compile(
        "^[A-Za-z0-9_-]*={0,2}$"
    );

    /**
     * Private constructor to prevent instantiation.
     */
    private Base64Validator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Validates if the given string is a valid Base64 encoded string.
     *
     * @param base64String the string to validate
     * @return true if valid Base64, false otherwise
     */
    public static boolean isValidBase64(String base64String) {
        if (base64String == null || base64String.trim().isEmpty()) {
            return false;
        }

        // Remove whitespace
        String cleaned = base64String.replaceAll("\\s", "");

        // Check pattern
        if (!BASE64_PATTERN.matcher(cleaned).matches()) {
            return false;
        }

        // Check length (must be multiple of 4)
        if (cleaned.length() % 4 != 0) {
            return false;
        }

        // Try to decode
        try {
            Base64.getDecoder().decode(cleaned);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Validates if the given string is a valid URL-safe Base64 encoded string.
     *
     * @param base64String the string to validate
     * @return true if valid URL-safe Base64, false otherwise
     */
    public static boolean isValidUrlSafeBase64(String base64String) {
        if (base64String == null || base64String.trim().isEmpty()) {
            return false;
        }

        // Remove whitespace
        String cleaned = base64String.replaceAll("\\s", "");

        // Check pattern
        if (!BASE64_URL_SAFE_PATTERN.matcher(cleaned).matches()) {
            return false;
        }

        // Try to decode
        try {
            Base64.getUrlDecoder().decode(cleaned);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Validates Base64 string and checks minimum length.
     *
     * @param base64String the string to validate
     * @param minDecodedLength minimum length of decoded data in bytes
     * @return true if valid and meets minimum length requirement
     */
    public static boolean isValidBase64WithMinLength(String base64String, int minDecodedLength) {
        if (!isValidBase64(base64String)) {
            return false;
        }

        try {
            byte[] decoded = Base64.getDecoder().decode(base64String.replaceAll("\\s", ""));
            return decoded.length >= minDecodedLength;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Validates Base64 string and checks exact length.
     *
     * @param base64String the string to validate
     * @param expectedDecodedLength expected length of decoded data in bytes
     * @return true if valid and meets exact length requirement
     */
    public static boolean isValidBase64WithExactLength(String base64String, int expectedDecodedLength) {
        if (!isValidBase64(base64String)) {
            return false;
        }

        try {
            byte[] decoded = Base64.getDecoder().decode(base64String.replaceAll("\\s", ""));
            return decoded.length == expectedDecodedLength;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Validates if the string is a valid Base64 encoded IV (Initialization Vector).
     * Typically IVs are 16 bytes (128 bits) for AES encryption.
     *
     * @param ivString the IV string to validate
     * @return true if valid Base64 IV, false otherwise
     */
    public static boolean isValidBase64IV(String ivString) {
        return isValidBase64WithExactLength(ivString, 16); // 16 bytes = 128 bits
    }

    /**
     * Gets the decoded length of a Base64 string without actually decoding it.
     *
     * @param base64String the Base64 string
     * @return the decoded length in bytes, or -1 if invalid
     */
    public static int getDecodedLength(String base64String) {
        if (base64String == null || base64String.trim().isEmpty()) {
            return -1;
        }

        String cleaned = base64String.replaceAll("\\s", "");
        
        if (cleaned.length() % 4 != 0) {
            return -1;
        }

        int paddingCount = 0;
        if (cleaned.endsWith("==")) {
            paddingCount = 2;
        } else if (cleaned.endsWith("=")) {
            paddingCount = 1;
        }

        return (cleaned.length() * 3) / 4 - paddingCount;
    }
}
