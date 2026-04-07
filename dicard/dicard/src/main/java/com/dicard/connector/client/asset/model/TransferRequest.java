package com.dicard.connector.client.asset.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * Asset transfer request (credit/debit).
 */
public class TransferRequest {

    @SerializedName("externalTranId")
    private String externalTranId;

    @SerializedName("asset")
    private String asset;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("remark")
    private String remark;

    public TransferRequest() {}

    public String getExternalTranId() { return externalTranId; }
    public TransferRequest setExternalTranId(String externalTranId) { this.externalTranId = externalTranId; return this; }
    public String getAsset() { return asset; }
    public TransferRequest setAsset(String asset) { this.asset = asset; return this; }
    public BigDecimal getAmount() { return amount; }
    public TransferRequest setAmount(BigDecimal amount) { this.amount = amount; return this; }
    public String getExternalUserId() { return externalUserId; }
    public TransferRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getRemark() { return remark; }
    public TransferRequest setRemark(String remark) { this.remark = remark; return this; }

    public void validate() {
        if (externalTranId == null || externalTranId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalTranId is required");
        }
        if (asset == null || asset.trim().isEmpty()) {
            throw new IllegalArgumentException("asset is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
    }

    @Override
    public String toString() {
        return "TransferRequest{externalTranId='" + externalTranId + "', asset='" + asset + "', amount=" + amount + "}";
    }
}
