package com.streaming.content;

/**
 * Derived class representing a Series content.
 */
public class Series extends Content {
    private int episodeCount;

    public Series(String title, String genre, double rating, int episodeCount) {
        super(title, genre, rating);
        this.episodeCount = episodeCount;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    @Override
    public void play() {
        System.out.println("Streaming Series: " + getTitle() + " [" + episodeCount + " episodes]...");
    }
}
