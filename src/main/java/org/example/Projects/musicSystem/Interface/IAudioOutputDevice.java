package org.example.Projects.musicSystem.Interface;


import org.example.Projects.musicSystem.model.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}