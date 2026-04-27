package com.streaming.subscriptions;

import java.time.LocalDate;

/**
 * Class representing a user's subscription details.
 */
public class Subscription {
    private PlanType planType;
    private LocalDate startDate;
    private LocalDate expiryDate;
    private boolean isActive;

    public Subscription(PlanType planType) {
        this.planType = planType;
        this.startDate = LocalDate.now();
        this.expiryDate = startDate.plusMonths(1);
        this.isActive = true;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public boolean isActive() {
        return isActive && LocalDate.now().isBefore(expiryDate);
    }

    public void setInactive() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Plan: " + planType + " (Valid until: " + expiryDate + ")";
    }
}
