package org.example.Projects.musicSystem;

import org.example.Projects.musicSystem.Interface.PlayStrategy;
import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

import java.util.*;

public class CustomQueuePlayStrategy implements PlayStrategy {
    private Queue<Song> customQueue = new LinkedList<>();
    private Stack<Song> history = new Stack<>();
    private PlayStrategy fallbackStrategy = new SequentialPlayStrategy();

    @Override
    public void setPlaylist(Playlist playlist) {
        fallbackStrategy.setPlaylist(playlist);
    }

    @Override
    public void addToNext(Song song) {
        customQueue.add(song);
    }

    @Override
    public boolean hasNext() {
        return !customQueue.isEmpty() || fallbackStrategy.hasNext();
    }

    @Override
    public Song next() {
        Song song;
        if (!customQueue.isEmpty()) {
            song = customQueue.poll();
        } else {
            song = fallbackStrategy.next();
        }
        if (song != null) history.push(song);
        return song;
    }

    @Override
    public boolean hasPrevious() {
        return history.size() > 1;
    }

    @Override
    public Song previous() {
        if (!hasPrevious()) return null;
        history.pop();
        return history.peek();
    }
}