/*
 * CardBridge Java Connector
 * Intent Ticket Management API models
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Request model for creating an intent ticket
 */
public class CreateIntentTicketRequest {
    
    /**
     * Ticket type
     * ticketType = CREATE_CARD_EDD, can use eddSowSalary/eddSowBizRevenue/eddSowGift/eddSowInheritance/eddSowInvest/eddSowOther
     * ticketType = INCREASE_LIMIT_EDD, can use eddSofSaving/eddSofSale/eddSofBizRevenue/eddSofCrypto/eddSofInvest/eddSofOther
     */
    @SerializedName("ticketType")
    private String ticketType;
    
    /**
     * External unique ticket ID
     */
    @SerializedName("ticketRef")
    private String ticketRef;
    
    /**
     * Business type
     * eg: CARD_ORDER_ID/CARD_ID
     */
    @SerializedName("businessType")
    private String businessType;
    
    /**
     * Business ID
     */
    @SerializedName("businessId")
    private String businessId;
    
    /**
     * Source of wealth - salary
     */
    @SerializedName("eddSowSalary")
    private EddSowSalary eddSowSalary;
    
    /**
     * Source of wealth - business revenue
     */
    @SerializedName("eddSowBizRevenue")
    private EddSowBizRevenue eddSowBizRevenue;
    
    /**
     * Source of wealth - gift
     */
    @SerializedName("eddSowGift")
    private EddSowGift eddSowGift;
    
    /**
     * Source of wealth - inheritance
     */
    @SerializedName("eddSowInheritance")
    private EddSowInheritance eddSowInheritance;
    
    /**
     * Source of wealth - investment
     */
    @SerializedName("eddSowInvest")
    private EddSowInvest eddSowInvest;
    
    /**
     * Source of wealth - other
     */
    @SerializedName("eddSowOther")
    private EddSowOther eddSowOther;
    
    /**
     * Source of funds - savings income
     */
    @SerializedName("eddSofSaving")
    private EddSofSaving eddSofSaving;
    
    /**
     * Source of funds - sale income
     */
    @SerializedName("eddSofSale")
    private EddSofSale eddSofSale;
    
    /**
     * Source of funds - business revenue
     */
    @SerializedName("eddSofBizRevenue")
    private EddSofBizRevenue eddSofBizRevenue;
    
    /**
     * Source of funds - cryptocurrency income
     */
    @SerializedName("eddSofCrypto")
    private EddSofCrypto eddSofCrypto;
    
    /**
     * Source of funds - investment income
     */
    @SerializedName("eddSofInvest")
    private EddSofInvest eddSofInvest;
    
    /**
     * Source of funds - other
     */
    @SerializedName("eddSofOther")
    private EddSofOther eddSofOther;
    
    public CreateIntentTicketRequest() {}
    
    // Getters and Setters with method chaining
    public String getTicketType() { return ticketType; }
    public CreateIntentTicketRequest setTicketType(String ticketType) { this.ticketType = ticketType; return this; }
    
    public String getTicketRef() { return ticketRef; }
    public CreateIntentTicketRequest setTicketRef(String ticketRef) { this.ticketRef = ticketRef; return this; }
    
    public String getBusinessType() { return businessType; }
    public CreateIntentTicketRequest setBusinessType(String businessType) { this.businessType = businessType; return this; }
    
    public String getBusinessId() { return businessId; }
    public CreateIntentTicketRequest setBusinessId(String businessId) { this.businessId = businessId; return this; }
    
    public EddSowSalary getEddSowSalary() { return eddSowSalary; }
    public CreateIntentTicketRequest setEddSowSalary(EddSowSalary eddSowSalary) { this.eddSowSalary = eddSowSalary; return this; }
    
    public EddSowBizRevenue getEddSowBizRevenue() { return eddSowBizRevenue; }
    public CreateIntentTicketRequest setEddSowBizRevenue(EddSowBizRevenue eddSowBizRevenue) { this.eddSowBizRevenue = eddSowBizRevenue; return this; }
    
    public EddSowGift getEddSowGift() { return eddSowGift; }
    public CreateIntentTicketRequest setEddSowGift(EddSowGift eddSowGift) { this.eddSowGift = eddSowGift; return this; }
    
    public EddSowInheritance getEddSowInheritance() { return eddSowInheritance; }
    public CreateIntentTicketRequest setEddSowInheritance(EddSowInheritance eddSowInheritance) { this.eddSowInheritance = eddSowInheritance; return this; }
    
    public EddSowInvest getEddSowInvest() { return eddSowInvest; }
    public CreateIntentTicketRequest setEddSowInvest(EddSowInvest eddSowInvest) { this.eddSowInvest = eddSowInvest; return this; }
    
    public EddSowOther getEddSowOther() { return eddSowOther; }
    public CreateIntentTicketRequest setEddSowOther(EddSowOther eddSowOther) { this.eddSowOther = eddSowOther; return this; }
    
    public EddSofSaving getEddSofSaving() { return eddSofSaving; }
    public CreateIntentTicketRequest setEddSofSaving(EddSofSaving eddSofSaving) { this.eddSofSaving = eddSofSaving; return this; }
    
    public EddSofSale getEddSofSale() { return eddSofSale; }
    public CreateIntentTicketRequest setEddSofSale(EddSofSale eddSofSale) { this.eddSofSale = eddSofSale; return this; }
    
    public EddSofBizRevenue getEddSofBizRevenue() { return eddSofBizRevenue; }
    public CreateIntentTicketRequest setEddSofBizRevenue(EddSofBizRevenue eddSofBizRevenue) { this.eddSofBizRevenue = eddSofBizRevenue; return this; }
    
    public EddSofCrypto getEddSofCrypto() { return eddSofCrypto; }
    public CreateIntentTicketRequest setEddSofCrypto(EddSofCrypto eddSofCrypto) { this.eddSofCrypto = eddSofCrypto; return this; }
    
    public EddSofInvest getEddSofInvest() { return eddSofInvest; }
    public CreateIntentTicketRequest setEddSofInvest(EddSofInvest eddSofInvest) { this.eddSofInvest = eddSofInvest; return this; }
    
    public EddSofOther getEddSofOther() { return eddSofOther; }
    public CreateIntentTicketRequest setEddSofOther(EddSofOther eddSofOther) { this.eddSofOther = eddSofOther; return this; }
    
    // Nested classes for EDD structures
    public static class EddSowSalary {
        /**
         * Employer name
         */
        @SerializedName("employerName")
        private String employerName;
        
        /**
         * Job title
         */
        @SerializedName("jobTitle")
        private String jobTitle;
        
        /**
         * Annual income
         */
        @SerializedName("annualIncome")
        private String annualIncome;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getEmployerName() { return employerName; }
        public EddSowSalary setEmployerName(String employerName) { this.employerName = employerName; return this; }
        
        public String getJobTitle() { return jobTitle; }
        public EddSowSalary setJobTitle(String jobTitle) { this.jobTitle = jobTitle; return this; }
        
        public String getAnnualIncome() { return annualIncome; }
        public EddSowSalary setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowSalary setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSowBizRevenue {
        /**
         * Business name
         */
        @SerializedName("businessName")
        private String businessName;
        
        /**
         * Nature of business
         */
        @SerializedName("natureOfBusiness")
        private String natureOfBusiness;
        
        /**
         * Annual revenue
         */
        @SerializedName("annualRevenue")
        private String annualRevenue;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getBusinessName() { return businessName; }
        public EddSowBizRevenue setBusinessName(String businessName) { this.businessName = businessName; return this; }
        
        public String getNatureOfBusiness() { return natureOfBusiness; }
        public EddSowBizRevenue setNatureOfBusiness(String natureOfBusiness) { this.natureOfBusiness = natureOfBusiness; return this; }
        
        public String getAnnualRevenue() { return annualRevenue; }
        public EddSowBizRevenue setAnnualRevenue(String annualRevenue) { this.annualRevenue = annualRevenue; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowBizRevenue setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSowGift {
        /**
         * Contributor's name
         */
        @SerializedName("contributorName")
        private String contributorName;
        
        /**
         * Relationship
         */
        @SerializedName("relationshipToYou")
        private String relationshipToYou;
        
        /**
         * Contributor's source of wealth
         */
        @SerializedName("contributorSourceOfWealth")
        private String contributorSourceOfWealth;
        
        /**
         * Net worth
         */
        @SerializedName("estimatedNetWorth")
        private String estimatedNetWorth;
        
        /**
         * Type of assets
         */
        @SerializedName("typeOfAssets")
        private String typeOfAssets;
        
        /**
         * Year assets received
         */
        @SerializedName("yearAssetsReceived")
        private String yearAssetsReceived;
        
        /**
         * Recurring gifts
         */
        @SerializedName("recurringGifts")
        private RecurringGiftsDetail recurringGifts;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        // Getters and setters...
        public String getContributorName() { return contributorName; }
        public EddSowGift setContributorName(String contributorName) { this.contributorName = contributorName; return this; }
        
        public String getRelationshipToYou() { return relationshipToYou; }
        public EddSowGift setRelationshipToYou(String relationshipToYou) { this.relationshipToYou = relationshipToYou; return this; }
        
        public String getContributorSourceOfWealth() { return contributorSourceOfWealth; }
        public EddSowGift setContributorSourceOfWealth(String contributorSourceOfWealth) { this.contributorSourceOfWealth = contributorSourceOfWealth; return this; }
        
        public String getEstimatedNetWorth() { return estimatedNetWorth; }
        public EddSowGift setEstimatedNetWorth(String estimatedNetWorth) { this.estimatedNetWorth = estimatedNetWorth; return this; }
        
        public String getTypeOfAssets() { return typeOfAssets; }
        public EddSowGift setTypeOfAssets(String typeOfAssets) { this.typeOfAssets = typeOfAssets; return this; }
        
        public String getYearAssetsReceived() { return yearAssetsReceived; }
        public EddSowGift setYearAssetsReceived(String yearAssetsReceived) { this.yearAssetsReceived = yearAssetsReceived; return this; }
        
        public RecurringGiftsDetail getRecurringGifts() { return recurringGifts; }
        public EddSowGift setRecurringGifts(RecurringGiftsDetail recurringGifts) { this.recurringGifts = recurringGifts; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowGift setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class RecurringGiftsDetail {
        /**
         * Duration - years
         */
        @SerializedName("numberOfYears")
        private String numberOfYears;
        
        /**
         * Payment frequency
         */
        @SerializedName("frequencyPerPayment")
        private String frequencyPerPayment;
        
        /**
         * Amount per payment
         */
        @SerializedName("amountPerPayment")
        private String amountPerPayment;
        
        public String getNumberOfYears() { return numberOfYears; }
        public RecurringGiftsDetail setNumberOfYears(String numberOfYears) { this.numberOfYears = numberOfYears; return this; }
        
        public String getFrequencyPerPayment() { return frequencyPerPayment; }
        public RecurringGiftsDetail setFrequencyPerPayment(String frequencyPerPayment) { this.frequencyPerPayment = frequencyPerPayment; return this; }
        
        public String getAmountPerPayment() { return amountPerPayment; }
        public RecurringGiftsDetail setAmountPerPayment(String amountPerPayment) { this.amountPerPayment = amountPerPayment; return this; }
    }
    
    public static class EddSowInheritance {
        /**
         * Deceased name
         */
        @SerializedName("deceasedName")
        private String deceasedName;
        
        /**
         * Relationship to you
         */
        @SerializedName("relationshipToYou")
        private String relationshipToYou;
        
        /**
         * Year inherited
         */
        @SerializedName("yearInherited")
        private String yearInherited;
        
        /**
         * Approximate value
         */
        @SerializedName("approximateValue")
        private String approximateValue;
        
        /**
         * Type of assets
         */
        @SerializedName("typeOfAssets")
        private String typeOfAssets;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getDeceasedName() { return deceasedName; }
        public EddSowInheritance setDeceasedName(String deceasedName) { this.deceasedName = deceasedName; return this; }
        
        public String getRelationshipToYou() { return relationshipToYou; }
        public EddSowInheritance setRelationshipToYou(String relationshipToYou) { this.relationshipToYou = relationshipToYou; return this; }
        
        public String getYearInherited() { return yearInherited; }
        public EddSowInheritance setYearInherited(String yearInherited) { this.yearInherited = yearInherited; return this; }
        
        public String getApproximateValue() { return approximateValue; }
        public EddSowInheritance setApproximateValue(String approximateValue) { this.approximateValue = approximateValue; return this; }
        
        public String getTypeOfAssets() { return typeOfAssets; }
        public EddSowInheritance setTypeOfAssets(String typeOfAssets) { this.typeOfAssets = typeOfAssets; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowInheritance setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSowInvest {
        /**
         * Investment type
         */
        @SerializedName("typeOfInvestment")
        private String typeOfInvestment;
        
        /**
         * Approximate value
         */
        @SerializedName("approximateValue")
        private String approximateValue;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getTypeOfInvestment() { return typeOfInvestment; }
        public EddSowInvest setTypeOfInvestment(String typeOfInvestment) { this.typeOfInvestment = typeOfInvestment; return this; }
        
        public String getApproximateValue() { return approximateValue; }
        public EddSowInvest setApproximateValue(String approximateValue) { this.approximateValue = approximateValue; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowInvest setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSowOther {
        /**
         * Description
         */
        @SerializedName("description")
        private String description;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getDescription() { return description; }
        public EddSowOther setDescription(String description) { this.description = description; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSowOther setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    // Source of Funds classes
    public static class EddSofSaving {
        /**
         * Employer name
         */
        @SerializedName("employerName")
        private String employerName;
        
        /**
         * Job title
         */
        @SerializedName("jobTitle")
        private String jobTitle;
        
        /**
         * Annual income
         */
        @SerializedName("annualIncome")
        private String annualIncome;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getEmployerName() { return employerName; }
        public EddSofSaving setEmployerName(String employerName) { this.employerName = employerName; return this; }
        
        public String getJobTitle() { return jobTitle; }
        public EddSofSaving setJobTitle(String jobTitle) { this.jobTitle = jobTitle; return this; }
        
        public String getAnnualIncome() { return annualIncome; }
        public EddSofSaving setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofSaving setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSofSale {
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofSale setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSofBizRevenue {
        /**
         * Business name
         */
        @SerializedName("businessName")
        private String businessName;
        
        /**
         * Nature of business
         */
        @SerializedName("natureOfBusiness")
        private String natureOfBusiness;
        
        /**
         * Annual revenue
         */
        @SerializedName("annualRevenue")
        private String annualRevenue;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getBusinessName() { return businessName; }
        public EddSofBizRevenue setBusinessName(String businessName) { this.businessName = businessName; return this; }
        
        public String getNatureOfBusiness() { return natureOfBusiness; }
        public EddSofBizRevenue setNatureOfBusiness(String natureOfBusiness) { this.natureOfBusiness = natureOfBusiness; return this; }
        
        public String getAnnualRevenue() { return annualRevenue; }
        public EddSofBizRevenue setAnnualRevenue(String annualRevenue) { this.annualRevenue = annualRevenue; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofBizRevenue setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSofCrypto {
        /**
         * Platform
         */
        @SerializedName("platform")
        private String platform;
        
        /**
         * Holding type
         * eg:
         * - Custodian: CUSTODIAN
         * - Non-custodian: NON_CUSTODIAN
         * - Both: ALL
         */
        @SerializedName("holdingType")
        private String holdingType;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getPlatform() { return platform; }
        public EddSofCrypto setPlatform(String platform) { this.platform = platform; return this; }
        
        public String getHoldingType() { return holdingType; }
        public EddSofCrypto setHoldingType(String holdingType) { this.holdingType = holdingType; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofCrypto setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSofInvest {
        /**
         * Investment type
         */
        @SerializedName("typeOfInvestment")
        private String typeOfInvestment;
        
        /**
         * Approximate value
         */
        @SerializedName("approximateValue")
        private String approximateValue;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getTypeOfInvestment() { return typeOfInvestment; }
        public EddSofInvest setTypeOfInvestment(String typeOfInvestment) { this.typeOfInvestment = typeOfInvestment; return this; }
        
        public String getApproximateValue() { return approximateValue; }
        public EddSofInvest setApproximateValue(String approximateValue) { this.approximateValue = approximateValue; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofInvest setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    public static class EddSofOther {
        /**
         * Description
         */
        @SerializedName("description")
        private String description;
        
        /**
         * Document URLs
         */
        @SerializedName("docUrls")
        private List<IntentTicketFileRequest> docUrls;
        
        public String getDescription() { return description; }
        public EddSofOther setDescription(String description) { this.description = description; return this; }
        
        public List<IntentTicketFileRequest> getDocUrls() { return docUrls; }
        public EddSofOther setDocUrls(List<IntentTicketFileRequest> docUrls) { this.docUrls = docUrls; return this; }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateIntentTicketRequest that = (CreateIntentTicketRequest) o;
        return Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(ticketRef, that.ticketRef) &&
                Objects.equals(businessType, that.businessType) &&
                Objects.equals(businessId, that.businessId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(ticketType, ticketRef, businessType, businessId);
    }
    
    @Override
    public String toString() {
        return "CreateIntentTicketRequest{" +
                "ticketType='" + ticketType + '\'' +
                ", ticketRef='" + ticketRef + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessId='" + businessId + '\'' +
                '}';
    }
}
