/*
 * dcs Java Connector
 * Guidance type enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of guidance types for redirect operations.
 * 
 * <p>This enum defines the different types of guidance operations
 * that can be performed through the redirect API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum GuidanceType {
    
    /**
     * Card information query guidance.
     */
    @SerializedName("1")
    CARD_INFO_QUERY("1", "Card Information Query"),
    
    /**
     * Set PIN guidance.
     */
    @SerializedName("2")
    SET_PIN("2", "Set PIN"),
    
    /**
     * Reset PIN guidance.
     */
    @SerializedName("3")
    RESET_PIN("3", "Reset PIN");

    private final String code;
    private final String description;

    GuidanceType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the type code.
     *
     * @return the type code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the type description.
     *
     * @return the type description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the GuidanceType by code.
     *
     * @param code the type code
     * @return the corresponding GuidanceType
     * @throws IllegalArgumentException if the code is not valid
     */
    public static GuidanceType fromCode(String code) {
        for (GuidanceType type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid guidance type code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
