package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class FCPaymentResponse {
    @SerializedName("externalTranId") private String externalTranId;
    @SerializedName("internalTranId") private String internalTranId;
    @SerializedName("amount") private String amount;
    @SerializedName("currency") private String currency;
    @SerializedName("paymentStatus") private String paymentStatus;
    @SerializedName("errorCode") private String errorCode;
    @SerializedName("errorMsg") private String errorMsg;
    @SerializedName("settleStatus") private String settleStatus;

    public FCPaymentResponse() {}
    public String getExternalTranId() { return externalTranId; }
    public FCPaymentResponse setExternalTranId(String v) { this.externalTranId = v; return this; }
    public String getInternalTranId() { return internalTranId; }
    public FCPaymentResponse setInternalTranId(String v) { this.internalTranId = v; return this; }
    public String getAmount() { return amount; }
    public FCPaymentResponse setAmount(String v) { this.amount = v; return this; }
    public String getCurrency() { return currency; }
    public FCPaymentResponse setCurrency(String v) { this.currency = v; return this; }
    public String getPaymentStatus() { return paymentStatus; }
    public FCPaymentResponse setPaymentStatus(String v) { this.paymentStatus = v; return this; }
    public String getErrorCode() { return errorCode; }
    public FCPaymentResponse setErrorCode(String v) { this.errorCode = v; return this; }
    public String getErrorMsg() { return errorMsg; }
    public FCPaymentResponse setErrorMsg(String v) { this.errorMsg = v; return this; }
    public String getSettleStatus() { return settleStatus; }
    public FCPaymentResponse setSettleStatus(String v) { this.settleStatus = v; return this; }
    @Override public String toString() { return "FCPaymentResponse{externalTranId='" + externalTranId + "', paymentStatus='" + paymentStatus + "'}"; }
}
