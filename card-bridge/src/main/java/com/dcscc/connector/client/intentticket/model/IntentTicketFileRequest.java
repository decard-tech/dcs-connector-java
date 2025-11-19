/*
 * CardBridge Java Connector
 * Intent Ticket File Request model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for intent ticket file information
 */
public class IntentTicketFileRequest {
    
    /**
     * File name
     */
    @SerializedName("fileName")
    private String fileName;
    
    /**
     * File path
     */
    @SerializedName("filePath")
    private String filePath;
    
    public IntentTicketFileRequest() {}
    
    public IntentTicketFileRequest(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public IntentTicketFileRequest setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public IntentTicketFileRequest setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }
    
    // For backward compatibility with examples
    public IntentTicketFileRequest setFileUrl(String fileUrl) {
        this.filePath = fileUrl;
        return this;
    }
    
    public String getFileUrl() {
        return filePath;
    }
    
    public IntentTicketFileRequest setFileType(String fileType) {
        // This is for example compatibility, actual API doesn't use fileType
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntentTicketFileRequest that = (IntentTicketFileRequest) o;
        return Objects.equals(fileName, that.fileName) &&
                Objects.equals(filePath, that.filePath);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fileName, filePath);
    }
    
    @Override
    public String toString() {
        return "IntentTicketFileRequest{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
