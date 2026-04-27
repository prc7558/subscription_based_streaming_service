# Users Package

## Purpose
The `users` package manages personal profiles, tracks engagement, and provides personalized experiences through a recommendation engine.

## Classes

### `User.java`
- **Type**: Class
- **Role**: The central entity representing a person using the service.
- **Responsibilities**:
    - Stores profile data (name, email).
    - Links to a `Subscription`.
    - Facilitates the "watching" action by checking subscription status before playing content.

### `WatchHistory.java`
- **Type**: Class
- **Role**: A specialized container for tracking a user's activity.
- **Encapsulation**: It uses a `List<Content>` internally but returns a copy via `getWatchedItems()` to prevent external code from accidentally corrupting the user's history.

### `RecommendationSystem.java`
- **Type**: Class (Behavioral Service)
- **Role**: Contains the "intelligence" of the platform.
- **Logic**:
    - **New Users**: If the history is empty, it suggests content with high ratings.
    - **Returning Users**: It analyzes the genre of recently watched items to suggest similar content.
    - **Filtering**: It ensures it doesn't recommend something the user has already finished.

## Code Explanation: State-Based Access Control
```java
public void watch(Content content) {
    if (subscription != null && subscription.isActive()) {
        content.play();
        history.addItem(content);
    } else {
        System.out.println("Access Denied...");
    }
}
```
This method in `User.java` demonstrates **Defensive Programming**. Instead of allowing playback and then checking permissions, it validates the "State" (is there a subscription? is it active?) before executing the "Action" (`play()`). This prevents unauthorized access to content.
