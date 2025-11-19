/*
 * CardBridge Java Connector
 * Intent Ticket API implementation
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.api;

import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.Pair;
import com.dcscc.connector.client.common.exception.ApiException;
import com.dcscc.connector.client.intentticket.model.CreateIntentTicketRequest;
import com.dcscc.connector.client.intentticket.model.GeneratePreUploadUrlRequest;
import com.dcscc.connector.client.intentticket.model.IntentTicketResponse;
import com.dcscc.connector.client.intentticket.model.PreUploadUrlResponse;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;

/**
 * Intent Ticket API implementation
 */
public class IntentTicketApi {
    
    private final ApiClient apiClient;
    
    public IntentTicketApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    /**
     * Create intent ticket
     * 
     * @param request Create intent ticket request (required)
     * @return ApiResponse&lt;IntentTicketResponse&gt;
     * @throws ApiException If fail to call the API
     */
    public ApiResponse<IntentTicketResponse> createIntentTicket(CreateIntentTicketRequest request) throws ApiException {
        Call call = createIntentTicketCall(request);
        return apiClient.execute(call, IntentTicketResponse.class);
    }
    
    /**
     * Get intent ticket detail
     * 
     * @param ticketId Ticket ID (optional)
     * @param ticketRef Ticket reference (optional)
     * @return ApiResponse&lt;IntentTicketResponse&gt;
     * @throws ApiException If fail to call the API
     */
    public ApiResponse<IntentTicketResponse> getIntentTicketDetail(String ticketId, String ticketRef) throws ApiException {
        Call call = getIntentTicketDetailCall(ticketId, ticketRef);
        return apiClient.execute(call, IntentTicketResponse.class);
    }
    
    /**
     * Generate pre-upload URL
     * 
     * @param request Generate pre-upload URL request (required)
     * @return ApiResponse&lt;PreUploadUrlResponse&gt;
     * @throws ApiException If fail to call the API
     */
    public ApiResponse<PreUploadUrlResponse> generatePreUploadUrl(GeneratePreUploadUrlRequest request) throws ApiException {
        Call call = generatePreUploadUrlCall(request);
        return apiClient.execute(call, PreUploadUrlResponse.class);
    }
    
    // Private methods for building calls
    private Call createIntentTicketCall(CreateIntentTicketRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling createIntentTicket");
        }

        return apiClient.buildCall(
            "/open-api/intent-ticket/v1/create",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }
    
    private Call getIntentTicketDetailCall(String ticketId, String ticketRef) throws ApiException {
        if (ticketId == null && ticketRef == null) {
            throw new ApiException("At least one of 'ticketId' or 'ticketRef' must be provided");
        }

        List<Pair> queryParams = new ArrayList<>();
        if (ticketId != null) {
            queryParams.addAll(apiClient.parameterToPair("ticketId", ticketId));
        }
        if (ticketRef != null) {
            queryParams.addAll(apiClient.parameterToPair("ticketRef", ticketRef));
        }

        return apiClient.buildCall(
            "/open-api/intent-ticket/v1/detail",
            "GET",
            queryParams,
            null,
            new String[]{}
        );
    }
    
    private Call generatePreUploadUrlCall(GeneratePreUploadUrlRequest request) throws ApiException {
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling generatePreUploadUrl");
        }

        return apiClient.buildCall(
            "/open-api/intent-ticket/v1/generate-pre-upload-url",
            "POST",
            new ArrayList<>(),
            request,
            new String[]{}
        );
    }
}
