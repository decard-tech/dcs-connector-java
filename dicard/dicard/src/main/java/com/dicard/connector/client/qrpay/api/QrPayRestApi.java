package com.dicard.connector.client.qrpay.api;

import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.qrpay.model.*;

/**
 * dicard QR Pay REST API client.
 *
 * <p>Provides QR code payment operations:
 * <ul>
 *   <li>QR code decode</li>
 *   <li>Payment order creation</li>
 *   <li>Payment confirmation</li>
 *   <li>Order list and detail queries</li>
 * </ul>
 *
 * @since 1.0.0
 */
public class QrPayRestApi {

    private final QrPayApi qrPayApi;

    public QrPayRestApi(ClientConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");
        configuration.validate();
        this.qrPayApi = new QrPayApi(new ApiClient(configuration));
    }

    public QrPayRestApi(ApiClient apiClient) {
        if (apiClient == null) throw new IllegalArgumentException("ApiClient cannot be null");
        this.qrPayApi = new QrPayApi(apiClient);
    }

    /** {@code POST /qrpay/v1/decode} */
    public ApiResponse<Object> decode(QrPayDecodeRequest request) throws ApiException {
        return qrPayApi.decode(request);
    }

    /** {@code POST /qrpay/v1/create} */
    public ApiResponse<Object> create(QrPayCreateRequest request) throws ApiException {
        return qrPayApi.create(request);
    }

    /** {@code POST /qrpay/v1/confirm} */
    public ApiResponse<Object> confirm(QrPayConfirmRequest request) throws ApiException {
        return qrPayApi.confirm(request);
    }

    /** {@code GET /qrpay/v1/order-list} */
    public ApiResponse<Object> orderList(String externalUserId, Long cursorOrderId, Integer limit) throws ApiException {
        return qrPayApi.orderList(externalUserId, cursorOrderId, limit);
    }

    /** {@code GET /qrpay/v1/order-detail} */
    public ApiResponse<Object> orderDetail(String externalUserId, String orderId) throws ApiException {
        return qrPayApi.orderDetail(externalUserId, orderId);
    }

    public QrPayApi getQrPayApi() { return qrPayApi; }
}
