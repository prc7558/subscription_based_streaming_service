package com.streaming.users;

import com.streaming.content.Content;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic recommendation system based on user watch history.
 */
public class RecommendationSystem {
    /**
     * Recommends content based on the most common genre in the history.
     * @param user The user to recommend content for.
     * @param availableContent Total content library.
     * @return List of suggested content.
     */
    public static List<Content> recommend(User user, List<Content> availableContent) {
        List<Content> history = user.getHistory().getWatchedItems();
        
        if (history.isEmpty()) {
            // Default: Recommend top rated content if history is empty
            return availableContent.stream()
                .filter(c -> c.getRating() >= 4.5)
                .limit(2)
                .collect(Collectors.toList());
        }

        // Logic: Find most watched genre (simplified)
        String favoriteGenre = history.get(0).getGenre(); // Just take the last watched genre for simplicity
        
        return availableContent.stream()
            .filter(c -> c.getGenre().equalsIgnoreCase(favoriteGenre))
            .filter(c -> !history.contains(c)) // Don't recommend what's already watched
            .limit(2)
            .collect(Collectors.toList());
    }
}
