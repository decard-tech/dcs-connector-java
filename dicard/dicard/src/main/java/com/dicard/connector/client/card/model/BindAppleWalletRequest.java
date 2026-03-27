package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to bind Apple Wallet.
 */
public class BindAppleWalletRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("applePublicCertificates")
    private List<String> applePublicCertificates;

    @SerializedName("appleNonce")
    private String appleNonce;

    @SerializedName("appleNonceSignature")
    private String appleNonceSignature;

    public BindAppleWalletRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public BindAppleWalletRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public BindAppleWalletRequest setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public List<String> getApplePublicCertificates() { return applePublicCertificates; }
    public BindAppleWalletRequest setApplePublicCertificates(List<String> applePublicCertificates) { this.applePublicCertificates = applePublicCertificates; return this; }
    public String getAppleNonce() { return appleNonce; }
    public BindAppleWalletRequest setAppleNonce(String appleNonce) { this.appleNonce = appleNonce; return this; }
    public String getAppleNonceSignature() { return appleNonceSignature; }
    public BindAppleWalletRequest setAppleNonceSignature(String appleNonceSignature) { this.appleNonceSignature = appleNonceSignature; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (applePublicCertificates == null || applePublicCertificates.isEmpty()) {
            throw new IllegalArgumentException("applePublicCertificates is required");
        }
        if (appleNonce == null || appleNonce.trim().isEmpty()) {
            throw new IllegalArgumentException("appleNonce is required");
        }
        if (appleNonceSignature == null || appleNonceSignature.trim().isEmpty()) {
            throw new IllegalArgumentException("appleNonceSignature is required");
        }
    }

    @Override
    public String toString() {
        return "BindAppleWalletRequest{externalUserId='" + externalUserId + "', cardMantissa='" + cardMantissa + "'}";
    }
}
