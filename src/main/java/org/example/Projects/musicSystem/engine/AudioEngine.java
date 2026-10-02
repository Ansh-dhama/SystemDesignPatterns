package org.example.Projects.musicSystem.engine;


import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.model.Song;

public class AudioEngine {
    private Song currentSong;
    private boolean isPaused;

    public void play(IAudioOutputDevice device, Song song) {
        if (song == null || device == null) return;
        
        if (currentSong != null && currentSong.equals(song) && isPaused) {
            System.out.println("[AUDIO ENGINE] Resuming: " + song.getTitle());
            isPaused = false;
        } else {
            this.currentSong = song;
            this.isPaused = false;
        }
        device.playAudio(song);
    }

    public void pause() {
        if (currentSong != null && !isPaused) {
            isPaused = true;
            System.out.println("[AUDIO ENGINE] Paused: " + currentSong.getTitle());
        }
    }

    public Song getCurrentSong() { return currentSong; }
    public boolean isPaused() { return isPaused; }
}