/*
 * dicard Java Connector
 * Asset API implementation
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.asset.api;

import com.dicard.connector.client.asset.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Low-level Asset API implementation for dicard REST API.
 *
 * @since 1.0.0
 */
public class AssetApi {

    private final ApiClient apiClient;

    public AssetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Credit assets to a user's wallet.
     *
     * @param request transfer request (required)
     * @return ApiResponse containing the transfer response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<TransferResponse> credit(TransferRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling credit");
        }

        Call call = apiClient.buildCall("/user-asset/v1/credit", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, TransferResponse.class);
    }

    /**
     * Debit assets from a user's wallet.
     *
     * @param request transfer request (required)
     * @return ApiResponse containing the transfer response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<TransferResponse> debit(TransferRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling debit");
        }

        Call call = apiClient.buildCall("/user-asset/v1/debit", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, TransferResponse.class);
    }

    /**
     * Query transfer records.
     *
     * @param page            page number (optional)
     * @param rows            page size (optional)
     * @param externalTranIds comma-separated external transaction IDs (optional)
     * @return ApiResponse containing the transfer response list
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<TransferResponse>> queryTransfer(Integer page, Integer rows, String externalTranIds)
            throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (page != null) {
            queryParams.addAll(apiClient.parameterToPair("page", page));
        }
        if (rows != null) {
            queryParams.addAll(apiClient.parameterToPair("rows", rows));
        }
        if (externalTranIds != null) {
            queryParams.addAll(apiClient.parameterToPair("externalTranIds", externalTranIds));
        }

        Call call = apiClient.buildCall("/user-asset/v1/transfer-query", "GET", queryParams, null, new String[]{});
        ApiResponse<TransferResponse[]> arrayResponse = apiClient.execute(call, TransferResponse[].class);
        List<TransferResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Query wallet balance.
     *
     * @param externalUserId user ID (required)
     * @return ApiResponse containing the wallet balance list
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<WalletBalanceResponse>> getBalance(String externalUserId) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getBalance");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));

        Call call = apiClient.buildCall("/user-asset/v1/balance", "GET", queryParams, null, new String[]{});
        ApiResponse<WalletBalanceResponse[]> arrayResponse = apiClient.execute(call, WalletBalanceResponse[].class);
        List<WalletBalanceResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Query crypto asset transactions.
     *
     * @param request crypto transactions request (required)
     * @return ApiResponse containing the raw transaction data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getCryptoTransactions(Object request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getCryptoTransactions");
        }
        Call call = apiClient.buildCall("/user-asset/v1/transactions", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    /**
     * Query crypto asset transaction detail.
     *
     * @param request crypto transaction detail request (required)
     * @return ApiResponse containing the raw transaction detail
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getCryptoTransactionDetail(Object request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getCryptoTransactionDetail");
        }
        Call call = apiClient.buildCall("/user-asset/v1/transaction-detail", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
