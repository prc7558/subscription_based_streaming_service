package com.streaming.payments;

import java.time.LocalDateTime;

/**
 * Class representing a single payment transaction.
 */
public class Payment {
    private String transactionId;
    private double amount;
    private LocalDateTime timestamp;
    private String status;

    public Payment(String transactionId, double amount, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction [" + transactionId + "] - Amount: " + amount + " - Status: " + status + " (" + timestamp + ")";
    }
}
