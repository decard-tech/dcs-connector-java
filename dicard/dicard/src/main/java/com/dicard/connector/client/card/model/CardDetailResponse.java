package com.dicard.connector.client.card.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * Card detail response.
 */
public class CardDetailResponse {

    @SerializedName("association")
    private String association;

    @SerializedName("cardType")
    private String cardType;

    @SerializedName("cardNo")
    private String cardNo;

    @SerializedName("cardHolder")
    private String cardHolder;

    @SerializedName("cardImage")
    private String cardImage;

    @SerializedName("cardEmbossingName")
    private String cardEmbossingName;

    @SerializedName("cardStatus")
    private String cardStatus;

    @SerializedName("physicalCardStatus")
    private String physicalCardStatus;

    @SerializedName("walletBalance")
    private BigDecimal walletBalance;

    @SerializedName("caBalance")
    private BigDecimal caBalance;

    @SerializedName("cardBalance")
    private BigDecimal cardBalance;

    @SerializedName("points")
    private Integer points;

    @SerializedName("billingCurrency")
    private String billingCurrency;

    @SerializedName("balanceCurrency")
    private String balanceCurrency;

    public CardDetailResponse() {}

    public String getAssociation() { return association; }
    public CardDetailResponse setAssociation(String association) { this.association = association; return this; }
    public String getCardType() { return cardType; }
    public CardDetailResponse setCardType(String cardType) { this.cardType = cardType; return this; }
    public String getCardNo() { return cardNo; }
    public CardDetailResponse setCardNo(String cardNo) { this.cardNo = cardNo; return this; }
    public String getCardHolder() { return cardHolder; }
    public CardDetailResponse setCardHolder(String cardHolder) { this.cardHolder = cardHolder; return this; }
    public String getCardImage() { return cardImage; }
    public CardDetailResponse setCardImage(String cardImage) { this.cardImage = cardImage; return this; }
    public String getCardEmbossingName() { return cardEmbossingName; }
    public CardDetailResponse setCardEmbossingName(String cardEmbossingName) { this.cardEmbossingName = cardEmbossingName; return this; }
    public String getCardStatus() { return cardStatus; }
    public CardDetailResponse setCardStatus(String cardStatus) { this.cardStatus = cardStatus; return this; }
    public String getPhysicalCardStatus() { return physicalCardStatus; }
    public CardDetailResponse setPhysicalCardStatus(String physicalCardStatus) { this.physicalCardStatus = physicalCardStatus; return this; }
    public BigDecimal getWalletBalance() { return walletBalance; }
    public CardDetailResponse setWalletBalance(BigDecimal walletBalance) { this.walletBalance = walletBalance; return this; }
    public BigDecimal getCaBalance() { return caBalance; }
    public CardDetailResponse setCaBalance(BigDecimal caBalance) { this.caBalance = caBalance; return this; }
    public BigDecimal getCardBalance() { return cardBalance; }
    public CardDetailResponse setCardBalance(BigDecimal cardBalance) { this.cardBalance = cardBalance; return this; }
    public Integer getPoints() { return points; }
    public CardDetailResponse setPoints(Integer points) { this.points = points; return this; }
    public String getBillingCurrency() { return billingCurrency; }
    public CardDetailResponse setBillingCurrency(String billingCurrency) { this.billingCurrency = billingCurrency; return this; }
    public String getBalanceCurrency() { return balanceCurrency; }
    public CardDetailResponse setBalanceCurrency(String balanceCurrency) { this.balanceCurrency = balanceCurrency; return this; }

    @Override
    public String toString() {
        return "CardDetailResponse{cardNo='" + cardNo + "', cardStatus='" + cardStatus + "', cardType='" + cardType + "'}";
    }
}
