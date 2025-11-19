/*
 * dcs Java Connector
 * 3DS API implementation
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.api;

import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeRequest;
import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeResponse;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;

/**
 * 3DS API implementation for dcs REST API.
 * 
 * <p>This class provides low-level access to dcs 3DS authentication endpoints.
 * It handles HTTP request construction, parameter validation, and response parsing
 * for all 3DS-related operations.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ThreeDSApi {

    private final ApiClient apiClient;

    /**
     * Constructs a new ThreeDSApi with the specified API client.
     *
     * @param apiClient the configured API client
     */
    public ThreeDSApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 3DS challenge authentication.
     * 
     * <p>Processes the result of a 3DS challenge authentication.
     *
     * @param request 3DS challenge request (required)
     * @return ApiResponse&lt;ThreeDSChallengeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ThreeDSChallengeResponse> authenticate(ThreeDSChallengeRequest request) throws ApiException {
        Call call = authenticateCall(request);
        return apiClient.execute(call, ThreeDSChallengeResponse.class);
    }

    /**
     * Build call for authenticate
     */
    private Call authenticateCall(ThreeDSChallengeRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling authenticate");
        }

        return apiClient.buildCall(
            "/open-api/3ds-challenge/v1/authenticate",
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
