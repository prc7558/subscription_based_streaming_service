package com.streaming.content;

/**
 * Abstract base class for all streaming content.
 */
public abstract class Content implements Playable {
    private String title;
    private String genre;
    private double rating;

    public Content(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return "[" + genre + "] " + title + " (Rating: " + rating + "/5.0)";
    }
}
