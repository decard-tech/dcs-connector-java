/*
 * dcs Java Connector
 * 3DS API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeRequest;
import com.dcscc.connector.client.authorisation.model.ThreeDSChallengeResponse;
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
 * API tests for ThreeDSApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class ThreeDSApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private ThreeDSApi threeDSApi;

    @BeforeEach
    public void setUp() {
        threeDSApi = new ThreeDSApi(apiClient);
    }

    /**
     * Test authenticate method
     */
    @Test
    public void authenticateTest() throws ApiException {
        ThreeDSChallengeRequest request = new ThreeDSChallengeRequest();
        ThreeDSChallengeResponse expectedResponse = new ThreeDSChallengeResponse();
        ApiResponse<ThreeDSChallengeResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, ThreeDSChallengeResponse.class)).thenReturn(mockResponse);

        ApiResponse<ThreeDSChallengeResponse> response = threeDSApi.authenticate(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/3ds-challenge/v1/authenticate", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test authenticate with null request
     */
    @Test
    public void authenticateWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            threeDSApi.authenticate(null);
        });

        assertEquals("Missing the required parameter 'request' when calling authenticate", exception.getMessage());
    }

    /**
     * Test getApiClient method
     */
    @Test
    public void getApiClientTest() {
        ApiClient result = threeDSApi.getApiClient();
        assertEquals(apiClient, result);
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        ThreeDSChallengeRequest request = new ThreeDSChallengeRequest();
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, ThreeDSChallengeResponse.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            threeDSApi.authenticate(request);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
