package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response for transaction ID resolution.
 */
public class TransactionIdResolveResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("outstandingTransactionId")
    private String outstandingTransactionId;

    @SerializedName("postedTransactionId")
    private String postedTransactionId;

    @SerializedName("posted")
    private Boolean posted;

    public TransactionIdResolveResponse() {}

    public String getId() { return id; }
    public TransactionIdResolveResponse setId(String id) { this.id = id; return this; }
    public String getOutstandingTransactionId() { return outstandingTransactionId; }
    public TransactionIdResolveResponse setOutstandingTransactionId(String outstandingTransactionId) { this.outstandingTransactionId = outstandingTransactionId; return this; }
    public String getPostedTransactionId() { return postedTransactionId; }
    public TransactionIdResolveResponse setPostedTransactionId(String postedTransactionId) { this.postedTransactionId = postedTransactionId; return this; }
    public Boolean getPosted() { return posted; }
    public TransactionIdResolveResponse setPosted(Boolean posted) { this.posted = posted; return this; }

    @Override
    public String toString() {
        return "TransactionIdResolveResponse{id='" + id + "', posted=" + posted + "}";
    }
}
