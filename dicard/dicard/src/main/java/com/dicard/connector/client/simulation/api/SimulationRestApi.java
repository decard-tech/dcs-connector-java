package com.dicard.connector.client.simulation.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.simulation.model.*;

/**
 * dicard Simulation REST API client (non-production environments only).
 *
 * <p>Provides simulation/testing operations:
 * <ul>
 *   <li>Generate KYC test token</li>
 *   <li>Simulate crypto deposit</li>
 *   <li>Simulate card authorization (spend, refund, reversal)</li>
 * </ul>
 *
 * <p><b>Warning:</b> These endpoints are only available in non-production environments.
 *
 * @since 1.0.0
 */
public class SimulationRestApi {

    private final SimulationApi simulationApi;

    public SimulationRestApi(ClientConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");
        configuration.validate();
        this.simulationApi = new SimulationApi(new ApiClient(configuration));
    }

    public SimulationRestApi(ApiClient apiClient) {
        if (apiClient == null) throw new IllegalArgumentException("ApiClient cannot be null");
        this.simulationApi = new SimulationApi(apiClient);
    }

    /** {@code POST /simulation/v1/generate-kyc-token} */
    public ApiResponse<SimulationKycTokenResponse> generateKycToken(SimulationKycTokenRequest request) throws ApiException {
        return simulationApi.generateKycToken(request);
    }

    /** {@code POST /simulation/v1/deposit} */
    public ApiResponse<Void> deposit(SimulationDepositRequest request) throws ApiException {
        return simulationApi.deposit(request);
    }

    /** {@code POST /simulation/v1/fund-auth} */
    public ApiResponse<SimulationAuthResponse> fundAuth(SimulationAuthRequest request) throws ApiException {
        return simulationApi.fundAuth(request);
    }

    public SimulationApi getSimulationApi() { return simulationApi; }
}
