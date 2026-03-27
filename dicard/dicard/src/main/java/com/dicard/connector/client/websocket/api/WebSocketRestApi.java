package com.dicard.connector.client.websocket.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

/**
 * dicard WebSocket REST API client.
 *
 * <p>Provides WebSocket channel management:
 * <ul>
 *   <li>Get listen channel for event subscription</li>
 *   <li>Search messages by version</li>
 * </ul>
 *
 * @since 1.0.0
 */
public class WebSocketRestApi {

    private final WebSocketApi webSocketApi;

    public WebSocketRestApi(ClientConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");
        configuration.validate();
        this.webSocketApi = new WebSocketApi(new ApiClient(configuration));
    }

    public WebSocketRestApi(ApiClient apiClient) {
        if (apiClient == null) throw new IllegalArgumentException("ApiClient cannot be null");
        this.webSocketApi = new WebSocketApi(apiClient);
    }

    /** {@code GET /websocket/v1/get-channel} */
    public ApiResponse<String> getChannel() throws ApiException {
        return webSocketApi.getChannel();
    }

    /** {@code GET /websocket/v1/search} */
    public ApiResponse<String> search(Long version) throws ApiException {
        return webSocketApi.search(version);
    }

    public WebSocketApi getWebSocketApi() { return webSocketApi; }
}
