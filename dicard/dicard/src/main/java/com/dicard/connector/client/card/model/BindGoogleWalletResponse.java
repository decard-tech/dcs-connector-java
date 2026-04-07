package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response for Google Wallet binding.
 */
public class BindGoogleWalletResponse {

    @SerializedName("last4")
    private String last4;

    @SerializedName("opaquePaymentCard")
    private String opaquePaymentCard;

    @SerializedName("vCardID")
    private String vCardID;

    public BindGoogleWalletResponse() {}

    public String getLast4() { return last4; }
    public BindGoogleWalletResponse setLast4(String last4) { this.last4 = last4; return this; }
    public String getOpaquePaymentCard() { return opaquePaymentCard; }
    public BindGoogleWalletResponse setOpaquePaymentCard(String opaquePaymentCard) { this.opaquePaymentCard = opaquePaymentCard; return this; }
    public String getVCardID() { return vCardID; }
    public BindGoogleWalletResponse setVCardID(String vCardID) { this.vCardID = vCardID; return this; }

    @Override
    public String toString() {
        return "BindGoogleWalletResponse{last4='" + last4 + "', vCardID='" + vCardID + "'}";
    }
}
