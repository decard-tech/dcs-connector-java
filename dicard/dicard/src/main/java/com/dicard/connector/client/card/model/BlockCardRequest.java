package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to block or unblock a card.
 */
public class BlockCardRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("block")
    private Boolean block;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("smsCode")
    private String smsCode;

    public BlockCardRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public BlockCardRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public Boolean getBlock() { return block; }
    public BlockCardRequest setBlock(Boolean block) { this.block = block; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public BlockCardRequest setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public String getSmsCode() { return smsCode; }
    public BlockCardRequest setSmsCode(String smsCode) { this.smsCode = smsCode; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (block == null) {
            throw new IllegalArgumentException("block is required");
        }
    }

    @Override
    public String toString() {
        return "BlockCardRequest{externalUserId='" + externalUserId + "', block=" + block + ", cardMantissa='" + cardMantissa + "'}";
    }
}
