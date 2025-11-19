/*
 * CardBridge Java Connector
 * Balance response model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.enterprise.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Enterprise balance response model.
 * 
 * <p>This class represents the response data for enterprise balance inquiries.
 * It contains comprehensive balance information including total, available,
 * and used amounts.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class BalanceResponse {

    /**
     * Currency
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Total amount
     */
    @SerializedName("totalAmount")
    private BigDecimal totalAmount;

    /**
     * Available amount
     */
    @SerializedName("availableAmount")
    private BigDecimal availableAmount;

    /**
     * Used amount
     */
    @SerializedName("usedAmount")
    private BigDecimal usedAmount;

    /**
     * Default constructor.
     */
    public BalanceResponse() {
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency the currency to set
     * @return this BalanceResponse instance for method chaining
     */
    public BalanceResponse setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Gets the total amount.
     *
     * @return the total amount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount.
     *
     * @param totalAmount the total amount to set
     * @return this BalanceResponse instance for method chaining
     */
    public BalanceResponse setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    /**
     * Gets the available amount.
     *
     * @return the available amount
     */
    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    /**
     * Sets the available amount.
     *
     * @param availableAmount the available amount to set
     * @return this BalanceResponse instance for method chaining
     */
    public BalanceResponse setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
        return this;
    }

    /**
     * Gets the used amount.
     *
     * @return the used amount
     */
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    /**
     * Sets the used amount.
     *
     * @param usedAmount the used amount to set
     * @return this BalanceResponse instance for method chaining
     */
    public BalanceResponse setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceResponse that = (BalanceResponse) o;
        return Objects.equals(currency, that.currency) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(availableAmount, that.availableAmount) &&
                Objects.equals(usedAmount, that.usedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, totalAmount, availableAmount, usedAmount);
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", availableAmount=" + availableAmount +
                ", usedAmount=" + usedAmount +
                '}';
    }
}
