package jp.ac.student.kbc19a37.ac.dentaku_kadai2020;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;

    private AudioAttributes audioAttributes;

    public SoundPlayer(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(2)
                    .build();

        } else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        }

        hitSound = soundPool.load(context, R.raw.d_34, 1);
    }

    public SoundPlayer(ButtonClickListener buttonClickListener) {
        playHitSound();
    }

    public void playHitSound() {
        soundPool.play(hitSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

}
