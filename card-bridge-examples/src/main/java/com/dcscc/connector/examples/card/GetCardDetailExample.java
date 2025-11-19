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
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;

/**
 * API examples for Card Management
 */
public class GetCardDetailExample {
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
     * Get card details
     *
     * <p>Retrieves detailed information for a specific card including status,
     * balance, limits, and configuration. Weight: 1
     *
     * @throws ApiException if the Api call fails
     */
    public void getCardDetailExample() throws ApiException {
        String cardId = "4595974387183623938";
        System.out.println("Calling API for card ID: " + cardId);

        ApiResponse<CardResponse> response = getApi().getCardDetail(cardId);
        System.out.println("API Response received. Status code: " + response.getStatusCode());

        CardResponse card = response.getData();
        if (card != null) {
            System.out.println("=== Card Details ===");
            System.out.println("Card ID: " + card.getCardId());
            System.out.println("Enterprise ID: " + card.getEnterpriseId());
            System.out.println("Profile ID: " + card.getProfileId());
            System.out.println("Type: " + card.getType());
            System.out.println("Customer ID: " + card.getCustomerId());
            System.out.println("Status: " + card.getStatus());
            System.out.println("Status Reason: " + card.getStatusReason());
            System.out.println("PAN First 6: " + card.getPanFirst6());
            System.out.println("PAN Last 4: " + card.getPanLast4());
            System.out.println("Create Time: " + card.getCreateTime());
            System.out.println("Modify Time: " + card.getModifyTime());
            System.out.println("===================");
        } else {
            System.out.println("Card data is null!");
        }

        System.out.println("Full response object: " + response.getData());
    }
}
