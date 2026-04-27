# Content Package

## Purpose
The `content` package is the core of the media library. It defines the hierarchy of items that can be streamed on the platform, ranging from standalone movies to episodic series.

## Classes and Interfaces

### `Playable.java`
- **Type**: Interface
- **Role**: Defines the essential contract for any item that can be "started" or "played" by the user.
- **Key Method**: `play()` - Forces implementing classes to define their own playback logic.

### `Content.java`
- **Type**: Abstract Class
- **Role**: The foundational blueprint for all media. It holds common attributes like title, genre, and rating.
- **Why Abstract?**: `Content` as a concept cannot be "played" on its own; it must be a specific type like a Movie or a Series.

### `Movie.java`
- **Type**: Derived Class (Extends `Content`)
- **Role**: Represents a single feature film.
- **Additional Attribute**: `durationMinutes` - specifically tracks how long the movie is.
- **Implementation**: Overrides `play()` to show a movie-specific message.

### `Series.java`
- **Type**: Derived Class (Extends `Content`)
- **Role**: Represents a television show or anthology.
- **Additional Attribute**: `episodeCount` - tracks the total number of episodes.
- **Implementation**: Overrides `play()` to show a series-specific message.

## Code Explanation: Inheritance in Action
```java
public class Movie extends Content {
    public Movie(...) {
        super(title, genre, rating); // Calls the parent constructor
    }
}
```
In this snippet, `Movie` inherits all the properties of `Content` (title, genre, rating) through the `extends` keyword. The `super()` call ensures that the base characteristics are initialized correctly before the `Movie` specific attributes (like duration) are set.
