package com.dicard.connector.client.simulation.model;

import com.google.gson.annotations.SerializedName;

public class SimulationKycTokenResponse {
    @SerializedName("token") private String token;

    public SimulationKycTokenResponse() {}

    public String getToken() { return token; } public SimulationKycTokenResponse setToken(String v) { this.token = v; return this; }

    @Override public String toString() { return "SimulationKycTokenResponse{token='***'}"; }
}
