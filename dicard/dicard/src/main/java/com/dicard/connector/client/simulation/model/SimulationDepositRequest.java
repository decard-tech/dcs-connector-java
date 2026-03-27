package com.dicard.connector.client.simulation.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SimulationDepositRequest {
    @SerializedName("chain") private String chain;
    @SerializedName("currency") private String currency;
    @SerializedName("amount") private BigDecimal amount;
    @SerializedName("address") private String address;

    public SimulationDepositRequest() {}

    public String getChain() { return chain; } public SimulationDepositRequest setChain(String v) { this.chain = v; return this; }
    public String getCurrency() { return currency; } public SimulationDepositRequest setCurrency(String v) { this.currency = v; return this; }
    public BigDecimal getAmount() { return amount; } public SimulationDepositRequest setAmount(BigDecimal v) { this.amount = v; return this; }
    public String getAddress() { return address; } public SimulationDepositRequest setAddress(String v) { this.address = v; return this; }

    public void validate() {
        if (chain == null || chain.trim().isEmpty()) throw new IllegalArgumentException("chain is required");
        if (currency == null || currency.trim().isEmpty()) throw new IllegalArgumentException("currency is required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("amount must be positive");
        if (address == null || address.trim().isEmpty()) throw new IllegalArgumentException("address is required");
    }

    @Override public String toString() { return "SimulationDepositRequest{chain='" + chain + "', amount=" + amount + "}"; }
}
