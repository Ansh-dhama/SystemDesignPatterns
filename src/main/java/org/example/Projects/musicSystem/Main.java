package org.example.Projects.musicSystem;


import org.example.Projects.musicSystem.enums.DeviceType;
import org.example.Projects.musicSystem.enums.StrategyType;
import org.example.Projects.musicSystem.farade.MusicPlayerApp;
import org.example.Projects.musicSystem.model.Song;

public class Main {
    public static void main(String[] args) {
        MusicPlayerApp app = new MusicPlayerApp();

        Song s1 = new Song("Kesariya", "Arijit Singh", "/audio/kesariya.mp3");
        Song s2 = new Song("Chaiya Chaiya", "Sukhwinder Singh", "/audio/chaiya.mp3");
        Song s3 = new Song("Tum Hi Ho", "Arijit Singh", "/audio/tumhiho.mp3");
        Song s4 = new Song("Jai Ho", "A.R. Rahman", "/audio/jaiho.mp3");

        app.createPlaylist("Bollywood Vibes");
        app.addSongToPlaylist("Bollywood Vibes", s1);
        app.addSongToPlaylist("Bollywood Vibes", s2);
        app.addSongToPlaylist("Bollywood Vibes", s3);
        app.addSongToPlaylist("Bollywood Vibes", s4);

        System.out.println("\n--- CONNECTING DEVICE ---");
        app.connectAudioDevice(DeviceType.BLUETOOTH);

        System.out.println("\n--- PLAYING SEQUENTIAL PLAYLIST ---");
        app.selectPlaybackStrategy(StrategyType.SEQUENTIAL);
        app.loadPlaylist("Bollywood Vibes");
        app.playAll();

        System.out.println("\n--- PLAYING RANDOM PLAYLIST ---");
        app.selectPlaybackStrategy(StrategyType.RANDOM);
        app.loadPlaylist("Bollywood Vibes");
        app.playNext();
        app.playNext();

        System.out.println("\n--- CUSTOM QUEUE PLAYBACK ---");
        app.selectPlaybackStrategy(StrategyType.CUSTOM);
        app.loadPlaylist("Bollywood Vibes");
        app.enqueueSong(s3); // Enqueue "Tum Hi Ho"
        app.playNext();      // Plays queued song
        app.playNext();      // Fallback to sequential
    }
}