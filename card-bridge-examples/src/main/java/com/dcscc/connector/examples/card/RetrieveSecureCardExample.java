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
import com.dcscc.connector.client.card.model.RetrieveSecureCardRequest;
import com.dcscc.connector.client.card.model.SecureCardResponse;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.common.utils.AESUtil;

/**
 * API examples for Card Management
 */
public class RetrieveSecureCardExample {
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
     * Retrieve secure card information
     *
     * <p>Returns sensitive card data such as PAN, expiry, and CVV in encrypted form.
     * This operation is logged for audit purposes. Weight: 20
     *
     * @throws ApiException if the Api call fails
     */
    public void retrieveSecureCardExample() throws ApiException {
        String sk = "xx/oC/s=";
        RetrieveSecureCardRequest request = new RetrieveSecureCardRequest();
        request.setCardId("1154377797108502528");

        ApiResponse<SecureCardResponse> response = getApi().retrieveSecureCard(request);
        SecureCardResponse data = response.getData();
        String iv = data.getIv();

        String pan = AESUtil.decryptGCM(data.getPan(), sk, iv);
        String expireDate = AESUtil.decryptGCM(data.getExpireDate(), sk, iv);
        String cvv2 = AESUtil.decryptGCM(data.getCvv2(), sk, iv);
        System.out.println("PAN: " + pan);
        System.out.println("Expire Date: " + expireDate);
        System.out.println("CVV2: " + cvv2);
    }
}
