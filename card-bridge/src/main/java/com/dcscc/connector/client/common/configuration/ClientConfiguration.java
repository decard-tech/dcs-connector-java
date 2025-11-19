/*
 * dcs Java Connector
 * Configuration class for dcs API client
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.configuration;

import java.net.Proxy;

/**
 * Configuration class for dcs API client.
 * 
 * <p>This class contains all the configuration parameters needed to connect to the dcs API,
 * including authentication credentials, network settings, and client behavior options.
 * 
 * <p>Example usage:
 * <pre>{@code
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 * config.setBaseUrl("https://api.thedecard.com");
 * config.setConnectTimeout(10000);
 * config.setReadTimeout(30000);
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ClientConfiguration {
    
    /** Default connection timeout in milliseconds */
    public static final int DEFAULT_CONNECT_TIMEOUT = 10000;
    
    /** Default read timeout in milliseconds */
    public static final int DEFAULT_READ_TIMEOUT = 30000;
    
    /** Default write timeout in milliseconds */
    public static final int DEFAULT_WRITE_TIMEOUT = 30000;
    
    /** Default base URL for dcs API */
    public static final String DEFAULT_BASE_URL = "https://api.thedecard.com";

    /** API key for authentication */
    private String apiKey;
    
    /** Secret key for HMAC signature generation */
    private String secretKey;
    
    /** Base URL for the dcs API */
    private String baseUrl = DEFAULT_BASE_URL;
    
    /** Connection timeout in milliseconds */
    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    
    /** Read timeout in milliseconds */
    private int readTimeout = DEFAULT_READ_TIMEOUT;
    
    /** Write timeout in milliseconds */
    private int writeTimeout = DEFAULT_WRITE_TIMEOUT;
    
    /** Proxy configuration for HTTP requests */
    private Proxy proxy;
    
    /** Enable debug logging */
    private boolean debug = false;
    
    /** Maximum number of retry attempts */
    private int maxRetries = 3;
    
    /** Retry delay in milliseconds */
    private long retryDelay = 1000;

    /**
     * Default constructor.
     */
    public ClientConfiguration() {
    }

    /**
     * Constructor with API credentials.
     *
     * @param apiKey the API key
     * @param secretKey the secret key
     */
    public ClientConfiguration(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    /**
     * Gets the API key.
     *
     * @return the API key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the API key.
     *
     * @param apiKey the API key to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Gets the secret key.
     *
     * @return the secret key
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Sets the secret key.
     *
     * @param secretKey the secret key to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    /**
     * Gets the base URL.
     *
     * @return the base URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the base URL.
     *
     * @param baseUrl the base URL to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Gets the connection timeout in milliseconds.
     *
     * @return the connection timeout
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets the connection timeout in milliseconds.
     *
     * @param connectTimeout the connection timeout to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    /**
     * Gets the read timeout in milliseconds.
     *
     * @return the read timeout
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Sets the read timeout in milliseconds.
     *
     * @param readTimeout the read timeout to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    /**
     * Gets the write timeout in milliseconds.
     *
     * @return the write timeout
     */
    public int getWriteTimeout() {
        return writeTimeout;
    }

    /**
     * Sets the write timeout in milliseconds.
     *
     * @param writeTimeout the write timeout to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    /**
     * Gets the proxy configuration.
     *
     * @return the proxy configuration
     */
    public Proxy getProxy() {
        return proxy;
    }

    /**
     * Sets the proxy configuration.
     *
     * @param proxy the proxy to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    /**
     * Checks if debug logging is enabled.
     *
     * @return true if debug logging is enabled
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Sets the debug logging flag.
     *
     * @param debug true to enable debug logging
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * Gets the maximum number of retry attempts.
     *
     * @return the maximum number of retries
     */
    public int getMaxRetries() {
        return maxRetries;
    }

    /**
     * Sets the maximum number of retry attempts.
     *
     * @param maxRetries the maximum number of retries to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    /**
     * Gets the retry delay in milliseconds.
     *
     * @return the retry delay
     */
    public long getRetryDelay() {
        return retryDelay;
    }

    /**
     * Sets the retry delay in milliseconds.
     *
     * @param retryDelay the retry delay to set
     * @return this configuration instance for method chaining
     */
    public ClientConfiguration setRetryDelay(long retryDelay) {
        this.retryDelay = retryDelay;
        return this;
    }

    /**
     * Validates the configuration.
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
        
        if (maxRetries < 0) {
            throw new IllegalArgumentException("Max retries cannot be negative");
        }
        
        if (retryDelay < 0) {
            throw new IllegalArgumentException("Retry delay cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "ClientConfiguration{" +
                "apiKey='" + (apiKey != null ? "***" : null) + '\'' +
                ", secretKey='" + (secretKey != null ? "***" : null) + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", connectTimeout=" + connectTimeout +
                ", readTimeout=" + readTimeout +
                ", writeTimeout=" + writeTimeout +
                ", proxy=" + proxy +
                ", debug=" + debug +
                ", maxRetries=" + maxRetries +
                ", retryDelay=" + retryDelay +
                '}';
    }
}
