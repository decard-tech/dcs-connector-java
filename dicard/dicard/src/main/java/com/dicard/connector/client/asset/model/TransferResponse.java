package com.dicard.connector.client.asset.model;

import com.google.gson.annotations.SerializedName;

/**
 * Asset transfer response.
 */
public class TransferResponse {

    @SerializedName("externalTranId")
    private String externalTranId;

    @SerializedName("asset")
    private String asset;

    @SerializedName("amount")
    private String amount;

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("direction")
    private String direction;

    @SerializedName("remark")
    private String remark;

    @SerializedName("status")
    private String status;

    @SerializedName("tranId")
    private Long tranId;

    public TransferResponse() {}

    public String getExternalTranId() { return externalTranId; }
    public TransferResponse setExternalTranId(String externalTranId) { this.externalTranId = externalTranId; return this; }
    public String getAsset() { return asset; }
    public TransferResponse setAsset(String asset) { this.asset = asset; return this; }
    public String getAmount() { return amount; }
    public TransferResponse setAmount(String amount) { this.amount = amount; return this; }
    public String getExternalUserId() { return externalUserId; }
    public TransferResponse setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getDirection() { return direction; }
    public TransferResponse setDirection(String direction) { this.direction = direction; return this; }
    public String getRemark() { return remark; }
    public TransferResponse setRemark(String remark) { this.remark = remark; return this; }
    public String getStatus() { return status; }
    public TransferResponse setStatus(String status) { this.status = status; return this; }
    public Long getTranId() { return tranId; }
    public TransferResponse setTranId(Long tranId) { this.tranId = tranId; return this; }

    @Override
    public String toString() {
        return "TransferResponse{externalTranId='" + externalTranId + "', status='" + status + "'}";
    }
}
