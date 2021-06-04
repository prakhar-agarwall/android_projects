package com.example.recyclerview_cardview;

import android.widget.RadioButton;

public class MyItemList {
    String itemHeading;
    String itemSubHeading;
    Integer itemImage;

    public MyItemList(String itemHeading, String itemSubHeading, Integer itemImage) {
        this.itemHeading = itemHeading;
        this.itemSubHeading = itemSubHeading;
        this.itemImage = itemImage;
      }

    public String getItemHeading() {
        return itemHeading;
    }

    public void setItemHeading(String itemHeading) {
        this.itemHeading = itemHeading;
    }

    public String getItemSubHeading() {
        return itemSubHeading;
    }

    public void setItemSubHeading(String itemSubHeading) {
        this.itemSubHeading = itemSubHeading;
    }

    public Integer getItemImage() {
        return itemImage;
    }

    public void setItemImage(Integer itemImage) {
        this.itemImage = itemImage;
    }
}
