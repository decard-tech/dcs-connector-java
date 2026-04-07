package com.dicard.connector.client.asset.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * Wallet balance response.
 */
public class WalletBalanceResponse {

    @SerializedName("asset")
    private String asset;

    @SerializedName("logo")
    private String logo;

    @SerializedName("network")
    private String network;

    @SerializedName("free")
    private BigDecimal free;

    @SerializedName("freeze")
    private BigDecimal freeze;

    @SerializedName("total")
    private BigDecimal total;

    public WalletBalanceResponse() {}

    public String getAsset() { return asset; }
    public WalletBalanceResponse setAsset(String asset) { this.asset = asset; return this; }
    public String getLogo() { return logo; }
    public WalletBalanceResponse setLogo(String logo) { this.logo = logo; return this; }
    public String getNetwork() { return network; }
    public WalletBalanceResponse setNetwork(String network) { this.network = network; return this; }
    public BigDecimal getFree() { return free; }
    public WalletBalanceResponse setFree(BigDecimal free) { this.free = free; return this; }
    public BigDecimal getFreeze() { return freeze; }
    public WalletBalanceResponse setFreeze(BigDecimal freeze) { this.freeze = freeze; return this; }
    public BigDecimal getTotal() { return total; }
    public WalletBalanceResponse setTotal(BigDecimal total) { this.total = total; return this; }

    @Override
    public String toString() {
        return "WalletBalanceResponse{asset='" + asset + "', total=" + total + "}";
    }
}
