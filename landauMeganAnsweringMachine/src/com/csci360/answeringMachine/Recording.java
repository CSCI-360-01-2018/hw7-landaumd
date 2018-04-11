/*
 * The code in the play() method was adapted from:
 * https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
 */
package com.csci360.answeringMachine;

import javax.sound.sampled.*;
import java.io.*;

public class Recording {

    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    public String wavFilePath;

    protected Recording(String filename) {
        wavFilePath = System.getProperty("user.dir") + "/src/com/csci360/answeringMachine/recordings/" + filename + ".wav";
        Recorder recorder = new Recorder();
        recorder.createNewRecording(wavFilePath);
    }

    protected Recording() {
        wavFilePath = System.getProperty("user.dir") + "/src/com/csci360/answeringMachine/recordings/" + "greeting" + ".wav";
        Recorder recorder = new Recorder();
        recorder.createNewRecording(wavFilePath);
    }

    protected void play() {

        String strFilename = wavFilePath;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }
        sourceLine.drain();
        sourceLine.close();
    }
}
