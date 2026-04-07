package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to bind invite relationship.
 */
public class BindInviteRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("externalInviterUserId")
    private String externalInviterUserId;

    public BindInviteRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public BindInviteRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getExternalInviterUserId() { return externalInviterUserId; }
    public BindInviteRequest setExternalInviterUserId(String externalInviterUserId) { this.externalInviterUserId = externalInviterUserId; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (externalInviterUserId == null || externalInviterUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalInviterUserId is required");
        }
    }

    @Override
    public String toString() {
        return "BindInviteRequest{externalUserId='" + externalUserId + "', externalInviterUserId='" + externalInviterUserId + "'}";
    }
}
