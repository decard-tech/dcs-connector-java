/*
 * dcs Java Connector
 * Card API implementation
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;


import com.dcscc.connector.client.card.model.*;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.Pair;
import com.dcscc.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Card API implementation for dcs REST API.
 * 
 * <p>This class provides low-level access to dcs card management endpoints.
 * It handles HTTP request construction, parameter validation, and response parsing
 * for all card-related operations.
 * 
 * <p>This class is typically used internally by {@link CardRestApi}
 * and should not be used directly unless you need fine-grained control over API calls.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CardApi {

    private final ApiClient apiClient;

    /**
     * Constructs a new CardApi with the specified API client.
     *
     * @param apiClient the configured API client
     */
    public CardApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get card details.
     * 
     * <p>Retrieves detailed information for a specific card including status,
     * balance, limits, and configuration.
     *
     * @param cardId Card ID (required)
     * @return ApiResponse&lt;CardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardResponse> getCardDetail(String cardId) throws ApiException {
        Call call = getCardDetailCall(cardId);
        return apiClient.execute(call, CardResponse.class);
    }

    /**
     * Build call for getCardDetail
     * @param cardId Card ID (required)
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private Call getCardDetailCall(String cardId) throws ApiException {
        // Verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling getCardDetail");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("cardId", cardId));

        return apiClient.buildCall(
            "/open-api/card/v1/detail",
            "GET",
            queryParams,
            null,
            new String[]{}
        );
    }

    /**
     * List cards for a customer.
     * 
     * <p>Retrieves all cards associated with a specific customer.
     *
     * @param customerId Customer ID (required)
     * @return ApiResponse&lt;List&lt;CardResponse&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<CardResponse>> listCards(String customerId) throws ApiException {
        Call call = listCardsCall(customerId);
        ApiResponse<CardResponse[]> arrayResponse = apiClient.execute(call, CardResponse[].class);
        List<CardResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Build call for listCards
     */
    private Call listCardsCall(String customerId) throws ApiException {
        if (customerId == null) {
            throw new ApiException("Missing the required parameter 'customerId' when calling listCards");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("customerId", customerId));

        return apiClient.buildCall(
            "/open-api/card/v1/list",
            "GET",
            queryParams,
            null,
            new String[]{}
        );
    }

    /**
     * Freeze or unfreeze a card.
     * 
     * <p>Temporarily disables or re-enables a card for transactions.
     *
     * @param request Freeze card request (required)
     * @return ApiResponse&lt;CardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardResponse> freezeCard(FreezeCardRequest request) throws ApiException {
        Call call = freezeCardCall(request);
        return apiClient.execute(call, CardResponse.class);
    }

    /**
     * Build call for freezeCard
     */
    private Call freezeCardCall(FreezeCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling freezeCard");
        }

        return apiClient.buildCall(
            "/open-api/card/v1/freeze",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Terminate a card.
     * 
     * <p>Permanently disables a card, making it unusable for future transactions.
     *
     * @param request Terminate card request (required)
     * @return ApiResponse&lt;CardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardResponse> terminateCard(TerminateCardRequest request) throws ApiException {
        Call call = terminateCardCall(request);
        return apiClient.execute(call, CardResponse.class);
    }

    /**
     * Build call for terminateCard
     */
    private Call terminateCardCall(TerminateCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling terminateCard");
        }

        return apiClient.buildCall(
            "/open-api/card/v1/terminate",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Activate a physical card.
     * 
     * <p>Activates a physical card for use in transactions.
     *
     * @param request Activate card request (required)
     * @return ApiResponse&lt;CardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CardResponse> activatePhysicalCard(ActivateCardRequest request) throws ApiException {
        Call call = activatePhysicalCardCall(request);
        return apiClient.execute(call, CardResponse.class);
    }

    /**
     * Build call for activatePhysicalCard
     */
    private Call activatePhysicalCardCall(ActivateCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling activatePhysicalCard");
        }

        return apiClient.buildCall(
            "/open-api/card/v1/physical-active",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Reset card PIN.
     * 
     * <p>Resets the PIN for a card using encrypted verification data.
     *
     * @param request Reset PIN request (required)
     * @return ApiResponse&lt;Boolean&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Boolean> resetPin(ResetPinRequest request) throws ApiException {
        Call call = resetPinCall(request);
        return apiClient.execute(call, Boolean.class);
    }

    /**
     * Build call for resetPin
     */
    private Call resetPinCall(ResetPinRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling resetPin");
        }

        return apiClient.buildCall(
            "/open-api/card/v1/reset-pin",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Retrieve secure card information.
     * 
     * <p>Returns sensitive card data such as PAN, expiry, and CVV in encrypted form.
     *
     * @param request Retrieve secure card request (required)
     * @return ApiResponse&lt;SecureCardResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SecureCardResponse> retrieveSecureCard(RetrieveSecureCardRequest request) throws ApiException {
        Call call = retrieveSecureCardCall(request);
        return apiClient.execute(call, SecureCardResponse.class);
    }

    /**
     * Build call for retrieveSecureCard
     */
    private Call retrieveSecureCardCall(RetrieveSecureCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling retrieveSecureCard");
        }

        return apiClient.buildCall(
            "/open-api/card/v1/retrieve-secure-card",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }

    /**
     * Get card shipping information.
     * 
     * <p>Retrieves shipping details and tracking information for a physical card.
     *
     * @param cardId Card ID (required)
     * @return ApiResponse&lt;ShippingInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShippingInfoResponse> getShippingInfo(String cardId) throws ApiException {
        Call call = getShippingInfoCall(cardId);
        return apiClient.execute(call, ShippingInfoResponse.class);
    }

    /**
     * Build call for getShippingInfo
     */
    private Call getShippingInfoCall(String cardId) throws ApiException {
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling getShippingInfo");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("cardId", cardId));

        return apiClient.buildCall(
            "/open-api/card/v1/shipping-info",
            "GET",
            queryParams,
            null,
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
