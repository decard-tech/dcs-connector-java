package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Card apply record response.
 */
public class CardApplyResponse {

    @SerializedName("applyId")
    private String applyId;

    @SerializedName("categoryId")
    private Long categoryId;

    @SerializedName("network")
    private String network;

    @SerializedName("currency")
    private String currency;

    @SerializedName("applyRef")
    private String applyRef;

    @SerializedName("status")
    private String status;

    @SerializedName("errorCode")
    private String errorCode;

    public CardApplyResponse() {}

    public String getApplyId() { return applyId; }
    public CardApplyResponse setApplyId(String applyId) { this.applyId = applyId; return this; }
    public Long getCategoryId() { return categoryId; }
    public CardApplyResponse setCategoryId(Long categoryId) { this.categoryId = categoryId; return this; }
    public String getNetwork() { return network; }
    public CardApplyResponse setNetwork(String network) { this.network = network; return this; }
    public String getCurrency() { return currency; }
    public CardApplyResponse setCurrency(String currency) { this.currency = currency; return this; }
    public String getApplyRef() { return applyRef; }
    public CardApplyResponse setApplyRef(String applyRef) { this.applyRef = applyRef; return this; }
    public String getStatus() { return status; }
    public CardApplyResponse setStatus(String status) { this.status = status; return this; }
    public String getErrorCode() { return errorCode; }
    public CardApplyResponse setErrorCode(String errorCode) { this.errorCode = errorCode; return this; }

    @Override
    public String toString() {
        return "CardApplyResponse{applyId='" + applyId + "', status='" + status + "', network='" + network + "'}";
    }
}
