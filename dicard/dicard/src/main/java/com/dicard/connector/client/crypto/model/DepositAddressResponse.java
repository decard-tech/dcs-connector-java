package com.dicard.connector.client.crypto.model;

import com.google.gson.annotations.SerializedName;

/**
 * Crypto deposit address response.
 */
public class DepositAddressResponse {

    @SerializedName("address")
    private String address;

    @SerializedName("network")
    private String network;

    @SerializedName("coin")
    private String coin;

    @SerializedName("tag")
    private String tag;

    public DepositAddressResponse() {}

    public String getAddress() { return address; }
    public DepositAddressResponse setAddress(String address) { this.address = address; return this; }
    public String getNetwork() { return network; }
    public DepositAddressResponse setNetwork(String network) { this.network = network; return this; }
    public String getCoin() { return coin; }
    public DepositAddressResponse setCoin(String coin) { this.coin = coin; return this; }
    public String getTag() { return tag; }
    public DepositAddressResponse setTag(String tag) { this.tag = tag; return this; }

    @Override
    public String toString() {
        return "DepositAddressResponse{address='" + address + "', network='" + network + "', coin='" + coin + "'}";
    }
}
