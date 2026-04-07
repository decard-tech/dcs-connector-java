package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class FCWithdrawalResponse {
    @SerializedName("externalTranId") private String externalTranId;
    @SerializedName("internalTranId") private String internalTranId;
    @SerializedName("amount") private String amount;
    @SerializedName("feeAmount") private String feeAmount;
    @SerializedName("settleAmount") private String settleAmount;
    @SerializedName("currency") private String currency;
    @SerializedName("withdrawStatus") private String withdrawStatus;
    @SerializedName("settleStatus") private String settleStatus;
    @SerializedName("errorCode") private String errorCode;
    @SerializedName("errorMsg") private String errorMsg;

    public FCWithdrawalResponse() {}
    public String getExternalTranId() { return externalTranId; }
    public FCWithdrawalResponse setExternalTranId(String v) { this.externalTranId = v; return this; }
    public String getInternalTranId() { return internalTranId; }
    public FCWithdrawalResponse setInternalTranId(String v) { this.internalTranId = v; return this; }
    public String getAmount() { return amount; }
    public FCWithdrawalResponse setAmount(String v) { this.amount = v; return this; }
    public String getFeeAmount() { return feeAmount; }
    public FCWithdrawalResponse setFeeAmount(String v) { this.feeAmount = v; return this; }
    public String getSettleAmount() { return settleAmount; }
    public FCWithdrawalResponse setSettleAmount(String v) { this.settleAmount = v; return this; }
    public String getCurrency() { return currency; }
    public FCWithdrawalResponse setCurrency(String v) { this.currency = v; return this; }
    public String getWithdrawStatus() { return withdrawStatus; }
    public FCWithdrawalResponse setWithdrawStatus(String v) { this.withdrawStatus = v; return this; }
    public String getSettleStatus() { return settleStatus; }
    public FCWithdrawalResponse setSettleStatus(String v) { this.settleStatus = v; return this; }
    public String getErrorCode() { return errorCode; }
    public FCWithdrawalResponse setErrorCode(String v) { this.errorCode = v; return this; }
    public String getErrorMsg() { return errorMsg; }
    public FCWithdrawalResponse setErrorMsg(String v) { this.errorMsg = v; return this; }
    @Override public String toString() { return "FCWithdrawalResponse{externalTranId='" + externalTranId + "', withdrawStatus='" + withdrawStatus + "'}"; }
}
