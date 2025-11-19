/*
 * dcs Java Connector
 * HMAC-SHA256 authentication implementation
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.auth;

import com.dcscc.connector.client.common.exception.ApiException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HMAC-SHA256 authentication implementation for dcs API.
 * 
 * <p>This class implements the HMAC-SHA256 signature authentication method
 * required by the dcs API. The signature is generated using the following formula:
 * 
 * <pre>
 * signature = HMAC-SHA256(apiKey + timestamp + nonce + payload, secretKey)
 * </pre>
 * 
 * <p>Where:
 * <ul>
 *   <li>apiKey: The API key provided by dcs</li>
 *   <li>timestamp: Current timestamp in milliseconds</li>
 *   <li>nonce: Random number between 10000 and 99999</li>
 *   <li>payload: Request payload (query string for GET, JSON body for POST)</li>
 *   <li>secretKey: The secret key provided by dcs</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>{@code
 * HmacAuthentication auth = new HmacAuthentication("your-api-key", "your-secret-key");
 * String signature = auth.generateSignature("1629876543000", "12345", "symbol=BTCUSDT");
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class HmacAuthentication implements Authentication {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private static final String AUTHENTICATION_METHOD = "HMAC-SHA256";

    private final String apiKey;
    private final String secretKey;

    /**
     * Constructs a new HmacAuthentication with the specified API key and secret key.
     *
     * @param apiKey the API key provided by CardBridge
     * @param secretKey the secret key provided by CardBridge
     * @throws IllegalArgumentException if apiKey or secretKey is null or empty
     */
    public HmacAuthentication(String apiKey, String secretKey) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or empty");
        }
        if (secretKey == null || secretKey.trim().isEmpty()) {
            throw new IllegalArgumentException("Secret key cannot be null or empty");
        }
        
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    /**
     * {@inheritDoc}
     * 
     * <p>Generates HMAC-SHA256 signature using the formula:
     * <code>HMAC-SHA256(apiKey + timestamp + nonce + payload, secretKey)</code>
     * 
     * @param timestamp the request timestamp in milliseconds
     * @param nonce the random nonce value for the request
     * @param payload the request payload
     * @return the hex-encoded HMAC-SHA256 signature
     * @throws ApiException if signature generation fails due to cryptographic errors
     */
    @Override
    public String generateSignature(String timestamp, String nonce, String payload) throws ApiException {
        try {
            // Build the message to sign: apiKey + timestamp + nonce + payload
            String message = apiKey + timestamp + nonce + (payload != null ? payload : "");
            
            // Create HMAC-SHA256 instance
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(
                secretKey.getBytes(StandardCharsets.UTF_8), 
                HMAC_SHA256_ALGORITHM
            );
            mac.init(secretKeySpec);
            
            // Generate signature
            byte[] signatureBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            
            // Return hex-encoded signature
            return Hex.encodeHexString(signatureBytes);
            
        } catch (NoSuchAlgorithmException e) {
            throw new ApiException("HMAC-SHA256 algorithm not available", e);
        } catch (InvalidKeyException e) {
            throw new ApiException("Invalid secret key for HMAC-SHA256", e);
        } catch (Exception e) {
            throw new ApiException("Failed to generate HMAC signature", e);
        }
    }
    /**
     * Gets the API key.
     *
     * @return the API key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Validates the signature parameters.
     *
     * @param timestamp the timestamp to validate
     * @param nonce the nonce to validate
     * @throws IllegalArgumentException if parameters are invalid
     */
    public void validateParameters(String timestamp, String nonce) {
        if (timestamp == null || timestamp.trim().isEmpty()) {
            throw new IllegalArgumentException("Timestamp cannot be null or empty");
        }
        
        if (nonce == null || nonce.trim().isEmpty()) {
            throw new IllegalArgumentException("Nonce cannot be null or empty");
        }
        
        // Validate timestamp format (should be a valid long)
        try {
            Long.parseLong(timestamp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid timestamp format: " + timestamp);
        }
        
        // Validate nonce format (should be between 10000 and 99999)
        try {
            int nonceValue = Integer.parseInt(nonce);
            if (nonceValue < 10000 || nonceValue > 99999) {
                throw new IllegalArgumentException("Nonce must be between 10000 and 99999: " + nonce);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid nonce format: " + nonce);
        }
    }

    @Override
    public String toString() {
        return "HmacAuthentication{" +
                "apiKey='" + (apiKey != null ? "***" : null) + '\'' +
                ", secretKey='" + (secretKey != null ? "***" : null) + '\'' +
                ", method='" + AUTHENTICATION_METHOD + '\'' +
                '}';
    }
}
