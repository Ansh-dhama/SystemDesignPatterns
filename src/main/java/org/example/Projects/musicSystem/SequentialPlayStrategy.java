package org.example.Projects.musicSystem;


import org.example.Projects.musicSystem.Interface.PlayStrategy;
import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

public class SequentialPlayStrategy implements PlayStrategy {
    private Playlist playlist;
    private int currentIndex = -1;

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return playlist != null && currentIndex + 1 < playlist.getSongs().size();
    }

    @Override
    public Song next() {
        if (!hasNext()) return null;
        currentIndex++;
        return playlist.getSongs().get(currentIndex);
    }

    @Override
    public boolean hasPrevious() {
        return playlist != null && currentIndex - 1 >= 0;
    }

    @Override
    public Song previous() {
        if (!hasPrevious()) return null;
        currentIndex--;
        return playlist.getSongs().get(currentIndex);
    }
}