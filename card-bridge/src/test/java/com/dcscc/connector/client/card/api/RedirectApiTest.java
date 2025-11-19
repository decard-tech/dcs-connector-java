/*
 * dcs Java Connector
 * Redirect API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.card.model.GuidanceRequest;
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
 * API tests for RedirectApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class RedirectApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private RedirectApi redirectApi;

    @BeforeEach
    public void setUp() {
        redirectApi = new RedirectApi(apiClient);
    }

    /**
     * Create a valid GuidanceRequest for testing
     */
    private GuidanceRequest createValidGuidanceRequest() {
        GuidanceRequest request = new GuidanceRequest();
        request.setCardId("card123");
        request.setCustomerId("customer123");
        request.setType("1"); // CARD_INFO_QUERY
        request.setOtpStatus("0"); // YES
        request.setLanguage("en");
        request.setTheme("light");
        request.setMode("web");
        request.setUserAgent("Mozilla/5.0");
        return request;
    }

    /**
     * Test getGuidanceUrl method
     */
    @Test
    public void getGuidanceUrlTest() throws ApiException {
        GuidanceRequest request = createValidGuidanceRequest();
        
        String expectedResponse = "https://example.com/guidance";
        ApiResponse<String> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, String.class)).thenReturn(mockResponse);

        ApiResponse<String> response = redirectApi.getGuidanceUrl(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-redirect/v1/guidance-link", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test getGuidanceUrl with null request
     */
    @Test
    public void getGuidanceUrlWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            redirectApi.getGuidanceUrl(null);
        });

        assertEquals("Missing the required parameter 'request' when calling getGuidanceUrl", exception.getMessage());
    }

    /**
     * Test getGuidanceUrl with invalid request (null cardId)
     */
    @Test
    public void getGuidanceUrlWithInvalidRequestTest() {
        GuidanceRequest request = new GuidanceRequest();
        // Don't set cardId, which will cause validation to fail
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            redirectApi.getGuidanceUrl(request);
        });

        assertEquals("Card ID cannot be null or empty", exception.getMessage());
    }

    /**
     * Test getGuidanceUrlCall method directly
     */
    @Test
    public void getGuidanceUrlCallTest() throws ApiException {
        GuidanceRequest request = createValidGuidanceRequest();
        
        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);

        Call result = redirectApi.getGuidanceUrlCall(request);

        assertEquals(call, result);
        verify(apiClient).buildCall(any(), any(), any(), any(), any());
    }

    /**
     * Test getGuidanceUrlCall with null request
     */
    @Test
    public void getGuidanceUrlCallWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            redirectApi.getGuidanceUrlCall(null);
        });

        assertEquals("Missing the required parameter 'request' when calling getGuidanceUrl", exception.getMessage());
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        GuidanceRequest request = createValidGuidanceRequest();
        
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, String.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            redirectApi.getGuidanceUrl(request);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
