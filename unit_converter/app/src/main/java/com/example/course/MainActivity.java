package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button ConvMilestoKM,ConvKMtoMiles,clearButton;
    private EditText textboxMiles,textboxKM;
    private DecimalFormat formatVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConvMilestoKM = findViewById(R.id.buttonConvMtoKM);
        ConvKMtoMiles = findViewById(R.id.buttonConvKMtoM);
        clearButton = findViewById(R.id.clear);
        textboxMiles = findViewById(R.id.editTextMiles);
        textboxKM = findViewById(R.id.editTextKM);

        formatVal = new DecimalFormat("##.##");

        ConvMilestoKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textboxMiles.getText().toString().isEmpty()){
                    return;
                }
                else {
                    double vMiles = Double.parseDouble(textboxMiles.getText().toString());
                    double vKM = vMiles / 0.62137;
                    textboxKM.setText(formatVal.format(vKM));
                }
            }
        });

        ConvKMtoMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textboxKM.getText().toString().isEmpty()){
                    return;
                }
                else{
                    double vKM = Double.parseDouble(textboxKM.getText().toString());
                    double vMiles = vKM * 0.62137;
                    textboxMiles.setText(formatVal.format(vMiles));
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textboxKM.setText("");
                textboxMiles.setText("");
            }
        });
    }
}
