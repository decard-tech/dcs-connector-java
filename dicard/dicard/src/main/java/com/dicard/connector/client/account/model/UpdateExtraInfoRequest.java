package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update user extra information.
 */
public class UpdateExtraInfoRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("virtualCardFullName")
    private String virtualCardFullName;

    public UpdateExtraInfoRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public UpdateExtraInfoRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getVirtualCardFullName() { return virtualCardFullName; }
    public UpdateExtraInfoRequest setVirtualCardFullName(String virtualCardFullName) { this.virtualCardFullName = virtualCardFullName; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (virtualCardFullName == null || virtualCardFullName.trim().isEmpty()) {
            throw new IllegalArgumentException("virtualCardFullName is required");
        }
    }

    @Override
    public String toString() {
        return "UpdateExtraInfoRequest{externalUserId='" + externalUserId + "'}";
    }
}
