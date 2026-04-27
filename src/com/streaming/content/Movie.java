package com.streaming.content;

/**
 * Derived class representing a Movie content.
 */
public class Movie extends Content {
    private int durationMinutes;

    public Movie(String title, String genre, double rating, int durationMinutes) {
        super(title, genre, rating);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void play() {
        System.out.println("Streaming Movie: " + getTitle() + " [" + durationMinutes + " mins]...");
    }
}
