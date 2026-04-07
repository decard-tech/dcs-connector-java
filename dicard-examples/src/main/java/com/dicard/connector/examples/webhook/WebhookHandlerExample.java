package com.dicard.connector.examples.webhook;

import com.dicard.connector.client.webhook.WebhookVerifier;
import com.dicard.connector.client.webhook.model.WebhookEvent;
import com.dicard.connector.client.webhook.model.WebhookPayload;

/**
 * Example of handling webhook notifications from dicard.
 *
 * <p>In your webhook endpoint (e.g. Spring Controller, Servlet, etc.),
 * use WebhookVerifier to validate and parse incoming notifications.
 */
public class WebhookHandlerExample {

    private final WebhookVerifier verifier = new WebhookVerifier("your-secret-key");

    /**
     * Simulates handling a webhook HTTP request.
     *
     * @param requestBody the raw HTTP body (JSON)
     * @param xSignature  the X-Signature header value
     */
    public void handleWebhook(String requestBody, String xSignature) {
        if (!verifier.verify(requestBody, xSignature)) {
            System.out.println("Invalid signature! Rejecting webhook.");
            return;
        }

        WebhookPayload payload = verifier.parse(requestBody);
        System.out.println("Webhook ID: " + payload.getWebhookId());
        System.out.println("Type: " + payload.getType());
        System.out.println("User: " + payload.getExternalUserId());
        System.out.println("Data: " + payload.getData());

        WebhookEvent event = payload.getEventType();
        if (event == null) {
            System.out.println("Unknown event type: " + payload.getType());
            return;
        }

        switch (event) {
            case KYC_STATUS:
                System.out.println("KYC status changed for user: " + payload.getExternalUserId());
                break;
            case CARD_TRANSACTION:
                System.out.println("Card transaction for user: " + payload.getExternalUserId());
                break;
            case BALANCE_CHANGE:
                System.out.println("Balance changed for user: " + payload.getExternalUserId());
                break;
            case CARD_APPLY:
                System.out.println("Card apply status for user: " + payload.getExternalUserId());
                break;
            case CARD_STATUS:
                System.out.println("Card status changed for user: " + payload.getExternalUserId());
                break;
            case ORDER_STATUS:
                System.out.println("Order status for user: " + payload.getExternalUserId());
                break;
            case FC_PAYMENT_INFO:
                System.out.println("FC payment info for user: " + payload.getExternalUserId());
                break;
            case FC_TRANSFER_INFO:
                System.out.println("FC transfer info for user: " + payload.getExternalUserId());
                break;
            case FC_WITHDRAW_INFO:
                System.out.println("FC withdraw info for user: " + payload.getExternalUserId());
                break;
            default:
                System.out.println("Event: " + event.getDescription());
                break;
        }
    }

    /**
     * Demonstrates using verifyAndParse for a more compact flow.
     */
    public void handleWebhookCompact(String requestBody, String xSignature) {
        try {
            WebhookPayload payload = verifier.verifyAndParse(requestBody, xSignature);
            System.out.println("Received valid webhook: " + payload.getType());
        } catch (SecurityException e) {
            System.out.println("Webhook signature invalid: " + e.getMessage());
        }
    }
}
