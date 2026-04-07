package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class FCWithdrawalRequest {
    @SerializedName("externalTranId") private String externalTranId;
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("amount") private BigDecimal amount;
    @SerializedName("currency") private String currency;
    @SerializedName("payeeName") private String payeeName;
    @SerializedName("payeeAddress") private String payeeAddress;
    @SerializedName("payeeBankAccountNo") private String payeeBankAccountNo;
    @SerializedName("payeeBankSwiftBic") private String payeeBankSwiftBic;
    @SerializedName("payeeBankCountryCode") private String payeeBankCountryCode;
    @SerializedName("purposeOfPayment") private String purposeOfPayment;

    public FCWithdrawalRequest() {}
    public String getExternalTranId() { return externalTranId; }
    public FCWithdrawalRequest setExternalTranId(String v) { this.externalTranId = v; return this; }
    public String getExternalUserId() { return externalUserId; }
    public FCWithdrawalRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public BigDecimal getAmount() { return amount; }
    public FCWithdrawalRequest setAmount(BigDecimal v) { this.amount = v; return this; }
    public String getCurrency() { return currency; }
    public FCWithdrawalRequest setCurrency(String v) { this.currency = v; return this; }
    public String getPayeeName() { return payeeName; }
    public FCWithdrawalRequest setPayeeName(String v) { this.payeeName = v; return this; }
    public String getPayeeAddress() { return payeeAddress; }
    public FCWithdrawalRequest setPayeeAddress(String v) { this.payeeAddress = v; return this; }
    public String getPayeeBankAccountNo() { return payeeBankAccountNo; }
    public FCWithdrawalRequest setPayeeBankAccountNo(String v) { this.payeeBankAccountNo = v; return this; }
    public String getPayeeBankSwiftBic() { return payeeBankSwiftBic; }
    public FCWithdrawalRequest setPayeeBankSwiftBic(String v) { this.payeeBankSwiftBic = v; return this; }
    public String getPayeeBankCountryCode() { return payeeBankCountryCode; }
    public FCWithdrawalRequest setPayeeBankCountryCode(String v) { this.payeeBankCountryCode = v; return this; }
    public String getPurposeOfPayment() { return purposeOfPayment; }
    public FCWithdrawalRequest setPurposeOfPayment(String v) { this.purposeOfPayment = v; return this; }

    public void validate() {
        if (externalTranId == null || externalTranId.trim().isEmpty()) throw new IllegalArgumentException("externalTranId is required");
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("amount must be positive");
        if (currency == null || currency.trim().isEmpty()) throw new IllegalArgumentException("currency is required");
        if (payeeName == null || payeeName.trim().isEmpty()) throw new IllegalArgumentException("payeeName is required");
        if (payeeBankAccountNo == null || payeeBankAccountNo.trim().isEmpty()) throw new IllegalArgumentException("payeeBankAccountNo is required");
        if (payeeBankSwiftBic == null || payeeBankSwiftBic.trim().isEmpty()) throw new IllegalArgumentException("payeeBankSwiftBic is required");
    }
    @Override public String toString() { return "FCWithdrawalRequest{externalTranId='" + externalTranId + "', amount=" + amount + "}"; }
}
