package com.dicard.connector.client.crypto.model;

import com.google.gson.annotations.SerializedName;

/**
 * Crypto withdrawal response.
 */
public class WithdrawResponse {

    @SerializedName("withdrawId")
    private String withdrawId;

    @SerializedName("status")
    private String status;

    public WithdrawResponse() {}

    public String getWithdrawId() { return withdrawId; }
    public WithdrawResponse setWithdrawId(String withdrawId) { this.withdrawId = withdrawId; return this; }
    public String getStatus() { return status; }
    public WithdrawResponse setStatus(String status) { this.status = status; return this; }

    @Override
    public String toString() {
        return "WithdrawResponse{withdrawId='" + withdrawId + "', status='" + status + "'}";
    }
}
