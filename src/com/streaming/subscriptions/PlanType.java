package com.streaming.subscriptions;

/**
 * Enum defining the available subscription plans.
 */
public enum PlanType {
    BASIC(499),
    PREMIUM(999);

    private double price;

    PlanType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
