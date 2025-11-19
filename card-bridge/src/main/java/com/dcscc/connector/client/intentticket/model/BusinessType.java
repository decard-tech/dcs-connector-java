/*
 * dcs Java Connector
 * Business type enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of business types for file upload operations.
 * 
 * <p>This enum defines the different business contexts for which
 * files can be uploaded through the intent ticket system.
 * The values must match the backend API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum BusinessType {
    
    /**
     * EDD for card application
     */
    @SerializedName("CREATE_CARD_EDD")
    CREATE_CARD_EDD("CREATE_CARD_EDD", "EDD for card application"),
    
    /**
     * EDD for limit increase
     */
    @SerializedName("INCREASE_LIMIT_EDD")
    INCREASE_LIMIT_EDD("INCREASE_LIMIT_EDD", "EDD for limit increase"),
    
    /**
     * KYC files needed for card creation
     */
    @SerializedName("CREATE_CARD_KYC")
    CREATE_CARD_KYC("CREATE_CARD_KYC", "KYC files needed for card creation");

    private final String code;
    private final String description;

    BusinessType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the business type code.
     *
     * @return the business type code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the business type description.
     *
     * @return the business type description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the BusinessType by code.
     *
     * @param code the business type code
     * @return the corresponding BusinessType
     * @throws IllegalArgumentException if the code is not valid
     */
    public static BusinessType fromCode(String code) {
        for (BusinessType businessType : values()) {
            if (businessType.code.equals(code)) {
                return businessType;
            }
        }
        throw new IllegalArgumentException("Invalid business type code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
