package com.example.recyclerview_cardview;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.ViewHolder>{

    private static final String TAG = "8941651";

    RadioButton radioButton_itemCheck;
    MyItemList[] myItemLists;
    Context context;

    public MyItemAdapter(MyItemList[] myItemLists, MainActivity activity) {
        this.myItemLists = myItemLists;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyItemList list_items = myItemLists[position];
        Log.d("484544815", "lol");
        Log.d("484544815", list_items.getItemHeading());
        holder.itemHeading.setText(list_items.getItemHeading());
        holder.itemImage.setImageResource(list_items.getItemImage());
        holder.itemSubHeading.setText(list_items.getItemSubHeading());

        holder.itemView.findViewById(R.id.itemCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 11");
                if(radioButton_itemCheck == null){
                    Log.d(TAG, "onClick: 22");
                    radioButton_itemCheck = (RadioButton) v;
                    radioButton_itemCheck.setChecked(true);
                    holder.itemHeading.setPaintFlags(holder.itemHeading.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                if(radioButton_itemCheck.isChecked()){
                    Log.d(TAG, "onClick: " + position);
                }
//                if(radioButton_itemCheck == null){
//                    Log.d("586151", "onClick: 22");
//                    radioButton_itemCheck = (RadioButton) v;
//                    radioButton_itemCheck.setChecked(true);
//                }
                if(radioButton_itemCheck== v)
                    return;
                radioButton_itemCheck.setChecked(false);
                ((RadioButton)v).setChecked(true);
                radioButton_itemCheck = (RadioButton)v;
                Log.d(TAG, "onClick: 33");
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list_items.getItemHeading() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return myItemLists.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemHeading, itemSubHeading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView);
            itemHeading = itemView.findViewById(R.id.heading);
            itemSubHeading = itemView.findViewById(R.id.sub_heading);

        }
    }



}
