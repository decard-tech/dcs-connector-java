package com.dicard.connector.client.common;

import com.dicard.connector.client.common.CommonRet;
import com.dicard.connector.client.common.auth.Authentication;
import com.dicard.connector.client.common.auth.HmacAuthentication;
import com.dicard.connector.client.common.configuration.ClientConfiguration;
import com.dicard.connector.client.common.exception.ApiException;
import com.dicard.connector.client.common.utils.SystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * API client for dicard REST API calls.
 *
 * <p>Ported from card-bridge ApiClient for consistent behavior: request signing,
 * authentication headers, and JSON parsing via {@link CommonRet}.
 */
public class ApiClient {

    private static final Logger log = Logger.getLogger(ApiClient.class.getName());

    private static final String DEFAULT_BASE_URL = "https://api.thedecard.com";
    private static final String DEFAULT_USER_AGENT =
            String.format(
                    "dicard-connector-java/1.0.0 (Java/%s; %s; %s)",
                    SystemUtil.getJavaVersion(), SystemUtil.getOs(), SystemUtil.getArch());

    // Request headers
    private static final String HEADER_API_KEY = "X-DAPI-API-KEY";
    private static final String HEADER_TIMESTAMP = "X-DAPI-TIMESTAMP";
    private static final String HEADER_NONCE = "X-DAPI-NONCE";
    private static final String HEADER_SIGNATURE = "X-DAPI-SIGN";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String USER_AGENT = "User-Agent";
    private static final String TRACE_ID = "x-trace-id";

    private final OkHttpClient httpClient;
    private final Gson gson;
    private final ClientConfiguration configuration;
    private final Authentication authentication;
    private final Random random = new Random();

    /**
     * Constructs a new ApiClient with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public ApiClient(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        this.configuration = configuration;
        this.authentication = new HmacAuthentication(configuration.getApiKey(), configuration.getSecretKey());
        this.gson = createGson();
        this.httpClient = createHttpClient();
    }

    private Gson createGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
    }

    private OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.MILLISECONDS);

        if (configuration.isDebug()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        if (configuration.getProxy() != null) {
            builder.proxy(configuration.getProxy());
        }

        return builder.build();
    }

    public Call buildCall(String path, String method, List<Pair> queryParams,
                          Object body, String[] authNames) throws ApiException {

        String url = buildUrl(path, queryParams);
        RequestBody requestBody = buildRequestBody(body, method);

        Request.Builder requestBuilder = new Request.Builder().url(url).method(method, requestBody);

        addAuthenticationHeaders(requestBuilder, method, path, queryParams, body);

        requestBuilder.addHeader(HEADER_CONTENT_TYPE, "application/json");
        requestBuilder.addHeader(HEADER_ACCEPT, "application/json");

        return httpClient.newCall(requestBuilder.build());
    }

    public <T> ApiResponse<T> execute(Call call, Class<T> returnType) throws ApiException {
        try {
            Response response = call.execute();
            return handleResponse(response, returnType);
        } catch (IOException e) {
            throw new ApiException("HTTP call failed", e);
        }
    }

    private <T> ApiResponse<T> handleResponse(Response response, Class<T> returnType) throws ApiException {
        try {
            String responseBody = response.body() != null ? response.body().string() : "";

            if (configuration.isDebug()) {
                log.fine("Response body: " + responseBody);
                log.fine("Return type: " + returnType.getName());
            }

            if (!response.isSuccessful()) {
                throw new ApiException(
                        "HTTP " + response.code() + ": " + response.message(),
                        response.code(),
                        response.headers().toMultimap(),
                        responseBody);
            }

            T data = null;
            if (StringUtils.isNotBlank(responseBody) && returnType != Void.class) {
                try {
                    CommonRet<T> commonRet =
                            gson.fromJson(
                                    responseBody,
                                    com.google.gson.reflect.TypeToken.getParameterized(CommonRet.class, returnType)
                                            .getType());

                    if (configuration.isDebug()) {
                        log.fine("Parsed CommonRet: " + commonRet);
                    }

                    if (commonRet != null && !commonRet.isSuccessful()) {
                        throw new ApiException(
                                "API Error: " + commonRet.getCode() + " - " + commonRet.getMessage(),
                                response.code(),
                                response.headers().toMultimap(),
                                responseBody);
                    }

                    data = commonRet != null ? commonRet.getData() : null;

                    if (configuration.isDebug()) {
                        log.fine("Extracted data: " + data);
                    }
                } catch (Exception e) {
                    if (configuration.isDebug()) {
                        log.fine("Error parsing response: " + e.getMessage());
                    }
                    throw e;
                }
            }

            return new ApiResponse<>(response.code(), response.headers().toMultimap(), data);

        } catch (IOException e) {
            throw new ApiException("Failed to read response body", e);
        } catch (Exception e) {
            throw new ApiException("Failed to parse response: " + e.getMessage(), e);
        }
    }

    private String buildUrl(String path, List<Pair> queryParams) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(configuration.getBaseUrl() != null ? configuration.getBaseUrl() : DEFAULT_BASE_URL);

        if (!path.startsWith("/")) {
            urlBuilder.append("/");
        }
        urlBuilder.append(path);

        if (queryParams != null && !queryParams.isEmpty()) {
            urlBuilder.append("?");
            for (int i = 0; i < queryParams.size(); i++) {
                if (i > 0) {
                    urlBuilder.append("&");
                }
                Pair param = queryParams.get(i);
                try {
                    urlBuilder
                            .append(URLEncoder.encode(param.getName(), "UTF-8"))
                            .append("=")
                            .append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return urlBuilder.toString();
    }

    private RequestBody buildRequestBody(Object body, String method) {
        if (body == null || "GET".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method)) {
            return null;
        }

        String json = gson.toJson(body);
        return RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
    }

    private void addAuthenticationHeaders(
            Request.Builder requestBuilder, String method, String path, List<Pair> queryParams, Object body)
            throws ApiException {

        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = generateNonce();
        String payload = buildPayload(method, queryParams, body);

        requestBuilder.addHeader(HEADER_API_KEY, configuration.getApiKey());
        requestBuilder.addHeader(HEADER_TIMESTAMP, timestamp);
        requestBuilder.addHeader(HEADER_NONCE, nonce);
        requestBuilder.addHeader(USER_AGENT, DEFAULT_USER_AGENT);
        requestBuilder.addHeader(TRACE_ID, UUID.randomUUID().toString());
        String signature = authentication.generateSignature(timestamp, nonce, payload);
        requestBuilder.addHeader(HEADER_SIGNATURE, signature);
    }

    private String generateNonce() {
        return String.valueOf(10000 + random.nextInt(90000));
    }

    private String buildPayload(String method, List<Pair> queryParams, Object body) {
        if ("GET".equalsIgnoreCase(method)) {
            if (queryParams == null || queryParams.isEmpty()) {
                return "";
            }

            StringBuilder queryString = new StringBuilder();
            for (int i = 0; i < queryParams.size(); i++) {
                if (i > 0) {
                    queryString.append("&");
                }
                Pair param = queryParams.get(i);
                queryString.append(param.getName()).append("=").append(param.getValue());
            }
            return queryString.toString();
        } else {
            return body != null ? gson.toJson(body) : "";
        }
    }

    public List<Pair> parameterToPair(String name, Object value) {
        List<Pair> params = new ArrayList<>();
        if (value != null) {
            params.add(new Pair(name, String.valueOf(value)));
        }
        return params;
    }

    public String selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) {
            return null;
        }

        for (String accept : accepts) {
            if ("application/json".equalsIgnoreCase(accept)) {
                return accept;
            }
        }

        return StringUtils.join(accepts, ",");
    }

    public String selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0) {
            return "application/json";
        }

        for (String contentType : contentTypes) {
            if ("application/json".equalsIgnoreCase(contentType)) {
                return contentType;
            }
        }

        return contentTypes[0];
    }

    public ClientConfiguration getConfiguration() {
        return configuration;
    }
}

