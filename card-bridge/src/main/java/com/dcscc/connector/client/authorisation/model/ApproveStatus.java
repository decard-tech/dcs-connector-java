/*
 * dcs Java Connector
 * 3DS approve status enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of 3DS challenge approval status.
 * 
 * <p>This enum defines the possible outcomes of a 3DS challenge
 * authentication process. The values must match the backend API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ApproveStatus {
    
    /**
     * Challenge approved by cardholder.
     */
    @SerializedName("APPROVE")
    APPROVE("APPROVE", "Challenge approved"),
    
    /**
     * Challenge rejected by cardholder.
     */
    @SerializedName("REJECT")
    REJECT("REJECT", "Challenge rejected");

    private final String code;
    private final String description;

    ApproveStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the status description.
     *
     * @return the status description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the ApproveStatus by code.
     *
     * @param code the status code
     * @return the corresponding ApproveStatus
     * @throws IllegalArgumentException if the code is not valid
     */
    public static ApproveStatus fromCode(String code) {
        for (ApproveStatus status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid approve status code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
