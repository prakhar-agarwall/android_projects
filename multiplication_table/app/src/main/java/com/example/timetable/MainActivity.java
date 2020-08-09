package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ttlistView;

    public void generatetimetable(int timetable){

        ArrayList<String> generatett = new ArrayList<String>();

        for(int i=1;i<=10;i++){
            generatett.add(Integer.toString(i*timetable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,generatett);
        ttlistView.setAdapter(arrayAdapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar ttseekbar = (SeekBar) findViewById(R.id.ttseekBar);
        ttlistView = (ListView) findViewById(R.id.listviewseekbar);


        ttseekbar.setMax(20);
        ttseekbar.setProgress(10);

        ttseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min=1,timetable;

                if(progress < min){
                    timetable=min;
                    ttseekbar.setProgress(min);
                }
                else{
                    timetable=progress;
                }
                generatetimetable(timetable);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generatetimetable(10);



;
    }
}
