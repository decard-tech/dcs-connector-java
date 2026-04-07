package com.dicard.connector.client.crypto.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * Crypto withdrawal request.
 */
public class WithdrawRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("coin")
    private String coin;

    @SerializedName("network")
    private String network;

    @SerializedName("address")
    private String address;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("tag")
    private String tag;

    @SerializedName("addressTag")
    private String addressTag;

    @SerializedName("name")
    private String name;

    @SerializedName("smsCode")
    private String smsCode;

    @SerializedName("fee")
    private BigDecimal fee;

    public WithdrawRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public WithdrawRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getCoin() { return coin; }
    public WithdrawRequest setCoin(String coin) { this.coin = coin; return this; }
    public String getNetwork() { return network; }
    public WithdrawRequest setNetwork(String network) { this.network = network; return this; }
    public String getAddress() { return address; }
    public WithdrawRequest setAddress(String address) { this.address = address; return this; }
    public BigDecimal getAmount() { return amount; }
    public WithdrawRequest setAmount(BigDecimal amount) { this.amount = amount; return this; }
    public String getTag() { return tag; }
    public WithdrawRequest setTag(String tag) { this.tag = tag; return this; }
    public String getAddressTag() { return addressTag; }
    public WithdrawRequest setAddressTag(String addressTag) { this.addressTag = addressTag; return this; }
    public String getName() { return name; }
    public WithdrawRequest setName(String name) { this.name = name; return this; }
    public String getSmsCode() { return smsCode; }
    public WithdrawRequest setSmsCode(String smsCode) { this.smsCode = smsCode; return this; }
    public BigDecimal getFee() { return fee; }
    public WithdrawRequest setFee(BigDecimal fee) { this.fee = fee; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (coin == null || coin.trim().isEmpty()) {
            throw new IllegalArgumentException("coin is required");
        }
        if (network == null || network.trim().isEmpty()) {
            throw new IllegalArgumentException("network is required");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("address is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }

    @Override
    public String toString() {
        return "WithdrawRequest{externalUserId='" + externalUserId + "', coin='" + coin + "', amount=" + amount + "}";
    }
}
