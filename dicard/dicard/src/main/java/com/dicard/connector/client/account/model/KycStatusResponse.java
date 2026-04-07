package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * KYC status response.
 *
 * <p>Status values:
 * <ul>
 *   <li>UNDO - KYC not started</li>
 *   <li>INIT - Initial state</li>
 *   <li>PENDING - Under review</li>
 *   <li>PASS - Approved</li>
 *   <li>REFUSE - Rejected</li>
 * </ul>
 */
public class KycStatusResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("statusDescription")
    private String statusDescription;

    @SerializedName("descriptionTimeMillis")
    private Long descriptionTimeMillis;

    public KycStatusResponse() {}

    public String getStatus() { return status; }
    public KycStatusResponse setStatus(String status) { this.status = status; return this; }
    public String getStatusDescription() { return statusDescription; }
    public KycStatusResponse setStatusDescription(String statusDescription) { this.statusDescription = statusDescription; return this; }
    public Long getDescriptionTimeMillis() { return descriptionTimeMillis; }
    public KycStatusResponse setDescriptionTimeMillis(Long descriptionTimeMillis) { this.descriptionTimeMillis = descriptionTimeMillis; return this; }

    @Override
    public String toString() {
        return "KycStatusResponse{status='" + status + "', statusDescription='" + statusDescription + "'}";
    }
}
