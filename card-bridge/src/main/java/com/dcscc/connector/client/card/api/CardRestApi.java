/*
 * dcs Java Connector
 * Card Management REST API client
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;


import com.dcscc.connector.client.card.model.*;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

import java.util.List;

/**
 * dcs Card Management REST API client.
 * 
 * <p>This class provides a high-level interface for interacting with CardBridge's
 * card management APIs. It handles card lifecycle operations including:
 * <ul>
 *   <li>Card information retrieval</li>
 *   <li>Card status management (freeze/unfreeze)</li>
 *   <li>Card termination</li>
 *   <li>Physical card activation</li>
 *   <li>PIN reset operations</li>
 *   <li>Secure card information retrieval</li>
 *   <li>Shipping information tracking</li>
 * </ul>
 * 
 * <p>All operations require proper authentication using API key and secret key.
 * The client automatically handles request signing and authentication headers.
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
 * CardRestApi cardApi = new CardRestApi(config);
 * 
 * // Get card details
 * ApiResponse<CardResponse> response = cardApi.getCardDetail("card-123");
 * CardResponse card = response.getData();
 * 
 * // Freeze a card
 * FreezeCardRequest freezeRequest = new FreezeCardRequest();
 * freezeRequest.setCardId("card-123");
 * freezeRequest.setFreeze(true);
 * freezeRequest.setFreezeReason("Suspicious activity");
 * 
 * ApiResponse<CardResponse> freezeResponse = cardApi.freezeCard(freezeRequest);
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 * @see CardApi
 * @see ClientConfiguration
 */
public class CardRestApi {

    private final CardApi cardApi;
    private final RedirectApi redirectApi;


    /**
     * Constructs a new CardRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public CardRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }
        
        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.cardApi = new CardApi(apiClient);
        this.redirectApi = new RedirectApi(apiClient);
    }

    /**
     * Constructs a new CardRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public CardRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }
        
        this.cardApi = new CardApi(apiClient);
        this.redirectApi = new RedirectApi(apiClient);
    }

    /**
     * Retrieves detailed information for a specific card.
     * 
     * <p>This method fetches comprehensive card information including status,
     * balance, limits, and other card properties. The card must belong to
     * the authenticated enterprise.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/card/v1/detail}
     * <p><b>Weight:</b> 1
     *
     * @param cardId the unique identifier of the card (required)
     * @return ApiResponse containing the card details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if cardId is null or empty
     * 
     * @see CardResponse
     */
    public ApiResponse<CardResponse> getCardDetail(String cardId) throws ApiException {
        return cardApi.getCardDetail(cardId);
    }

    /**
     * Retrieves a list of cards for a specific customer.
     * 
     * <p>This method returns all cards associated with the specified customer
     * within the authenticated enterprise. The response includes basic card
     * information for each card.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/card/v1/list}
     * <p><b>Weight:</b> 5
     *
     * @param customerId the unique identifier of the customer (required)
     * @return ApiResponse containing the list of cards
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if customerId is null or empty
     * 
     * @see CardResponse
     */
    public ApiResponse<List<CardResponse>> listCards(String customerId) throws ApiException {
        return cardApi.listCards(customerId);
    }

    /**
     * Freezes or unfreezes a card.
     * 
     * <p>This method allows you to temporarily freeze a card to prevent transactions,
     * or unfreeze a previously frozen card to restore normal functionality.
     * When freezing a card, you can optionally provide a reason for the action.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card/v1/freeze}
     * <p><b>Weight:</b> 10
     *
     * @param request the freeze/unfreeze request parameters (required)
     * @return ApiResponse containing the updated card information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see FreezeCardRequest
     * @see CardResponse
     */
    public ApiResponse<CardResponse> freezeCard(FreezeCardRequest request) throws ApiException {
        return cardApi.freezeCard(request);
    }

    /**
     * Terminates (permanently disables) a card.
     * 
     * <p>This method permanently terminates a card, making it unusable for any
     * future transactions. This action cannot be reversed. A reason for
     * termination must be provided.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card/v1/terminate}
     * <p><b>Weight:</b> 10
     *
     * @param request the card termination request parameters (required)
     * @return ApiResponse containing the updated card information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see TerminateCardRequest
     * @see CardResponse
     */
    public ApiResponse<CardResponse> terminateCard(TerminateCardRequest request) throws ApiException {
        return cardApi.terminateCard(request);
    }

    /**
     * Activates a physical card.
     * 
     * <p>This method activates a physical card that has been issued but not yet
     * activated. Once activated, the card can be used for transactions according
     * to its configured limits and restrictions.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card/v1/physical-active}
     * <p><b>Weight:</b> 10
     *
     * @param request the card activation request parameters (required)
     * @return ApiResponse containing the updated card information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see ActivateCardRequest
     * @see CardResponse
     */
    public ApiResponse<CardResponse> activatePhysicalCard(ActivateCardRequest request) throws ApiException {
        return cardApi.activatePhysicalCard(request);
    }

    /**
     * Resets the PIN for a card.
     * 
     * <p>This method allows resetting the PIN for a card. The request must include
     * encrypted card verification data (expiry date, CVV2, last 4 digits of PAN)
     * and the new encrypted PIN. All sensitive data must be encrypted using the
     * appropriate encryption method.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card/v1/reset-pin}
     * <p><b>Weight:</b> 10
     * <p><b>Security:</b> This operation is logged for audit purposes
     *
     * @param request the PIN reset request parameters (required)
     * @return ApiResponse indicating the success of the operation
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see ResetPinRequest
     */
    public ApiResponse<Boolean> resetPin(ResetPinRequest request) throws ApiException {
        return cardApi.resetPin(request);
    }

    /**
     * Retrieves secure card information.
     * 
     * <p>This method returns sensitive card information such as the full PAN,
     * expiry date, and CVV. Access to this information is strictly controlled
     * and logged for security and compliance purposes.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card/v1/retrieve-secure-card}
     * <p><b>Weight:</b> 20
     * <p><b>Security:</b> This operation is logged for audit purposes
     *
     * @param request the secure card retrieval request parameters (required)
     * @return ApiResponse containing the encrypted secure card information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see RetrieveSecureCardRequest
     * @see SecureCardResponse
     */
    public ApiResponse<SecureCardResponse> retrieveSecureCard(RetrieveSecureCardRequest request) throws ApiException {
        return cardApi.retrieveSecureCard(request);
    }

    /**
     * Retrieves shipping information for a physical card.
     * 
     * <p>This method returns detailed shipping information for a physical card,
     * including tracking numbers, shipping status, delivery address, and
     * estimated delivery dates.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/card/v1/shipping-info}
     * <p><b>Weight:</b> 1
     *
     * @param cardId the unique identifier of the card (required)
     * @return ApiResponse containing the shipping information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if cardId is null or empty
     * 
     * @see ShippingInfoResponse
     */
    public ApiResponse<ShippingInfoResponse> getShippingInfo(String cardId) throws ApiException {
        return cardApi.getShippingInfo(cardId);
    }

    /**
     * Generate guidance page URL.
     *
     * <p>Generates a URL for redirecting users to appropriate card management
     * guidance pages. The URL will direct users to interfaces for operations
     * like card information query, PIN setting, or PIN reset.
     *
     * <p>The generated URL takes into account the user's language preference,
     * theme settings, and whether the user has been pre-verified by the channel.
     *
     * <p><b>Weight:</b> 1
     *
     * @param request the guidance request containing operation details (required)
     * @return ApiResponse containing the guidance URL
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     *
     * @see GuidanceRequest
     */
    public ApiResponse<String> getGuidanceUrl(GuidanceRequest request) throws ApiException {
        if (request == null) {
            throw new IllegalArgumentException("Guidance request cannot be null");
        }

        return redirectApi.getGuidanceUrl(request);
    }

    /**
     * Gets the underlying CardApi instance.
     * 
     * <p>This method provides access to the low-level CardApi for advanced use cases
     * that require direct access to the API client functionality.
     *
     * @return the CardApi instance
     */
    public CardApi getCardApi() {
        return cardApi;
    }
}
