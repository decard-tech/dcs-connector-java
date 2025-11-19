/*
 * CardBridge Java Connector
 * Card Management API Examples
 *
 * The version of the CardBridge API: 1.0.0
 *
 * NOTE: This class provides examples for Card Management API usage.
 * Do not edit the class manually.
 */

package com.dcscc.connector.examples.card;

import com.dcscc.connector.client.card.api.CardRestApi;
import com.dcscc.connector.client.card.model.ShippingInfoResponse;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * API examples for Card Management
 */
public class GetShippingInfoExample {
    private volatile CardRestApi api;

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
     * Get card shipping information
     *
     * <p>Retrieves shipping details and tracking information for a physical card.
     * Weight: 1
     *
     * @throws ApiException if the Api call fails
     */
    public void getShippingInfoExample() throws ApiException {
        String cardId = "card_123456789";
        ApiResponse<ShippingInfoResponse> response = getApi().getShippingInfo(cardId);
        System.out.println(response.getData());
    }
}
