package com.thecodecity.teenyexamples;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.thecodecity.teenyexamples.services.BackgroundMusicService;

public class ActivityMusicPlayStream extends Activity {
    Button btnPlay, btnStream;
    EditText etURL;
    Boolean isPlaying = false, isStreaming = false;
    MediaPlayer m;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play_stream);
        etURL = findViewById(R.id.etURL);
        btnPlay = findViewById(R.id.btnPlayInBg);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    stopService(new Intent(ActivityMusicPlayStream.this, BackgroundMusicService.class));
                    isPlaying = false;
                } else {
                    Log.d("mylog", "Button Click");
                    startService(new Intent(ActivityMusicPlayStream.this, BackgroundMusicService.class));
                    isPlaying = true;
                }
            }
        });
        btnStream = findViewById(R.id.btnStream);
        btnStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStreaming) {
                    stopPlaying();
                    isStreaming = false;
                } else {
                    startAudioStream(etURL.getText().toString());
                    isStreaming = true;
                }
            }
        });

    }

    public void startAudioStream(String url) {
        if (m == null)
            m = new MediaPlayer();
        try {
            Log.d("mylog", "Playing: " + url);
            m.setAudioStreamType(AudioManager.STREAM_MUSIC);
            m.setDataSource(url);
            //descriptor.close();
            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(false);
            m.start();
        } catch (Exception e) {
            Log.d("mylog", "Error playing in SoundHandler: " + e.toString());
        }
    }

    private void stopPlaying() {
        if (m != null && m.isPlaying()) {
            m.stop();
            m.release();
            m = new MediaPlayer();
            m.reset();
        }
    }

}
