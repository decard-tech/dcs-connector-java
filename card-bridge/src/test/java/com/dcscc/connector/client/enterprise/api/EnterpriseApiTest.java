/*
 * dcs Java Connector
 * Enterprise API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.enterprise.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.enterprise.model.BalanceResponse;
import com.dcscc.connector.client.enterprise.model.SettlementFileType;
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
 * API tests for EnterpriseApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class EnterpriseApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private EnterpriseApi enterpriseApi;

    @BeforeEach
    public void setUp() {
        enterpriseApi = new EnterpriseApi(apiClient);
    }

    /**
     * Test getEnterpriseBalance method
     */
    @Test
    public void getEnterpriseBalanceTest() throws ApiException {
        String currency = "USD";
        BalanceResponse expectedResponse = new BalanceResponse();
        ApiResponse<BalanceResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, BalanceResponse.class)).thenReturn(mockResponse);

        ApiResponse<BalanceResponse> response = enterpriseApi.getEnterpriseBalance(currency);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/enterprise/v1/enterprise-balance", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getEnterpriseBalance with null currency
     */
    @Test
    public void getEnterpriseBalanceWithNullCurrencyTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            enterpriseApi.getEnterpriseBalance(null);
        });

        assertEquals("Missing the required parameter 'currency' when calling getEnterpriseBalance", exception.getMessage());
    }

    /**
     * Test getSettlementFileUrl method with String parameters
     */
    @Test
    public void getSettlementFileUrlWithStringTest() throws ApiException {
        String fileType = "transaction";
        String fileDate = "20231225";
        String expectedResponse = "https://example.com/file.csv";
        ApiResponse<String> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, String.class)).thenReturn(mockResponse);

        ApiResponse<String> response = enterpriseApi.getSettlementFileUrl(fileType, fileDate);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/enterprise/v1/settlement-file-url", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getSettlementFileUrl method with enum parameter
     */
    @Test
    public void getSettlementFileUrlWithEnumTest() throws ApiException {
        SettlementFileType fileType = SettlementFileType.TRANSACTION;
        String fileDate = "20231225";
        String expectedResponse = "https://example.com/file.csv";
        ApiResponse<String> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, String.class)).thenReturn(mockResponse);

        ApiResponse<String> response = enterpriseApi.getSettlementFileUrl(fileType, fileDate);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/enterprise/v1/settlement-file-url", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getSettlementFileUrl with null fileType
     */
    @Test
    public void getSettlementFileUrlWithNullFileTypeTest() {
        String fileDate = "20231225";
        
        ApiException exception = assertThrows(ApiException.class, () -> {
            enterpriseApi.getSettlementFileUrl((String) null, fileDate);
        });

        assertEquals("Missing the required parameter 'fileType' when calling getSettlementFileUrl", exception.getMessage());
    }

    /**
     * Test getSettlementFileUrl with null fileDate
     */
    @Test
    public void getSettlementFileUrlWithNullFileDateTest() {
        String fileType = "transaction";
        
        ApiException exception = assertThrows(ApiException.class, () -> {
            enterpriseApi.getSettlementFileUrl(fileType, null);
        });

        assertEquals("Missing the required parameter 'fileDate' when calling getSettlementFileUrl", exception.getMessage());
    }

    /**
     * Test getSettlementFileUrl with both parameters null
     */
    @Test
    public void getSettlementFileUrlWithBothNullTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            enterpriseApi.getSettlementFileUrl((String) null, null);
        });

        assertEquals("Missing the required parameter 'fileType' when calling getSettlementFileUrl", exception.getMessage());
    }

    /**
     * Test getApiClient method
     */
    @Test
    public void getApiClientTest() {
        ApiClient result = enterpriseApi.getApiClient();
        assertEquals(apiClient, result);
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        String currency = "USD";
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, BalanceResponse.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            enterpriseApi.getEnterpriseBalance(currency);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
