package com.dicard.connector.client.account.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to generate pre-signed upload URLs for files.
 */
public class UploadPrepareRequest {

    @SerializedName("fileNames")
    private List<String> fileNames;

    public UploadPrepareRequest() {}

    public List<String> getFileNames() { return fileNames; }
    public UploadPrepareRequest setFileNames(List<String> fileNames) { this.fileNames = fileNames; return this; }

    public void validate() {
        if (fileNames == null || fileNames.isEmpty()) {
            throw new IllegalArgumentException("fileNames is required");
        }
    }

    @Override
    public String toString() {
        return "UploadPrepareRequest{fileNames=" + fileNames + "}";
    }
}
