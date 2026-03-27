package com.dicard.connector.client.common.configuration;

import java.net.Proxy;

/**
 * Configuration class for dicard API client.
 */
public class ClientConfiguration {

    public static final int DEFAULT_CONNECT_TIMEOUT = 10000;
    public static final int DEFAULT_READ_TIMEOUT = 30000;
    public static final int DEFAULT_WRITE_TIMEOUT = 30000;
    public static final String DEFAULT_BASE_URL = "https://api.thedecard.com";

    private String apiKey;
    private String secretKey;
    private String baseUrl = DEFAULT_BASE_URL;
    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    private int readTimeout = DEFAULT_READ_TIMEOUT;
    private int writeTimeout = DEFAULT_WRITE_TIMEOUT;
    private Proxy proxy;
    private boolean debug = false;

    public String getApiKey() {
        return apiKey;
    }

    public ClientConfiguration setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public ClientConfiguration setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public ClientConfiguration setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public ClientConfiguration setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public ClientConfiguration setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public ClientConfiguration setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public ClientConfiguration setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public ClientConfiguration setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * Validates the configuration parameters.
     *
     * @throws IllegalArgumentException if the configuration is invalid
     */
    public void validate() {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or empty");
        }
        if (secretKey == null || secretKey.trim().isEmpty()) {
            throw new IllegalArgumentException("Secret key cannot be null or empty");
        }
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Base URL cannot be null or empty");
        }
        if (connectTimeout <= 0) {
            throw new IllegalArgumentException("Connect timeout must be positive");
        }
        if (readTimeout <= 0) {
            throw new IllegalArgumentException("Read timeout must be positive");
        }
        if (writeTimeout <= 0) {
            throw new IllegalArgumentException("Write timeout must be positive");
        }
    }

    @Override
    public String toString() {
        return "ClientConfiguration{"
                + "apiKey='" + (apiKey != null ? "***" : null) + '\''
                + ", secretKey='" + (secretKey != null ? "***" : null) + '\''
                + ", baseUrl='" + baseUrl + '\''
                + ", connectTimeout=" + connectTimeout
                + ", readTimeout=" + readTimeout
                + ", writeTimeout=" + writeTimeout
                + ", proxy=" + proxy
                + ", debug=" + debug
                + '}';
    }
}

