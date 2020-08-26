package com.example.custom_listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        ListView listView;
        String ItemName[] = {"Item Name 1","Item Name 2","Item Name 3"};
        String Description[] = {"Desciption 1","Desciption 2","Desciption 3"};
        int images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3};
        Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, ItemName,Description,images,button);
        listView.setAdapter(adapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("lol","lol1");
                if(i == 0){
                    Toast.makeText(MainActivity.this,  "Desciption 1", Toast.LENGTH_SHORT).show();
                }
                if(i == 1){
                    Toast.makeText(MainActivity.this,  "Desciption 2", Toast.LENGTH_SHORT).show();
                }
                if(i == 2){
                    Toast.makeText(MainActivity.this,  "Desciption 3", Toast.LENGTH_SHORT).show();
                }

            }
        });*/


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String mItemName[];
        String mDescription[];
        int mimages[];
        Button mcart;

        MyAdapter (Context c,String ItemName[],String Description[], int images[], Button cart){
            super(c,R.layout.row,R.id.item_name,ItemName);
            this.context = c;
            this.mItemName = ItemName;
            this.mDescription = Description;
            this.mimages = images;
            this.mcart = cart;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.imageView);
            TextView item_name = row.findViewById(R.id.item_name);
            TextView item_description = row.findViewById(R.id.item_description);
            Button cartt = row.findViewById(R.id.add_to_cart);

            images.setImageResource(mimages[position]);
            item_name.setText(mItemName[position]);
            item_description.setText(mDescription[position]);
            
            cartt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Product added to cart", Toast.LENGTH_SHORT).show();
                }
            });

            return row;
        }
    }
}