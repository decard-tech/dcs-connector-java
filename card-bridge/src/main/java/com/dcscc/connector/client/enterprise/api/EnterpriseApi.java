/*
 * CardBridge Java Connector
 * Enterprise API implementation
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.enterprise.api;

import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.Pair;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.enterprise.model.BalanceResponse;
import com.dcscc.connector.client.enterprise.model.SettlementFileType;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Enterprise API implementation for CardBridge REST API.
 * 
 * <p>This class provides low-level access to CardBridge enterprise management endpoints.
 * It handles HTTP request construction, parameter validation, and response parsing
 * for all enterprise-related operations.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class EnterpriseApi {

    private final ApiClient apiClient;

    /**
     * Constructs a new EnterpriseApi with the specified API client.
     *
     * @param apiClient the configured API client
     */
    public EnterpriseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Query enterprise account balance.
     * 
     * <p>Retrieves the current balance for the enterprise in the specified currency.
     *
     * @param currency Currency, using ISO3 numeric code (required)
     * @return ApiResponse&lt;BalanceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<BalanceResponse> getEnterpriseBalance(String currency) throws ApiException {
        Call call = getEnterpriseBalanceCall(currency);
        return apiClient.execute(call, BalanceResponse.class);
    }

    /**
     * Build call for getEnterpriseBalance
     */
    private Call getEnterpriseBalanceCall(String currency) throws ApiException {
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling getEnterpriseBalance");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("currency", currency));

        return apiClient.buildCall(
            "/open-api/enterprise/v1/enterprise-balance",
            "GET",
            queryParams,
            null,
            new String[]{}
        );
    }

    /**
     * Get settlement file download link.
     * 
     * <p>Retrieves a secure download URL for settlement files.
     *
     * @param fileType File type (required)
     * @param fileDate File date in YYYYMMDD format (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> getSettlementFileUrl(String fileType, String fileDate) throws ApiException {
        Call call = getSettlementFileUrlCall(fileType, fileDate);
        return apiClient.execute(call, String.class);
    }

    /**
     * Get settlement file download link using enum.
     * 
     * <p>Retrieves a secure download URL for settlement files.
     * This method provides type safety by using the SettlementFileType enum.
     *
     * @param fileType File type enum (required)
     * @param fileDate File date in YYYYMMDD format (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @see SettlementFileType
     */
    public ApiResponse<String> getSettlementFileUrl(SettlementFileType fileType, String fileDate) throws ApiException {
        return getSettlementFileUrl(fileType.getCode(), fileDate);
    }

    /**
     * Build call for getSettlementFileUrl
     */
    private Call getSettlementFileUrlCall(String fileType, String fileDate) throws ApiException {
        if (fileType == null) {
            throw new ApiException("Missing the required parameter 'fileType' when calling getSettlementFileUrl");
        }
        if (fileDate == null) {
            throw new ApiException("Missing the required parameter 'fileDate' when calling getSettlementFileUrl");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("fileType", fileType));
        queryParams.addAll(apiClient.parameterToPair("fileDate", fileDate));

        return apiClient.buildCall(
            "/open-api/enterprise/v1/settlement-file-url",
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
