package com.dicard.connector.client.common.auth;

import com.dicard.connector.client.common.exception.ApiException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HMAC-SHA256 authentication implementation for dicard API.
 */
public class HmacAuthentication implements Authentication {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    private final String apiKey;
    private final String secretKey;

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

    @Override
    public String generateSignature(String timestamp, String nonce, String payload) throws ApiException {
        try {
            String message = apiKey + timestamp + nonce + (payload != null ? payload : "");

            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            SecretKeySpec secretKeySpec =
                    new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);

            byte[] signatureBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(signatureBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new ApiException("HMAC-SHA256 algorithm not available", e);
        } catch (InvalidKeyException e) {
            throw new ApiException("Invalid secret key for HMAC-SHA256", e);
        } catch (Exception e) {
            throw new ApiException("Failed to generate HMAC signature", e);
        }
    }
}

