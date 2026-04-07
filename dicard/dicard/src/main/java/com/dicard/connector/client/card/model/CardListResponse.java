package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response for card category list.
 */
public class CardListResponse {

    @SerializedName("association")
    private String association;

    @SerializedName("type")
    private String type;

    @SerializedName("name")
    private String name;

    @SerializedName("badge")
    private String badge;

    @SerializedName("image")
    private String image;

    @SerializedName("tags")
    private List<String> tags;

    public CardListResponse() {}

    public String getAssociation() { return association; }
    public CardListResponse setAssociation(String association) { this.association = association; return this; }
    public String getType() { return type; }
    public CardListResponse setType(String type) { this.type = type; return this; }
    public String getName() { return name; }
    public CardListResponse setName(String name) { this.name = name; return this; }
    public String getBadge() { return badge; }
    public CardListResponse setBadge(String badge) { this.badge = badge; return this; }
    public String getImage() { return image; }
    public CardListResponse setImage(String image) { this.image = image; return this; }
    public List<String> getTags() { return tags; }
    public CardListResponse setTags(List<String> tags) { this.tags = tags; return this; }

    @Override
    public String toString() {
        return "CardListResponse{association='" + association + "', type='" + type + "', name='" + name + "'}";
    }
}
