/*
 * dcs Java Connector
 * Card Order API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.card.model.CardOrderResponse;
import com.dcscc.connector.client.card.model.CreateCardOrderRequest;
import com.dcscc.connector.client.card.model.ReplaceCardOrderRequest;
import com.dcscc.connector.client.card.model.VirtualToPhysicalRequest;
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
 * API tests for CardOrderApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class CardOrderApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private CardOrderApi cardOrderApi;

    @BeforeEach
    public void setUp() {
        cardOrderApi = new CardOrderApi(apiClient);
    }

    /**
     * Test createVirtualCardOrder method
     */
    @Test
    public void createVirtualCardOrderTest() throws ApiException {
        CreateCardOrderRequest orderRequest = new CreateCardOrderRequest();
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(201, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.createVirtualCardOrder(orderRequest);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/apply-virtual", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test createVirtualCardOrder with null request
     */
    @Test
    public void createVirtualCardOrderWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardOrderApi.createVirtualCardOrder(null);
        });

        assertEquals("Missing the required parameter 'request' when calling createVirtualCardOrder", exception.getMessage());
    }

    /**
     * Test getCardOrderDetail method with cardOrderId
     */
    @Test
    public void getCardOrderDetailWithCardOrderIdTest() throws ApiException {
        String cardOrderId = "order123";
        String cardOrderRef = null;
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.getCardOrderDetail(cardOrderId, cardOrderRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getCardOrderDetail method with cardOrderRef
     */
    @Test
    public void getCardOrderDetailWithCardOrderRefTest() throws ApiException {
        String cardOrderId = null;
        String cardOrderRef = "ref123";
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.getCardOrderDetail(cardOrderId, cardOrderRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getCardOrderDetail method with both parameters
     */
    @Test
    public void getCardOrderDetailWithBothParametersTest() throws ApiException {
        String cardOrderId = "order123";
        String cardOrderRef = "ref123";
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.getCardOrderDetail(cardOrderId, cardOrderRef);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getCardOrderDetail with both parameters null
     */
    @Test
    public void getCardOrderDetailWithNullParametersTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardOrderApi.getCardOrderDetail(null, null);
        });

        assertEquals("At least one of 'cardOrderId' or 'cardOrderRef' must be provided", exception.getMessage());
    }

    /**
     * Test replaceCard method
     */
    @Test
    public void replaceCardTest() throws ApiException {
        ReplaceCardOrderRequest replaceRequest = new ReplaceCardOrderRequest();
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.replaceCard(replaceRequest);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/replace", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test replaceCard with null request
     */
    @Test
    public void replaceCardWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardOrderApi.replaceCard(null);
        });

        assertEquals("Missing the required parameter 'request' when calling replaceCard", exception.getMessage());
    }

    /**
     * Test virtualToPhysical method
     */
    @Test
    public void virtualToPhysicalTest() throws ApiException {
        VirtualToPhysicalRequest request = new VirtualToPhysicalRequest();
        CardOrderResponse expectedResponse = new CardOrderResponse();
        ApiResponse<CardOrderResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardOrderResponse> response = cardOrderApi.virtualToPhysical(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card-order/v1/virtual-to-physical", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test virtualToPhysical with null request
     */
    @Test
    public void virtualToPhysicalWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardOrderApi.virtualToPhysical(null);
        });

        assertEquals("Missing the required parameter 'request' when calling virtualToPhysical", exception.getMessage());
    }

    /**
     * Test getApiClient method
     */
    @Test
    public void getApiClientTest() {
        ApiClient result = cardOrderApi.getApiClient();
        assertEquals(apiClient, result);
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        CreateCardOrderRequest orderRequest = new CreateCardOrderRequest();
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardOrderResponse.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            cardOrderApi.createVirtualCardOrder(orderRequest);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
