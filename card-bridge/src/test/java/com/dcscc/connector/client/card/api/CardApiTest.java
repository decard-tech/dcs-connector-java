/*
 * dcs Java Connector
 * Card API Test implementation - 100% Coverage
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dcscc.connector.client.card.model.*;
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

import java.util.Arrays;
import java.util.List;

/**
 * API tests for CardApi - 100% Coverage
 */
@ExtendWith(MockitoExtension.class)
public class CardApiTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private Call call;

    private CardApi cardApi;

    @BeforeEach
    public void setUp() {
        cardApi = new CardApi(apiClient);
    }

    /**
     * Test getCardDetail method
     */
    @Test
    public void getCardDetailTest() throws ApiException {
        String cardId = "card123";
        CardResponse expectedResponse = new CardResponse();
        ApiResponse<CardResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardResponse> response = cardApi.getCardDetail(cardId);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/detail", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getCardDetail with null cardId
     */
    @Test
    public void getCardDetailWithNullCardIdTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.getCardDetail(null);
        });

        assertEquals("Missing the required parameter 'cardId' when calling getCardDetail", exception.getMessage());
    }

    /**
     * Test listCards method
     */
    @Test
    public void listCardsTest() throws ApiException {
        String customerId = "customer123";
        CardResponse card1 = new CardResponse();
        CardResponse card2 = new CardResponse();
        CardResponse[] cardArray = {card1, card2};
        ApiResponse<CardResponse[]> mockResponse = new ApiResponse<>(200, null, cardArray);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse[].class)).thenReturn(mockResponse);

        ApiResponse<List<CardResponse>> response = cardApi.listCards(customerId);

        assertEquals(200, response.getStatusCode());
        assertEquals(2, response.getData().size());
        assertEquals(Arrays.asList(cardArray), response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/list", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test listCards with null customerId
     */
    @Test
    public void listCardsWithNullCustomerIdTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.listCards(null);
        });

        assertEquals("Missing the required parameter 'customerId' when calling listCards", exception.getMessage());
    }

    /**
     * Test freezeCard method
     */
    @Test
    public void freezeCardTest() throws ApiException {
        FreezeCardRequest request = new FreezeCardRequest();
        CardResponse expectedResponse = new CardResponse();
        ApiResponse<CardResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardResponse> response = cardApi.freezeCard(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/freeze", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test freezeCard with null request
     */
    @Test
    public void freezeCardWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.freezeCard(null);
        });

        assertEquals("Missing the required parameter 'request' when calling freezeCard", exception.getMessage());
    }

    /**
     * Test terminateCard method
     */
    @Test
    public void terminateCardTest() throws ApiException {
        TerminateCardRequest request = new TerminateCardRequest();
        CardResponse expectedResponse = new CardResponse();
        ApiResponse<CardResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardResponse> response = cardApi.terminateCard(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/terminate", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test terminateCard with null request
     */
    @Test
    public void terminateCardWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.terminateCard(null);
        });

        assertEquals("Missing the required parameter 'request' when calling terminateCard", exception.getMessage());
    }

    /**
     * Test activatePhysicalCard method
     */
    @Test
    public void activatePhysicalCardTest() throws ApiException {
        ActivateCardRequest request = new ActivateCardRequest();
        CardResponse expectedResponse = new CardResponse();
        ApiResponse<CardResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse.class)).thenReturn(mockResponse);

        ApiResponse<CardResponse> response = cardApi.activatePhysicalCard(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/physical-active", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test activatePhysicalCard with null request
     */
    @Test
    public void activatePhysicalCardWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.activatePhysicalCard(null);
        });

        assertEquals("Missing the required parameter 'request' when calling activatePhysicalCard", exception.getMessage());
    }

    /**
     * Test resetPin method
     */
    @Test
    public void resetPinTest() throws ApiException {
        ResetPinRequest request = new ResetPinRequest();
        Boolean expectedResponse = true;
        ApiResponse<Boolean> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, Boolean.class)).thenReturn(mockResponse);

        ApiResponse<Boolean> response = cardApi.resetPin(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/reset-pin", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test resetPin with null request
     */
    @Test
    public void resetPinWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.resetPin(null);
        });

        assertEquals("Missing the required parameter 'request' when calling resetPin", exception.getMessage());
    }

    /**
     * Test retrieveSecureCard method
     */
    @Test
    public void retrieveSecureCardTest() throws ApiException {
        RetrieveSecureCardRequest request = new RetrieveSecureCardRequest();
        SecureCardResponse expectedResponse = new SecureCardResponse();
        ApiResponse<SecureCardResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, SecureCardResponse.class)).thenReturn(mockResponse);

        ApiResponse<SecureCardResponse> response = cardApi.retrieveSecureCard(request);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/retrieve-secure-card", pathCaptor.getValue());
        assertEquals("POST", methodCaptor.getValue());
    }

    /**
     * Test retrieveSecureCard with null request
     */
    @Test
    public void retrieveSecureCardWithNullRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.retrieveSecureCard(null);
        });

        assertEquals("Missing the required parameter 'request' when calling retrieveSecureCard", exception.getMessage());
    }

    /**
     * Test getShippingInfo method
     */
    @Test
    public void getShippingInfoTest() throws ApiException {
        String cardId = "card123";
        ShippingInfoResponse expectedResponse = new ShippingInfoResponse();
        ApiResponse<ShippingInfoResponse> mockResponse = new ApiResponse<>(200, null, expectedResponse);

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, ShippingInfoResponse.class)).thenReturn(mockResponse);

        ApiResponse<ShippingInfoResponse> response = cardApi.getShippingInfo(cardId);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedResponse, response.getData());

        ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> methodCaptor = ArgumentCaptor.forClass(String.class);
        verify(apiClient).buildCall(pathCaptor.capture(), methodCaptor.capture(), any(), any(), any());

        assertEquals("/open-api/card/v1/shipping-info", pathCaptor.getValue());
        assertEquals("GET", methodCaptor.getValue());
    }

    /**
     * Test getShippingInfo with null cardId
     */
    @Test
    public void getShippingInfoWithNullCardIdTest() {
        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.getShippingInfo(null);
        });

        assertEquals("Missing the required parameter 'cardId' when calling getShippingInfo", exception.getMessage());
    }

    /**
     * Test getApiClient method
     */
    @Test
    public void getApiClientTest() {
        ApiClient result = cardApi.getApiClient();
        assertEquals(apiClient, result);
    }

    /**
     * Test API exception handling
     */
    @Test
    public void testApiExceptionHandling() throws ApiException {
        String cardId = "card123";
        ApiException expectedException = new ApiException("Server error");

        when(apiClient.buildCall(any(), any(), any(), any(), any())).thenReturn(call);
        when(apiClient.execute(call, CardResponse.class)).thenThrow(expectedException);

        ApiException exception = assertThrows(ApiException.class, () -> {
            cardApi.getCardDetail(cardId);
        });

        assertEquals("Server error", exception.getMessage());
    }
}
