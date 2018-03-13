/*
 * This code has been adapted from this post:
 * http://www.codejava.net/coding/capture-and-record-sound-into-wav-file-with-java-sound-api
 */
package com.csci360.answeringMachine;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Recorder {

//    static final long RECORD_TIME = 60000;  // 1 minute
//    static final long RECORD_TIME = 10000;  // 10 secs
    static final long RECORD_TIME = 5000;  // 5 secs
    File wavFile;
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;
 
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }
 
    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
 
            AudioInputStream ais = new AudioInputStream(line);
            System.out.println("Start recording...");
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }

    public void createNewRecording(String filename) {
    	wavFile = new File(filename);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, RECORD_TIME);

        this.start();
    }

}
