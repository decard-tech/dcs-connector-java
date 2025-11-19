/*
 * CardBridge Java Connector
 * Card Order Management REST API client
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.card.api;

import com.dcscc.connector.client.card.model.CardOrderResponse;
import com.dcscc.connector.client.card.model.CreateCardOrderRequest;
import com.dcscc.connector.client.card.model.ReplaceCardOrderRequest;
import com.dcscc.connector.client.card.model.VirtualToPhysicalRequest;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * CardBridge Card Order Management REST API client.
 * 
 * <p>This class provides a high-level interface for interacting with CardBridge's
 * card order management APIs. It handles card order lifecycle operations including:
 * <ul>
 *   <li>Virtual card order creation</li>
 *   <li>Order status tracking</li>
 *   <li>Card replacement orders</li>
 *   <li>Virtual to physical card conversion</li>
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
 * CardOrderRestApi orderApi = new CardOrderRestApi(config);
 * 
 * // Create a virtual card order
 * CreateCardOrderRequest request = new CreateCardOrderRequest();
 * request.setProfileId("profile_123");
 * request.setCardOrderRef("order_ref_456");
 * request.setCustomerInfo(customerInfo);
 * request.setKycInfo(kycInfo);
 * 
 * ApiResponse<CardOrderResponse> response = orderApi.createVirtualCardOrder(request);
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 * @see CardOrderApi
 * @see ClientConfiguration
 */
public class CardOrderRestApi {

    private final CardOrderApi cardOrderApi;

    /**
     * Constructs a new CardOrderRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public CardOrderRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }
        
        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.cardOrderApi = new CardOrderApi(apiClient);
    }

    /**
     * Constructs a new CardOrderRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public CardOrderRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }
        
        this.cardOrderApi = new CardOrderApi(apiClient);
    }

    /**
     * Creates a virtual card order.
     * 
     * <p>This method creates a new virtual card order with the specified customer
     * and KYC information. The virtual card will be issued instantly upon successful
     * order processing and KYC verification.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card-order/v1/apply-virtual}
     * <p><b>Weight:</b> 10
     *
     * @param request the card order creation request parameters (required)
     * @return ApiResponse containing the created card order details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see CreateCardOrderRequest
     * @see CardOrderResponse
     */
    public ApiResponse<CardOrderResponse> createVirtualCardOrder(CreateCardOrderRequest request) throws ApiException {
        return cardOrderApi.createVirtualCardOrder(request);
    }

    /**
     * Retrieves card order details.
     * 
     * <p>This method fetches detailed information about a card order using either
     * the order ID or the order reference. At least one of these parameters must
     * be provided.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/card-order/v1/detail}
     * <p><b>Weight:</b> 1
     *
     * @param cardOrderId the unique identifier of the card order (optional)
     * @param cardOrderRef the reference identifier of the card order (optional)
     * @return ApiResponse containing the card order details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if both cardOrderId and cardOrderRef are null
     * 
     * @see CardOrderResponse
     */
    public ApiResponse<CardOrderResponse> getCardOrderDetail(String cardOrderId, String cardOrderRef) throws ApiException {
        return cardOrderApi.getCardOrderDetail(cardOrderId, cardOrderRef);
    }

    /**
     * Creates a card replacement order.
     * 
     * <p>This method creates a replacement order for an existing card. The replacement
     * can be due to various reasons such as card damage, loss, or security concerns.
     * The original card will be terminated and a new card will be issued.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card-order/v1/replace}
     * <p><b>Weight:</b> 10
     *
     * @param request the card replacement request parameters (required)
     * @return ApiResponse containing the replacement order details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see ReplaceCardOrderRequest
     * @see CardOrderResponse
     */
    public ApiResponse<CardOrderResponse> replaceCard(ReplaceCardOrderRequest request) throws ApiException {
        return cardOrderApi.replaceCard(request);
    }

    /**
     * Converts a virtual card to a physical card.
     * 
     * <p>This method creates an order to convert an existing virtual card to a
     * physical card. The physical card will be manufactured and shipped to the
     * provided address while the virtual card remains active until the physical
     * card is activated.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/card-order/v1/virtual-to-physical}
     * <p><b>Weight:</b> 10
     *
     * @param request the virtual to physical conversion request parameters (required)
     * @return ApiResponse containing the conversion order details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see VirtualToPhysicalRequest
     * @see CardOrderResponse
     */
    public ApiResponse<CardOrderResponse> virtualToPhysical(VirtualToPhysicalRequest request) throws ApiException {
        return cardOrderApi.virtualToPhysical(request);
    }

    /**
     * Gets the underlying CardOrderApi instance.
     * 
     * <p>This method provides access to the low-level CardOrderApi for advanced use cases
     * that require direct access to the API client functionality.
     *
     * @return the CardOrderApi instance
     */
    public CardOrderApi getCardOrderApi() {
        return cardOrderApi;
    }
}
