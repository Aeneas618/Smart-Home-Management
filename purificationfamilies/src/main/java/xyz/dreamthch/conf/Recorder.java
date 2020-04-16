package xyz.dreamthch.conf;

import java.io.File;
import java.util.Date;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class Recorder {
    private static final long serialVersionUID = 1L;
    private static final Date date = new Date();
    AudioFormat audioFormat;
    TargetDataLine targetDataLine;

    public static void main(String args[]) {
        Recorder recorder = new Recorder();
        recorder.newRecorder();
    }

    public void newRecorder(){
        long time = date.getTime();
        captureAudio();
        while (true){
            Date d = new Date();
            long time1 = d.getTime();
            if (time1-time==10000){
                targetDataLine.stop();
                targetDataLine.close();
                break;
            }
        }
        System.out.println("Success");
    }

    public void captureAudio(){
        try {
            audioFormat = getAudioFormat();//构造具有线性 PCM 编码和给定参数的 AudioFormat。
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            new CaptureThread().start();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 8000F;
        int sampleSizeInBits = 16;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
                bigEndian);
    }

    class CaptureThread extends Thread {
        public void run() {
            AudioFileFormat.Type fileType = null;
            File audioFile = null;
            fileType = AudioFileFormat.Type.WAVE;
            audioFile = new File("./wav/test.pcm");
            try {
                targetDataLine.open(audioFormat);
                targetDataLine.start();
                AudioSystem.write(new AudioInputStream(targetDataLine),fileType, audioFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}