package com.example.google_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add_btn;
    EditText title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.add_task);
        title = findViewById(R.id.textView_title);
        description = findViewById(R.id.textView_description);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){

                    Intent intent_task = new Intent(Intent.ACTION_INSERT);
                    intent_task.setData(CalendarContract.Events.CONTENT_URI);
                    intent_task.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent_task.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                    intent_task.putExtra(CalendarContract.Events.ALL_DAY, true);

                    if(intent_task.resolveActivity(getPackageManager()) != null){
                        startActivity(intent_task);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No app to support this action", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}