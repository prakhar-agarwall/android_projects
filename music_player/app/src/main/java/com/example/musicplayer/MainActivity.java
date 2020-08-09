package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.musicplayer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer musiccc;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button) findViewById(R.id.button_play);
        Button pause = (Button) findViewById(R.id.button_pause);
        Button stop = (Button) findViewById(R.id.button_stop);


        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_play:
               /* musiccc = MediaPlayer.create(this,R.raw.ride);
                musiccc.start();
                break;*/
                if (musiccc == null) {
                    musiccc = MediaPlayer.create(this, R.raw.ride);
                    musiccc.start();
                    break;
                }
                else if (!musiccc.isPlaying()) {
                    musiccc.seekTo(position);
                    musiccc.start();
                    break;
                }
            case R.id.button_pause:
                if (musiccc != null) {
                    musiccc.pause();
                    position = musiccc.getCurrentPosition();
                    break;
                }
            case R.id.button_stop:
                if (musiccc != null) {
                    musiccc.stop();
                    musiccc = null;
                    break;
                }

        }
    }

}
