/*
 * dcs Java Connector
 * Freeze reason enumeration
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.card.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of card freeze reasons.
 * 
 * <p>This enum defines the standard reasons for freezing a card.
 * These values are used to track why a card was frozen and help with
 * audit trails and compliance reporting.
 * 
 * <p>The values must match the backend API CardStatusReasonEnum to ensure
 * proper synchronization between client and server systems.
 * 
 * <p>Usage examples:
 * <pre>{@code
 * // Using enum directly
 * FreezeCardRequest request = new FreezeCardRequest();
 * request.setFreezeReason(FreezeReason.USER_FREEZE);
 * 
 * // Converting from code
 * FreezeReason reason = FreezeReason.fromCode("USER_FREEZE");
 * 
 * // Getting description for display
 * String description = FreezeReason.USER_FREEZE.getDescription();
 * }</pre>
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public enum FreezeReason {
    
    /**
     * Normal status (no special marking).
     * 
     * <p>This indicates that the card is in a normal operational state
     * without any special restrictions or freeze conditions. This is
     * typically used when unfreezing a card or when no specific reason
     * is applicable.
     */
    @SerializedName("NORMAL")
    NORMAL("NORMAL", "Normal status"),
    
    /**
     * User requested freeze.
     * 
     * <p>This indicates that the cardholder or an authorized user has
     * specifically requested that the card be frozen. This is commonly
     * used for:
     * <ul>
     *   <li>Temporary suspension while traveling</li>
     *   <li>Precautionary measure when card is misplaced</li>
     *   <li>User-initiated security measure</li>
     *   <li>Temporary account management</li>
     * </ul>
     */
    @SerializedName("USER_FREEZE")
    USER_FREEZE("USER_FREEZE", "User requested freeze");

    private final String code;
    private final String description;

    FreezeReason(String code, String description) {
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
     * Gets the FreezeReason by code.
     *
     * @param code the reason code
     * @return the corresponding FreezeReason
     * @throws IllegalArgumentException if the code is not valid
     */
    public static FreezeReason fromCode(String code) {
        for (FreezeReason reason : values()) {
            if (reason.code.equals(code)) {
                return reason;
            }
        }
        throw new IllegalArgumentException("Invalid freeze reason code: " + code);
    }

    @Override
    public String toString() {
        return code;
    }
}
