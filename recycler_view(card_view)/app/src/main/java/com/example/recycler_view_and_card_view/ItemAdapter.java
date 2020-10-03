package com.example.recycler_view_and_card_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.DataViewHolder> {

    private ArrayList<DataItem> mdataItemArrayList;

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        public ImageView nimageView;
        public TextView ntextView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            nimageView = itemView.findViewById(R.id.imageView_layout);
            ntextView = itemView.findViewById(R.id.textView_layout);
        }
    }

    public ItemAdapter(ArrayList<DataItem> dataItemArrayList) {     //Constructor
        mdataItemArrayList = dataItemArrayList;
    }

    //Press ctrl+I to get remaining(below) 3 functions

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false));
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        DataViewHolder dvh = new DataViewHolder(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        DataItem currentItem = mdataItemArrayList.get(position);

        holder.nimageView.setImageResource(currentItem.getmImageReource());
        holder.ntextView.setText(currentItem.getmText1());
    }



    @Override
    public int getItemCount() {
        return mdataItemArrayList.size();
    }
}
