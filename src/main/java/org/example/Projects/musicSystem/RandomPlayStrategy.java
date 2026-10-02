package org.example.Projects.musicSystem;

import org.example.Projects.musicSystem.Interface.PlayStrategy;
import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

import java.util.*;

public class RandomPlayStrategy implements PlayStrategy {
    private Playlist playlist;
    private List<Song> remainingSongs = new ArrayList<>();
    private Stack<Song> history = new Stack<>();
    private Random random = new Random();

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.remainingSongs = new ArrayList<>(playlist.getSongs());
        this.history.clear();
    }

    @Override
    public boolean hasNext() {
        return !remainingSongs.isEmpty();
    }

    @Override
    public Song next() {
        if (!hasNext()) return null;
        int index = random.nextInt(remainingSongs.size());
        Song song = remainingSongs.remove(index);
        history.push(song);
        return song;
    }

    @Override
    public boolean hasPrevious() {
        return history.size() > 1;
    }

    @Override
    public Song previous() {
        if (!hasPrevious()) return null;
        remainingSongs.add(history.pop()); // Return current song to pool
        return history.peek();
    }
}