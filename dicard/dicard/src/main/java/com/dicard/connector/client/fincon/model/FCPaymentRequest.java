package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class FCPaymentRequest {
    @SerializedName("externalTranId") private String externalTranId;
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("amount") private BigDecimal amount;
    @SerializedName("currency") private String currency;
    @SerializedName("remark") private String remark;

    public FCPaymentRequest() {}
    public String getExternalTranId() { return externalTranId; }
    public FCPaymentRequest setExternalTranId(String v) { this.externalTranId = v; return this; }
    public String getExternalUserId() { return externalUserId; }
    public FCPaymentRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public BigDecimal getAmount() { return amount; }
    public FCPaymentRequest setAmount(BigDecimal v) { this.amount = v; return this; }
    public String getCurrency() { return currency; }
    public FCPaymentRequest setCurrency(String v) { this.currency = v; return this; }
    public String getRemark() { return remark; }
    public FCPaymentRequest setRemark(String v) { this.remark = v; return this; }

    public void validate() {
        if (externalTranId == null || externalTranId.trim().isEmpty()) throw new IllegalArgumentException("externalTranId is required");
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("amount must be positive");
        if (currency == null || currency.trim().isEmpty()) throw new IllegalArgumentException("currency is required");
    }
    @Override public String toString() { return "FCPaymentRequest{externalTranId='" + externalTranId + "', amount=" + amount + "}"; }
}
