package com.example.boot;

import com.example.boot.util.MediaUtil;
import org.junit.Test;
import ws.schild.jave.*;

import java.io.File;

public class wavtomp3Test {


    @Test
    public void test02() throws EncoderException {
        String wavPath = "/data/test.wav";
        String mp3Path = "/data/test.mp3";
        File file = MediaUtil.convertWavToMp3(wavPath, mp3Path);

        if (file.length() > 0) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }
    }


}
