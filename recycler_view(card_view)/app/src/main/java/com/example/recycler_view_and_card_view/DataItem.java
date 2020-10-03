package com.example.recycler_view_and_card_view;

public class DataItem {
    private int mImageReource;
    private String mText1;

    public DataItem(int mImageReource, String mText1) {
        this.mImageReource = mImageReource;
        this.mText1 = mText1;
    }

    public DataItem() {
    }

    public int getmImageReource() {
        return mImageReource;
    }

    public void setmImageReource(int mImageReource) {
        this.mImageReource = mImageReource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }
}
