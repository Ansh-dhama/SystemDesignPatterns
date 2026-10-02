package org.example.Projects.musicSystem.adapter;

import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.api.BluetoothSpeakerApi;
import org.example.Projects.musicSystem.model.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice {
    private BluetoothSpeakerApi bluetoothSpeakerApi;

    public BluetoothSpeakerAdapter(BluetoothSpeakerApi api) {
        this.bluetoothSpeakerApi = api;
    }

    @Override
    public void playAudio(Song song) {
        bluetoothSpeakerApi.playSoundViaBluetooth(song.toString());
    }

}

