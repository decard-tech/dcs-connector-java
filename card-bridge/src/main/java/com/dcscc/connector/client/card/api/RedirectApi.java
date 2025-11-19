/*
 * dcs Java Connector
 * Redirect API implementation
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;

import com.dcscc.connector.client.card.model.GuidanceRequest;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.Pair;
import com.dcscc.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Redirect API implementation for dcs REST API.
 * 
 * <p>This class provides low-level access to dcs redirect endpoints.
 * It handles HTTP request construction, parameter validation, and response parsing
 * for redirect-related operations.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class RedirectApi {

    private final ApiClient apiClient;

    /**
     * Constructs a new RedirectApi with the specified API client.
     *
     * @param apiClient the configured API client
     */
    public RedirectApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generate guidance page URL.
     * 
     * <p>Generates a URL for redirecting users to appropriate card management
     * guidance pages based on the operation type and user context.
     *
     * @param request Guidance request parameters (required)
     * @return ApiResponse&lt;String&gt; containing the guidance URL
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> getGuidanceUrl(GuidanceRequest request) throws ApiException {
        Call call = getGuidanceUrlCall(request);
        return apiClient.execute(call, String.class);
    }

    /**
     * Build call for getGuidanceUrl operation.
     *
     * @param request Guidance request parameters (required)
     * @return Call to execute
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public Call getGuidanceUrlCall(GuidanceRequest request) throws ApiException {
        // Verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getGuidanceUrl");
        }

        // Validate the request
        request.validate();

        String localVarPath = "/open-api/card-redirect/v1/guidance-link";

        List<Pair> localVarQueryParams = new ArrayList<>();

        // No query parameters for this endpoint

        // No header parameters

        // No form parameters

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        return apiClient.buildCall(
            localVarPath, 
            "POST", 
            localVarQueryParams, 
            request, 
            new String[]{}
        );
    }
}
