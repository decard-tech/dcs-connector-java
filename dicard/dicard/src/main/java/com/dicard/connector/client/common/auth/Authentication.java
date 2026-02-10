package com.dicard.connector.client.common.auth;

import com.dicard.connector.client.common.exception.ApiException;

/**
 * Interface for dicard API authentication mechanisms.
 */
public interface Authentication {

    String generateSignature(String timestamp, String nonce, String payload) throws ApiException;
}

