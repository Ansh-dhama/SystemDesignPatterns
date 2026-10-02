package org.example.Projects.musicSystem.adapter;

import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.api.WiredSpeakerApi;
import org.example.Projects.musicSystem.model.Song;

public class WiredSpeakerAdapter implements IAudioOutputDevice {
    private WiredSpeakerApi wiredSpeakerApi;

    public WiredSpeakerAdapter(WiredSpeakerApi api) {
        this.wiredSpeakerApi = api;
    }

    @Override
    public void playAudio(Song song) {
        wiredSpeakerApi.playSoundViaWire(song.toString());
    }
}
