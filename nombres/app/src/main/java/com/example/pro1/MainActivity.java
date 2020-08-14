package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music0,music1,music2,music3,music4,music5,music6,music7,music8,music9,music10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void play0(View v){
        music0.start();
    }
    public void play1(View v){
        music1.start();
    }
    public void play2(View v){
        music2.start();
    }
    public void play3(View v){
        music3.start();
    }
    public void play4(View v){
        music4.start();
    }
    public void play5(View v){
        music5.start();
    }
    public void play6(View v){
        music6.start();
    }
    public void play7(View v){
        music7.start();
    }
    public void play8(View v){
        music8.start();
    }
    public void play9(View v){
        music9.start();
    }
    public void play10(View v){
        music10.start();
    }

    private void initialize(){
        music0 = MediaPlayer.create(this, R.raw.zero);
        music1 = MediaPlayer.create(this, R.raw.one);
        music2 = MediaPlayer.create(this, R.raw.two);
        music3 = MediaPlayer.create(this, R.raw.three);
        music4 = MediaPlayer.create(this, R.raw.four);
        music5 = MediaPlayer.create(this, R.raw.five);
        music6 = MediaPlayer.create(this, R.raw.six);
        music7 = MediaPlayer.create(this, R.raw.seven);
        music8 = MediaPlayer.create(this, R.raw.eight);
        music9 = MediaPlayer.create(this, R.raw.nine);
        music10 = MediaPlayer.create(this, R.raw.ten);
    }
}

