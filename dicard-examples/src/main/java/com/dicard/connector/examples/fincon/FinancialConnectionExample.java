package com.dicard.connector.examples.fincon;

import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.fincon.api.FinancialConnectionRestApi;
import com.dicard.connector.client.fincon.model.*;

import java.math.BigDecimal;

public class FinancialConnectionExample {
    private volatile FinancialConnectionRestApi api;

    public FinancialConnectionRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new FinancialConnectionRestApi(config);
                }
            }
        }
        return api;
    }

    public void createUserExample() throws ApiException {
        CreateUserRequest request = new CreateUserRequest()
                .setUserRef("user_ref_" + System.currentTimeMillis())
                .setMobilePhone("1234567890")
                .setMobileAreaCode("US")
                .setEmail("user@example.com");

        ApiResponse<FCUserResponse> response = getApi().createUser(request);
        FCUserResponse user = response.getData();
        System.out.println("User Ref: " + user.getUserRef());
        System.out.println("External User ID: " + user.getExternalUserId());
    }

    public void paymentExample() throws ApiException {
        FCPaymentRequest request = new FCPaymentRequest()
                .setExternalTranId("pay_" + System.currentTimeMillis())
                .setExternalUserId("user_123456")
                .setAmount(new BigDecimal("50.00"))
                .setCurrency("USD");

        ApiResponse<FCPaymentResponse> response = getApi().payment(request);
        System.out.println("Payment status: " + response.getData().getPaymentStatus());
    }
}
