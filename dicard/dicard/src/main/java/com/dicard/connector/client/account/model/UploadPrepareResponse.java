package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response containing pre-signed upload URLs.
 */
public class UploadPrepareResponse {

    @SerializedName("uploadFileResponses")
    private List<UploadFileResponse> uploadFileResponses;

    public UploadPrepareResponse() {}

    public List<UploadFileResponse> getUploadFileResponses() { return uploadFileResponses; }
    public UploadPrepareResponse setUploadFileResponses(List<UploadFileResponse> uploadFileResponses) { this.uploadFileResponses = uploadFileResponses; return this; }

    @Override
    public String toString() {
        return "UploadPrepareResponse{uploadFileResponses=" + uploadFileResponses + "}";
    }

    public static class UploadFileResponse {
        @SerializedName("fileName")
        private String fileName;
        @SerializedName("url")
        private String url;
        @SerializedName("objectKey")
        private String objectKey;

        public UploadFileResponse() {}
        public String getFileName() { return fileName; }
        public UploadFileResponse setFileName(String fileName) { this.fileName = fileName; return this; }
        public String getUrl() { return url; }
        public UploadFileResponse setUrl(String url) { this.url = url; return this; }
        public String getObjectKey() { return objectKey; }
        public UploadFileResponse setObjectKey(String objectKey) { this.objectKey = objectKey; return this; }

        @Override
        public String toString() {
            return "UploadFileResponse{fileName='" + fileName + "', objectKey='" + objectKey + "'}";
        }
    }
}
