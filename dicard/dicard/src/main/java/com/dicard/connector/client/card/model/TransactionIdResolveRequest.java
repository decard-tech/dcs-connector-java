package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to resolve transaction IDs.
 */
public class TransactionIdResolveRequest {

    @SerializedName("ids")
    private List<String> ids;

    public TransactionIdResolveRequest() {}

    public List<String> getIds() { return ids; }
    public TransactionIdResolveRequest setIds(List<String> ids) { this.ids = ids; return this; }

    public void validate() {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ids cannot be empty");
        }
        if (ids.size() > 100) {
            throw new IllegalArgumentException("max 100 ids per request");
        }
    }

    @Override
    public String toString() {
        return "TransactionIdResolveRequest{ids=" + (ids != null ? ids.size() + " items" : "null") + "}";
    }
}
