/*
 * dcs Java Connector
 * Card Management API Examples
 *
 * The version of the dcs API: 1.0.0
 *
 * NOTE: This class provides examples for Card Management API usage.
 */

package com.dcscc.connector.examples.card;

import com.dcscc.connector.client.card.api.CardRestApi;
import com.dcscc.connector.client.card.model.*;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * API examples for Card Guidance URL Generation
 */
public class GetGuidanceUrlExample {
    private volatile CardRestApi api;

    /**
     * Get API instance with configuration
     */
    public CardRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration clientConfiguration = new ClientConfiguration();
                    clientConfiguration.setApiKey("your-api-key");
                    clientConfiguration.setSecretKey("your-secret-key");
                    clientConfiguration.setBaseUrl("https://api.thedecard.com");
                    api = new CardRestApi(clientConfiguration);
                }
            }

        }
        return api;
    }

    /**
     * Generate guidance URL for card information query
     *
     * @throws ApiException if the Api call fails
     */
    public void getCardInfoGuidanceUrlExample() throws ApiException {
        System.out.println("=== Card Information Query Guidance URL Example ===");

        GuidanceRequest request = new GuidanceRequest()
                .setCardId("4595974387183623938")
                .setCustomerId("4595849907119562497")
                .setType(GuidanceType.CARD_INFO_QUERY)
                .setOtpStatus("1") // 1: Channel has not verified, DCS needs to verify
                .setLanguage(Language.ENGLISH)
                .setTheme("default")
                .setMode("web")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
                .setSuccessfulRedirectUrl("https://example.com/success");

        ApiResponse<String> response = getApi().getGuidanceUrl(request);
        System.out.println("API Response received. Status code: " + response.getStatusCode());

        String guidanceUrl = response.getData();
        if (guidanceUrl != null) {
            System.out.println("Guidance URL: " + guidanceUrl);
        } else {
            System.out.println("Guidance URL is null!");
        }

        System.out.println("=== Example completed ===\n");
    }

}
