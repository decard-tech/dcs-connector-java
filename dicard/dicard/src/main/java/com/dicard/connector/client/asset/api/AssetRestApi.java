/*
 * dicard Java Connector
 * Asset Management REST API client
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.asset.api;

import com.dicard.connector.client.asset.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

import java.util.List;

/**
 * dicard Asset Management REST API client.
 *
 * <p>This class provides a high-level interface for asset/wallet operations:
 * <ul>
 *   <li>Credit assets to user wallet</li>
 *   <li>Debit assets from user wallet</li>
 *   <li>Query transfer records</li>
 *   <li>Query wallet balance</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 *
 * AssetRestApi assetApi = new AssetRestApi(config);
 *
 * // Credit assets
 * TransferRequest req = new TransferRequest();
 * req.setExternalTranId("txn-001");
 * req.setAsset("USDT");
 * req.setAmount(new BigDecimal("100"));
 * req.setExternalUserId("user-123");
 * ApiResponse<TransferResponse> resp = assetApi.credit(req);
 *
 * // Query balance
 * ApiResponse<List<WalletBalanceResponse>> balance = assetApi.getBalance("user-123");
 * }</pre>
 *
 * @since 1.0.0
 * @see AssetApi
 * @see ClientConfiguration
 */
public class AssetRestApi {

    private final AssetApi assetApi;

    /**
     * Constructs a new AssetRestApi with the specified configuration.
     *
     * @param configuration the client configuration
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public AssetRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.assetApi = new AssetApi(apiClient);
    }

    /**
     * Constructs a new AssetRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public AssetRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }

        this.assetApi = new AssetApi(apiClient);
    }

    /**
     * Credits assets to a user's wallet.
     *
     * <p><b>API Endpoint:</b> {@code POST /user-asset/v1/credit}
     *
     * @param request the credit transfer request (required)
     * @return ApiResponse containing the transfer result
     * @throws ApiException if the API call fails
     * @see TransferRequest
     * @see TransferResponse
     */
    public ApiResponse<TransferResponse> credit(TransferRequest request) throws ApiException {
        return assetApi.credit(request);
    }

    /**
     * Debits assets from a user's wallet.
     *
     * <p><b>API Endpoint:</b> {@code POST /user-asset/v1/debit}
     *
     * @param request the debit transfer request (required)
     * @return ApiResponse containing the transfer result
     * @throws ApiException if the API call fails
     * @see TransferRequest
     * @see TransferResponse
     */
    public ApiResponse<TransferResponse> debit(TransferRequest request) throws ApiException {
        return assetApi.debit(request);
    }

    /**
     * Queries transfer records.
     *
     * <p><b>API Endpoint:</b> {@code GET /user-asset/v1/transfer-query}
     *
     * @param page            page number (optional)
     * @param rows            page size (optional)
     * @param externalTranIds comma-separated external transaction IDs (optional)
     * @return ApiResponse containing the transfer records
     * @throws ApiException if the API call fails
     * @see TransferResponse
     */
    public ApiResponse<List<TransferResponse>> queryTransfer(Integer page, Integer rows, String externalTranIds)
            throws ApiException {
        return assetApi.queryTransfer(page, rows, externalTranIds);
    }

    /**
     * Queries wallet balances for a user.
     *
     * <p><b>API Endpoint:</b> {@code GET /user-asset/v1/balance}
     *
     * @param externalUserId the dicard user ID (required)
     * @return ApiResponse containing the wallet balance list
     * @throws ApiException if the API call fails
     * @see WalletBalanceResponse
     */
    public ApiResponse<List<WalletBalanceResponse>> getBalance(String externalUserId) throws ApiException {
        return assetApi.getBalance(externalUserId);
    }

    /**
     * Queries crypto asset transactions.
     *
     * <p><b>API Endpoint:</b> {@code POST /user-asset/v1/transactions}
     *
     * @param request the crypto transactions query request body (required)
     * @return ApiResponse containing the transaction data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getCryptoTransactions(Object request) throws ApiException {
        return assetApi.getCryptoTransactions(request);
    }

    /**
     * Queries a specific crypto asset transaction detail.
     *
     * <p><b>API Endpoint:</b> {@code POST /user-asset/v1/transaction-detail}
     *
     * @param request the crypto transaction detail request body (required)
     * @return ApiResponse containing the transaction detail
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getCryptoTransactionDetail(Object request) throws ApiException {
        return assetApi.getCryptoTransactionDetail(request);
    }

    /**
     * Gets the underlying AssetApi instance for advanced use cases.
     *
     * @return the AssetApi instance
     */
    public AssetApi getAssetApi() {
        return assetApi;
    }
}
