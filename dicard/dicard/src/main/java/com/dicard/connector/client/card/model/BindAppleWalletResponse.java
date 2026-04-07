package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response for Apple Wallet binding.
 */
public class BindAppleWalletResponse {

    @SerializedName("encryptedPassData")
    private String encryptedPassData;

    @SerializedName("activationData")
    private String activationData;

    @SerializedName("ephemeralPublicKey")
    private String ephemeralPublicKey;

    @SerializedName("vCardID")
    private String vCardID;

    public BindAppleWalletResponse() {}

    public String getEncryptedPassData() { return encryptedPassData; }
    public BindAppleWalletResponse setEncryptedPassData(String encryptedPassData) { this.encryptedPassData = encryptedPassData; return this; }
    public String getActivationData() { return activationData; }
    public BindAppleWalletResponse setActivationData(String activationData) { this.activationData = activationData; return this; }
    public String getEphemeralPublicKey() { return ephemeralPublicKey; }
    public BindAppleWalletResponse setEphemeralPublicKey(String ephemeralPublicKey) { this.ephemeralPublicKey = ephemeralPublicKey; return this; }
    public String getVCardID() { return vCardID; }
    public BindAppleWalletResponse setVCardID(String vCardID) { this.vCardID = vCardID; return this; }

    @Override
    public String toString() {
        return "BindAppleWalletResponse{vCardID='" + vCardID + "'}";
    }
}
