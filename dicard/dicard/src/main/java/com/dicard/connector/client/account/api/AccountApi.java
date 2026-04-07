/*
 * dicard Java Connector
 * Account API implementation
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.account.api;

import com.dicard.connector.client.account.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Low-level Account API implementation for dicard REST API.
 *
 * <p>This class is typically used internally by {@link AccountRestApi}.
 *
 * @since 1.0.0
 */
public class AccountApi {

    private final ApiClient apiClient;

    public AccountApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Register a new user.
     *
     * @param request registration request (required)
     * @return ApiResponse containing the externalUserId
     * @throws ApiException if the API call fails
     */
    public ApiResponse<String> register(RegisterRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling register");
        }

        Call call = apiClient.buildCall("/account/v1/register", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, String.class);
    }

    /**
     * Get user status.
     *
     * @param externalUserId user ID (required)
     * @return ApiResponse containing the user status
     * @throws ApiException if the API call fails
     */
    public ApiResponse<UserStatusResponse> getUserStatus(String externalUserId) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getUserStatus");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));

        Call call = apiClient.buildCall("/account/v1/user-status", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, UserStatusResponse.class);
    }

    /**
     * Get KYC status (v2).
     *
     * @param externalUserId user ID (required)
     * @return ApiResponse containing the KYC status
     * @throws ApiException if the API call fails
     */
    public ApiResponse<KycStatusResponse> getKycStatus(String externalUserId) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId' when calling getKycStatus");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));

        Call call = apiClient.buildCall("/account/v2/kyc-status", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, KycStatusResponse.class);
    }

    /**
     * Bind invite relationship.
     *
     * @param request bind invite request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Void> bindInviteRelationship(BindInviteRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException(
                    "Missing the required parameter 'request' when calling bindInviteRelationship");
        }

        Call call = apiClient.buildCall(
                "/account/v1/bind-invite-relationship", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Void.class);
    }

    /**
     * Query travel rule.
     *
     * @param externalUserId user ID (required)
     * @return ApiResponse containing travel rule info
     * @throws ApiException if the API call fails
     */
    public ApiResponse<TravelRuleResponse> queryTravelRule(String externalUserId) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException(
                    "Missing the required parameter 'externalUserId' when calling queryTravelRule");
        }

        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));

        Call call = apiClient.buildCall(
                "/account/v1/query-travel-rule", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, TravelRuleResponse.class);
    }

    /**
     * Update travel rule.
     *
     * @param request travel rule request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Void> updateTravelRule(TravelRuleRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling updateTravelRule");
        }

        Call call = apiClient.buildCall(
                "/account/v1/update-travel-rule", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Void.class);
    }

    /**
     * Generate pre-signed file upload URLs.
     *
     * @param request upload prepare request (required)
     * @return ApiResponse containing the pre-signed URLs
     * @throws ApiException if the API call fails
     */
    public ApiResponse<List<UploadPrepareResponse.UploadFileResponse>> generateFileUploadPrepare(
            UploadPrepareRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException(
                    "Missing the required parameter 'request' when calling generateFileUploadPrepare");
        }

        Call call = apiClient.buildCall(
                "/account/v1/generate-file-upload-prepare", "POST", new ArrayList<>(), request, new String[]{});
        ApiResponse<UploadPrepareResponse.UploadFileResponse[]> arrayResponse =
                apiClient.execute(call, UploadPrepareResponse.UploadFileResponse[].class);
        List<UploadPrepareResponse.UploadFileResponse> list = Arrays.asList(arrayResponse.getData());
        return new ApiResponse<>(arrayResponse.getStatusCode(), arrayResponse.getHeaders(), list);
    }

    /**
     * Upload EDD file.
     *
     * @param request EDD file upload request body (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Void> uploadEddFile(Object request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling uploadEddFile");
        }

        Call call = apiClient.buildCall(
                "/account/v1/upload-edd-file", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Void.class);
    }

    /**
     * Update user extra information.
     *
     * @param request extra info request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Void> updateExtraInfo(UpdateExtraInfoRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling updateExtraInfo");
        }

        Call call = apiClient.buildCall(
                "/account/v1/update-extra-info", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Void.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
