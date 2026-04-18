package se.yrgo.game;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
    public void playSound(String path) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(path);
            if (audioSrc == null)
                return;
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}