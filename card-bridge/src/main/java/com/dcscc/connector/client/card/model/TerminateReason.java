/*
 * dcs Java Connector
 * Terminate reason enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of card termination reasons.
 * 
 * <p>This enum defines the standard reasons for permanently terminating a card.
 * These values are critical for compliance, fraud tracking, and regulatory
 * reporting. Once a card is terminated with one of these reasons, it cannot
 * be reactivated.
 * 
 * <p>The values must match the backend API to ensure proper processing
 * and audit trail maintenance.
 * 
 * <p>Termination reasons are used for:
 * <ul>
 *   <li>Fraud prevention and investigation</li>
 *   <li>Regulatory compliance reporting</li>
 *   <li>Customer service and dispute resolution</li>
 *   <li>Risk management and analytics</li>
 * </ul>
 * 
 * <p>Usage examples:
 * <pre>{@code
 * // Using enum directly
 * TerminateCardRequest request = new TerminateCardRequest();
 * request.setInvalidateReason(TerminateReason.CARD_LOST);
 * 
 * // Converting from code
 * TerminateReason reason = TerminateReason.fromCode("CARD_STOLEN");
 * 
 * // Getting description for logging
 * String description = TerminateReason.CARD_LOST.getDescription();
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum TerminateReason {
    
    /**
     * Card reported as lost.
     * 
     * <p>This reason is used when the cardholder reports that their card
     * has been lost or misplaced. The card is terminated to prevent
     * unauthorized use if found by someone else.
     * 
     * <p>Common scenarios:
     * <ul>
     *   <li>Cardholder cannot locate their physical card</li>
     *   <li>Card may have been dropped or left somewhere</li>
     *   <li>Precautionary measure when card location is unknown</li>
     * </ul>
     * 
     * <p>This termination reason typically triggers:
     * <ul>
     *   <li>Immediate card deactivation</li>
     *   <li>Fraud monitoring alerts</li>
     *   <li>Replacement card issuance process</li>
     * </ul>
     */
    @SerializedName("CARD_LOST")
    CARD_LOST("CARD_LOST", "Card reported as lost"),
    
    /**
     * Card reported as stolen.
     * 
     * <p>This reason is used when the cardholder reports that their card
     * has been stolen or taken without authorization. This is a high-priority
     * security event that requires immediate action.
     * 
     * <p>Common scenarios:
     * <ul>
     *   <li>Card taken during theft or robbery</li>
     *   <li>Wallet or purse stolen containing the card</li>
     *   <li>Suspected unauthorized possession of card</li>
     * </ul>
     * 
     * <p>This termination reason typically triggers:
     * <ul>
     *   <li>Immediate card deactivation</li>
     *   <li>High-priority fraud alerts</li>
     *   <li>Enhanced monitoring of related accounts</li>
     *   <li>Potential law enforcement notification</li>
     *   <li>Expedited replacement card processing</li>
     * </ul>
     */
    @SerializedName("CARD_STOLEN")
    CARD_STOLEN("CARD_STOLEN", "Card reported as stolen");

    private final String code;
    private final String description;

    TerminateReason(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the reason code.
     *
     * @return the reason code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the reason description.
     *
     * @return the reason description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the TerminateReason by code.
     *
     * @param code the reason code
     * @return the corresponding TerminateReason
     * @throws IllegalArgumentException if the code is not valid
     */
    public static TerminateReason fromCode(String code) {
        for (TerminateReason reason : values()) {
            if (reason.code.equals(code)) {
                return reason;
            }
        }
        throw new IllegalArgumentException("Invalid terminate reason code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
