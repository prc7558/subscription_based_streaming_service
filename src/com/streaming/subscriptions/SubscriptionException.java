package com.streaming.subscriptions;

/**
 * Custom exception thrown when a subscription-related error occurs,
 * such as attempting to access content without an active plan.
 */
public class SubscriptionException extends Exception {
    public SubscriptionException(String message) {
        super(message);
    }
}
