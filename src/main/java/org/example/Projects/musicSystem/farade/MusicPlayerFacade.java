package org.example.Projects.musicSystem.farade;


import org.example.Projects.musicSystem.Interface.PlayStrategy;
import org.example.Projects.musicSystem.engine.AudioEngine;
import org.example.Projects.musicSystem.enums.DeviceType;
import org.example.Projects.musicSystem.enums.StrategyType;
import org.example.Projects.musicSystem.manager.DeviceManager;
import org.example.Projects.musicSystem.manager.PlaylistManager;
import org.example.Projects.musicSystem.manager.StrategyManager;
import org.example.Projects.musicSystem.model.Playlist;
import org.example.Projects.musicSystem.model.Song;

public class MusicPlayerFacade {
    private static MusicPlayerFacade instance;
    private AudioEngine audioEngine;
    private DeviceManager deviceManager;
    private PlaylistManager playlistManager;
    private StrategyManager strategyManager;
    private Playlist currentPlaylist;
    private PlayStrategy currentStrategy;

    private MusicPlayerFacade() {
        this.audioEngine = new AudioEngine();
        this.deviceManager = DeviceManager.getInstance();
        this.playlistManager = PlaylistManager.getInstance();
        this.strategyManager = StrategyManager.getInstance();
    }

    public static synchronized MusicPlayerFacade getInstance() {
        if (instance == null) {
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    public void connectDevice(DeviceType type) {
        deviceManager.connect(type);
    }

    public void loadPlaylist(String playlistName) {
        this.currentPlaylist = playlistManager.getPlaylist(playlistName);
        if (currentStrategy != null && currentPlaylist != null) {
            currentStrategy.setPlaylist(currentPlaylist);
        }
    }

    public void setStrategy(StrategyType type) {
        this.currentStrategy = strategyManager.getStrategy(type);
        if (currentPlaylist != null) {
            currentStrategy.setPlaylist(currentPlaylist);
        }
    }

    public void playAllTracks() {
        if (currentStrategy == null || deviceManager.getCurrentDevice() == null) {
            System.out.println("[FACADE] Connect device and set strategy first.");
            return;
        }

        while (currentStrategy.hasNext()) {
                Song song = currentStrategy.next();
            audioEngine.play(deviceManager.getCurrentDevice(), song);
        }
    }

    public void playNextTrack() {
        if (currentStrategy != null && currentStrategy.hasNext()) {
            Song song = currentStrategy.next();
            audioEngine.play(deviceManager.getCurrentDevice(), song);
        }
    }

    public void playPreviousTrack() {
        if (currentStrategy != null && currentStrategy.hasPrevious()) {
            Song song = currentStrategy.previous();
            audioEngine.play(deviceManager.getCurrentDevice(), song);
        }
    }

    public void pauseSong() {
        audioEngine.pause();
    }

    public void enqueueNext(Song song) {
        if (currentStrategy != null) {
            currentStrategy.addToNext(song);
        }
    }
}