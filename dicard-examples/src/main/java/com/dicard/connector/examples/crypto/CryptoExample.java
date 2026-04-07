package com.dicard.connector.examples.crypto;

import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.crypto.api.CryptoRestApi;
import com.dicard.connector.client.crypto.model.DepositAddressResponse;
import com.dicard.connector.client.crypto.model.WithdrawRequest;
import com.dicard.connector.client.crypto.model.WithdrawResponse;

import java.math.BigDecimal;

public class CryptoExample {
    private volatile CryptoRestApi api;

    public CryptoRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new CryptoRestApi(config);
                }
            }
        }
        return api;
    }

    public void getDepositAddressExample() throws ApiException {
        ApiResponse<DepositAddressResponse> response = getApi().getDepositAddress("user_123456", "ETH", "USDT");
        DepositAddressResponse addr = response.getData();
        System.out.println("Address: " + addr.getAddress());
        System.out.println("Network: " + addr.getNetwork());
    }

    public void withdrawExample() throws ApiException {
        WithdrawRequest request = new WithdrawRequest()
                .setExternalUserId("user_123456")
                .setCoin("USDT")
                .setNetwork("ETH")
                .setAddress("0x1234567890abcdef1234567890abcdef12345678")
                .setAmount(new BigDecimal("50"))
                .setFee(new BigDecimal("1"))
                .setSmsCode("123456");

        ApiResponse<WithdrawResponse> response = getApi().withdrawApply(request);
        System.out.println("Withdraw status: " + response.getData().getStatus());
    }
}
