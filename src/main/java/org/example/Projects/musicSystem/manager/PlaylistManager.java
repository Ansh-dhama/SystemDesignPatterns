package org.example.Projects.musicSystem.manager;

import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

import java.util.HashMap;
import java.util.Map;

public class PlaylistManager {
    private static PlaylistManager instance;
    private Map<String, Playlist> playlistMap;

    private PlaylistManager() {
        this.playlistMap = new HashMap<>();
    }

    public static synchronized PlaylistManager getInstance() {
        if (instance == null) {
            instance = new PlaylistManager();
        }
        return instance;
    }

    public void createPlaylist(String name) {
        if (playlistMap.containsKey(name)) {
            throw new IllegalArgumentException("Playlist already exists!");
        }
        playlistMap.put(name, new Playlist(name));
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        Playlist playlist = playlistMap.get(playlistName);
        if (playlist != null) {
            playlist.addSong(song);
        }
    }

    public Playlist getPlaylist(String name) {
        return playlistMap.get(name);
    }
}