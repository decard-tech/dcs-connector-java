package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request for querying card transactions.
 */
public class CardTransactionsRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("startTime")
    private String startTime;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("page")
    private Integer page;

    @SerializedName("size")
    private Integer size;

    @SerializedName("type")
    private String type;

    public CardTransactionsRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public CardTransactionsRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public CardTransactionsRequest setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public String getStartTime() { return startTime; }
    public CardTransactionsRequest setStartTime(String startTime) { this.startTime = startTime; return this; }
    public String getEndTime() { return endTime; }
    public CardTransactionsRequest setEndTime(String endTime) { this.endTime = endTime; return this; }
    public Integer getPage() { return page; }
    public CardTransactionsRequest setPage(Integer page) { this.page = page; return this; }
    public Integer getSize() { return size; }
    public CardTransactionsRequest setSize(Integer size) { this.size = size; return this; }
    public String getType() { return type; }
    public CardTransactionsRequest setType(String type) { this.type = type; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
    }

    @Override
    public String toString() {
        return "CardTransactionsRequest{externalUserId='" + externalUserId + "', page=" + page + ", size=" + size + "}";
    }
}
