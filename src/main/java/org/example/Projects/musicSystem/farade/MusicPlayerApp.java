package org.example.Projects.musicSystem.farade;

import org.example.Projects.musicSystem.enums.DeviceType;
import org.example.Projects.musicSystem.enums.StrategyType;
import org.example.Projects.musicSystem.manager.PlaylistManager;
import org.example.Projects.musicSystem.model.Song;

public class MusicPlayerApp {
    private MusicPlayerFacade facade = MusicPlayerFacade.getInstance();
    private PlaylistManager playlistManager = PlaylistManager.getInstance();

    public void connectAudioDevice(DeviceType type) {
        facade.connectDevice(type);
    }

    public void createPlaylist(String name) {
        playlistManager.createPlaylist(name);
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        playlistManager.addSongToPlaylist(playlistName, song);
    }

    public void selectPlaybackStrategy(StrategyType type) {
        facade.setStrategy(type);
    }

    public void loadPlaylist(String name) {
        facade.loadPlaylist(name);
    }

    public void playAll() {
        facade.playAllTracks();
    }

    public void playNext() {
        facade.playNextTrack();
    }

    public void playPrevious() {
        facade.playPreviousTrack();
    }

    public void enqueueSong(Song song) {
        facade.enqueueNext(song);
    }
}