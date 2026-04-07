/*
 * dicard Java Connector
 * Redirect Management REST API client
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.redirect.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.redirect.model.GuidanceRequest;

/**
 * dicard Redirect Management REST API client.
 *
 * <p>This class provides a high-level interface for generating redirect/guidance
 * page URLs for H5 card management pages, including:
 * <ul>
 *   <li>KYC guidance</li>
 *   <li>Card information display</li>
 *   <li>Physical card application</li>
 *   <li>Physical card activation</li>
 *   <li>PIN management</li>
 *   <li>Travel rule updates</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 *
 * RedirectRestApi redirectApi = new RedirectRestApi(config);
 *
 * GuidanceRequest req = new GuidanceRequest();
 * req.setAction("CARD_INFO");
 * req.setExternalUserId("user-123");
 * req.setSuccessRedirectUrl("https://example.com/success");
 * req.setErrorRedirectUrl("https://example.com/error");
 *
 * ApiResponse<String> resp = redirectApi.getGuidanceUrl(req);
 * String guidanceUrl = resp.getData();
 * }</pre>
 *
 * @since 1.0.0
 * @see RedirectApi
 * @see ClientConfiguration
 */
public class RedirectRestApi {

    private final RedirectApi redirectApi;

    /**
     * Constructs a new RedirectRestApi with the specified configuration.
     *
     * @param configuration the client configuration
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public RedirectRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.redirectApi = new RedirectApi(apiClient);
    }

    /**
     * Constructs a new RedirectRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public RedirectRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }

        this.redirectApi = new RedirectApi(apiClient);
    }

    /**
     * Generates a guidance page URL for H5 card management.
     *
     * <p>The generated URL directs users to appropriate card management pages
     * based on the specified action type.
     *
     * <p><b>API Endpoint:</b> {@code POST /redirect/v1/guidance-link}
     *
     * @param request the guidance request parameters (required)
     * @return ApiResponse containing the guidance page URL
     * @throws ApiException if the API call fails
     * @see GuidanceRequest
     */
    public ApiResponse<String> getGuidanceUrl(GuidanceRequest request) throws ApiException {
        if (request == null) {
            throw new IllegalArgumentException("Guidance request cannot be null");
        }

        return redirectApi.getGuidanceUrl(request);
    }

    /**
     * Gets the underlying RedirectApi instance for advanced use cases.
     *
     * @return the RedirectApi instance
     */
    public RedirectApi getRedirectApi() {
        return redirectApi;
    }
}
