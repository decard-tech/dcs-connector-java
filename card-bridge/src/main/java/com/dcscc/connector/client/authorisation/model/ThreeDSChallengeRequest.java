/*
 * dcs Java Connector
 * 3DS challenge request model
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.authorisation.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Request model for 3DS challenge authentication.
 * 
 * <p>This class represents the request parameters for processing a 3DS challenge
 * authentication result. It contains the challenge ID and the approval status
 * determined by the cardholder's response to the authentication challenge.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class ThreeDSChallengeRequest {

    /**
     * Unique identifier for the 3DS challenge.
     */
    @SerializedName("challengeId")
    private String challengeId;

    /**
     * Approval status of the challenge (APPROVED, DECLINED, etc.).
     */
    @SerializedName("approveStatus")
    private String approveStatus;

    /**
     * Default constructor.
     */
    public ThreeDSChallengeRequest() {
    }

    /**
     * Constructor with required parameters.
     *
     * @param challengeId the challenge ID
     * @param approveStatus the approval status
     */
    public ThreeDSChallengeRequest(String challengeId, String approveStatus) {
        this.challengeId = challengeId;
        this.approveStatus = approveStatus;
    }

    /**
     * Gets the challenge ID.
     *
     * @return the challenge ID
     */
    public String getChallengeId() {
        return challengeId;
    }

    /**
     * Sets the challenge ID.
     *
     * @param challengeId the challenge ID to set
     * @return this ThreeDSChallengeRequest instance for method chaining
     */
    public ThreeDSChallengeRequest setChallengeId(String challengeId) {
        this.challengeId = challengeId;
        return this;
    }

    /**
     * Gets the approve status.
     *
     * @return the approve status
     */
    public String getApproveStatus() {
        return approveStatus;
    }

    /**
     * Sets the approve status.
     *
     * @param approveStatus the approve status to set
     * @return this ThreeDSChallengeRequest instance for method chaining
     */
    public ThreeDSChallengeRequest setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
        return this;
    }

    /**
     * Sets the approve status using enum.
     *
     * @param approveStatus the approve status enum
     * @return this ThreeDSChallengeRequest instance for method chaining
     */
    public ThreeDSChallengeRequest setApproveStatus(ApproveStatus approveStatus) {
        this.approveStatus = approveStatus.getCode();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreeDSChallengeRequest that = (ThreeDSChallengeRequest) o;
        return Objects.equals(challengeId, that.challengeId) && Objects.equals(approveStatus, that.approveStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(challengeId, approveStatus);
    }

    @Override
    public String toString() {
        return "ThreeDSChallengeRequest{" +
                "challengeId='" + challengeId + '\'' +
                ", approveStatus='" + approveStatus + '\'' +
                '}';
    }
}
