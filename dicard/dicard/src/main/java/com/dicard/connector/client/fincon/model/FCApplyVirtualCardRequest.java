package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;

public class FCApplyVirtualCardRequest {
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("categoryId") private Long categoryId;
    @SerializedName("applyRef") private String applyRef;
    @SerializedName("kybInfo") private Object kybInfo;

    public FCApplyVirtualCardRequest() {}
    public String getExternalUserId() { return externalUserId; }
    public FCApplyVirtualCardRequest setExternalUserId(String v) { this.externalUserId = v; return this; }
    public Long getCategoryId() { return categoryId; }
    public FCApplyVirtualCardRequest setCategoryId(Long v) { this.categoryId = v; return this; }
    public String getApplyRef() { return applyRef; }
    public FCApplyVirtualCardRequest setApplyRef(String v) { this.applyRef = v; return this; }
    public Object getKybInfo() { return kybInfo; }
    public FCApplyVirtualCardRequest setKybInfo(Object v) { this.kybInfo = v; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) throw new IllegalArgumentException("externalUserId is required");
        if (categoryId == null) throw new IllegalArgumentException("categoryId is required");
        if (applyRef == null || applyRef.trim().isEmpty()) throw new IllegalArgumentException("applyRef is required");
        if (kybInfo == null) throw new IllegalArgumentException("kybInfo is required");
    }
    @Override public String toString() { return "FCApplyVirtualCardRequest{externalUserId='" + externalUserId + "', categoryId=" + categoryId + "}"; }
}
