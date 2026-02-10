package com.dicard.connector.client.card.api;

import com.dicard.connector.client.common.ApiClient;
import okhttp3.Call;

import java.io.IOException;

/**
 * Example high-level API for dicard card operations.
 *
 * <p>This is a skeleton similar to card-bridge's CardRestApi. You can expand it
 * with real request/response models and endpoints.
 */
public class CardRestApi {

    private final ApiClient apiClient;

    public CardRestApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Example method: query a card by its ID.
     *
     * <p>Currently this just calls a placeholder path and returns raw JSON string.
     * Replace "/open-api/card/v1/detail" with the real dicard endpoint.
     */
    public String getCardDetail(String cardId) throws IOException {
        String path = "/open-api/card/v1/detail?cardId=" + cardId;
        Call call = apiClient.buildGetCall(path);
        return apiClient.execute(call, String.class);
    }
}

