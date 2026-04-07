package com.dicard.connector.examples.card;

import com.dicard.connector.client.card.api.CardRestApi;
import com.dicard.connector.client.card.model.BlockCardRequest;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

public class BlockCardExample {
    private volatile CardRestApi api;

    public CardRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new CardRestApi(config);
                }
            }
        }
        return api;
    }

    public void blockCardExample() throws ApiException {
        BlockCardRequest request = new BlockCardRequest()
                .setExternalUserId("user_123456")
                .setBlock(true)
                .setCardMantissa("1234");

        ApiResponse<Boolean> response = getApi().blockCard(request);
        System.out.println("Block result: " + response.getData());
    }

    public void unblockCardExample() throws ApiException {
        BlockCardRequest request = new BlockCardRequest()
                .setExternalUserId("user_123456")
                .setBlock(false)
                .setCardMantissa("1234")
                .setSmsCode("123456");

        ApiResponse<Boolean> response = getApi().blockCard(request);
        System.out.println("Unblock result: " + response.getData());
    }
}
