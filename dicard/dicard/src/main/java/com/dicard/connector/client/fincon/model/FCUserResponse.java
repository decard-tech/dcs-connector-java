package com.dicard.connector.client.fincon.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;

public class FCUserResponse {
    @SerializedName("userRef") private String userRef;
    @SerializedName("externalUserId") private String externalUserId;
    @SerializedName("vaInfoList") private List<VaInfo> vaInfoList;

    public FCUserResponse() {}
    public String getUserRef() { return userRef; }
    public FCUserResponse setUserRef(String userRef) { this.userRef = userRef; return this; }
    public String getExternalUserId() { return externalUserId; }
    public FCUserResponse setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public List<VaInfo> getVaInfoList() { return vaInfoList; }
    public FCUserResponse setVaInfoList(List<VaInfo> vaInfoList) { this.vaInfoList = vaInfoList; return this; }

    @Override public String toString() { return "FCUserResponse{userRef='" + userRef + "', externalUserId='" + externalUserId + "'}"; }

    public static class VaInfo {
        @SerializedName("vaType") private String vaType;
        @SerializedName("vaNumber") private String vaNumber;
        @SerializedName("currency") private String currency;
        @SerializedName("channelCode") private String channelCode;
        @SerializedName("channelName") private String channelName;
        @SerializedName("channelSwiftCode") private String channelSwiftCode;
        @SerializedName("channelAddressInfo") private String channelAddressInfo;
        @SerializedName("accountBalanceList") private List<AccountBalance> accountBalanceList;

        public VaInfo() {}
        public String getVaType() { return vaType; }
        public VaInfo setVaType(String vaType) { this.vaType = vaType; return this; }
        public String getVaNumber() { return vaNumber; }
        public VaInfo setVaNumber(String vaNumber) { this.vaNumber = vaNumber; return this; }
        public String getCurrency() { return currency; }
        public VaInfo setCurrency(String currency) { this.currency = currency; return this; }
        public String getChannelCode() { return channelCode; }
        public VaInfo setChannelCode(String channelCode) { this.channelCode = channelCode; return this; }
        public String getChannelName() { return channelName; }
        public VaInfo setChannelName(String channelName) { this.channelName = channelName; return this; }
        public String getChannelSwiftCode() { return channelSwiftCode; }
        public VaInfo setChannelSwiftCode(String channelSwiftCode) { this.channelSwiftCode = channelSwiftCode; return this; }
        public String getChannelAddressInfo() { return channelAddressInfo; }
        public VaInfo setChannelAddressInfo(String channelAddressInfo) { this.channelAddressInfo = channelAddressInfo; return this; }
        public List<AccountBalance> getAccountBalanceList() { return accountBalanceList; }
        public VaInfo setAccountBalanceList(List<AccountBalance> accountBalanceList) { this.accountBalanceList = accountBalanceList; return this; }
    }

    public static class AccountBalance {
        @SerializedName("asset") private String asset;
        @SerializedName("free") private BigDecimal free;
        @SerializedName("freeze") private BigDecimal freeze;

        public AccountBalance() {}
        public String getAsset() { return asset; }
        public AccountBalance setAsset(String asset) { this.asset = asset; return this; }
        public BigDecimal getFree() { return free; }
        public AccountBalance setFree(BigDecimal free) { this.free = free; return this; }
        public BigDecimal getFreeze() { return freeze; }
        public AccountBalance setFreeze(BigDecimal freeze) { this.freeze = freeze; return this; }
    }
}
