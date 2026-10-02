package org.example.Projects.musicSystem.manager;


import org.example.Projects.musicSystem.Interface.IAudioOutputDevice;
import org.example.Projects.musicSystem.enums.DeviceType;
import org.example.Projects.musicSystem.factory.DeviceFactory;

public class DeviceManager {
    private static DeviceManager instance;
    private IAudioOutputDevice currentDevice;
    private DeviceFactory deviceFactory;

    private DeviceManager() {
        this.deviceFactory = new DeviceFactory();
    }

    public static synchronized DeviceManager getInstance() {
        if (instance == null) {
            instance = new DeviceManager();
        }
        return instance;
    }

    public void connect(DeviceType type) {
        this.currentDevice = deviceFactory.createDevice(type);
        System.out.println("[DEVICE MANAGER] Connected to " + type + " device.");
    }

    public IAudioOutputDevice getCurrentDevice() {
        return currentDevice;
    }
}