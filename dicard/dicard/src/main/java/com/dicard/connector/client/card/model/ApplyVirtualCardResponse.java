package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response for virtual card application.
 */
public class ApplyVirtualCardResponse {

    @SerializedName("applyId")
    private String applyId;

    @SerializedName("categoryId")
    private Long categoryId;

    @SerializedName("applyRef")
    private String applyRef;

    @SerializedName("status")
    private String status;

    @SerializedName("errorCode")
    private String errorCode;

    @SerializedName("errorReason")
    private String errorReason;

    @SerializedName("needEddFile")
    private Boolean needEddFile;

    @SerializedName("remark")
    private String remark;

    public ApplyVirtualCardResponse() {}

    public String getApplyId() { return applyId; }
    public ApplyVirtualCardResponse setApplyId(String applyId) { this.applyId = applyId; return this; }
    public Long getCategoryId() { return categoryId; }
    public ApplyVirtualCardResponse setCategoryId(Long categoryId) { this.categoryId = categoryId; return this; }
    public String getApplyRef() { return applyRef; }
    public ApplyVirtualCardResponse setApplyRef(String applyRef) { this.applyRef = applyRef; return this; }
    public String getStatus() { return status; }
    public ApplyVirtualCardResponse setStatus(String status) { this.status = status; return this; }
    public String getErrorCode() { return errorCode; }
    public ApplyVirtualCardResponse setErrorCode(String errorCode) { this.errorCode = errorCode; return this; }
    public String getErrorReason() { return errorReason; }
    public ApplyVirtualCardResponse setErrorReason(String errorReason) { this.errorReason = errorReason; return this; }
    public Boolean getNeedEddFile() { return needEddFile; }
    public ApplyVirtualCardResponse setNeedEddFile(Boolean needEddFile) { this.needEddFile = needEddFile; return this; }
    public String getRemark() { return remark; }
    public ApplyVirtualCardResponse setRemark(String remark) { this.remark = remark; return this; }

    @Override
    public String toString() {
        return "ApplyVirtualCardResponse{applyId='" + applyId + "', status='" + status + "', applyRef='" + applyRef + "'}";
    }
}
