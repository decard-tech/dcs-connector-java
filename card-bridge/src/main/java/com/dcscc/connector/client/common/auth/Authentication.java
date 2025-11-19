/*
 * dcs Java Connector
 * Authentication interface for dcs API
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.auth;

import com.dcscc.connector.client.common.exception.ApiException;

/**
 * Interface for API authentication mechanisms.
 * 
 * <p>This interface defines the contract for different authentication methods
 * supported by the dcs API. Implementations should handle the generation
 * of authentication signatures based on the specific algorithm requirements.
 * 
 * <p>Currently supported authentication methods:
 * <ul>
 *   <li>HMAC-SHA256 signature authentication</li>
 * </ul>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Authentication {

    /**
     * Generates an authentication signature for the given parameters.
     * 
     * <p>The signature is generated using the authentication method's specific algorithm
     * and the provided request parameters. This signature is used to verify the
     * authenticity and integrity of the API request.
     *
     * @param timestamp the request timestamp in milliseconds
     * @param nonce the random nonce value for the request
     * @param payload the request payload (query string for GET, JSON body for POST)
     * @return the generated signature string
     * @throws ApiException if signature generation fails
     */
    String generateSignature(String timestamp, String nonce, String payload) throws ApiException;
}
