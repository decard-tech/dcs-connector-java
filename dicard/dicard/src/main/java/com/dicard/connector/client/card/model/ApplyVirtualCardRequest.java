package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to apply for a virtual card.
 */
public class ApplyVirtualCardRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("categoryId")
    private Long categoryId;

    @SerializedName("applyRef")
    private String applyRef;

    @SerializedName("kycInfo")
    private KycInfo kycInfo;

    public ApplyVirtualCardRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public ApplyVirtualCardRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public Long getCategoryId() { return categoryId; }
    public ApplyVirtualCardRequest setCategoryId(Long categoryId) { this.categoryId = categoryId; return this; }
    public String getApplyRef() { return applyRef; }
    public ApplyVirtualCardRequest setApplyRef(String applyRef) { this.applyRef = applyRef; return this; }
    public KycInfo getKycInfo() { return kycInfo; }
    public ApplyVirtualCardRequest setKycInfo(KycInfo kycInfo) { this.kycInfo = kycInfo; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (categoryId == null) {
            throw new IllegalArgumentException("categoryId is required");
        }
        if (applyRef == null || applyRef.trim().isEmpty()) {
            throw new IllegalArgumentException("applyRef is required");
        }
        if (kycInfo == null) {
            throw new IllegalArgumentException("kycInfo is required");
        }
    }

    @Override
    public String toString() {
        return "ApplyVirtualCardRequest{externalUserId='" + externalUserId + "', categoryId=" + categoryId + ", applyRef='" + applyRef + "'}";
    }

    /**
     * KYC information for virtual card application.
     */
    public static class KycInfo {

        @SerializedName("sumsubShareToken")
        private String sumsubShareToken;

        @SerializedName("poaDocType")
        private String poaDocType;

        @SerializedName("poaDocUrlList")
        private List<String> poaDocUrlList;

        @SerializedName("poaDocDate")
        private String poaDocDate;

        @SerializedName("addressLine1")
        private String addressLine1;

        @SerializedName("addressLine2")
        private String addressLine2;

        @SerializedName("state")
        private String state;

        @SerializedName("city")
        private String city;

        @SerializedName("postalCode")
        private String postalCode;

        @SerializedName("country")
        private String country;

        @SerializedName("employmentStatus")
        private String employmentStatus;

        @SerializedName("employerName")
        private String employerName;

        @SerializedName("employmentJobIndustry")
        private String employmentJobIndustry;

        @SerializedName("occupation")
        private String occupation;

        @SerializedName("purposeOfAccount")
        private String purposeOfAccount;

        @SerializedName("sourceOfFunds")
        private String sourceOfFunds;

        @SerializedName("sourceOfWealth")
        private String sourceOfWealth;

        public KycInfo() {}

        public String getSumsubShareToken() { return sumsubShareToken; }
        public KycInfo setSumsubShareToken(String sumsubShareToken) { this.sumsubShareToken = sumsubShareToken; return this; }
        public String getPoaDocType() { return poaDocType; }
        public KycInfo setPoaDocType(String poaDocType) { this.poaDocType = poaDocType; return this; }
        public List<String> getPoaDocUrlList() { return poaDocUrlList; }
        public KycInfo setPoaDocUrlList(List<String> poaDocUrlList) { this.poaDocUrlList = poaDocUrlList; return this; }
        public String getPoaDocDate() { return poaDocDate; }
        public KycInfo setPoaDocDate(String poaDocDate) { this.poaDocDate = poaDocDate; return this; }
        public String getAddressLine1() { return addressLine1; }
        public KycInfo setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; return this; }
        public String getAddressLine2() { return addressLine2; }
        public KycInfo setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; return this; }
        public String getState() { return state; }
        public KycInfo setState(String state) { this.state = state; return this; }
        public String getCity() { return city; }
        public KycInfo setCity(String city) { this.city = city; return this; }
        public String getPostalCode() { return postalCode; }
        public KycInfo setPostalCode(String postalCode) { this.postalCode = postalCode; return this; }
        public String getCountry() { return country; }
        public KycInfo setCountry(String country) { this.country = country; return this; }
        public String getEmploymentStatus() { return employmentStatus; }
        public KycInfo setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; return this; }
        public String getEmployerName() { return employerName; }
        public KycInfo setEmployerName(String employerName) { this.employerName = employerName; return this; }
        public String getEmploymentJobIndustry() { return employmentJobIndustry; }
        public KycInfo setEmploymentJobIndustry(String employmentJobIndustry) { this.employmentJobIndustry = employmentJobIndustry; return this; }
        public String getOccupation() { return occupation; }
        public KycInfo setOccupation(String occupation) { this.occupation = occupation; return this; }
        public String getPurposeOfAccount() { return purposeOfAccount; }
        public KycInfo setPurposeOfAccount(String purposeOfAccount) { this.purposeOfAccount = purposeOfAccount; return this; }
        public String getSourceOfFunds() { return sourceOfFunds; }
        public KycInfo setSourceOfFunds(String sourceOfFunds) { this.sourceOfFunds = sourceOfFunds; return this; }
        public String getSourceOfWealth() { return sourceOfWealth; }
        public KycInfo setSourceOfWealth(String sourceOfWealth) { this.sourceOfWealth = sourceOfWealth; return this; }
    }
}
