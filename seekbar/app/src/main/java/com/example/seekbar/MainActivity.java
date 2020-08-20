package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView1.setTextColor(Color.GREEN);

                if(seekBar.getProgress() >= 0 && seekBar.getProgress() <=3){
                    textView1.setTextColor(Color.GREEN);
                    textView1.setText(String.format("Pain level: %d/%d", seekBar.getProgress(), seekBar.getMax()));
                }
                else if(seekBar.getProgress() >= 7) {
                    textView1.setTextColor(Color.RED);
                    textView1.setText(String.format("Pain level: %d/%d", seekBar.getProgress(), seekBar.getMax()));
                }
                else if(seekBar.getProgress() >= 4 && seekBar.getProgress() <=6){
                    textView1.setTextColor(Color.GRAY);
                    textView1.setText(String.format("Pain level: %d/%d", seekBar.getProgress(), seekBar.getMax()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}