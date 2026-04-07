package com.dicard.connector.examples.account;

import com.dicard.connector.client.account.api.AccountRestApi;
import com.dicard.connector.client.account.model.KycStatusResponse;
import com.dicard.connector.client.account.model.RegisterRequest;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

public class RegisterExample {
    private volatile AccountRestApi api;

    public AccountRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new AccountRestApi(config);
                }
            }
        }
        return api;
    }

    public void registerExample() throws ApiException {
        RegisterRequest request = new RegisterRequest()
                .setMobileCode("US")
                .setMobile("1234567890")
                .setSmsCode("123456");

        ApiResponse<String> response = getApi().register(request);
        String externalUserId = response.getData();
        System.out.println("Registered user: " + externalUserId);
    }

    public void getKycStatusExample() throws ApiException {
        ApiResponse<KycStatusResponse> response = getApi().getKycStatus("user_123456");
        KycStatusResponse kyc = response.getData();
        System.out.println("KYC Status: " + kyc.getStatus());
        System.out.println("Description: " + kyc.getStatusDescription());
    }
}
