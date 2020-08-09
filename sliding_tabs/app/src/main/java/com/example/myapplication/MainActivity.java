package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    FragmentTabAdapter mFragmentTabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.view_pager);
        mFragmentTabAdapter = new FragmentTabAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mFragmentTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);




    }
}