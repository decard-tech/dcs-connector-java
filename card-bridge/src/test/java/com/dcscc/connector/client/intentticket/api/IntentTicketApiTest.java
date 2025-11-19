/*
 * dcs Java Connector
 * Intent Ticket API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.intentticket.model.CreateIntentTicketRequest;
import com.dcscc.connector.client.intentticket.model.GeneratePreUploadUrlRequest;
import com.dcscc.connector.client.intentticket.model.IntentTicketResponse;
import com.dcscc.connector.client.intentticket.model.PreUploadUrlResponse;
import com.dcscc.connector.client.common.ApiClient;
import com.dcscc.connector.client.common.ApiResponse;
import com.dcscc.connector.client.common.exception.ApiException;
import okhttp3.Call;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * API tests for IntentTicketApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class IntentTicketApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private IntentTicketApi intentTicketApi;

    @BeforeEach
    public void setUp() {
        intentTicketApi = new IntentTicketApi(apiClient);
    }

    /**
     * Test createIntentTicket method
     */
    @Test
    public void createIntentTicketTest() throws ApiException {
        CreateIntentTicketRequest request = new CreateIntentTicketRequest();
        IntentTicketResponse expectedResponse = new IntentTicketResponse();
        ApiResponse<IntentTicketResponse> mockResponse = new ApiResponse<>(201, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, IntentTicketResponse.class)).thenReturn(mockResponse);

        ApiResponse<IntentTicketResponse> response = intentTicketApi.createIntentTicket(request);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/intent-ticket/v1/create", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test createIntentTicket with null request
     */
    @Test
    public void createIntentTicketWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            intentTicketApi.createIntentTicket(null);
        });

        assertEquals("Missing the required parameter 'request' when calling createIntentTicket", exception.getMessage());
    }

    /**
     * Test getIntentTicketDetail method with ticketId
     */
    @Test
    public void getIntentTicketDetailWithTicketIdTest() throws ApiException {
        String ticketId = "ticket123";
        String ticketRef = null;
        IntentTicketResponse expectedResponse = new IntentTicketResponse();
        ApiResponse<IntentTicketResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, IntentTicketResponse.class)).thenReturn(mockResponse);

        ApiResponse<IntentTicketResponse> response = intentTicketApi.getIntentTicketDetail(ticketId, ticketRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/intent-ticket/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getIntentTicketDetail method with ticketRef
     */
    @Test
    public void getIntentTicketDetailWithTicketRefTest() throws ApiException {
        String ticketId = null;
        String ticketRef = "ref123";
        IntentTicketResponse expectedResponse = new IntentTicketResponse();
        ApiResponse<IntentTicketResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, IntentTicketResponse.class)).thenReturn(mockResponse);

        ApiResponse<IntentTicketResponse> response = intentTicketApi.getIntentTicketDetail(ticketId, ticketRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/intent-ticket/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getIntentTicketDetail method with both parameters
     */
    @Test
    public void getIntentTicketDetailWithBothParametersTest() throws ApiException {
        String ticketId = "ticket123";
        String ticketRef = "ref123";
        IntentTicketResponse expectedResponse = new IntentTicketResponse();
        ApiResponse<IntentTicketResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, IntentTicketResponse.class)).thenReturn(mockResponse);

        ApiResponse<IntentTicketResponse> response = intentTicketApi.getIntentTicketDetail(ticketId, ticketRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/intent-ticket/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getIntentTicketDetail with both parameters null
     */
    @Test
    public void getIntentTicketDetailWithNullParametersTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            intentTicketApi.getIntentTicketDetail(null, null);
        });

        assertEquals("At least one of 'ticketId' or 'ticketRef' must be provided", exception.getMessage());
    }

    /**
     * Test generatePreUploadUrl method
     */
    @Test
    public void generatePreUploadUrlTest() throws ApiException {
        GeneratePreUploadUrlRequest request = new GeneratePreUploadUrlRequest();
        PreUploadUrlResponse expectedResponse = new PreUploadUrlResponse();
        ApiResponse<PreUploadUrlResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, PreUploadUrlResponse.class)).thenReturn(mockResponse);

        ApiResponse<PreUploadUrlResponse> response = intentTicketApi.generatePreUploadUrl(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/intent-ticket/v1/generate-pre-upload-url", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test generatePreUploadUrl with null request
     */
    @Test
    public void generatePreUploadUrlWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            intentTicketApi.generatePreUploadUrl(null);
        });

        assertEquals("Missing the required parameter 'request' when calling generatePreUploadUrl", exception.getMessage());
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        CreateIntentTicketRequest request = new CreateIntentTicketRequest();
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, IntentTicketResponse.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            intentTicketApi.createIntentTicket(request);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
