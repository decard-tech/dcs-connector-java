package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update travel rule information.
 */
public class TravelRuleRequest {

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("institutionName")
    private String institutionName;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private ID id;

    @SerializedName("address")
    private Address address;

    @SerializedName("dateOfBirth")
    private String dateOfBirth;

    @SerializedName("placeOfBirth")
    private String placeOfBirth;

    public TravelRuleRequest() {}

    public String getExternalUserId() { return externalUserId; }
    public TravelRuleRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getChannelName() { return channelName; }
    public TravelRuleRequest setChannelName(String channelName) { this.channelName = channelName; return this; }
    public String getInstitutionName() { return institutionName; }
    public TravelRuleRequest setInstitutionName(String institutionName) { this.institutionName = institutionName; return this; }
    public String getName() { return name; }
    public TravelRuleRequest setName(String name) { this.name = name; return this; }
    public ID getId() { return id; }
    public TravelRuleRequest setId(ID id) { this.id = id; return this; }
    public Address getAddress() { return address; }
    public TravelRuleRequest setAddress(Address address) { this.address = address; return this; }
    public String getDateOfBirth() { return dateOfBirth; }
    public TravelRuleRequest setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
    public String getPlaceOfBirth() { return placeOfBirth; }
    public TravelRuleRequest setPlaceOfBirth(String placeOfBirth) { this.placeOfBirth = placeOfBirth; return this; }

    public void validate() {
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
    }

    @Override
    public String toString() {
        return "TravelRuleRequest{externalUserId='" + externalUserId + "', name='" + name + "'}";
    }

    public static class ID {
        @SerializedName("type")
        private String type;
        @SerializedName("value")
        private String value;
        @SerializedName("countryOfIssue")
        private String countryOfIssue;

        public ID() {}
        public String getType() { return type; }
        public ID setType(String type) { this.type = type; return this; }
        public String getValue() { return value; }
        public ID setValue(String value) { this.value = value; return this; }
        public String getCountryOfIssue() { return countryOfIssue; }
        public ID setCountryOfIssue(String countryOfIssue) { this.countryOfIssue = countryOfIssue; return this; }
    }

    public static class Address {
        @SerializedName("city")
        private String city;
        @SerializedName("country")
        private String country;
        @SerializedName("dependentLocality")
        private String dependentLocality;
        @SerializedName("postalCode")
        private String postalCode;
        @SerializedName("region")
        private String region;
        @SerializedName("addressLines")
        private String addressLines;

        public Address() {}
        public String getCity() { return city; }
        public Address setCity(String city) { this.city = city; return this; }
        public String getCountry() { return country; }
        public Address setCountry(String country) { this.country = country; return this; }
        public String getDependentLocality() { return dependentLocality; }
        public Address setDependentLocality(String dependentLocality) { this.dependentLocality = dependentLocality; return this; }
        public String getPostalCode() { return postalCode; }
        public Address setPostalCode(String postalCode) { this.postalCode = postalCode; return this; }
        public String getRegion() { return region; }
        public Address setRegion(String region) { this.region = region; return this; }
        public String getAddressLines() { return addressLines; }
        public Address setAddressLines(String addressLines) { this.addressLines = addressLines; return this; }
    }
}
