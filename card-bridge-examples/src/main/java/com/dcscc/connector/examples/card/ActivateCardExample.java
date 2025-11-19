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
import com.dcscc.connector.client.card.model.ActivateCardRequest;
import com.dcscc.connector.client.card.model.CardResponse;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * API examples for Card Management
 */
public class ActivateCardExample {
    private volatile CardRestApi api;

    public CardRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration clientConfiguration = new ClientConfiguration();
                    clientConfiguration.setApiKey(System.getenv("DCS_API_KEY"));
                    clientConfiguration.setSecretKey(System.getenv("DCS_SECRET_KEY"));
                    clientConfiguration.setBaseUrl(System.getenv("DCS_BASE_URL"));
                    api = new CardRestApi(clientConfiguration);
                }
            }
        }
        return api;
    }

    /**
     * Activate physical card
     *
     * <p>Activates a physical card for use in transactions.
     * Weight: 10
     *
     * @throws ApiException if the Api call fails
     */
    public void activatePhysicalCardExample() {
        try {
            ActivateCardRequest request = new ActivateCardRequest();
            request.setCardId("card_123456789");

            ApiResponse<CardResponse> response = getApi().activatePhysicalCard(request);
            System.out.println(response.getData());
        } catch (ApiException e) {
            System.err.println("API call failed: " + e.getMessage());
            throw e;
        }
    }
}
