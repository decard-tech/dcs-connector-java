/*
 * CardBridge Java Connector
 * Pre Upload URL Response model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Response model for pre-upload URL generation
 */
public class PreUploadUrlResponse {
    
    @SerializedName("uploadFileResponses")
    private List<UploadFileResponse> uploadFileResponses;
    
    public PreUploadUrlResponse() {}
    
    public PreUploadUrlResponse(List<UploadFileResponse> uploadFileResponses) {
        this.uploadFileResponses = uploadFileResponses;
    }
    
    public List<UploadFileResponse> getUploadFileResponses() {
        return uploadFileResponses;
    }
    
    public PreUploadUrlResponse setUploadFileResponses(List<UploadFileResponse> uploadFileResponses) {
        this.uploadFileResponses = uploadFileResponses;
        return this;
    }
    
    /**
     * Individual file upload response
     */
    public static class UploadFileResponse {
        
        /**
         * Original file name
         */
        @SerializedName("fileName")
        private String fileName;
        
        /**
         * Upload URL
         * Valid for one hour
         */
        @SerializedName("url")
        private String url;
        
        /**
         * Renamed file name
         */
        @SerializedName("objectKey")
        private String objectKey;
        
        public UploadFileResponse() {}
        
        public UploadFileResponse(String fileName, String url, String objectKey) {
            this.fileName = fileName;
            this.url = url;
            this.objectKey = objectKey;
        }
        
        public String getFileName() {
            return fileName;
        }
        
        public UploadFileResponse setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        
        public String getUrl() {
            return url;
        }
        
        public UploadFileResponse setUrl(String url) {
            this.url = url;
            return this;
        }
        
        public String getObjectKey() {
            return objectKey;
        }
        
        public UploadFileResponse setObjectKey(String objectKey) {
            this.objectKey = objectKey;
            return this;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UploadFileResponse that = (UploadFileResponse) o;
            return Objects.equals(fileName, that.fileName) &&
                    Objects.equals(url, that.url) &&
                    Objects.equals(objectKey, that.objectKey);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(fileName, url, objectKey);
        }
        
        @Override
        public String toString() {
            return "UploadFileResponse{" +
                    "fileName='" + fileName + '\'' +
                    ", url='" + url + '\'' +
                    ", objectKey='" + objectKey + '\'' +
                    '}';
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreUploadUrlResponse that = (PreUploadUrlResponse) o;
        return Objects.equals(uploadFileResponses, that.uploadFileResponses);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(uploadFileResponses);
    }
    
    @Override
    public String toString() {
        return "PreUploadUrlResponse{" +
                "uploadFileResponses=" + uploadFileResponses +
                '}';
    }
}
