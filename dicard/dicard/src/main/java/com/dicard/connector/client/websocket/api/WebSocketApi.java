package com.dicard.connector.client.websocket.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Low-level WebSocket API implementation.
 *
 * @since 1.0.0
 */
public class WebSocketApi {

    private final ApiClient apiClient;

    public WebSocketApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get WebSocket listen channel.
     *
     * @return ApiResponse containing the listen channel ID
     * @throws ApiException if the API call fails
     */
    public ApiResponse<String> getChannel() throws ApiException {
        Call call = apiClient.buildCall("/websocket/v1/get-channel", "GET", new ArrayList<>(), null, new String[]{});
        return apiClient.execute(call, String.class);
    }

    /**
     * Search WebSocket messages by version.
     *
     * @param version message version (required)
     * @return ApiResponse containing the message data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<String> search(Long version) throws ApiException {
        if (version == null) throw new ApiException("Missing 'version' when calling search");
        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("version", version));
        Call call = apiClient.buildCall("/websocket/v1/search", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, String.class);
    }

    public ApiClient getApiClient() { return apiClient; }
}
