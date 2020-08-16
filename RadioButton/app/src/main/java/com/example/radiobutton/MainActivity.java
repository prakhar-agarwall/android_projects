package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                radioButton = findViewById(id);

                switch (id){
                    case R.id.radioButton1:{
                        if(radioButton.isChecked()) {
                            Log.d(TAG, "YES");
                        }
                    }
                    case R.id.radioButton2:{
                        if(radioButton.isChecked()) {
                            Log.d(TAG, "NO");
                        }
                    }
                    case R.id.radioButton3:{
                        if(radioButton.isChecked()) {
                            Log.d(TAG,"MAYBE");
                        }
                    }
                }
            }
        });
    }
}