/*
 * dicard Java Connector
 * Crypto API implementation
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.crypto.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.crypto.model.*;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Low-level Crypto API implementation for dicard REST API.
 *
 * @since 1.0.0
 */
public class CryptoApi {

    private final ApiClient apiClient;

    public CryptoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get crypto deposit address.
     *
     * @param externalUserId user ID (required)
     * @param network        blockchain network (required)
     * @param coin           coin/token name (required)
     * @return ApiResponse containing the deposit address
     * @throws ApiException if the API call fails
     */
    public ApiResponse<DepositAddressResponse> getDepositAddress(
            String externalUserId, String network, String coin) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException(
                    "Missing the required parameter 'externalUserId' when calling getDepositAddress");
        }
        if (network == null) {
            throw new ApiException("Missing the required parameter 'network' when calling getDepositAddress");
        }
        if (coin == null) {
            throw new ApiException("Missing the required parameter 'coin' when calling getDepositAddress");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        queryParams.addAll(apiClient.parameterToPair("network", network));
        queryParams.addAll(apiClient.parameterToPair("coin", coin));

        Call call = apiClient.buildCall("/crypto/v1/deposit-address", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, DepositAddressResponse.class);
    }

    /**
     * Apply for crypto withdrawal.
     *
     * @param request withdrawal request (required)
     * @return ApiResponse containing the withdrawal response
     * @throws ApiException if the API call fails
     */
    public ApiResponse<WithdrawResponse> withdrawApply(WithdrawRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling withdrawApply");
        }

        Call call = apiClient.buildCall(
                "/crypto/v1/withdraw-apply", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, WithdrawResponse.class);
    }

    /**
     * Get supported network and coin configurations.
     *
     * @param type config type (optional)
     * @return ApiResponse containing the raw configuration data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getNetworkCoinConfig(String type) throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (type != null) {
            queryParams.addAll(apiClient.parameterToPair("type", type));
        }

        Call call = apiClient.buildCall("/crypto/v1/network-coin", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    /**
     * Get crypto deposit address (V2).
     *
     * @param externalUserId user ID (required)
     * @param network        blockchain network (required)
     * @param coin           coin/token name (required)
     * @return ApiResponse containing the V2 deposit address
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getDepositAddressV2(
            String externalUserId, String network, String coin) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing 'externalUserId' when calling getDepositAddressV2");
        }
        if (network == null) {
            throw new ApiException("Missing 'network' when calling getDepositAddressV2");
        }
        if (coin == null) {
            throw new ApiException("Missing 'coin' when calling getDepositAddressV2");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        queryParams.addAll(apiClient.parameterToPair("network", network));
        queryParams.addAll(apiClient.parameterToPair("coin", coin));

        Call call = apiClient.buildCall("/crypto/v2/deposit-address", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
