package com.dicard.connector.examples.simulation;

import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.simulation.api.SimulationRestApi;
import com.dicard.connector.client.simulation.model.*;

import java.math.BigDecimal;

/**
 * Simulation API examples (non-production only).
 */
public class SimulationExample {
    private volatile SimulationRestApi api;

    public SimulationRestApi getApi() {
        if (api == null) {
            synchronized (this) {
                if (api == null) {
                    ClientConfiguration config = new ClientConfiguration();
                    config.setApiKey("your-api-key");
                    config.setSecretKey("your-secret-key");
                    config.setBaseUrl("https://api.uatdcd.com");
                    api = new SimulationRestApi(config);
                }
            }
        }
        return api;
    }

    public void generateKycTokenExample() throws ApiException {
        SimulationKycTokenRequest request = new SimulationKycTokenRequest()
                .setExternalUserId("user_123456");

        ApiResponse<SimulationKycTokenResponse> response = getApi().generateKycToken(request);
        System.out.println("KYC Token: " + response.getData().getToken());
    }

    public void simulateDepositExample() throws ApiException {
        SimulationDepositRequest request = new SimulationDepositRequest()
                .setChain("Ethereum")
                .setCurrency("USDT")
                .setAmount(new BigDecimal("100"))
                .setAddress("0x1234567890abcdef1234567890abcdef12345678");

        getApi().deposit(request);
        System.out.println("Deposit simulation submitted");
    }

    public void simulateAuthExample() throws ApiException {
        SimulationAuthRequest request = new SimulationAuthRequest()
                .setExternalUserId("user_123456")
                .setCardMantissa("1234")
                .setAuthType("EXPEND")
                .setAmount(new BigDecimal("25.50"))
                .setCurrency("USD");

        ApiResponse<SimulationAuthResponse> response = getApi().fundAuth(request);
        System.out.println("Approved: " + response.getData().getApproved());
    }
}
