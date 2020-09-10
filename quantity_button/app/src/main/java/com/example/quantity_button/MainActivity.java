package com.example.quantity_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button minus_btn,plus_btn;
    TextView result;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.minus_btn:
                    minusCounter();
                    break;
                case R.id.plus_btn:
                    plusCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minus_btn = findViewById(R.id.minus_btn);
        plus_btn = findViewById(R.id.plus_btn);
        result = findViewById(R.id.quantity_result);

        minus_btn.setOnClickListener(clickListener);
        plus_btn.setOnClickListener(clickListener);

        counter=0;
        result.setText(String.valueOf(counter));
    }

    private void plusCounter(){
        if(counter>=10){
            return;
        }
        else{
            counter++;
            result.setText(String.valueOf(counter));
        }
    }

    private void minusCounter(){
        if(counter<=0){
            return;
        }
        else{
            --counter;
            result.setText(String.valueOf(counter));
        }

    }
}