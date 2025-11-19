/*
 * dcs Java Connector
 * 3DS Authentication REST API client
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.api;

import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeRequest;
import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeResponse;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * dcs 3DS Authentication REST API client.
 * 
 * <p>This class provides a high-level interface for interacting with dcs's
 * 3DS (3D Secure) authentication APIs. It handles 3DS challenge operations including:
 * <ul>
 *   <li>3DS challenge authentication processing</li>
 *   <li>Challenge result validation</li>
 *   <li>Authentication status tracking</li>
 *   <li>Security verification workflows</li>
 * </ul>
 * 
 * <p>3D Secure is a protocol designed to be an additional security layer for
 * online credit and debit card transactions. It provides authentication of
 * cardholders through the card issuer's authentication system.
 * 
 * <p>Example usage:
 * <pre>{@code
 * // Configure the client
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 * config.setBaseUrl("https://api.thedecard.com");
 * 
 * // Create the API client
 * ThreeDSRestApi threeDSApi = new ThreeDSRestApi(config);
 * 
 * // Process 3DS challenge authentication
 * ThreeDSChallengeRequest request = new ThreeDSChallengeRequest();
 * request.setChallengeId("challenge_123");
 * request.setApproveStatus("APPROVE");
 * 
 * ApiResponse<ThreeDSChallengeResponse> response = threeDSApi.authenticate(request);
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 * @see ThreeDSApi
 * @see ClientConfiguration
 */
public class ThreeDSRestApi {

    private final ThreeDSApi threeDSApi;

    /**
     * Constructs a new ThreeDSRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public ThreeDSRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }
        
        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.threeDSApi = new ThreeDSApi(apiClient);
    }

    /**
     * Constructs a new ThreeDSRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public ThreeDSRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }
        
        this.threeDSApi = new ThreeDSApi(apiClient);
    }

    /**
     * Processes 3DS challenge authentication.
     * 
     * <p>This method processes the result of a 3DS challenge authentication,
     * updating the authentication status based on the cardholder's response
     * to the challenge. The challenge can be approved or declined, and the
     * system will update the transaction status accordingly.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/3ds-challenge/v1/authenticate}
     * <p><b>Weight:</b> 5
     *
     * @param request the 3DS challenge authentication request parameters (required)
     * @return ApiResponse containing the authentication result
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see ThreeDSChallengeRequest
     * @see ThreeDSChallengeResponse
     */
    public ApiResponse<ThreeDSChallengeResponse> authenticate(ThreeDSChallengeRequest request) throws ApiException {
        return threeDSApi.authenticate(request);
    }

    /**
     * Gets the underlying ThreeDSApi instance.
     * 
     * <p>This method provides access to the low-level ThreeDSApi for advanced use cases
     * that require direct access to the API client functionality.
     *
     * @return the ThreeDSApi instance
     */
    public ThreeDSApi getThreeDSApi() {
        return threeDSApi;
    }
}
