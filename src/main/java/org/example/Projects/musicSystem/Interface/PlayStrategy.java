package org.example.Projects.musicSystem.Interface;


import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    boolean hasNext();
    Song next();
    boolean hasPrevious();
    Song previous();
    default void addToNext(Song song) {
        // Optional override for Custom Queue
    }
}