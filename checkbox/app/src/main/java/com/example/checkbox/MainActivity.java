package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button show_button;
    TextView result;

    CheckBox checkbox1,checkbox2,checkbox3;
    String box1,box2,box3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        show_button = findViewById(R.id.show_button);
        result = findViewById(R.id.result);

        box1=box2=box3="off";

        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                if(checkbox1.isChecked()){
                    box1="on";
                }
                if(checkbox2.isChecked()){
                    box2="on";
                }
                if(checkbox3.isChecked()){
                    box3="on";
                }
                stringBuilder.append(checkbox1.getText().toString() + " is " + box1 + "\n");
                stringBuilder.append(checkbox2.getText().toString() + " is " + box2 + "\n");
                stringBuilder.append(checkbox3.getText().toString() + " is " + box3 + "\n");

                result.setText(stringBuilder);
                box1=box2=box3="off";
            }
        });
    }
}