package com.example.recycler_view_and_card_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;       //Used to bridge the data and recycler view
    private RecyclerView.LayoutManager layoutManager;       //Used to layout items in a list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem(R.drawable.ic_account,"Line 1"));
        dataItems.add(new DataItem(R.drawable.ic_android,"Line 2"));
        dataItems.add(new DataItem(R.drawable.ic_adjust,"Line 3"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ItemAdapter(dataItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}