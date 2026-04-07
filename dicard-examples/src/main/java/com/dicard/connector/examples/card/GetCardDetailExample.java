package com.dicard.connector.examples.card;

import com.dicard.connector.client.card.api.CardRestApi;
import com.dicard.connector.client.card.model.CardDetailResponse;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

import java.util.List;

public class GetCardDetailExample {
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

    public void getCardDetailExample() throws ApiException {
        String externalUserId = "user_123456";
        String cardMantissa = "1234";

        ApiResponse<List<CardDetailResponse>> response = getApi().getCardDetail(externalUserId, cardMantissa);
        List<CardDetailResponse> cards = response.getData();

        for (CardDetailResponse card : cards) {
            System.out.println("Card No: " + card.getCardNo());
            System.out.println("Status: " + card.getCardStatus());
            System.out.println("Balance: " + card.getCardBalance());
        }
    }
}
