package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class QueryTranListRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("pageSize") private Integer pageSize;
    @SerializedName("vaNumber") private String vaNumber;
    @SerializedName("cursor") private String cursor;

    public QueryTranListRequest() {}
    public String getExternalUserId() { return externalUserId; }
    public QueryTranListRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public Integer getPageSize() { return pageSize; }
    public QueryTranListRequest setPageSize(Integer v) { this.pageSize = v; return this; }
    public String getVaNumber() { return vaNumber; }
    public QueryTranListRequest setVaNumber(String v) { this.vaNumber = v; return this; }
    public String getCursor() { return cursor; }
    public QueryTranListRequest setCursor(String v) { this.cursor = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (vaNumber == null || vaNumber.trim().isEmpty()) throw new IllegalArgumentException("vaNumber is required");
    }
    @Override public String toString() { return "QueryTranListRequest{externalUserId='" + externalUserId + "', vaNumber='" + vaNumber + "'}"; }
}
