package com.dicard.connector.client.webhook.model;

/**
 * Webhook event types pushed by dicard to the client's configured webhook URL.
 *
 * <p>These event types are shared between webhook and WebSocket notifications.
 *
 * @since 1.0.0
 */
public enum WebhookEvent {

    KYC_STATUS("KYC_STATUS", "KYC status change"),
    BALANCE_CHANGE("BALANCE_CHANGE", "Wallet balance change"),
    CARD_TRANSACTION("CARD_TRANSACTION", "Card transaction"),
    ORDER_STATUS("ORDER_STATUS", "Deposit order status"),
    CARD_PHYSICAL_SHIPPING("CARD_PHYSICAL_SHIPPING", "Physical card shipping status"),
    CARD_TRANSACTION_SETTLEMENT("CARD_TRANSACTION_SETTLEMENT", "Authorization settlement"),
    QR_ORDER_STATUS("QR_ORDER_STATUS", "QR Pay order status"),
    BANK_TRANSFER_INFO("BANK_TRANSFER_INFO", "Bank transfer deposit info"),
    FC_PAYMENT_INFO("FC_PAYMENT_INFO", "Financial connection payment info"),
    FC_TRANSFER_INFO("FC_TRANSFER_INFO", "Financial connection transfer info"),
    FC_WITHDRAW_INFO("FC_WITHDRAW_INFO", "Financial connection withdrawal info"),
    CARD_APPLY("CARD_APPLY", "Card application status"),
    CARD_STATUS("CARD_STATUS", "Card status change");

    private final String code;
    private final String description;

    WebhookEvent(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Finds a WebhookEvent by its code string.
     *
     * @param code the event code
     * @return the matching WebhookEvent, or null if not found
     */
    public static WebhookEvent fromCode(String code) {
        if (code == null) return null;
        for (WebhookEvent event : values()) {
            if (event.code.equals(code)) {
                return event;
            }
        }
        return null;
    }
}
