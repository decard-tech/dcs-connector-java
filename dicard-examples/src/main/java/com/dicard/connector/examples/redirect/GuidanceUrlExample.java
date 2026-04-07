package com.dicard.connector.examples.redirect;

import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.redirect.api.RedirectRestApi;
import com.dicard.connector.client.redirect.model.GuidanceRequest;

public class GuidanceUrlExample {
    private volatile RedirectRestApi api;

    public RedirectRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new RedirectRestApi(config);
                }
            }
        }
        return api;
    }

    public void getKycGuidanceUrlExample() throws ApiException {
        GuidanceRequest request = new GuidanceRequest()
                .setAction("KYC_GUIDE")
                .setExternalUserId("user_123456")
                .setSuccessRedirectUrl("https://example.com/success")
                .setErrorRedirectUrl("https://example.com/error")
                .setLanguage("en")
                .setTheme("blue")
                .setMode("light");

        ApiResponse<String> response = getApi().getGuidanceUrl(request);
        System.out.println("Guidance URL: " + response.getData());
    }

    public void getCardInfoGuidanceUrlExample() throws ApiException {
        GuidanceRequest request = new GuidanceRequest()
                .setAction("CARD_INFO")
                .setExternalUserId("user_123456")
                .setCardMantissa("1234")
                .setSuccessRedirectUrl("https://example.com/success")
                .setErrorRedirectUrl("https://example.com/error");

        ApiResponse<String> response = getApi().getGuidanceUrl(request);
        System.out.println("Card Info URL: " + response.getData());
    }
}
