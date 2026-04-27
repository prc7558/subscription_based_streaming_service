package com.streaming.users;

import com.streaming.subscriptions.Subscription;
import com.streaming.subscriptions.SubscriptionException;
import com.streaming.content.Content;

/**
 * Class representing a application user.
 */
public class User {
    private String name;
    private String email;
    private Subscription subscription;
    private WatchHistory history;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.history = new WatchHistory();
    }

    public void subscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Attempts to watch content.
     * @param content The content to watch.
     * @throws SubscriptionException If the user does not have an active plan.
     */
    public void watch(Content content) throws SubscriptionException {
        if (subscription == null || !subscription.isActive()) {
            throw new SubscriptionException("Access Denied: Please activate your subscription to watch " + content.getTitle());
        }
        content.play();
        history.addItem(content);
    }


    public String getName() { return name; }
    public WatchHistory getHistory() { return history; }
    public Subscription getSubscription() { return subscription; }

    @Override
    public String toString() {
        return "User: " + name + " (" + email + ") | " + (subscription != null ? subscription : "No Active Plan");
    }
}
