package com.dicard.connector.client.simulation.model;

import com.google.gson.annotations.SerializedName;

public class SimulationKycTokenRequest {
    @SerializedName("externalUserId") private String externalUserId;

    public SimulationKycTokenRequest() {}

    public String getExternalUserId() { return externalUserId; } public SimulationKycTokenRequest setExternalUserId(String v) { this.externalUserId = v; return this; }

    public void validate() { if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required"); }

    @Override public String toString() { return "SimulationKycTokenRequest{externalUserId='" + externalUserId + "'}"; }
}
