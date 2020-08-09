package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        RadioGroup radioGroup_colors = (RadioGroup) findViewById(R.id.radiogroup_colors);

        if(preferences.contains("colorId"))
            layout.setBackgroundColor(preferences.getInt("colorId",0));

        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorcode = 0;
                switch (checkedId) {
                    case R.id.radioButton_blue:
                        colorcode = (Color.BLUE);
                        break;
                    case R.id.radioButton_magenta:
                        colorcode = (Color.MAGENTA);
                        break;
                    case R.id.radioButton_yellow:
                        colorcode = (Color.YELLOW);
                        break;
                }
            layout.setBackgroundColor(colorcode);
                editor.putInt("colorId",colorcode);
                editor.commit();

            }
        });
    }
}
