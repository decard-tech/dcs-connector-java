package com.dicard.connector.client.qrpay.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.Pair;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.qrpay.model.*;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Low-level QR Pay API implementation.
 *
 * @since 1.0.0
 */
public class QrPayApi {

    private final ApiClient apiClient;

    public QrPayApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiResponse<Object> decode(QrPayDecodeRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling decode");
        Call call = apiClient.buildCall("/qrpay/v1/decode", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiResponse<Object> create(QrPayCreateRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling create");
        Call call = apiClient.buildCall("/qrpay/v1/create", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiResponse<Object> confirm(QrPayConfirmRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling confirm");
        Call call = apiClient.buildCall("/qrpay/v1/confirm", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiResponse<Object> orderList(String externalUserId, Long cursorOrderId, Integer limit) throws ApiException {
        if (externalUserId == null) throw new ApiException("Missing 'externalUserId' when calling orderList");
        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        if (cursorOrderId != null) queryParams.addAll(apiClient.parameterToPair("cursorOrderId", cursorOrderId));
        if (limit != null) queryParams.addAll(apiClient.parameterToPair("limit", limit));
        Call call = apiClient.buildCall("/qrpay/v1/order-list", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiResponse<Object> orderDetail(String externalUserId, String orderId) throws ApiException {
        if (externalUserId == null) throw new ApiException("Missing 'externalUserId' when calling orderDetail");
        if (orderId == null) throw new ApiException("Missing 'orderId' when calling orderDetail");
        List<Pair> queryParams = new ArrayList<>();
        queryParams.addAll(apiClient.parameterToPair("externalUserId", externalUserId));
        queryParams.addAll(apiClient.parameterToPair("orderId", orderId));
        Call call = apiClient.buildCall("/qrpay/v1/order-detail", "GET", queryParams, null, new String[]{});
        return apiClient.execute(call, Object.class);
    }

    public ApiClient getApiClient() { return apiClient; }
}
