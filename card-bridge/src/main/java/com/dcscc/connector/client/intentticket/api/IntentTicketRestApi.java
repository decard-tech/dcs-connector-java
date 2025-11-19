/*
 * CardBridge Java Connector
 * Intent Ticket Management REST API client
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.api;


import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.configuration.ClientConfiguration;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.intentticket.model.CreateIntentTicketRequest;
import com.dcscc.connector.client.intentticket.model.GeneratePreUploadUrlRequest;
import com.dcscc.connector.client.intentticket.model.IntentTicketResponse;
import com.dcscc.connector.client.intentticket.model.PreUploadUrlResponse;

/**
 * CardBridge Intent Ticket Management REST API client.
 * 
 * <p>This class provides a high-level interface for interacting with CardBridge's
 * intent ticket management APIs. It handles intent ticket operations including:
 * <ul>
 *   <li>Intent ticket creation for various business processes</li>
 *   <li>Ticket status tracking and updates</li>
 *   <li>File upload URL generation for document submission</li>
 *   <li>Ticket detail retrieval and management</li>
 * </ul>
 * 
 * <p>Intent tickets are used to manage business processes that require
 * documentation, approval workflows, or multi-step processing such as
 * KYC verification, risk assessment, and compliance reviews.
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
 * IntentTicketRestApi ticketApi = new IntentTicketRestApi(config);
 * 
 * // Create an intent ticket
 * CreateIntentTicketRequest request = new CreateIntentTicketRequest();
 * request.setTicketRef("ticket_ref_123");
 * request.setTicketType("KYC_VERIFICATION");
 * request.setCustomerId("customer_456");
 * 
 * ApiResponse<IntentTicketResponse> response = ticketApi.createIntentTicket(request);
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IntentTicketApi
 * @see ClientConfiguration
 */
public class IntentTicketRestApi {

    private final IntentTicketApi intentTicketApi;

    /**
     * Constructs a new IntentTicketRestApi with the specified configuration.
     *
     * @param configuration the client configuration containing API credentials and settings
     * @throws IllegalArgumentException if configuration is null or invalid
     */
    public IntentTicketRestApi(ClientConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }
        
        configuration.validate();
        ApiClient apiClient = new ApiClient(configuration);
        this.intentTicketApi = new IntentTicketApi(apiClient);
    }

    /**
     * Constructs a new IntentTicketRestApi with the specified API client.
     *
     * @param apiClient the configured API client
     * @throws IllegalArgumentException if apiClient is null
     */
    public IntentTicketRestApi(ApiClient apiClient) {
        if (apiClient == null) {
            throw new IllegalArgumentException("ApiClient cannot be null");
        }
        
        this.intentTicketApi = new IntentTicketApi(apiClient);
    }

    /**
     * Creates a new intent ticket.
     * 
     * <p>This method creates a new intent ticket for managing business processes
     * that require documentation, approval, or multi-step workflows. The ticket
     * serves as a container for related documents, status tracking, and process
     * management.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/intent-ticket/v1/create}
     * <p><b>Weight:</b> 5
     *
     * @param request the intent ticket creation request parameters (required)
     * @return ApiResponse containing the created intent ticket details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see CreateIntentTicketRequest
     * @see IntentTicketResponse
     */
    public ApiResponse<IntentTicketResponse> createIntentTicket(CreateIntentTicketRequest request) throws ApiException {
        return intentTicketApi.createIntentTicket(request);
    }

    /**
     * Retrieves intent ticket details.
     * 
     * <p>This method fetches detailed information about an intent ticket using
     * either the ticket ID or the ticket reference. At least one of these
     * parameters must be provided.
     * 
     * <p><b>API Endpoint:</b> {@code GET /open-api/intent-ticket/v1/detail}
     * <p><b>Weight:</b> 1
     *
     * @param ticketId the unique identifier of the intent ticket (optional)
     * @param ticketRef the reference identifier of the intent ticket (optional)
     * @return ApiResponse containing the intent ticket details
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if both ticketId and ticketRef are null
     * 
     * @see IntentTicketResponse
     */
    public ApiResponse<IntentTicketResponse> getIntentTicketDetail(String ticketId, String ticketRef) throws ApiException {
        return intentTicketApi.getIntentTicketDetail(ticketId, ticketRef);
    }

    /**
     * Generates pre-signed upload URLs for file submission.
     * 
     * <p>This method generates secure, time-limited URLs for uploading files
     * related to an intent ticket. The URLs allow direct upload to cloud storage
     * without exposing storage credentials. Files are typically used for
     * document submission in KYC, compliance, or verification processes.
     * 
     * <p><b>API Endpoint:</b> {@code POST /open-api/intent-ticket/v1/generate-pre-upload-url}
     * <p><b>Weight:</b> 1
     *
     * @param request the pre-upload URL generation request parameters (required)
     * @return ApiResponse containing the pre-signed upload URLs
     * @throws ApiException if the API call fails
     * @throws IllegalArgumentException if request is null or invalid
     * 
     * @see GeneratePreUploadUrlRequest
     * @see PreUploadUrlResponse
     */
    public ApiResponse<PreUploadUrlResponse> generatePreUploadUrl(GeneratePreUploadUrlRequest request) throws ApiException {
        return intentTicketApi.generatePreUploadUrl(request);
    }

    /**
     * Gets the underlying IntentTicketApi instance.
     * 
     * <p>This method provides access to the low-level IntentTicketApi for advanced use cases
     * that require direct access to the API client functionality.
     *
     * @return the IntentTicketApi instance
     */
    public IntentTicketApi getIntentTicketApi() {
        return intentTicketApi;
    }
}
