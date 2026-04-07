/*
 * dicard Java Connector
 * Card API implementation
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.card.api;

import com.dicard.connector.client.card.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Low-level Card API implementation for dicard REST API.
 *
 * <p>This class is typically used internally by {@link CardRestApi}
 * and should not be used directly unless fine-grained control is needed.
 *
 * @since 1.0.0
 */
public class CardApi {

    private final ApiClient apiClient;

    public CardApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List available card categories.
     *
     * @return ApiResponse containing the list of card categories
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<CardListResponse>> listCardCategories() throws ApiException {
        Call call = apiClient.buildCall("/card/v1/list", "GET", new ArrayList<>(), null, new String[]{});
        ApiResponse<CardListResponse[]> arrayResponse = apiClient.execute(call, CardListResponse[].class);
        List<CardListResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Get card detail.
     *
     * @param externalUserId user ID (required)
     * @param cardMantissa   last 4 digits of card number (optional)
     * @return ApiResponse containing the card detail list
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<CardDetailResponse>> getCardDetail(String externalUserId, String cardMantissa)
            throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getCardDetail");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (cardMantissa != null) {
            queryParams.addAll(apiClient.parameterToPair("cardMantissa", cardMantissa));
        }

        Call call = apiClient.buildCall("/card/v1/detail", "GET", queryParams, null, new String[]{});
        ApiResponse<CardDetailResponse[]> arrayResponse = apiClient.execute(call, CardDetailResponse[].class);
        List<CardDetailResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Block or unblock a card.
     *
     * @param request block card request (required)
     * @return ApiResponse containing the result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Boolean> blockCard(BlockCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling blockCard");
        }

        Call call = apiClient.buildCall("/card/v1/block", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Boolean.class);
    }

    /**
     * Query card transactions.
     *
     * @param request card transactions request (required)
     * @return ApiResponse containing the raw transaction result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getCardTransactions(CardTransactionsRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getCardTransactions");
        }

        Call call = apiClient.buildCall("/card/v1/transactions", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    /**
     * Apply for a virtual card.
     *
     * @param request apply virtual card request (required)
     * @return ApiResponse containing the application response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<ApplyVirtualCardResponse> applyVirtualCard(ApplyVirtualCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling applyVirtualCard");
        }

        Call call = apiClient.buildCall(
                "/card/v1/virtual-card/apply", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, ApplyVirtualCardResponse.class);
    }

    /**
     * Get virtual card application detail.
     *
     * @param externalUserId user ID (required)
     * @param applyId        apply ID (optional)
     * @param applyRef       apply reference (optional)
     * @return ApiResponse containing the application detail
     * @throws ApiException if the API call fails
     */
    public ApiResponse<ApplyVirtualCardResponse> getVirtualCardDetail(
            String externalUserId, String applyId, String applyRef) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException(
                    "Missing the required parameter 'externalUserId' when calling getVirtualCardDetail");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (applyId != null) {
            queryParams.addAll(apiClient.parameterToPair("applyId", applyId));
        }
        if (applyRef != null) {
            queryParams.addAll(apiClient.parameterToPair("applyRef", applyRef));
        }

        Call call = apiClient.buildCall("/card/v1/virtual-card/detail", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, ApplyVirtualCardResponse.class);
    }

    /**
     * Bind Apple Wallet.
     *
     * @param request Apple Wallet binding request (required)
     * @return ApiResponse containing the binding response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<BindAppleWalletResponse> bindAppleWallet(BindAppleWalletRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling bindAppleWallet");
        }

        Call call = apiClient.buildCall(
                "/card/v1/apple-bind-wallet", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, BindAppleWalletResponse.class);
    }

    /**
     * Bind Google Wallet.
     *
     * @param request Google Wallet binding request (required)
     * @return ApiResponse containing the binding response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<BindGoogleWalletResponse> bindGoogleWallet(BindGoogleWalletRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling bindGoogleWallet");
        }

        Call call = apiClient.buildCall(
                "/card/v1/google-bind-wallet", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, BindGoogleWalletResponse.class);
    }

    /**
     * Get physical card shipping information.
     *
     * @param externalUserId user ID (required)
     * @param cardMantissa   last 4 digits of card number (required)
     * @return ApiResponse containing the shipping info
     * @throws ApiException if the API call fails
     */
    public ApiResponse<ShippingInfoResponse> getShippingInfo(String externalUserId, String cardMantissa)
            throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getShippingInfo");
        }
        if (cardMantissa == null) {
            throw new ApiException("Missing the required parameter 'cardMantissa' when calling getShippingInfo");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        queryParams.addAll(apiClient.parameterToPair("cardMantissa", cardMantissa));

        Call call = apiClient.buildCall("/card/v1/physical-shipping-info", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, ShippingInfoResponse.class);
    }

    /**
     * Get card apply records.
     *
     * @param externalUserId user ID (required)
     * @return ApiResponse containing the apply records
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<CardApplyResponse>> getApplyList(String externalUserId) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getApplyList");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));

        Call call = apiClient.buildCall("/card/v1/apply-list", "GET", queryParams, null, new String[]{});
        ApiResponse<CardApplyResponse[]> arrayResponse = apiClient.execute(call, CardApplyResponse[].class);
        List<CardApplyResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Resolve transaction IDs.
     *
     * @param request transaction ID resolve request (required)
     * @return ApiResponse containing resolved transaction info
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<TransactionIdResolveResponse>> resolveTransactionIds(
            TransactionIdResolveRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling resolveTransactionIds");
        }

        Call call = apiClient.buildCall(
                "/card/v1/transaction/id/resolve", "POST", new ArrayList<>(), request, new String[]{});
        ApiResponse<TransactionIdResolveResponse[]> arrayResponse =
                apiClient.execute(call, TransactionIdResolveResponse[].class);
        List<TransactionIdResolveResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Get card statements.
     *
     * @param externalUserId user ID (required)
     * @param cardMantissa   last 4 digits of card number (optional)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @param startTime      start date, format: yyyy-MM-dd (optional)
     * @param endTime        end date, format: yyyy-MM-dd (optional)
     * @return ApiResponse containing the raw statement data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getStatements(String externalUserId, String cardMantissa,
                                             Integer page, Integer rows,
                                             String startTime, String endTime) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getStatements");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (cardMantissa != null) {
            queryParams.addAll(apiClient.parameterToPair("cardMantissa", cardMantissa));
        }
        if (page != null) {
            queryParams.addAll(apiClient.parameterToPair("page", page));
        }
        if (rows != null) {
            queryParams.addAll(apiClient.parameterToPair("rows", rows));
        }
        if (startTime != null) {
            queryParams.addAll(apiClient.parameterToPair("startTime", startTime));
        }
        if (endTime != null) {
            queryParams.addAll(apiClient.parameterToPair("endTime", endTime));
        }

        Call call = apiClient.buildCall("/card/v1/statements", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    /**
     * Get statement transaction details.
     *
     * @param externalUserId user ID (required)
     * @param statementId    statement ID (required)
     * @param cardMantissa   last 4 digits of card number (optional)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @return ApiResponse containing the raw statement detail data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getStatementDetails(String externalUserId, String statementId,
                                                   String cardMantissa, Integer page, Integer rows) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException(
                    "Missing the required parameter 'externalUserId' when calling getStatementDetails");
        }
        if (statementId == null) {
            throw new ApiException(
                    "Missing the required parameter 'statementId' when calling getStatementDetails");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        queryParams.addAll(apiClient.parameterToPair("statementId", statementId));
        if (cardMantissa != null) {
            queryParams.addAll(apiClient.parameterToPair("cardMantissa", cardMantissa));
        }
        if (page != null) {
            queryParams.addAll(apiClient.parameterToPair("page", page));
        }
        if (rows != null) {
            queryParams.addAll(apiClient.parameterToPair("rows", rows));
        }

        Call call = apiClient.buildCall("/card/v1/statements/detail", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    /**
     * Get fiat transactions.
     *
     * @param externalUserId user ID (required)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @return ApiResponse containing the raw fiat transaction data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getFiatTransactions(String externalUserId, Integer page, Integer rows)
            throws ApiException {
        if (externalUserId == null) {
            throw new ApiException(
                    "Missing the required parameter 'externalUserId' when calling getFiatTransactions");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (page != null) {
            queryParams.addAll(apiClient.parameterToPair("page", page));
        }
        if (rows != null) {
            queryParams.addAll(apiClient.parameterToPair("rows", rows));
        }

        Call call = apiClient.buildCall("/card/v1/fiat/transactions", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
