package com.dicard.connector.client.simulation.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SimulationAuthRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("cardMantissa") private String cardMantissa;
    @SerializedName("authType") private String authType;
    @SerializedName("amount") private BigDecimal amount;
    @SerializedName("currency") private String currency;

    public SimulationAuthRequest() {}

    public String getExternalUserId() { return externalUserId; } public SimulationAuthRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public String getCardMantissa() { return cardMantissa; } public SimulationAuthRequest setCardMantissa(String v) { this.cardMantissa = v; return this; }
    public String getAuthType() { return authType; } public SimulationAuthRequest setAuthType(String v) { this.authType = v; return this; }
    public BigDecimal getAmount() { return amount; } public SimulationAuthRequest setAmount(BigDecimal v) { this.amount = v; return this; }
    public String getCurrency() { return currency; } public SimulationAuthRequest setCurrency(String v) { this.currency = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (cardMantissa == null || cardMantissa.trim().isEmpty()) throw new IllegalArgumentException("cardMantissa is required");
        if (authType == null || authType.trim().isEmpty()) throw new IllegalArgumentException("authType is required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("amount must be positive");
        if (currency == null || currency.trim().isEmpty()) throw new IllegalArgumentException("currency is required");
    }

    @Override public String toString() { return "SimulationAuthRequest{externalUserId='" + externalUserId + "', authType='" + authType + "'}"; }
}
