package com.dicard.connector.client.captcha.api;

import com.dicard.connector.client.captcha.model.SendMobileCodeRequest;
import com.dicard.connector.client.common.ApiClient;
import com.dicard.connector.client.common.ApiResponse;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;

/**
 * dicard Captcha REST API client.
 *
 * <p>Provides SMS verification code operations.
 *
 * @since 1.0.0
 */
public class CaptchaRestApi {

    private final CaptchaApi captchaApi;

    public CaptchaRestApi(ClientConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");
        configuration.validate();
        this.captchaApi = new CaptchaApi(new ApiClient(configuration));
    }

    public CaptchaRestApi(ApiClient apiClient) {
        if (apiClient == null) throw new IllegalArgumentException("ApiClient cannot be null");
        this.captchaApi = new CaptchaApi(apiClient);
    }

    /** {@code POST /captcha/v1/send-mobile-code} */
    public ApiResponse<String> sendMobileCode(SendMobileCodeRequest request) throws ApiException {
        return captchaApi.sendMobileCode(request);
    }

    public CaptchaApi getCaptchaApi() { return captchaApi; }
}
