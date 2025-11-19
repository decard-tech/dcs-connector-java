/*
 * dcs Java Connector
 * Replace card order request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for creating a card replacement order.
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ReplaceCardOrderRequest {

    /**
     * Card order idempotency field
     */
    @SerializedName("cardOrderRef")
    private String cardOrderRef;

    /**
     * Replace card ID
     */
    @SerializedName("replaceCardId")
    private String replaceCardId;

    public ReplaceCardOrderRequest() {
    }

    public ReplaceCardOrderRequest(String cardOrderRef, String replaceCardId) {
        this.cardOrderRef = cardOrderRef;
        this.replaceCardId = replaceCardId;
    }

    public String getCardOrderRef() {
        return cardOrderRef;
    }

    public ReplaceCardOrderRequest setCardOrderRef(String cardOrderRef) {
        this.cardOrderRef = cardOrderRef;
        return this;
    }

    public String getReplaceCardId() {
        return replaceCardId;
    }

    public ReplaceCardOrderRequest setReplaceCardId(String replaceCardId) {
        this.replaceCardId = replaceCardId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplaceCardOrderRequest that = (ReplaceCardOrderRequest) o;
        return Objects.equals(cardOrderRef, that.cardOrderRef) && Objects.equals(replaceCardId, that.replaceCardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardOrderRef, replaceCardId);
    }

    @Override
    public String toString() {
        return "ReplaceCardOrderRequest{" +
                "cardOrderRef='" + cardOrderRef + '\'' +
                ", replaceCardId='" + replaceCardId + '\'' +
                '}';
    }
}
