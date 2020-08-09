package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView joker = (ImageView) findViewById(R.id.joker);
        final ImageView batman = (ImageView) findViewById(R.id.batman);


        batman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batman.animate().alpha(0f).setDuration(2000);
                batman.setClickable(false);
                joker.animate().alpha(1f).setDuration(2000);
                joker.setClickable(true);
            }
        });

        joker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joker.animate().alpha(0f).setDuration(2000);
                joker.setClickable(false);
                batman.animate().alpha(1f).setDuration(2000);
                batman.setClickable(true);
            }
        });




    }
}
