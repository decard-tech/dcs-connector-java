package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class QueryTranListResponse {
    @SerializedName("cursor") private String cursor;
    @SerializedName("tranList") private List<Detail> tranList;

    public QueryTranListResponse() {}
    public String getCursor() { return cursor; }
    public QueryTranListResponse setCursor(String v) { this.cursor = v; return this; }
    public List<Detail> getTranList() { return tranList; }
    public QueryTranListResponse setTranList(List<Detail> v) { this.tranList = v; return this; }
    @Override public String toString() { return "QueryTranListResponse{cursor='" + cursor + "', count=" + (tranList != null ? tranList.size() : 0) + "}"; }

    public static class Detail {
        @SerializedName("vaNumber") private String vaNumber;
        @SerializedName("transType") private String transType;
        @SerializedName("amount") private String amount;
        @SerializedName("currency") private String currency;
        @SerializedName("debitCreditIndicator") private String debitCreditIndicator;
        @SerializedName("tranTime") private String tranTime;
        @SerializedName("internalTranId") private String internalTranId;

        public Detail() {}
        public String getVaNumber() { return vaNumber; }
        public Detail setVaNumber(String v) { this.vaNumber = v; return this; }
        public String getTransType() { return transType; }
        public Detail setTransType(String v) { this.transType = v; return this; }
        public String getAmount() { return amount; }
        public Detail setAmount(String v) { this.amount = v; return this; }
        public String getCurrency() { return currency; }
        public Detail setCurrency(String v) { this.currency = v; return this; }
        public String getDebitCreditIndicator() { return debitCreditIndicator; }
        public Detail setDebitCreditIndicator(String v) { this.debitCreditIndicator = v; return this; }
        public String getTranTime() { return tranTime; }
        public Detail setTranTime(String v) { this.tranTime = v; return this; }
        public String getInternalTranId() { return internalTranId; }
        public Detail setInternalTranId(String v) { this.internalTranId = v; return this; }
    }
}
