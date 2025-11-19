/*
 * CardBridge Java Connector
 * Enterprise Management REST API client
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.enterprise.api;


import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.enterprise.model.BalanceResponse;
import com.dcscc.connector.client.enterprise.model.SettlementFileType;

/**
 * CardBridge Enterprise Management REST API client.
 * 
 * <p>This class provides a high-level interface for interacting with CardBridge's
 * enterprise management APIs. It handles enterprise-level operations including:
 * <ul>
 *   <li>Enterprise balance inquiries</li>
 *   <li>Balance change history tracking</li>
 *   <li>Settlement file downloads</li>
 *   <li>Financial reporting and reconciliation</li>
 * </ul>
 * 
 * <p>All operations require proper authentication using API key and secret key.
 * The client automatically handles request signing and authentication headers.
 * 
 * <p>Example usage:
 * <pre>{@code
 * // Configure the client
 * ClientConfiguration config = new ClientConfiguration();
 * config.setApiKey("your-api-key");
 * config.setSecretKey("your-secret-key");
 * config.setBaseUrl("https://api.thedecard.com");
 * 
 * // Create the API client
 * EnterpriseRestApi enterpriseApi = new EnterpriseRestApi(config);
 * 
 * // Get enterprise balance
 * ApiResponse<BalanceResponse> response = enterpriseApi.getEnterpriseBalance("840");
 * BalanceResponse balance = response.getData();
 * 
 * // Get settlement file URL using string
 * String fileUrl = enterpriseApi.getSettlementFileUrl("transaction", "20240115");
 * 
 * // Get settlement file URL using enum (recommended)
 * String fileUrl2 = enterpriseApi.getSettlementFileUrl(SettlementFileType.TRANSACTION, "20240115");
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 * @see EnterpriseApi
 * @see ClientConfiguration
 */
public class EnterpriseRestApi {

    private final EnterpriseApi enterpriseApi;

    /**
     * Constructs a new EnterpriseRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public EnterpriseRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }
        
        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.enterpriseApi = new EnterpriseApi(apiClient);
    }

    /**
     * Constructs a new EnterpriseRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public EnterpriseRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }
        
        this.enterpriseApi = new EnterpriseApi(apiClient);
    }

    /**
     * Query enterprise account balance.
     * 
     * <p>This method returns the current balance information for the authenticated
     * enterprise in the specified currency. The balance includes available funds,
     * reserved amounts, and other financial details.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/enterprise/v1/enterprise-balance}
     * <p><b>Weight:</b> 1
     *
     * @param currency Currency, using ISO3 numeric code (required)
     * @return ApiResponse containing the enterprise balance information
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if currency is null or empty
     * 
     * @see BalanceResponse
     */
    public ApiResponse<BalanceResponse> getEnterpriseBalance(String currency) throws ApiException {
        return enterpriseApi.getEnterpriseBalance(currency);
    }

    /**
     * Get settlement file download link using enum.
     * 
     * <p>This method generates a time-limited, secure URL for downloading
     * settlement files. This overload provides type safety by using the
     * SettlementFileType enum instead of a raw string.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/enterprise/v1/settlement-file-url}
     * <p><b>Weight:</b> 1
     *
     * @param fileType the type of settlement file to download (required)
     * @param fileDate the date of the file in YYYYMMDD format (required)
     * @return ApiResponse containing the secure download URL
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if fileType or fileDate is null or invalid
     * @see SettlementFileType
     */
    public ApiResponse<String> getSettlementFileUrl(SettlementFileType fileType, String fileDate) throws ApiException {
        return enterpriseApi.getSettlementFileUrl(fileType, fileDate);
    }

    /**
     * Gets the underlying EnterpriseApi instance.
     * 
     * <p>This method provides access to the low-level EnterpriseApi for advanced use cases
     * that require direct access to the API client functionality.
     *
     * @return the EnterpriseApi instance
     */
    public EnterpriseApi getEnterpriseApi() {
        return enterpriseApi;
    }
}
