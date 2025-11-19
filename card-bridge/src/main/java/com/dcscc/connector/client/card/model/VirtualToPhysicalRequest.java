/*
 * dcs Java Connector
 * Virtual to physical card request model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for converting a virtual card to a physical card.
 *
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class VirtualToPhysicalRequest {

    /**
     * Card order idempotency field
     */
    @SerializedName("cardOrderRef")
    private String cardOrderRef;

    /**
     * Replace card ID
     */
    @SerializedName("replaceCardId")
    private String replaceCardId;

    /**
     * Virtual to physical card body information
     */
    @SerializedName("virtualToPhysicalInfo")
    private VirtualToPhysicalInfo virtualToPhysicalInfo;

    /**
     * Default constructor.
     */
    public VirtualToPhysicalRequest() {
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
     * @return this VirtualToPhysicalRequest instance for method chaining
     */
    public VirtualToPhysicalRequest setCardOrderRef(String cardOrderRef) {
        this.cardOrderRef = cardOrderRef;
        return this;
    }

    /**
     * Gets the replace card ID.
     *
     * @return the replace card ID
     */
    public String getReplaceCardId() {
        return replaceCardId;
    }

    /**
     * Sets the replace card ID.
     *
     * @param replaceCardId the replace card ID to set
     * @return this VirtualToPhysicalRequest instance for method chaining
     */
    public VirtualToPhysicalRequest setReplaceCardId(String replaceCardId) {
        this.replaceCardId = replaceCardId;
        return this;
    }

    /**
     * Gets the virtual to physical information.
     *
     * @return the virtual to physical information
     */
    public VirtualToPhysicalInfo getVirtualToPhysicalInfo() {
        return virtualToPhysicalInfo;
    }

    /**
     * Sets the virtual to physical information.
     *
     * @param virtualToPhysicalInfo the virtual to physical information to set
     * @return this VirtualToPhysicalRequest instance for method chaining
     */
    public VirtualToPhysicalRequest setVirtualToPhysicalInfo(VirtualToPhysicalInfo virtualToPhysicalInfo) {
        this.virtualToPhysicalInfo = virtualToPhysicalInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualToPhysicalRequest that = (VirtualToPhysicalRequest) o;
        return Objects.equals(cardOrderRef, that.cardOrderRef) &&
                Objects.equals(replaceCardId, that.replaceCardId) &&
                Objects.equals(virtualToPhysicalInfo, that.virtualToPhysicalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardOrderRef, replaceCardId, virtualToPhysicalInfo);
    }

    @Override
    public String toString() {
        return "VirtualToPhysicalRequest{" +
                "cardOrderRef='" + cardOrderRef + '\'' +
                ", replaceCardId='" + replaceCardId + '\'' +
                ", virtualToPhysicalInfo=" + virtualToPhysicalInfo +
                '}';
    }

    /**
     * Virtual to physical card information.
     */
    public static class VirtualToPhysicalInfo {
        /**
         * Country code
         * String
         * Required
         * 
         * Country code, 2-digit ISO
         * eg: CN/US/SG
         */
        @SerializedName("countryCode")
        private String countryCode;

        /**
         * state
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
         * Address
         */
        @SerializedName("address")
        private String address;

        /**
         * Address 2
         */
        @SerializedName("address2")
        private String address2;

        /**
         * Address 3
         */
        @SerializedName("address3")
        private String address3;

        /**
         * Address 4
         */
        @SerializedName("address4")
        private String address4;

        /**
         * Address 5
         */
        @SerializedName("address5")
        private String address5;

        /**
         * Embossing name
         */
        @SerializedName("embossingName")
        private String embossingName;

        /**
         * Card layout code
         */
        @SerializedName("cardLayoutCode")
        private String cardLayoutCode;

        /**
         * Need physical card shipping information
         */
        @SerializedName("needShippingInfo")
        private Boolean needShippingInfo;

        // Getters and setters with method chaining
        public String getCountryCode() { return countryCode; }
        public VirtualToPhysicalInfo setCountryCode(String countryCode) { this.countryCode = countryCode; return this; }

        public String getState() { return state; }
        public VirtualToPhysicalInfo setState(String state) { this.state = state; return this; }

        public String getCity() { return city; }
        public VirtualToPhysicalInfo setCity(String city) { this.city = city; return this; }

        public String getPostalCode() { return postalCode; }
        public VirtualToPhysicalInfo setPostalCode(String postalCode) { this.postalCode = postalCode; return this; }

        public String getAddress() { return address; }
        public VirtualToPhysicalInfo setAddress(String address) { this.address = address; return this; }

        public String getAddress2() { return address2; }
        public VirtualToPhysicalInfo setAddress2(String address2) { this.address2 = address2; return this; }

        public String getAddress3() { return address3; }
        public VirtualToPhysicalInfo setAddress3(String address3) { this.address3 = address3; return this; }

        public String getAddress4() { return address4; }
        public VirtualToPhysicalInfo setAddress4(String address4) { this.address4 = address4; return this; }

        public String getAddress5() { return address5; }
        public VirtualToPhysicalInfo setAddress5(String address5) { this.address5 = address5; return this; }

        public String getEmbossingName() { return embossingName; }
        public VirtualToPhysicalInfo setEmbossingName(String embossingName) { this.embossingName = embossingName; return this; }

        public String getCardLayoutCode() { return cardLayoutCode; }
        public VirtualToPhysicalInfo setCardLayoutCode(String cardLayoutCode) { this.cardLayoutCode = cardLayoutCode; return this; }

        public Boolean getNeedShippingInfo() { return needShippingInfo; }
        public VirtualToPhysicalInfo setNeedShippingInfo(Boolean needShippingInfo) { this.needShippingInfo = needShippingInfo; return this; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VirtualToPhysicalInfo that = (VirtualToPhysicalInfo) o;
            return Objects.equals(countryCode, that.countryCode) &&
                    Objects.equals(state, that.state) &&
                    Objects.equals(city, that.city) &&
                    Objects.equals(postalCode, that.postalCode) &&
                    Objects.equals(address, that.address) &&
                    Objects.equals(address2, that.address2) &&
                    Objects.equals(address3, that.address3) &&
                    Objects.equals(address4, that.address4) &&
                    Objects.equals(address5, that.address5) &&
                    Objects.equals(embossingName, that.embossingName) &&
                    Objects.equals(cardLayoutCode, that.cardLayoutCode) &&
                    Objects.equals(needShippingInfo, that.needShippingInfo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(countryCode, state, city, postalCode, address, address2, address3, address4, address5,
                    embossingName, cardLayoutCode, needShippingInfo);
        }

        @Override
        public String toString() {
            return "VirtualToPhysicalInfo{" +
                    "countryCode='" + countryCode + '\'' +
                    ", state='" + state + '\'' +
                    ", city='" + city + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    ", address='" + address + '\'' +
                    ", address2='" + address2 + '\'' +
                    ", address3='" + address3 + '\'' +
                    ", address4='" + address4 + '\'' +
                    ", address5='" + address5 + '\'' +
                    ", embossingName='" + embossingName + '\'' +
                    ", cardLayoutCode='" + cardLayoutCode + '\'' +
                    ", needShippingInfo=" + needShippingInfo +
                    '}';
        }
    }
}
