package com.example.progress_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    int progress= 0;
    ProgressBar progress_bar;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        display = findViewById(R.id.display);
        progress_bar = findViewById(R.id.progress_bar);

        updateProgressBar();

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress <= 90){
                    progress -= 10;
                    updateProgressBar();
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress >= 0){
                    progress += 10;
                    updateProgressBar();
                }
            }
        });
    }

    private void updateProgressBar(){
        progress_bar.setProgress(progress);
        display.setText(String.valueOf(progress));
    }
}