package org.example.Projects.musicSystem.factory;

import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.adapter.BluetoothSpeakerAdapter;
import org.example.Projects.musicSystem.adapter.HeadphonesAdapter;
import org.example.Projects.musicSystem.adapter.WiredSpeakerAdapter;
import org.example.Projects.musicSystem.api.BluetoothSpeakerApi;
import org.example.Projects.musicSystem.api.HeadphonesApi;
import org.example.Projects.musicSystem.api.WiredSpeakerApi;
import org.example.Projects.musicSystem.enums.DeviceType;

public class DeviceFactory {
    public IAudioOutputDevice createDevice(DeviceType type) {
        switch (type) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerApi());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerApi());
            case HEADPHONES:
                return new HeadphonesAdapter(new HeadphonesApi());
            default:
                throw new IllegalArgumentException("Unsupported Device Type");
        }
    }
}