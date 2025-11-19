/*
 * dcs Java Connector
 * Card Order API implementation
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;
import com.dcscc.connector.client.card.model.CardOrderResponse;
import com.dcscc.connector.client.card.model.CreateCardOrderRequest;
import com.dcscc.connector.client.card.model.ReplaceCardOrderRequest;
import com.dcscc.connector.client.card.model.VirtualToPhysicalRequest;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.Pair;
import com.dcscc.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Card Order API implementation for dcs REST API.
 * 
 * <p>This class provides low-level access to CardBridge card order management endpoints.
 * It handles HTTP request construction, parameter validation, and response parsing
 * for all card order-related operations.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CardOrderApi {

    private final ApiClient apiClient;

    /**
     * Constructs a new CardOrderApi with the specified API client.
     *
     * @param apiClient the configured API client
     */
    public CardOrderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create virtual card order.
     * 
     * <p>Creates a new virtual card order with customer and KYC information.
     *
     * @param request Create card order request (required)
     * @return ApiResponse&lt;CardOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardOrderResponse> createVirtualCardOrder(CreateCardOrderRequest request) throws ApiException {
        Call call = createVirtualCardOrderCall(request);
        return apiClient.execute(call, CardOrderResponse.class);
    }

    /**
     * Build call for createVirtualCardOrder
     */
    private Call createVirtualCardOrderCall(CreateCardOrderRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling createVirtualCardOrder");
        }

        return apiClient.buildCall(
            "/open-api/card-order/v1/apply-virtual",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Get card order details.
     * 
     * <p>Retrieves detailed information about a card order.
     *
     * @param cardOrderId Card order ID (optional)
     * @param cardOrderRef Card order reference (optional)
     * @return ApiResponse&lt;CardOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardOrderResponse> getCardOrderDetail(String cardOrderId, String cardOrderRef) throws ApiException {
        Call call = getCardOrderDetailCall(cardOrderId, cardOrderRef);
        return apiClient.execute(call, CardOrderResponse.class);
    }

    /**
     * Build call for getCardOrderDetail
     */
    private Call getCardOrderDetailCall(String cardOrderId, String cardOrderRef) throws ApiException {
        if (cardOrderId == null && cardOrderRef == null) {
            throw new ApiException("At least one of 'cardOrderId' or 'cardOrderRef' must be provided");
        }

        List<Pair> queryParams = new ArrayList<>();
        if (cardOrderId != null) {
            queryParams.addAll(apiClient.parameterToPair("cardOrderId", cardOrderId));
        }
        if (cardOrderRef != null) {
            queryParams.addAll(apiClient.parameterToPair("cardOrderRef", cardOrderRef));
        }

        return apiClient.buildCall(
            "/open-api/card-order/v1/detail",
            "GET",
            queryParams,
            null,
            new String[]{}
        );
    }

    /**
     * Replace a card.
     * 
     * <p>Creates a replacement order for an existing card.
     *
     * @param request Replace card request (required)
     * @return ApiResponse&lt;CardOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardOrderResponse> replaceCard(ReplaceCardOrderRequest request) throws ApiException {
        Call call = replaceCardCall(request);
        return apiClient.execute(call, CardOrderResponse.class);
    }

    /**
     * Build call for replaceCard
     */
    private Call replaceCardCall(ReplaceCardOrderRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling replaceCard");
        }

        return apiClient.buildCall(
            "/open-api/card-order/v1/replace",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Convert virtual card to physical card.
     * 
     * <p>Creates an order to convert a virtual card to a physical card.
     *
     * @param request Virtual to physical conversion request (required)
     * @return ApiResponse&lt;CardOrderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardOrderResponse> virtualToPhysical(VirtualToPhysicalRequest request) throws ApiException {
        Call call = virtualToPhysicalCall(request);
        return apiClient.execute(call, CardOrderResponse.class);
    }

    /**
     * Build call for virtualToPhysical
     */
    private Call virtualToPhysicalCall(VirtualToPhysicalRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling virtualToPhysical");
        }

        return apiClient.buildCall(
            "/open-api/card-order/v1/virtual-to-physical",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Gets the API client
     * @return API client
     */
    public ApiClient getApiClient() {
        return apiClient;
    }
}
