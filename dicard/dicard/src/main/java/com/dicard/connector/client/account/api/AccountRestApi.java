/*
 * dicard Java Connector
 * Account Management REST API client
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.account.api;

import com.dicard.connector.client.account.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

import java.util.List;

/**
 * dicard Account Management REST API client.
 *
 * <p>This class provides a high-level interface for user account operations:
 * <ul>
 *   <li>User registration</li>
 *   <li>User status and KYC status queries</li>
 *   <li>Invite relationship binding</li>
 *   <li>Travel rule management</li>
 *   <li>File upload and EDD document submission</li>
 *   <li>User extra info updates</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 *
 * AccountRestApi accountApi = new AccountRestApi(config);
 *
 * // Register a user
 * RegisterRequest req = new RegisterRequest();
 * req.setMobileCode("US");
 * req.setMobile("1234567890");
 * req.setSmsCode("123456");
 * ApiResponse<String> resp = accountApi.register(req);
 * String externalUserId = resp.getData();
 *
 * // Check KYC status
 * ApiResponse<KycStatusResponse> kyc = accountApi.getKycStatus(externalUserId);
 * }</pre>
 *
 * @since 1.0.0
 * @see AccountApi
 * @see ClientConfiguration
 */
public class AccountRestApi {

    private final AccountApi accountApi;

    /**
     * Constructs a new AccountRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public AccountRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.accountApi = new AccountApi(apiClient);
    }

    /**
     * Constructs a new AccountRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public AccountRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }

        this.accountApi = new AccountApi(apiClient);
    }

    /**
     * Registers a new user.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/register}
     *
     * @param request the registration request (required)
     * @return ApiResponse containing the externalUserId
     * @throws ApiException if the API call fails
     * @see RegisterRequest
     */
    public ApiResponse<String> register(RegisterRequest request) throws ApiException {
        return accountApi.register(request);
    }

    /**
     * Gets user status information.
     *
     * <p><b>API Endpoint:</b> {@code GET /account/v1/user-status}
     *
     * @param externalUserId the dicard user ID (required)
     * @return ApiResponse containing the user status
     * @throws ApiException if the API call fails
     * @see UserStatusResponse
     */
    public ApiResponse<UserStatusResponse> getUserStatus(String externalUserId) throws ApiException {
        return accountApi.getUserStatus(externalUserId);
    }

    /**
     * Gets KYC status for a user (v2).
     *
     * <p><b>API Endpoint:</b> {@code GET /account/v2/kyc-status}
     *
     * @param externalUserId the dicard user ID (required)
     * @return ApiResponse containing the KYC status
     * @throws ApiException if the API call fails
     * @see KycStatusResponse
     */
    public ApiResponse<KycStatusResponse> getKycStatus(String externalUserId) throws ApiException {
        return accountApi.getKycStatus(externalUserId);
    }

    /**
     * Binds an invite relationship between two users.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/bind-invite-relationship}
     *
     * @param request the invite binding request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     * @see BindInviteRequest
     */
    public ApiResponse<Void> bindInviteRelationship(BindInviteRequest request) throws ApiException {
        return accountApi.bindInviteRelationship(request);
    }

    /**
     * Queries travel rule information for a user.
     *
     * <p><b>API Endpoint:</b> {@code GET /account/v1/query-travel-rule}
     *
     * @param externalUserId the dicard user ID (required)
     * @return ApiResponse containing travel rule information
     * @throws ApiException if the API call fails
     * @see TravelRuleResponse
     */
    public ApiResponse<TravelRuleResponse> queryTravelRule(String externalUserId) throws ApiException {
        return accountApi.queryTravelRule(externalUserId);
    }

    /**
     * Updates travel rule information for a user.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/update-travel-rule}
     *
     * @param request the travel rule update request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     * @see TravelRuleRequest
     */
    public ApiResponse<Void> updateTravelRule(TravelRuleRequest request) throws ApiException {
        return accountApi.updateTravelRule(request);
    }

    /**
     * Generates pre-signed URLs for file upload.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/generate-file-upload-prepare}
     *
     * @param request the upload prepare request (required)
     * @return ApiResponse containing the pre-signed upload URLs
     * @throws ApiException if the API call fails
     * @see UploadPrepareRequest
     * @see UploadPrepareResponse.UploadFileResponse
     */
    public ApiResponse<List<UploadPrepareResponse.UploadFileResponse>> generateFileUploadPrepare(
            UploadPrepareRequest request) throws ApiException {
        return accountApi.generateFileUploadPrepare(request);
    }

    /**
     * Uploads EDD file for KYC verification.
     *
     * <p>The request body should contain EDD source of wealth and source of funds
     * information along with file references.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/upload-edd-file}
     *
     * @param request the EDD file upload request body (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Void> uploadEddFile(Object request) throws ApiException {
        return accountApi.uploadEddFile(request);
    }

    /**
     * Updates user extra information such as embossing name.
     *
     * <p><b>API Endpoint:</b> {@code POST /account/v1/update-extra-info}
     *
     * @param request the extra info update request (required)
     * @return ApiResponse with void result
     * @throws ApiException if the API call fails
     * @see UpdateExtraInfoRequest
     */
    public ApiResponse<Void> updateExtraInfo(UpdateExtraInfoRequest request) throws ApiException {
        return accountApi.updateExtraInfo(request);
    }

    /**
     * Gets the underlying AccountApi instance for advanced use cases.
     *
     * @return the AccountApi instance
     */
    public AccountApi getAccountApi() {
        return accountApi;
    }
}
