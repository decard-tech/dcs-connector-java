package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class FCTransferResponse {
    @SerializedName("externalTranId") private String externalTranId;
    @SerializedName("internalTranId") private String internalTranId;
    @SerializedName("amount") private String amount;
    @SerializedName("currency") private String currency;
    @SerializedName("transferStatus") private String transferStatus;
    @SerializedName("errorCode") private String errorCode;
    @SerializedName("errorMsg") private String errorMsg;

    public FCTransferResponse() {}
    public String getExternalTranId() { return externalTranId; }
    public FCTransferResponse setExternalTranId(String v) { this.externalTranId = v; return this; }
    public String getInternalTranId() { return internalTranId; }
    public FCTransferResponse setInternalTranId(String v) { this.internalTranId = v; return this; }
    public String getAmount() { return amount; }
    public FCTransferResponse setAmount(String v) { this.amount = v; return this; }
    public String getCurrency() { return currency; }
    public FCTransferResponse setCurrency(String v) { this.currency = v; return this; }
    public String getTransferStatus() { return transferStatus; }
    public FCTransferResponse setTransferStatus(String v) { this.transferStatus = v; return this; }
    public String getErrorCode() { return errorCode; }
    public FCTransferResponse setErrorCode(String v) { this.errorCode = v; return this; }
    public String getErrorMsg() { return errorMsg; }
    public FCTransferResponse setErrorMsg(String v) { this.errorMsg = v; return this; }
    @Override public String toString() { return "FCTransferResponse{externalTranId='" + externalTranId + "', transferStatus='" + transferStatus + "'}"; }
}
