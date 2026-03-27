package com.dicard.connector.client.captcha.api;

import com.dicard.connector.client.captcha.model.SendMobileCodeRequest;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.exception.ApiException;
import okhttp3.Call;

import java.util.ArrayList;

/**
 * Low-level Captcha API implementation.
 *
 * @since 1.0.0
 */
public class CaptchaApi {

    private final ApiClient apiClient;

    public CaptchaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Send mobile SMS verification code.
     *
     * @param request send mobile code request (required)
     * @return ApiResponse containing the mobile number
     * @throws ApiException if the API call fails
     */
    public ApiResponse<String> sendMobileCode(SendMobileCodeRequest request) throws ApiException {
        if (request == null) throw new ApiException("Missing 'request' when calling sendMobileCode");
        Call call = apiClient.buildCall("/captcha/v1/send-mobile-code", "POST", new ArrayList<>(), request, new String[]{});
        return apiClient.execute(call, String.class);
    }

    public ApiClient getApiClient() { return apiClient; }
}
