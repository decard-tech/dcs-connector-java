/*
 * dcs Java Connector
 * Language enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of supported languages for guidance pages.
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Language {

    @SerializedName("zh")
    CHINESE("zh", "Chinese"),

    @SerializedName("en")
    ENGLISH("en", "English");

    private final String code;
    private final String description;

    Language(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the language code.
     *
     * @return the language code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the language description.
     *
     * @return the language description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the Language by code.
     *
     * @param code the language code
     * @return the corresponding Language
     * @throws IllegalArgumentException if the code is not valid
     */
    public static Language fromCode(String code) {
        for (Language language : values()) {
            if (language.code.equals(code)) {
                return language;
            }
        }
        throw new IllegalArgumentException("Invalid language code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
