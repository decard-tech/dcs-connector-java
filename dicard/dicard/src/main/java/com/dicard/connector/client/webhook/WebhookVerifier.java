package com.dicard.connector.client.webhook;

import com.dicard.connector.client.webhook.model.WebhookPayload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility for verifying and parsing dicard webhook notifications.
 *
 * <p>When dicard sends a webhook notification to your configured URL, the request includes:
 * <ul>
 *   <li>HTTP Body: JSON payload (fields sorted alphabetically)</li>
 *   <li>Header {@code X-Signature}: HMAC-SHA256 signature of the body using your secret key</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * WebhookVerifier verifier = new WebhookVerifier("your-secret-key");
 *
 * // In your webhook endpoint handler:
 * String requestBody = ...; // raw HTTP body
 * String signature = ...; // X-Signature header value
 *
 * if (verifier.verify(requestBody, signature)) {
 *     WebhookPayload payload = verifier.parse(requestBody);
 *     WebhookEvent eventType = payload.getEventType();
 *     // Handle event...
 * } else {
 *     // Reject: invalid signature
 * }
 * }</pre>
 *
 * @since 1.0.0
 */
public class WebhookVerifier {

    private static final String HMAC_SHA256 = "HmacSHA256";

    private final String secretKey;
    private final Gson gson;

    /**
     * Creates a new WebhookVerifier with the specified secret key.
     *
     * @param secretKey the secret key used for HMAC signature verification (same as your API secret key)
     * @throws IllegalArgumentException if secretKey is null or empty
     */
    public WebhookVerifier(String secretKey) {
        if (secretKey == null || secretKey.trim().isEmpty()) {
            throw new IllegalArgumentException("Secret key cannot be null or empty");
        }
        this.secretKey = secretKey;
        this.gson = new GsonBuilder().create();
    }

    /**
     * Verifies the webhook signature.
     *
     * @param requestBody the raw HTTP request body (JSON string)
     * @param signature   the value of the {@code X-Signature} header
     * @return true if the signature is valid, false otherwise
     */
    public boolean verify(String requestBody, String signature) {
        if (requestBody == null || signature == null) {
            return false;
        }

        try {
            String computed = computeSignature(requestBody);
            return MessageDigest.isEqual(
                    computed.getBytes(StandardCharsets.UTF_8),
                    signature.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Parses the webhook request body into a {@link WebhookPayload}.
     *
     * @param requestBody the raw HTTP request body (JSON string)
     * @return the parsed webhook payload
     */
    public WebhookPayload parse(String requestBody) {
        return gson.fromJson(requestBody, WebhookPayload.class);
    }

    /**
     * Verifies the signature and parses the payload in one step.
     *
     * @param requestBody the raw HTTP request body (JSON string)
     * @param signature   the value of the {@code X-Signature} header
     * @return the parsed WebhookPayload if signature is valid
     * @throws SecurityException if the signature verification fails
     */
    public WebhookPayload verifyAndParse(String requestBody, String signature) {
        if (!verify(requestBody, signature)) {
            throw new SecurityException("Invalid webhook signature");
        }
        return parse(requestBody);
    }

    /**
     * Computes the HMAC-SHA256 signature for the given payload.
     *
     * @param payload the payload string
     * @return the hex-encoded HMAC-SHA256 signature
     */
    public String computeSignature(String payload) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec keySpec = new SecretKeySpec(
                    secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
            mac.init(keySpec);
            byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to compute HMAC signature", e);
        }
    }
}
