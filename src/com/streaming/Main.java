package com.streaming;

import com.streaming.content.*;
import com.streaming.users.*;
import com.streaming.subscriptions.*;
import com.streaming.payments.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Main application class to demonstrate the streaming service functionality.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Java Streaming Service Simulation ===\n");

        // 1. Initialize Content Library
        List<Content> library = new ArrayList<>();
        library.add(new Movie("Inception", "Sci-Fi", 4.8, 148));
        library.add(new Movie("The Dark Knight", "Action", 4.9, 152));
        library.add(new Series("Stranger Things", "Sci-Fi", 4.7, 34));
        library.add(new Series("Breaking Bad", "Crime", 4.9, 62));
        library.add(new Movie("Toy Story", "Animation", 4.3, 81));
        library.add(new Movie("Interstellar", "Sci-Fi", 4.6, 169));
        library.add(new Series("The Expanse", "Sci-Fi", 4.5, 62));

        // 2. Create a User
        User user = new User("Alex", "alex@example.com");
        System.out.println("New User Created: " + user.getName());
        System.out.println(user + "\n");

        // 3. Attempt to watch without subscription
        System.out.println("Attempting to watch content...");
        try {
            user.watch(library.get(0));
        } catch (SubscriptionException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }
        System.out.println();

        // 4. Process Subscription and Payment
        System.out.println("Upgrading to PREMIUM plan...");
        PlanType selectedPlan = PlanType.PREMIUM;
        Payment payment = PaymentProcessor.process(selectedPlan);
        System.out.println(payment);
        
        Subscription sub = new Subscription(selectedPlan);
        user.subscribe(sub);
        System.out.println("Subscription activated!");
        System.out.println(user + "\n");

        // 5. Watch Content
        System.out.println("Watching some content...");
        try {
            user.watch(library.get(0)); // Inception (Sci-Fi)
            user.watch(library.get(2)); // Stranger Things (Sci-Fi)
        } catch (SubscriptionException e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
        System.out.println();

        // 6. View History
        System.out.println(user.getHistory());

        // 7. Get Recommendations
        System.out.println("Personalized Recommendations:");
        List<Content> suggestions = RecommendationSystem.recommend(user, library);
        for (Content c : suggestions) {
            System.out.println(">>> Suggested: " + c);
        }

        System.out.println("\n=== Simulation Complete ===");
    }
}
