package com.dicard.connector.client.redirect.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request to generate a guidance page URL.
 *
 * <p>Supported action types:
 * <ul>
 *   <li>KYC_GUIDE - KYC guidance page</li>
 *   <li>CARD_INFO - Card information</li>
 *   <li>CREATE_PHYSICAL_CARD - Physical card application</li>
 *   <li>ACTIVE_PHYSICAL_CARD - Physical card activation</li>
 *   <li>UPDATE_PIN - Update PIN</li>
 *   <li>TRAVEL_RULE - Update travel rule</li>
 *   <li>KYC_EXTRA_DOC - KYC supplementary documents</li>
 * </ul>
 */
public class GuidanceRequest {

    @SerializedName("action")
    private String action;

    @SerializedName("externalUserId")
    private String externalUserId;

    @SerializedName("successRedirectUrl")
    private String successRedirectUrl;

    @SerializedName("errorRedirectUrl")
    private String errorRedirectUrl;

    @SerializedName("referer")
    private String referer;

    @SerializedName("userAgent")
    private String userAgent;

    @SerializedName("cardMantissa")
    private String cardMantissa;

    @SerializedName("language")
    private String language;

    @SerializedName("selectCardPageShow")
    private String selectCardPageShow;

    @SerializedName("theme")
    private String theme;

    @SerializedName("mode")
    private String mode;

    @SerializedName("primaryColor")
    private String primaryColor;

    public GuidanceRequest() {}

    public String getAction() { return action; }
    public GuidanceRequest setAction(String action) { this.action = action; return this; }
    public String getExternalUserId() { return externalUserId; }
    public GuidanceRequest setExternalUserId(String externalUserId) { this.externalUserId = externalUserId; return this; }
    public String getSuccessRedirectUrl() { return successRedirectUrl; }
    public GuidanceRequest setSuccessRedirectUrl(String successRedirectUrl) { this.successRedirectUrl = successRedirectUrl; return this; }
    public String getErrorRedirectUrl() { return errorRedirectUrl; }
    public GuidanceRequest setErrorRedirectUrl(String errorRedirectUrl) { this.errorRedirectUrl = errorRedirectUrl; return this; }
    public String getReferer() { return referer; }
    public GuidanceRequest setReferer(String referer) { this.referer = referer; return this; }
    public String getUserAgent() { return userAgent; }
    public GuidanceRequest setUserAgent(String userAgent) { this.userAgent = userAgent; return this; }
    public String getCardMantissa() { return cardMantissa; }
    public GuidanceRequest setCardMantissa(String cardMantissa) { this.cardMantissa = cardMantissa; return this; }
    public String getLanguage() { return language; }
    public GuidanceRequest setLanguage(String language) { this.language = language; return this; }
    public String getSelectCardPageShow() { return selectCardPageShow; }
    public GuidanceRequest setSelectCardPageShow(String selectCardPageShow) { this.selectCardPageShow = selectCardPageShow; return this; }
    public String getTheme() { return theme; }
    public GuidanceRequest setTheme(String theme) { this.theme = theme; return this; }
    public String getMode() { return mode; }
    public GuidanceRequest setMode(String mode) { this.mode = mode; return this; }
    public String getPrimaryColor() { return primaryColor; }
    public GuidanceRequest setPrimaryColor(String primaryColor) { this.primaryColor = primaryColor; return this; }

    public void validate() {
        if (action == null || action.trim().isEmpty()) {
            throw new IllegalArgumentException("action is required");
        }
        if (externalUserId == null || externalUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("externalUserId is required");
        }
        if (successRedirectUrl == null || successRedirectUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("successRedirectUrl is required");
        }
        if (errorRedirectUrl == null || errorRedirectUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("errorRedirectUrl is required");
        }
    }

    @Override
    public String toString() {
        return "GuidanceRequest{action='" + action + "', externalUserId='" + externalUserId + "'}";
    }
}
