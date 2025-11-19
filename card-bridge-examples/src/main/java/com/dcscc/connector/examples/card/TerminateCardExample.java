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
import com.dcscc.connector.client.card.model.CardResponse;
import com.dcscc.connector.client.card.model.TerminateCardRequest;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/** API examples for Card Management */
public class TerminateCardExample {
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
     * Terminate card
     *
     * <p>Permanently disables a card, making it unusable for future transactions.
     * Weight: 10
     *
     * @throws ApiException if the Api call fails
     */
    public void terminateCardExample() throws ApiException {
        TerminateCardRequest request = new TerminateCardRequest();
        request.setCardId("card_123456789");
        request.setInvalidateReason("Lost card reported by customer");
        
        ApiResponse<CardResponse> response = getApi().terminateCard(request);
        System.out.println(response.getData());
    }
}
