/*
 * CardBridge Java Connector
 * Generate Pre Upload URL Request model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Request model for generating pre-upload URLs
 */
public class GeneratePreUploadUrlRequest {
    
    /**
     * File names
     */
    @SerializedName("fileNames")
    private List<String> fileNames;
    
    /**
     * Business type
     * CREATE_CARD_EDD - EDD for card application
     * INCREASE_LIMIT_EDD - EDD for limit increase
     * CREATE_CARD_KYC - KYC files needed for card creation
     */
    @SerializedName("businessType")
    private String businessType;
    
    public GeneratePreUploadUrlRequest() {}
    
    public GeneratePreUploadUrlRequest(List<String> fileNames, String businessType) {
        this.fileNames = fileNames;
        this.businessType = businessType;
    }
    
    public List<String> getFileNames() {
        return fileNames;
    }
    
    public GeneratePreUploadUrlRequest setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
        return this;
    }
    
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Sets the business type using enum.
     *
     * @param businessType the business type enum
     * @return this GeneratePreUploadUrlRequest instance for method chaining
     */
    public GeneratePreUploadUrlRequest setBusinessType(BusinessType businessType) {
        this.businessType = businessType.getCode();
        return this;
    }

    /**
     * Validates the request parameters.
     *
     * @throws IllegalArgumentException if the request is invalid
     */
    public void validate() {
        if (fileNames == null || fileNames.isEmpty()) {
            throw new IllegalArgumentException("File names list cannot be null or empty");
        }

        if (businessType == null || businessType.trim().isEmpty()) {
            throw new IllegalArgumentException("Business type cannot be null or empty");
        }

        // Validate business type
        try {
            BusinessType.fromCode(businessType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid business type: " + businessType);
        }
        // Check file count limit (reasonable limit)
        if (fileNames.size() > 10) {
            throw new IllegalArgumentException("Too many files. Maximum 10 files allowed per request");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneratePreUploadUrlRequest that = (GeneratePreUploadUrlRequest) o;
        return Objects.equals(fileNames, that.fileNames) &&
                Objects.equals(businessType, that.businessType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fileNames, businessType);
    }
    
    @Override
    public String toString() {
        return "GeneratePreUploadUrlRequest{" +
                "fileNames=" + fileNames +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
