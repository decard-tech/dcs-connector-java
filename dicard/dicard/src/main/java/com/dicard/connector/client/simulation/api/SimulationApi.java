package com.dicard.connector.client.simulation.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.simulation.model.*;
import okhttp3.Call;

import java.util.ArrayList;

/**
 * Low-level Simulation API implementation (non-production only).
 *
 * @since 1.0.0
 */
public class SimulationApi {

    private final ApiClient apiClient;

    public SimulationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiResponse<SimulationKycTokenResponse> generateKycToken(SimulationKycTokenRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling generateKycToken");
        Call call = apiClient.buildCall("/simulation/v1/generate-kyc-token", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, SimulationKycTokenResponse.class);
    }

    public ApiResponse<Void> deposit(SimulationDepositRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling deposit");
        Call call = apiClient.buildCall("/simulation/v1/deposit", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Void.class);
    }

    public ApiResponse<SimulationAuthResponse> fundAuth(SimulationAuthRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling fundAuth");
        Call call = apiClient.buildCall("/simulation/v1/fund-auth", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, SimulationAuthResponse.class);
    }

    public ApiClient getApiClient() { return apiClient; }
}
