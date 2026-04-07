package com.dicard.connector.examples.card;

import com.dicard.connector.client.card.api.CardRestApi;
import com.dicard.connector.client.card.model.ApplyVirtualCardRequest;
import com.dicard.connector.client.card.model.ApplyVirtualCardResponse;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

public class ApplyVirtualCardExample {
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

    public void applyVirtualCardExample() throws ApiException {
        ApplyVirtualCardRequest.KycInfo kycInfo = new ApplyVirtualCardRequest.KycInfo()
                .setSumsubShareToken("sumsub_token_abc123")
                .setCountry("US")
                .setCity("San Francisco")
                .setAddressLine1("123 Main St");

        ApplyVirtualCardRequest request = new ApplyVirtualCardRequest()
                .setExternalUserId("user_123456")
                .setCategoryId(1L)
                .setApplyRef("apply_ref_" + System.currentTimeMillis())
                .setKycInfo(kycInfo);

        ApiResponse<ApplyVirtualCardResponse> response = getApi().applyVirtualCard(request);
        ApplyVirtualCardResponse data = response.getData();
        System.out.println("Apply ID: " + data.getApplyId());
        System.out.println("Status: " + data.getStatus());
    }
}
