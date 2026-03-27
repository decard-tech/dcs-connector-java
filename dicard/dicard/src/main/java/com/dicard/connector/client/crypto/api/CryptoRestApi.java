/*
 * dicard Java Connector
 * Crypto Management REST API client
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.crypto.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.crypto.model.*;

/**
 * dicard Crypto Management REST API client.
 *
 * <p>This class provides a high-level interface for crypto/wallet operations:
 * <ul>
 *   <li>Deposit address retrieval</li>
 *   <li>Withdrawal applications</li>
 *   <li>Network and coin configuration queries</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 *
 * CryptoRestApi cryptoApi = new CryptoRestApi(config);
 *
 * // Get deposit address
 * ApiResponse<DepositAddressResponse> addr =
 *     cryptoApi.getDepositAddress("user-123", "ETH", "USDT");
 *
 * // Apply for withdrawal
 * WithdrawRequest req = new WithdrawRequest();
 * req.setExternalUserId("user-123");
 * req.setCoin("USDT");
 * req.setNetwork("ETH");
 * req.setAddress("0x...");
 * req.setAmount(new BigDecimal("100"));
 * ApiResponse<WithdrawResponse> resp = cryptoApi.withdrawApply(req);
 * }</pre>
 *
 * @since 1.0.0
 * @see CryptoApi
 * @see ClientConfiguration
 */
public class CryptoRestApi {

    private final CryptoApi cryptoApi;

    /**
     * Constructs a new CryptoRestApi with the specified configuration.
     *
     * @param configuration the client configuration
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public CryptoRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.cryptoApi = new CryptoApi(apiClient);
    }

    /**
     * Constructs a new CryptoRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public CryptoRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }

        this.cryptoApi = new CryptoApi(apiClient);
    }

    /**
     * Gets a crypto deposit address for a user.
     *
     * <p><b>API Endpoint:</b> {@code GET /crypto/v1/deposit-address}
     *
     * @param externalUserId the dicard user ID (required)
     * @param network        the blockchain network, e.g. "ETH", "TRX" (required)
     * @param coin           the coin/token, e.g. "USDT" (required)
     * @return ApiResponse containing the deposit address
     * @throws ApiException if the API call fails
     * @see DepositAddressResponse
     */
    public ApiResponse<DepositAddressResponse> getDepositAddress(
            String externalUserId, String network, String coin) throws ApiException {
        return cryptoApi.getDepositAddress(externalUserId, network, coin);
    }

    /**
     * Applies for a crypto withdrawal.
     *
     * <p><b>API Endpoint:</b> {@code POST /crypto/v1/withdraw-apply}
     *
     * @param request the withdrawal request (required)
     * @return ApiResponse containing the withdrawal result
     * @throws ApiException if the API call fails
     * @see WithdrawRequest
     * @see WithdrawResponse
     */
    public ApiResponse<WithdrawResponse> withdrawApply(WithdrawRequest request) throws ApiException {
        return cryptoApi.withdrawApply(request);
    }

    /**
     * Gets supported network and coin configurations.
     *
     * <p><b>API Endpoint:</b> {@code GET /crypto/v1/network-coin}
     *
     * @param type the config type (optional)
     * @return ApiResponse containing the configuration data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getNetworkCoinConfig(String type) throws ApiException {
        return cryptoApi.getNetworkCoinConfig(type);
    }

    /**
     * Gets a crypto deposit address (V2) for a user.
     *
     * <p><b>API Endpoint:</b> {@code GET /crypto/v2/deposit-address}
     *
     * @param externalUserId the dicard user ID (required)
     * @param network        the blockchain network (required)
     * @param coin           the coin/token (required)
     * @return ApiResponse containing the V2 deposit address
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getDepositAddressV2(
            String externalUserId, String network, String coin) throws ApiException {
        return cryptoApi.getDepositAddressV2(externalUserId, network, coin);
    }

    /**
     * Gets the underlying CryptoApi instance for advanced use cases.
     *
     * @return the CryptoApi instance
     */
    public CryptoApi getCryptoApi() {
        return cryptoApi;
    }
}
