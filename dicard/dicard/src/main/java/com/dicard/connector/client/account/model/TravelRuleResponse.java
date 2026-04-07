package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;

/**
 * Travel rule query response.
 */
public class TravelRuleResponse {

    @SerializedName("externalUserId")
    private String externalUserId;

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

    public TravelRuleResponse() {}

    public String getExternalUserId() { return externalUserId; }
    public TravelRuleResponse setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getName() { return name; }
    public TravelRuleResponse setName(String name) { this.name = name; return this; }
    public ID getId() { return id; }
    public TravelRuleResponse setId(ID id) { this.id = id; return this; }
    public Address getAddress() { return address; }
    public TravelRuleResponse setAddress(Address address) { this.address = address; return this; }
    public String getDateOfBirth() { return dateOfBirth; }
    public TravelRuleResponse setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
    public String getPlaceOfBirth() { return placeOfBirth; }
    public TravelRuleResponse setPlaceOfBirth(String placeOfBirth) { this.placeOfBirth = placeOfBirth; return this; }

    @Override
    public String toString() {
        return "TravelRuleResponse{externalUserId='" + externalUserId + "', name='" + name + "'}";
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
        @SerializedName("postalCode")
        private String postalCode;
        @SerializedName("addressLines")
        private String addressLines;

        public Address() {}
        public String getCity() { return city; }
        public Address setCity(String city) { this.city = city; return this; }
        public String getPostalCode() { return postalCode; }
        public Address setPostalCode(String postalCode) { this.postalCode = postalCode; return this; }
        public String getAddressLines() { return addressLines; }
        public Address setAddressLines(String addressLines) { this.addressLines = addressLines; return this; }
    }
}
