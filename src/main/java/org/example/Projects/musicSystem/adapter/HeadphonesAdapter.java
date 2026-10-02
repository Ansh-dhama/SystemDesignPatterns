package org.example.Projects.musicSystem.adapter;

import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.api.HeadphonesApi;
import org.example.Projects.musicSystem.model.Song;

public class HeadphonesAdapter implements IAudioOutputDevice {
    private HeadphonesApi headphonesApi;

    public HeadphonesAdapter(HeadphonesApi api) {
        this.headphonesApi = api;
    }

    @Override
    public void playAudio(Song song) {
        headphonesApi.playSoundViaJack(song.toString());
    }
}
