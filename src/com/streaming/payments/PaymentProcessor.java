package com.streaming.payments;

import com.streaming.subscriptions.PlanType;
import java.util.UUID;

/**
 * Service to simulate payment processing.
 */
public class PaymentProcessor {
    /**
     * Processes a payment for a specific plan.
     * @param plan The plan being purchased.
     * @return A Payment object representing the transaction.
     */
    public static Payment process(PlanType plan) {
        System.out.println("Connecting to payment gateway for amount: " + plan.getPrice() + "...");
        
        // Simulating processing delay
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String txId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return new Payment(txId, plan.getPrice(), "SUCCESS");
    }
}
