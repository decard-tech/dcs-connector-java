package com.dicard.connector.examples.asset;

import com.dicard.connector.client.asset.api.AssetRestApi;
import com.dicard.connector.client.asset.model.TransferRequest;
import com.dicard.connector.client.asset.model.TransferResponse;
import com.dicard.connector.client.asset.model.WalletBalanceResponse;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

import java.math.BigDecimal;
import java.util.List;

public class AssetTransferExample {
    private volatile AssetRestApi api;

    public AssetRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.thedecard.com");
                    api = new AssetRestApi(config);
                }
            }
        }
        return api;
    }

    public void creditExample() throws ApiException {
        TransferRequest request = new TransferRequest()
                .setExternalTranId("txn_credit_" + System.currentTimeMillis())
                .setAsset("USDT")
                .setAmount(new BigDecimal("100.00"))
                .setExternalUserId("user_123456")
                .setRemark("Top up");

        ApiResponse<TransferResponse> response = getApi().credit(request);
        System.out.println("Transfer status: " + response.getData().getStatus());
    }

    public void getBalanceExample() throws ApiException {
        ApiResponse<List<WalletBalanceResponse>> response = getApi().getBalance("user_123456");
        for (WalletBalanceResponse balance : response.getData()) {
            System.out.println(balance.getAsset() + ": " + balance.getTotal());
        }
    }
}
