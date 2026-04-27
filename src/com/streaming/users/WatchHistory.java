package com.streaming.users;

import com.streaming.content.Content;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracks the content viewed by a user.
 */
public class WatchHistory {
    private List<Content> watchedItems;

    public WatchHistory() {
        this.watchedItems = new ArrayList<>();
    }

    public void addItem(Content content) {
        watchedItems.add(content);
    }

    public List<Content> getWatchedItems() {
        return new ArrayList<>(watchedItems); // Return copy to preserve encapsulation
    }

    @Override
    public String toString() {
        if (watchedItems.isEmpty()) return "History is empty.";
        StringBuilder sb = new StringBuilder("Watch History:\n");
        for (Content item : watchedItems) {
            sb.append("- ").append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
