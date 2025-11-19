/*
 * CardBridge Java Connector
 * Intent Ticket Response model
 *
 * The version of the CardBridge API: 1.0.0
 */

package com.dcscc.connector.client.intentticket.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Response model for intent ticket operations
 */
public class IntentTicketResponse {
    
    /**
     * Ticket ID
     */
    @SerializedName("ticketId")
    private String ticketId;
    
    /**
     * Ticket type
     * eg: CREATE_CARD_EDD/INCREASE_LIMIT_EDD
     */
    @SerializedName("ticketType")
    private String ticketType;
    
    /**
     * Ticket status
     * eg: INIT/SUBMIT_COMPETED/CHECK_PASS/SUCCEED/FAILED
     */
    @SerializedName("ticketStatus")
    private String ticketStatus;
    
    /**
     * External unique ID
     */
    @SerializedName("ticketRef")
    private String ticketRef;
    
    /**
     * Create time
     * eg:yyyy-MM-dd'T'HH:mm:ss+08:00
     */
    @SerializedName("createTime")
    private String createTime;
    
    /**
     * Last update time
     * eg:yyyy-MM-dd'T'HH:mm:ss+08:00
     */
    @SerializedName("modifyTime")
    private String modifyTime;
    
    public IntentTicketResponse() {}
    
    public String getTicketId() {
        return ticketId;
    }
    
    public IntentTicketResponse setTicketId(String ticketId) {
        this.ticketId = ticketId;
        return this;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public IntentTicketResponse setTicketType(String ticketType) {
        this.ticketType = ticketType;
        return this;
    }
    
    public String getTicketStatus() {
        return ticketStatus;
    }
    
    public IntentTicketResponse setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
        return this;
    }
    
    public String getTicketRef() {
        return ticketRef;
    }
    
    public IntentTicketResponse setTicketRef(String ticketRef) {
        this.ticketRef = ticketRef;
        return this;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public IntentTicketResponse setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
    
    public String getModifyTime() {
        return modifyTime;
    }
    
    public IntentTicketResponse setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntentTicketResponse that = (IntentTicketResponse) o;
        return Objects.equals(ticketId, that.ticketId) &&
                Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(ticketStatus, that.ticketStatus) &&
                Objects.equals(ticketRef, that.ticketRef) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(ticketId, ticketType, ticketStatus, ticketRef, createTime, modifyTime);
    }
    
    @Override
    public String toString() {
        return "IntentTicketResponse{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", ticketRef='" + ticketRef + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
