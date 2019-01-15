package com.example.boot.util;

import ws.schild.jave.*;
import java.io.File;

public class MediaUtil {

    public static File convertWavToMp3(final String wavPath, final String mp3Path) throws EncoderException {
        return convertWavToMp3(new File(wavPath), new File(mp3Path));
    }

    public static File convertWavToMp3(final File wavFile, final File mp3File) throws EncoderException {
        AudioAttributes audioAttributes = new AudioAttributes();
        audioAttributes.setCodec("libmp3lame");
        audioAttributes.setBitRate(22050);
        audioAttributes.setChannels(2);
        audioAttributes.setSamplingRate(11025);

        EncodingAttributes encodingAttributes = new EncodingAttributes();
        encodingAttributes.setFormat("mp3");
        encodingAttributes.setAudioAttributes(audioAttributes);

        executeEncode(wavFile, mp3File, encodingAttributes);

        return mp3File;
    }

    private static void executeEncode(final File wavFile, final File mp3File, EncodingAttributes attributes)  throws EncoderException{
        Encoder encoder = new Encoder();
        encoder.encode(new MultimediaObject(wavFile), mp3File, attributes);
    }

}
