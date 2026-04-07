/*
 * dicard Java Connector
 * Card Management REST API client
 *
 * The version of the dicard API: 1.0.0
 */

package com.dicard.connector.client.card.api;

import com.dicard.connector.client.card.model.*;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

import java.util.List;

/**
 * dicard Card Management REST API client.
 *
 * <p>This class provides a high-level interface for interacting with dicard's
 * card management APIs. It handles card lifecycle operations including:
 * <ul>
 *   <li>Card category listing</li>
 *   <li>Card detail retrieval</li>
 *   <li>Card blocking/unblocking</li>
 *   <li>Transaction history</li>
 *   <li>Virtual card application</li>
 *   <li>Apple Pay / Google Pay wallet binding</li>
 *   <li>Physical card shipping tracking</li>
 *   <li>Card apply record listing</li>
 * </ul>
 *
 * <p>All operations require proper authentication using API key and secret key.
 * The client automatically handles request signing and authentication headers.
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 * config.setBaseUrl("https://api.thedecard.com");
 *
 * CardRestApi cardApi = new CardRestApi(config);
 *
 * // List card categories
 * ApiResponse<List<CardListResponse>> categories = cardApi.listCardCategories();
 *
 * // Get card detail
 * ApiResponse<List<CardDetailResponse>> detail = cardApi.getCardDetail("user-123", null);
 *
 * // Block a card
 * BlockCardRequest blockReq = new BlockCardRequest();
 * blockReq.setExternalUserId("user-123");
 * blockReq.setBlock(true);
 * blockReq.setCardMantissa("1234");
 * ApiResponse<Boolean> blockResult = cardApi.blockCard(blockReq);
 * }</pre>
 *
 * @since 1.0.0
 * @see CardApi
 * @see ClientConfiguration
 */
public class CardRestApi {

    private final CardApi cardApi;

    /**
     * Constructs a new CardRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public CardRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.cardApi = new CardApi(apiClient);
    }

    /**
     * Constructs a new CardRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public CardRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }

        this.cardApi = new CardApi(apiClient);
    }

    /**
     * Lists available card categories.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/list}
     *
     * @return ApiResponse containing the list of card categories
     * @throws ApiException if the API call fails
     * @see CardListResponse
     */
    public ApiResponse<List<CardListResponse>> listCardCategories() throws ApiException {
        return cardApi.listCardCategories();
    }

    /**
     * Retrieves card detail for a user.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/detail}
     *
     * @param externalUserId the dicard user ID (required)
     * @param cardMantissa   last 4 digits of card number (optional, returns all cards if null)
     * @return ApiResponse containing the card detail list
     * @throws ApiException if the API call fails
     * @see CardDetailResponse
     */
    public ApiResponse<List<CardDetailResponse>> getCardDetail(String externalUserId, String cardMantissa)
            throws ApiException {
        return cardApi.getCardDetail(externalUserId, cardMantissa);
    }

    /**
     * Blocks or unblocks a card.
     *
     * <p>When unblocking, an SMS verification code is required.
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/block}
     *
     * @param request the block/unblock request parameters (required)
     * @return ApiResponse indicating the success of the operation
     * @throws ApiException if the API call fails
     * @see BlockCardRequest
     */
    public ApiResponse<Boolean> blockCard(BlockCardRequest request) throws ApiException {
        return cardApi.blockCard(request);
    }

    /**
     * Queries card transaction history.
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/transactions}
     *
     * @param request the transactions query parameters (required)
     * @return ApiResponse containing the transaction search result
     * @throws ApiException if the API call fails
     * @see CardTransactionsRequest
     */
    public ApiResponse<Object> getCardTransactions(CardTransactionsRequest request) throws ApiException {
        return cardApi.getCardTransactions(request);
    }

    /**
     * Applies for a virtual card.
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/virtual-card/apply}
     *
     * @param request the virtual card application parameters (required)
     * @return ApiResponse containing the application result
     * @throws ApiException if the API call fails
     * @see ApplyVirtualCardRequest
     * @see ApplyVirtualCardResponse
     */
    public ApiResponse<ApplyVirtualCardResponse> applyVirtualCard(ApplyVirtualCardRequest request) throws ApiException {
        return cardApi.applyVirtualCard(request);
    }

    /**
     * Gets virtual card application detail.
     *
     * <p>At least one of applyId or applyRef should be provided.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/virtual-card/detail}
     *
     * @param externalUserId the dicard user ID (required)
     * @param applyId        the apply ID (optional)
     * @param applyRef       the apply reference (optional)
     * @return ApiResponse containing the application detail
     * @throws ApiException if the API call fails
     * @see ApplyVirtualCardResponse
     */
    public ApiResponse<ApplyVirtualCardResponse> getVirtualCardDetail(
            String externalUserId, String applyId, String applyRef) throws ApiException {
        return cardApi.getVirtualCardDetail(externalUserId, applyId, applyRef);
    }

    /**
     * Binds a card to Apple Wallet (Apple Pay).
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/apple-bind-wallet}
     *
     * @param request the Apple Wallet binding request (required)
     * @return ApiResponse containing the binding result
     * @throws ApiException if the API call fails
     * @see BindAppleWalletRequest
     * @see BindAppleWalletResponse
     */
    public ApiResponse<BindAppleWalletResponse> bindAppleWallet(BindAppleWalletRequest request) throws ApiException {
        return cardApi.bindAppleWallet(request);
    }

    /**
     * Binds a card to Google Wallet (Google Pay).
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/google-bind-wallet}
     *
     * @param request the Google Wallet binding request (required)
     * @return ApiResponse containing the binding result
     * @throws ApiException if the API call fails
     * @see BindGoogleWalletRequest
     * @see BindGoogleWalletResponse
     */
    public ApiResponse<BindGoogleWalletResponse> bindGoogleWallet(BindGoogleWalletRequest request) throws ApiException {
        return cardApi.bindGoogleWallet(request);
    }

    /**
     * Gets physical card shipping information.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/physical-shipping-info}
     *
     * @param externalUserId the dicard user ID (required)
     * @param cardMantissa   last 4 digits of card number (required)
     * @return ApiResponse containing the shipping information
     * @throws ApiException if the API call fails
     * @see ShippingInfoResponse
     */
    public ApiResponse<ShippingInfoResponse> getShippingInfo(String externalUserId, String cardMantissa)
            throws ApiException {
        return cardApi.getShippingInfo(externalUserId, cardMantissa);
    }

    /**
     * Gets card application records.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/apply-list}
     *
     * @param externalUserId the dicard user ID (required)
     * @return ApiResponse containing the apply records
     * @throws ApiException if the API call fails
     * @see CardApplyResponse
     */
    public ApiResponse<List<CardApplyResponse>> getApplyList(String externalUserId) throws ApiException {
        return cardApi.getApplyList(externalUserId);
    }

    /**
     * Resolves transaction IDs to determine posted/outstanding status.
     *
     * <p><b>API Endpoint:</b> {@code POST /card/v1/transaction/id/resolve}
     *
     * @param request the transaction ID resolve request (required, max 100 IDs)
     * @return ApiResponse containing the resolved transaction info
     * @throws ApiException if the API call fails
     * @see TransactionIdResolveRequest
     * @see TransactionIdResolveResponse
     */
    public ApiResponse<List<TransactionIdResolveResponse>> resolveTransactionIds(
            TransactionIdResolveRequest request) throws ApiException {
        return cardApi.resolveTransactionIds(request);
    }

    /**
     * Gets card statements.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/statements}
     *
     * @param externalUserId the dicard user ID (required)
     * @param cardMantissa   last 4 digits of card number (optional)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @param startTime      start date, format: yyyy-MM-dd (optional)
     * @param endTime        end date, format: yyyy-MM-dd (optional)
     * @return ApiResponse containing the statement data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getStatements(String externalUserId, String cardMantissa,
                                             Integer page, Integer rows,
                                             String startTime, String endTime) throws ApiException {
        return cardApi.getStatements(externalUserId, cardMantissa, page, rows, startTime, endTime);
    }

    /**
     * Gets statement transaction details.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/statements/detail}
     *
     * @param externalUserId the dicard user ID (required)
     * @param statementId    the statement ID (required)
     * @param cardMantissa   last 4 digits of card number (optional)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @return ApiResponse containing the statement detail data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getStatementDetails(String externalUserId, String statementId,
                                                   String cardMantissa, Integer page, Integer rows)
            throws ApiException {
        return cardApi.getStatementDetails(externalUserId, statementId, cardMantissa, page, rows);
    }

    /**
     * Gets fiat transaction records.
     *
     * <p><b>API Endpoint:</b> {@code GET /card/v1/fiat/transactions}
     *
     * @param externalUserId the dicard user ID (required)
     * @param page           page number (optional)
     * @param rows           page size (optional)
     * @return ApiResponse containing the fiat transaction data
     * @throws ApiException if the API call fails
     */
    public ApiResponse<Object> getFiatTransactions(String externalUserId, Integer page, Integer rows)
            throws ApiException {
        return cardApi.getFiatTransactions(externalUserId, page, rows);
    }

    /**
     * Gets the underlying CardApi instance for advanced use cases.
     *
     * @return the CardApi instance
     */
    public CardApi getCardApi() {
        return cardApi;
    }
}
