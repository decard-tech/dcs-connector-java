/*
 * dcs Java Connector
 * Create card order request model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Request model for creating a virtual card order.
 * 
 * <p>This class represents the request parameters for creating a new virtual card order.
 * It includes customer information, KYC data, and card configuration details.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class CreateCardOrderRequest {

    /**
     * Card configuration ID, contact Card bridge team to obtain
     */
    @SerializedName("profileId")
    private String profileId;

    /**
     * Card order idempotency field
     */
    @SerializedName("cardOrderRef")
    private String cardOrderRef;

    /**
     * AES GCM mode IV for decrypting customerInfoEncryption and kycInfoEncryption
     */
    @SerializedName("encryptionIV")
    private String encryptionIV;

    /**
     * Encrypted customerInfo JSON object using AES GCM mode
     * Either customerInfoEncryption or customerInfo must be provided.
     * If both are provided, customerInfoEncryption takes priority.
     */
    @SerializedName("customerInfoEncryption")
    private String customerInfoEncryption;

    /**
     * Customer information
     * Either customerInfoEncryption or customerInfo must be provided.
     * If both are provided, customerInfoEncryption takes priority.
     */
    @SerializedName("customerInfo")
    private CustomerInfo customerInfo;

    /**
     * Encrypted kycInfo JSON object using AES GCM mode
     * Either kycInfoEncryption or kycInfo must be provided.
     * If both are provided, kycInfoEncryption takes priority.
     */
    @SerializedName("kycInfoEncryption")
    private String kycInfoEncryption;

    /**
     * KYC information
     * Either kycInfoEncryption or kycInfo must be provided.
     * If both are provided, kycInfoEncryption takes priority.
     */
    @SerializedName("kycInfo")
    private KycInfo kycInfo;

    /**
     * Default constructor.
     */
    public CreateCardOrderRequest() {
    }

    /**
     * Gets the profile ID.
     *
     * @return the profile ID
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Sets the profile ID.
     *
     * @param profileId the profile ID to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setProfileId(String profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * Gets the card order reference.
     *
     * @return the card order reference
     */
    public String getCardOrderRef() {
        return cardOrderRef;
    }

    /**
     * Sets the card order reference.
     *
     * @param cardOrderRef the card order reference to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setCardOrderRef(String cardOrderRef) {
        this.cardOrderRef = cardOrderRef;
        return this;
    }

    /**
     * Gets the encryption IV.
     *
     * @return the encryption IV
     */
    public String getEncryptionIV() {
        return encryptionIV;
    }

    /**
     * Sets the encryption IV.
     *
     * @param encryptionIV the encryption IV to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setEncryptionIV(String encryptionIV) {
        this.encryptionIV = encryptionIV;
        return this;
    }

    /**
     * Gets the encrypted customer information.
     *
     * @return the encrypted customer information
     */
    public String getCustomerInfoEncryption() {
        return customerInfoEncryption;
    }

    /**
     * Sets the encrypted customer information.
     *
     * @param customerInfoEncryption the encrypted customer information to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setCustomerInfoEncryption(String customerInfoEncryption) {
        this.customerInfoEncryption = customerInfoEncryption;
        return this;
    }

    /**
     * Gets the encrypted KYC information.
     *
     * @return the encrypted KYC information
     */
    public String getKycInfoEncryption() {
        return kycInfoEncryption;
    }

    /**
     * Sets the encrypted KYC information.
     *
     * @param kycInfoEncryption the encrypted KYC information to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setKycInfoEncryption(String kycInfoEncryption) {
        this.kycInfoEncryption = kycInfoEncryption;
        return this;
    }

    /**
     * Gets the customer information.
     *
     * @return the customer information
     */
    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    /**
     * Sets the customer information.
     *
     * @param customerInfo the customer information to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
        return this;
    }

    /**
     * Gets the KYC information.
     *
     * @return the KYC information
     */
    public KycInfo getKycInfo() {
        return kycInfo;
    }

    /**
     * Sets the KYC information.
     *
     * @param kycInfo the KYC information to set
     * @return this CreateCardOrderRequest instance for method chaining
     */
    public CreateCardOrderRequest setKycInfo(KycInfo kycInfo) {
        this.kycInfo = kycInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCardOrderRequest that = (CreateCardOrderRequest) o;
        return Objects.equals(profileId, that.profileId) &&
                Objects.equals(cardOrderRef, that.cardOrderRef) &&
                Objects.equals(encryptionIV, that.encryptionIV) &&
                Objects.equals(customerInfoEncryption, that.customerInfoEncryption) &&
                Objects.equals(customerInfo, that.customerInfo) &&
                Objects.equals(kycInfoEncryption, that.kycInfoEncryption) &&
                Objects.equals(kycInfo, that.kycInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, cardOrderRef, encryptionIV, customerInfoEncryption, customerInfo, kycInfoEncryption, kycInfo);
    }

    @Override
    public String toString() {
        return "CreateCardOrderRequest{" +
                "profileId='" + profileId + '\'' +
                ", cardOrderRef='" + cardOrderRef + '\'' +
                ", encryptionIV='" + encryptionIV + '\'' +
                ", customerInfoEncryption='" + customerInfoEncryption + '\'' +
                ", customerInfo=" + customerInfo +
                ", kycInfoEncryption='" + kycInfoEncryption + '\'' +
                ", kycInfo=" + kycInfo +
                '}';
    }

    /**
     * Customer information for card order.
     */
    public static class CustomerInfo {
        /**
         * Phone country code
         * Country code, 2-digit ISO
         * eg: CN/US/SG
         */
        @SerializedName("phoneCountryCode")
        private String phoneCountryCode;

        /**
         * Phone number with country prefix
         * eg: +8613800138000
         */
        @SerializedName("phone")
        private String phone;

        /**
         * Email address
         */
        @SerializedName("email")
        private String email;

        /**
         * Customer idempotency field
         */
        @SerializedName("customerRef")
        private String customerRef;

        // Getters and setters with method chaining
        public String getPhoneCountryCode() { return phoneCountryCode; }
        public CustomerInfo setPhoneCountryCode(String phoneCountryCode) { this.phoneCountryCode = phoneCountryCode; return this; }

        public String getPhone() { return phone; }
        public CustomerInfo setPhone(String phone) { this.phone = phone; return this; }

        public String getEmail() { return email; }
        public CustomerInfo setEmail(String email) { this.email = email; return this; }

        public String getCustomerRef() { return customerRef; }
        public CustomerInfo setCustomerRef(String customerRef) { this.customerRef = customerRef; return this; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomerInfo that = (CustomerInfo) o;
            return Objects.equals(phoneCountryCode, that.phoneCountryCode) &&
                    Objects.equals(phone, that.phone) &&
                    Objects.equals(email, that.email) &&
                    Objects.equals(customerRef, that.customerRef);
        }

        @Override
        public int hashCode() {
            return Objects.hash(phoneCountryCode, phone, email, customerRef);
        }

        @Override
        public String toString() {
            return "CustomerInfo{" +
                    "phoneCountryCode='" + phoneCountryCode + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", customerRef='" + customerRef + '\'' +
                    '}';
        }
    }

    /**
     * KYC (Know Your Customer) information.
     */
    public static class KycInfo {
        /**
         * Sumsub share token
         */
        @SerializedName("sumsubShareToken")
        private String sumsubShareToken;

        /**
         * Document type
         */
        @SerializedName("poaDocType")
        private String poaDocType;

        /**
         * Document URL list
         */
        @SerializedName("poaDocUrlList")
        private List<String> poaDocUrlList;

        /**
         * Document date
         * eg: 2025-01-01
         */
        @SerializedName("poaDocDate")
        private String poaDocDate;

        /**
         * Address line 1
         */
        @SerializedName("addressLine1")
        private String addressLine1;

        /**
         * Address line 2
         */
        @SerializedName("addressLine2")
        private String addressLine2;

        /**
         * State
         */
        @SerializedName("state")
        private String state;

        /**
         * City
         */
        @SerializedName("city")
        private String city;

        /**
         * Postal code
         */
        @SerializedName("postalCode")
        private String postalCode;

        /**
         * Country
         * Country code, 2-digit ISO
         * eg: CN/US/SG
         */
        @SerializedName("country")
        private String country;

        /**
         * Employment status
         * EMPLOYED/BUSINESS_OWNER/SELF_EMPLOYED/UNEMPLOYED/PENSIONER/STUDENT
         */
        @SerializedName("employmentStatus")
        private String employmentStatus;

        /**
         * Employer name, required when employmentStatus is "EMPLOYED"
         */
        @SerializedName("employerName")
        private String employerName;

        /**
         * Job industry
         * INFORMATION_AND_COMMUNICATIONS/RETAIL_TRADE/FINANCIAL_AND_INSURANCE_ACTIVITIES/ELECTRICITY/GAS_AND_WATER_SUPPLY/TRANSPORT_AND_STORAGE/CONSTRUCTION/TRAVEL_RELATED/ACCOMMODATION_AND_FOOD_SERVICES_ACTIVITIES/ENTERTAINMENT/PAYMENTS/DIGITAL_PAYMENT_TOKEN_RELATED/PROFESSIONAL/LUXURY_GOODS/MANUFACTURING/MINING_AND_QUARRYING/AGRICULTURE_AND_FISHING/REAL_PROPERTY_AND_DEVELOPMENT_OF_LAND/WHOLESALE_TRADE/OTHERS/
         */
        @SerializedName("employmentJobIndustry")
        private String employmentJobIndustry;

        /**
         * Occupation
         */
        @SerializedName("occupation")
        private String occupation;

        /**
         * Job seniority
         * SENIOR_MANAGEMENT/DIRECTOR/PARTNER/EXECUTIVE/TEACHER/MANAGERIAL/SUPERVISOR/SALES/ASSOCIATE/DIPLOMAT/OTHERS
         */
        @SerializedName("jobSeniority")
        private String jobSeniority;

        /**
         * Purpose of account
         * CASH_ADVANCE_PROGRAM/INVESTMENT/DAILY_SPENDING/BILL_PAYMENT/OTHERS
         */
        @SerializedName("purposeOfAccount")
        private String purposeOfAccount;

        /**
         * Source of funds
         * OWN_BANK_ACCOUNT/THIRD_PARTY_BANK_ACCOUNT/CRYPTO_TOP_UP/DUSD/OTHERS
         */
        @SerializedName("sourceOfFunds")
        private String sourceOfFunds;

        /**
         * Source of funds country
         * Country code, 2-digit ISO
         * eg: CN/US/SG
         */
        @SerializedName("sourceOfFundsCountry")
        private String sourceOfFundsCountry;

        /**
         * Source of wealth
         * EMPLOYMENT/SAVINGS/INHERITANCE/BUSINESS/INVESTMENT/TRUST_FUND/CRYPTOCURRENCIES/OTHERS
         */
        @SerializedName("sourceOfWealth")
        private String sourceOfWealth;

        // Getters and setters with method chaining
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

        public String getJobSeniority() { return jobSeniority; }
        public KycInfo setJobSeniority(String jobSeniority) { this.jobSeniority = jobSeniority; return this; }

        public String getPurposeOfAccount() { return purposeOfAccount; }
        public KycInfo setPurposeOfAccount(String purposeOfAccount) { this.purposeOfAccount = purposeOfAccount; return this; }

        public String getSourceOfFunds() { return sourceOfFunds; }
        public KycInfo setSourceOfFunds(String sourceOfFunds) { this.sourceOfFunds = sourceOfFunds; return this; }

        public String getSourceOfFundsCountry() { return sourceOfFundsCountry; }
        public KycInfo setSourceOfFundsCountry(String sourceOfFundsCountry) { this.sourceOfFundsCountry = sourceOfFundsCountry; return this; }

        public String getSourceOfWealth() { return sourceOfWealth; }
        public KycInfo setSourceOfWealth(String sourceOfWealth) { this.sourceOfWealth = sourceOfWealth; return this; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KycInfo kycInfo = (KycInfo) o;
            return Objects.equals(sumsubShareToken, kycInfo.sumsubShareToken) &&
                    Objects.equals(poaDocType, kycInfo.poaDocType) &&
                    Objects.equals(poaDocUrlList, kycInfo.poaDocUrlList) &&
                    Objects.equals(poaDocDate, kycInfo.poaDocDate) &&
                    Objects.equals(addressLine1, kycInfo.addressLine1) &&
                    Objects.equals(addressLine2, kycInfo.addressLine2) &&
                    Objects.equals(state, kycInfo.state) &&
                    Objects.equals(city, kycInfo.city) &&
                    Objects.equals(postalCode, kycInfo.postalCode) &&
                    Objects.equals(country, kycInfo.country) &&
                    Objects.equals(employmentStatus, kycInfo.employmentStatus) &&
                    Objects.equals(employerName, kycInfo.employerName) &&
                    Objects.equals(employmentJobIndustry, kycInfo.employmentJobIndustry) &&
                    Objects.equals(occupation, kycInfo.occupation) &&
                    Objects.equals(jobSeniority, kycInfo.jobSeniority) &&
                    Objects.equals(purposeOfAccount, kycInfo.purposeOfAccount) &&
                    Objects.equals(sourceOfFunds, kycInfo.sourceOfFunds) &&
                    Objects.equals(sourceOfFundsCountry, kycInfo.sourceOfFundsCountry) &&
                    Objects.equals(sourceOfWealth, kycInfo.sourceOfWealth);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sumsubShareToken, poaDocType, poaDocUrlList, poaDocDate, addressLine1, addressLine2,
                    state, city, postalCode, country, employmentStatus, employerName, employmentJobIndustry,
                    occupation, jobSeniority, purposeOfAccount, sourceOfFunds, sourceOfFundsCountry, sourceOfWealth);
        }

        @Override
        public String toString() {
            return "KycInfo{" +
                    "sumsubShareToken='" + sumsubShareToken + '\'' +
                    ", poaDocType='" + poaDocType + '\'' +
                    ", poaDocUrlList=" + poaDocUrlList +
                    ", poaDocDate='" + poaDocDate + '\'' +
                    ", addressLine1='" + addressLine1 + '\'' +
                    ", addressLine2='" + addressLine2 + '\'' +
                    ", state='" + state + '\'' +
                    ", city='" + city + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    ", country='" + country + '\'' +
                    ", employmentStatus='" + employmentStatus + '\'' +
                    ", employerName='" + employerName + '\'' +
                    ", employmentJobIndustry='" + employmentJobIndustry + '\'' +
                    ", occupation='" + occupation + '\'' +
                    ", jobSeniority='" + jobSeniority + '\'' +
                    ", purposeOfAccount='" + purposeOfAccount + '\'' +
                    ", sourceOfFunds='" + sourceOfFunds + '\'' +
                    ", sourceOfFundsCountry='" + sourceOfFundsCountry + '\'' +
                    ", sourceOfWealth='" + sourceOfWealth + '\'' +
                    '}';
        }
    }
}
