/*
 * dcs Java Connector
 * Java connector for dcs APIs
 *
 * The version of the dcs API: 1.0.0
 *
 * NOTE: This class provides the core HTTP client functionality for dcs API calls.
 * It handles authentication, request signing, and response processing.
 */

package com.dcscc.connector.client.common;

import com.dcscc.connector.client.common.auth.Authentication;
import com.dcscc.connector.client.common.auth.HmacAuthentication;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.common.utils.SystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
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
 * API client for dcs REST API calls.
 *
 * <p>This class provides the core functionality for making authenticated HTTP requests
 * to the dcs API. It handles:
 * <ul>
 *   <li>HMAC-SHA256 signature generation</li>
 *   <li>Request authentication headers</li>
 *   <li>HTTP client configuration</li>
 *   <li>Response parsing and error handling</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 *
 * ApiClient client = new ApiClient(config);
 * ApiResponse<String> response = client.execute(call, String.class);
 * }</pre>
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApiClient {

    private static final Logger log = Logger.getLogger(ApiClient.class.getName());

    private static final String DEFAULT_BASE_URL = "https://api.thedecard.com";
    private static final String DEFAULT_USER_AGENT =
            String.format(
                    "dcs-connector-java/1.0.0 (Java/%s; %s; %s)",
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

    /**
     * Creates and configures the Gson instance for JSON serialization/deserialization.
     *
     * @return configured Gson instance
     */
    private Gson createGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    /**
     * Creates and configures the OkHttp client with timeouts and interceptors.
     *
     * @return configured OkHttpClient instance
     */
    private OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.MILLISECONDS);

        // Add logging interceptor if debug mode is enabled
        if (configuration.isDebug()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        // Add proxy if configured
        if (configuration.getProxy() != null) {
            builder.proxy(configuration.getProxy());
        }

        return builder.build();
    }

    /**
     * Builds an HTTP call for the specified parameters.
     *
     * @param path        the API endpoint path
     * @param method      the HTTP method (GET, POST, etc.)
     * @param queryParams the query parameters
     * @param body        the request body (for POST/PUT requests)
     * @param authNames   the authentication methods to use
     * @return the configured Call object
     * @throws ApiException if the call cannot be built
     */
    public Call buildCall(String path, String method, List<Pair> queryParams,
                          Object body, String[] authNames) throws ApiException {

        String url = buildUrl(path, queryParams);
        RequestBody requestBody = buildRequestBody(body, method);

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .method(method, requestBody);

        // Add authentication headers
        addAuthenticationHeaders(requestBuilder, method, path, queryParams, body);

        // Add common headers
        requestBuilder.addHeader(HEADER_CONTENT_TYPE, "application/json");
        requestBuilder.addHeader(HEADER_ACCEPT, "application/json");

        return httpClient.newCall(requestBuilder.build());
    }

    /**
     * Executes the HTTP call and returns the parsed response.
     *
     * @param <T>        the expected response type
     * @param call       the HTTP call to execute
     * @param returnType the class of the expected response type
     * @return the API response containing the parsed data
     * @throws ApiException if the call fails or response cannot be parsed
     */
    public <T> ApiResponse<T> execute(Call call, Class<T> returnType) throws ApiException {
        try {
            Response response = call.execute();
            return handleResponse(response, returnType);
        } catch (IOException e) {
            throw new ApiException("HTTP call failed", e);
        }
    }

    /**
     * Handles the HTTP response and parses it into the expected type.
     *
     * @param <T>        the expected response type
     * @param response   the HTTP response
     * @param returnType the class of the expected response type
     * @return the parsed API response
     * @throws ApiException if the response indicates an error or cannot be parsed
     */
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
                        responseBody
                );
            }

            T data = null;
            if (StringUtils.isNotBlank(responseBody) && returnType != Void.class) {
                try {
                    // Parse the CommonRet wrapper first
                    CommonRet<T> commonRet = gson.fromJson(responseBody,
                            com.google.gson.reflect.TypeToken.getParameterized(CommonRet.class, returnType).getType());

                    if (configuration.isDebug()) {
                        log.fine("Parsed CommonRet: " + commonRet);
                    }

                    // Check if the API call was successful
                    if (commonRet != null && !commonRet.isSuccessful()) {
                        throw new ApiException(
                                "API Error: " + commonRet.getCode() + " - " + commonRet.getMessage(),
                                response.code(),
                                response.headers().toMultimap(),
                                responseBody
                        );
                    }

                    // Extract the actual data from the wrapper
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

    /**
     * Builds the complete URL from base URL, path, and query parameters.
     *
     * @param path        the API endpoint path
     * @param queryParams the query parameters
     * @return the complete URL string
     */
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
                    urlBuilder.append(URLEncoder.encode(param.getName(), "UTF-8"))
                            .append("=")
                            .append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return urlBuilder.toString();
    }

    /**
     * Builds the request body for POST/PUT requests.
     *
     * @param body   the request body object
     * @param method the HTTP method
     * @return the RequestBody for OkHttp
     */
    private RequestBody buildRequestBody(Object body, String method) {
        if (body == null || "GET".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method)) {
            return null;
        }

        String json = gson.toJson(body);
        return RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
    }

    /**
     * Adds authentication headers to the request.
     *
     * @param requestBuilder the request builder
     * @param method         the HTTP method
     * @param path           the API endpoint path
     * @param queryParams    the query parameters
     * @param body           the request body
     * @throws ApiException if authentication fails
     */
    private void addAuthenticationHeaders(Request.Builder requestBuilder, String method,
                                          String path, List<Pair> queryParams, Object body) throws ApiException {

        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = generateNonce();
        String payload = buildPayload(method, queryParams, body);

        requestBuilder.addHeader(HEADER_API_KEY, configuration.getApiKey());
        requestBuilder.addHeader(HEADER_TIMESTAMP, timestamp);
        requestBuilder.addHeader(HEADER_NONCE, nonce);
        requestBuilder.addHeader(USER_AGENT, DEFAULT_USER_AGENT);
        requestBuilder.addHeader(TRACE_ID, UUID.randomUUID().toString());
        // Generate signature
        String signature = authentication.generateSignature(timestamp, nonce, payload);
        requestBuilder.addHeader(HEADER_SIGNATURE, signature);
    }

    /**
     * Generates a random nonce for request authentication.
     *
     * @return a random nonce string in the range [10000, 99999]
     */
    private String generateNonce() {
        return String.valueOf(10000 + random.nextInt(90000));
    }

    /**
     * Builds the payload string for signature generation.
     *
     * @param method      the HTTP method
     * @param queryParams the query parameters
     * @param body        the request body
     * @return the payload string
     */
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

    /**
     * Converts parameters to a list of Pair objects.
     *
     * @param name  the parameter name
     * @param value the parameter value
     * @return a list containing the parameter pair
     */
    public List<Pair> parameterToPair(String name, Object value) {
        List<Pair> params = new ArrayList<>();
        if (value != null) {
            params.add(new Pair(name, String.valueOf(value)));
        }
        return params;
    }

    /**
     * Selects the appropriate Accept header from the given options.
     *
     * @param accepts the array of acceptable content types
     * @return the selected Accept header value
     */
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

    /**
     * Selects the appropriate Content-Type header from the given options.
     *
     * @param contentTypes the array of content types
     * @return the selected Content-Type header value
     */
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

    /**
     * Gets the current client configuration.
     *
     * @return the client configuration
     */
    public ClientConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Gets the Gson instance used for JSON processing.
     *
     * @return the Gson instance
     */
    public Gson getGson() {
        return gson;
    }
}
