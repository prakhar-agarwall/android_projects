package com.example.store_internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String FILE_NAME = "sample_test.txt";

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void save(View v){
        String text = editText.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);      //Private mode is used so that no other app can access the information stored
            fos.write(text.getBytes());
            
            editText.getText().clear();
          //  Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
            
        } catch (FileNotFoundException e) {         //As IOException is a superclass of FileNotFoundException, this catch can be removed
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.d(TAG, "save: 1");
            if(fos!=null){
                try {
                    Log.d(TAG, "save: 2");
                    fos.close();        //Closing up the file
                } catch (IOException e) {
                    Log.d(TAG, "save: 3");
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v){
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine())!= null){
                sb.append(text).append("\n");
            }

            String[] lines = sb.toString().split("\\n");
            Log.d(TAG, lines[0]);
            Log.d(TAG, lines[1]);
            for (int i = 0; i < lines.length; i++) {
                String s = lines[i];
                Log.d(TAG, s);
                Log.d(TAG, lines[i]);
            }
            editText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            Log.d(TAG, "load:1 ");
            if(fis!=null){
                try {
                    Log.d(TAG, "load:2 ");
                    fis.close();
                } catch (IOException e) {
                    Log.d(TAG, "load:3 ");
                    e.printStackTrace();
                }
            }
        }
    }
}