/*
 * dicard Java Connector
 * Redirect API implementation
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.redirect.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.redirect.model.GuidanceRequest;
import okhttp3.Call;

import java.util.ArrayList;

/**
 * Low-level Redirect API implementation for dicard REST API.
 *
 * @since 1.0.0
 */
public class RedirectApi {

    private final ApiClient apiClient;

    public RedirectApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generate a guidance page URL.
     *
     * @param request guidance request (required)
     * @return ApiResponse containing the guidance URL
     * @throws ApiException if the API call fails
     */
    public ApiResponse<String> getGuidanceUrl(GuidanceRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getGuidanceUrl");
        }

        Call call = apiClient.buildCall(
                "/redirect/v1/guidance-link", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, String.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
