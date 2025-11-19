/*
 * dcs Java Connector
 * Settlement file type enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.enterprise.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of settlement file types.
 * 
 * <p>This enum defines the different types of settlement files
 * that can be downloaded by enterprises. The values must match the backend API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum SettlementFileType {
    
    /**
     * Transaction file.
     */
    @SerializedName("transaction")
    TRANSACTION("transaction", "Transaction File"),
    
    /**
     * Authorization file.
     */
    @SerializedName("authorisation")
    AUTHORISATION("authorisation", "Authorization File");

    private final String code;
    private final String description;

    SettlementFileType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the file type code.
     *
     * @return the file type code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the file type description.
     *
     * @return the file type description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the SettlementFileType by code.
     *
     * @param code the file type code
     * @return the corresponding SettlementFileType
     * @throws IllegalArgumentException if the code is not valid
     */
    public static SettlementFileType fromCode(String code) {
        for (SettlementFileType fileType : values()) {
            if (fileType.code.equals(code)) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("Invalid settlement file type code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
