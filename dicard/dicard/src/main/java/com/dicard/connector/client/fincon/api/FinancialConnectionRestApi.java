package com.dicard.connector.client.fincon.api;

import com.dicard.connector.client.card.model.ApplyVirtualCardResponse;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.fincon.model.*;

/**
 * dicard Financial Connection REST API client.
 *
 * <p>Provides operations for financial connections including:
 * <ul>
 *   <li>User creation and query</li>
 *   <li>Virtual card application</li>
 *   <li>Payment processing</li>
 *   <li>Settlement-to-spending transfers</li>
 *   <li>Fiat withdrawal</li>
 *   <li>Transaction list queries</li>
 * </ul>
 *
 * @since 1.0.0
 */
public class FinancialConnectionRestApi {

    private final FinancialConnectionApi fcApi;

    public FinancialConnectionRestApi(ClientConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");
        configuration.validate();
        this.fcApi = new FinancialConnectionApi(new ApiClient(configuration));
    }

    public FinancialConnectionRestApi(ApiClient apiClient) {
        if (apiClient == null) throw new IllegalArgumentException("ApiClient cannot be null");
        this.fcApi = new FinancialConnectionApi(apiClient);
    }

    /** {@code POST /financial-connection/v1/create-user} */
    public ApiResponse<FCUserResponse> createUser(CreateUserRequest request) throws ApiException {
        return fcApi.createUser(request);
    }

    /** {@code GET /financial-connection/v1/query-user-info} */
    public ApiResponse<FCUserResponse> queryUserInfo(String userRef, String externalUserId) throws ApiException {
        return fcApi.queryUserInfo(userRef, externalUserId);
    }

    /** {@code POST /financial-connection/v1/virtual-card/apply} */
    public ApiResponse<ApplyVirtualCardResponse> applyVirtualCard(FCApplyVirtualCardRequest request) throws ApiException {
        return fcApi.applyVirtualCard(request);
    }

    /** {@code GET /financial-connection/v1/virtual-card/detail} */
    public ApiResponse<ApplyVirtualCardResponse> getVirtualCardDetail(String externalUserId, String applyId, String applyRef) throws ApiException {
        return fcApi.getVirtualCardDetail(externalUserId, applyId, applyRef);
    }

    /** {@code POST /financial-connection/v1/payment} */
    public ApiResponse<FCPaymentResponse> payment(FCPaymentRequest request) throws ApiException {
        return fcApi.payment(request);
    }

    /** {@code GET /financial-connection/v1/query-payment-info} */
    public ApiResponse<FCPaymentResponse> queryPaymentInfo(String externalTranId, String internalTranId) throws ApiException {
        return fcApi.queryPaymentInfo(externalTranId, internalTranId);
    }

    /** {@code POST /financial-connection/v1/transfer-to-spending} */
    public ApiResponse<FCTransferResponse> transferToSpending(FCTransferToSpendingRequest request) throws ApiException {
        return fcApi.transferToSpending(request);
    }

    /** {@code GET /financial-connection/v1/query-transfer-info} */
    public ApiResponse<FCTransferResponse> queryTransferInfo(String externalTranId, String internalTranId) throws ApiException {
        return fcApi.queryTransferInfo(externalTranId, internalTranId);
    }

    /** {@code POST /financial-connection/v1/withdraw} */
    public ApiResponse<FCWithdrawalResponse> withdraw(FCWithdrawalRequest request) throws ApiException {
        return fcApi.withdraw(request);
    }

    /** {@code GET /financial-connection/v1/query-withdrawal-info} */
    public ApiResponse<FCWithdrawalResponse> queryWithdrawalInfo(String externalTranId, String internalTranId) throws ApiException {
        return fcApi.queryWithdrawalInfo(externalTranId, internalTranId);
    }

    /** {@code POST /financial-connection/v1/query-tran-list} */
    public ApiResponse<QueryTranListResponse> queryTranList(QueryTranListRequest request) throws ApiException {
        return fcApi.queryTranList(request);
    }

    public FinancialConnectionApi getFinancialConnectionApi() {
        return fcApi;
    }
}
