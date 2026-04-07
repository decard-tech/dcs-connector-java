package com.dicard.connector.client.webhook.model;

import com.google.gson.annotations.SerializedName;

/**
 * Webhook notification payload sent by dicard to the client's webhook URL.
 *
 * <p>The payload is sent as JSON in the HTTP request body with an {@code X-Signature}
 * header containing the HMAC-SHA256 signature for verification.
 *
 * <p>JSON fields are serialized in alphabetical order for signature computation.
 *
 * @since 1.0.0
 */
public class WebhookPayload {

    @SerializedName("webhookId")
    private String webhookId;

    @SerializedName("type")
    private String type;

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("data")
    private Object data;

    @SerializedName("notificationTimestamp")
    private Long notificationTimestamp;

    @SerializedName("eventTimestamp")
    private Long eventTimestamp;

    public WebhookPayload() {
    }

    public String getWebhookId() {
        return webhookId;
    }

    public WebhookPayload setWebhookId(String webhookId) {
        this.webhookId = webhookId;
        return this;
    }

    public String getType() {
        return type;
    }

    public WebhookPayload setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Returns the parsed event type enum, or null if the type is unknown.
     */
    public WebhookEvent getEventType() {
        return WebhookEvent.fromCode(type);
    }

    public String getExternalUserId() {
        return externalUserId;
    }

    public WebhookPayload setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
        return this;
    }

    public Object getData() {
        return data;
    }

    public WebhookPayload setData(Object data) {
        this.data = data;
        return this;
    }

    public Long getNotificationTimestamp() {
        return notificationTimestamp;
    }

    public WebhookPayload setNotificationTimestamp(Long notificationTimestamp) {
        this.notificationTimestamp = notificationTimestamp;
        return this;
    }

    public Long getEventTimestamp() {
        return eventTimestamp;
    }

    public WebhookPayload setEventTimestamp(Long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
        return this;
    }

    @Override
    public String toString() {
        return "WebhookPayload{"
                + "webhookId='" + webhookId + '\''
                + ", type='" + type + '\''
                + ", externalUserId='" + externalUserId + '\''
                + ", notificationTimestamp=" + notificationTimestamp
                + ", eventTimestamp=" + eventTimestamp
                + '}';
    }
}
