package com.dicard.connector.client.simulation.model;

import com.google.gson.annotations.SerializedName;

public class SimulationAuthResponse {
    @SerializedName("approved") private Boolean approved;
    @SerializedName("errorCode") private String errorCode;

    public SimulationAuthResponse() {}

    public Boolean getApproved() { return approved; } public SimulationAuthResponse setApproved(Boolean v) { this.approved = v; return this; }
    public String getErrorCode() { return errorCode; } public SimulationAuthResponse setErrorCode(String v) { this.errorCode = v; return this; }

    @Override public String toString() { return "SimulationAuthResponse{approved=" + approved + "}"; }
}
