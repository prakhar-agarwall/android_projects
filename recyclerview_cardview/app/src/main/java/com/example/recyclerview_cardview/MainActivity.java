package com.example.recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        MyItemList[] myItemLists_list = new MyItemList[]{
            new MyItemList("Heading 1","Sub Heading 1", R.drawable.ic_launcher_background),
                new MyItemList("Heading 2","Sub Heading 2", R.drawable.ic_launcher_background),
                new MyItemList("Heading 3","Sub Heading 3", R.drawable.ic_launcher_background),
                new MyItemList("Heading 4","Sub Heading 4", R.drawable.ic_launcher_background),
        };

        Log.d("46851686686", "onCreate: ");

        MyItemAdapter myItemList_adapter = new MyItemAdapter(myItemLists_list,MainActivity.this);
        recyclerView.setAdapter(myItemList_adapter);


    }
}