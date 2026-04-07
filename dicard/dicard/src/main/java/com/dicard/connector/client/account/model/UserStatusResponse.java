package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * User status response.
 */
public class UserStatusResponse {

    @SerializedName("forbidWithdraw")
    private Boolean forbidWithdraw;

    @SerializedName("forbidCardTransaction")
    private Boolean forbidCardTransaction;

    public UserStatusResponse() {}

    public Boolean getForbidWithdraw() { return forbidWithdraw; }
    public UserStatusResponse setForbidWithdraw(Boolean forbidWithdraw) { this.forbidWithdraw = forbidWithdraw; return this; }
    public Boolean getForbidCardTransaction() { return forbidCardTransaction; }
    public UserStatusResponse setForbidCardTransaction(Boolean forbidCardTransaction) { this.forbidCardTransaction = forbidCardTransaction; return this; }

    @Override
    public String toString() {
        return "UserStatusResponse{forbidWithdraw=" + forbidWithdraw + ", forbidCardTransaction=" + forbidCardTransaction + "}";
    }
}
