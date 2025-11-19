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
import com.dcscc.connector.client.card.model.ResetPinRequest;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.common.utils.AESUtil;

/**
 * API examples for Card Management
 */
public class ResetPinExample {
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
     * Reset card PIN
     *
     * <p>Resets the PIN for a card using encrypted verification data.
     * This operation is logged for audit purposes. Weight: 10
     *
     * @throws ApiException if the Api call fails
     */
    public void resetPinExample() throws ApiException {
        String sk = "xxx/oC/s=";
        String iv = AESUtil.generateIV();
        ResetPinRequest request = new ResetPinRequest();
        request.setCardId("1154377797108502528");
        request.setEncryptedExpireDate(AESUtil.encryptGCM("3208", sk, iv));
        request.setEncryptedCvv2(AESUtil.encryptGCM("233", sk, iv));
        request.setEncryptedPanLast4(AESUtil.encryptGCM("1922", sk, iv));
        request.setEncryptedNewPin(AESUtil.encryptGCM("1234", sk, iv));
        request.setIv(iv);

        ApiResponse<Boolean> response = getApi().resetPin(request);
        System.out.println(response.getData());
    }
}
