package com.example.intro_slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SliderAdapter sliderAdapter;
    private TextView cDouts[];
    private LinearLayout dots_layout;
    private ViewPager viewPager;
    private Button next_btn;
    private int current_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        dots_layout = findViewById(R.id.dots_layout);
        next_btn = findViewById(R.id.next_btn);

        sliderAdapter = new SliderAdapter(MainActivity.this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addDotsIndicator(int position){
        cDouts = new TextView[3];
        dots_layout.removeAllViews();
        int i;
        for(i=0;i < cDouts.length; i++){
            cDouts[i] = new TextView(MainActivity.this);
            cDouts[i].setText(Html.fromHtml("&#8226;"));
            cDouts[i].setTextSize(35);
            cDouts[i].setTextColor(getResources().getColor(R.color.all));

            dots_layout.addView(cDouts[i]);
        }

        if(cDouts.length > 0){
            cDouts[position].setTextColor(getResources().getColor(R.color.transparent));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            current_position = position;

            if(position == 0){
                next_btn.setVisibility(View.INVISIBLE);
            }
            else if(position == cDouts.length-1){
                next_btn.setVisibility(View.VISIBLE);
            }
            else{
                next_btn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}