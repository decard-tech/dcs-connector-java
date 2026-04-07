package com.dicard.connector.client.fincon.api;

import com.dicard.connector.client.card.model.ApplyVirtualCardResponse;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.fincon.model.*;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Low-level Financial Connection API implementation.
 *
 * @since 1.0.0
 */
public class FinancialConnectionApi {

    private final ApiClient apiClient;

    public FinancialConnectionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiResponse<FCUserResponse> createUser(CreateUserRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling createUser");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/create-user", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, FCUserResponse.class);
    }

    public ApiResponse<FCUserResponse> queryUserInfo(String userRef, String externalUserId) throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (userRef != null) {
            queryParams.addAll(apiClient.parameterToPair("userRef", userRef));
        }
        if (externalUserId != null) {
            queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        }
        Call call = apiClient.buildCall("/financial-connection/v1/query-user-info", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, FCUserResponse.class);
    }

    public ApiResponse<ApplyVirtualCardResponse> applyVirtualCard(FCApplyVirtualCardRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling applyVirtualCard");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/virtual-card/apply", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, ApplyVirtualCardResponse.class);
    }

    public ApiResponse<ApplyVirtualCardResponse> getVirtualCardDetail(String externalUserId, String applyId, String applyRef) throws ApiException {
        if (externalUserId == null) {
            throw new ApiException("Missing the required parameter 'externalUserId'");
        }
        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (applyId != null) queryParams.addAll(apiClient.parameterToPair("applyId", applyId));
        if (applyRef != null) queryParams.addAll(apiClient.parameterToPair("applyRef", applyRef));
        Call call = apiClient.buildCall("/financial-connection/v1/virtual-card/detail", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, ApplyVirtualCardResponse.class);
    }

    public ApiResponse<FCPaymentResponse> payment(FCPaymentRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling payment");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/payment", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, FCPaymentResponse.class);
    }

    public ApiResponse<FCPaymentResponse> queryPaymentInfo(String externalTranId, String internalTranId) throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (externalTranId != null) queryParams.addAll(apiClient.parameterToPair("externalTranId", externalTranId));
        if (internalTranId != null) queryParams.addAll(apiClient.parameterToPair("internalTranId", internalTranId));
        Call call = apiClient.buildCall("/financial-connection/v1/query-payment-info", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, FCPaymentResponse.class);
    }

    public ApiResponse<FCTransferResponse> transferToSpending(FCTransferToSpendingRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling transferToSpending");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/transfer-to-spending", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, FCTransferResponse.class);
    }

    public ApiResponse<FCTransferResponse> queryTransferInfo(String externalTranId, String internalTranId) throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (externalTranId != null) queryParams.addAll(apiClient.parameterToPair("externalTranId", externalTranId));
        if (internalTranId != null) queryParams.addAll(apiClient.parameterToPair("internalTranId", internalTranId));
        Call call = apiClient.buildCall("/financial-connection/v1/query-transfer-info", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, FCTransferResponse.class);
    }

    public ApiResponse<FCWithdrawalResponse> withdraw(FCWithdrawalRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling withdraw");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/withdraw", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, FCWithdrawalResponse.class);
    }

    public ApiResponse<FCWithdrawalResponse> queryWithdrawalInfo(String externalTranId, String internalTranId) throws ApiException {
        List<Pair> queryParams = new ArrayList<>();
        if (externalTranId != null) queryParams.addAll(apiClient.parameterToPair("externalTranId", externalTranId));
        if (internalTranId != null) queryParams.addAll(apiClient.parameterToPair("internalTranId", internalTranId));
        Call call = apiClient.buildCall("/financial-connection/v1/query-withdrawal-info", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, FCWithdrawalResponse.class);
    }

    public ApiResponse<QueryTranListResponse> queryTranList(QueryTranListRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling queryTranList");
        }
        Call call = apiClient.buildCall("/financial-connection/v1/query-tran-list", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, QueryTranListResponse.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
