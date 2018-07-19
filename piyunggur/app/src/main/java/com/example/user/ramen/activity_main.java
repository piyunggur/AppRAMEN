package com.example.user.ramen;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_main extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private adapter_slider sliderAdapter;

    private Button mNextBt;
    private Button mBackBt;

    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBt = (Button) findViewById(R.id.bt_next);
        mBackBt = (Button) findViewById(R.id.bt_back);

        sliderAdapter = new adapter_slider(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnclickListeners

        mNextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                Button set_bt_next = (Button)view;
                String text_bt_next = set_bt_next.getText().toString();
                if(text_bt_next.equalsIgnoreCase("FINISH")){
                    startActivity(new Intent(activity_main.this,activity_login.class));
                }

            }
        });

        mBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void  addDotsIndicator(int position){
        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor((R.color.colortransparentWhite)));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int page) {
//            addDotsIndicator(i);
            for(int i = 0; i < mDots.length ; i++) {

                if (i==page)
                    mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));
                else
                    mDots[i].setTextColor(getResources().getColor(R.color.colortransparentWhite));
            }

            mCurrentPage = page;

            if(page == 0){
                mNextBt.setEnabled(true);
                mBackBt.setEnabled(false);
                mBackBt.setVisibility(View.INVISIBLE);

                mNextBt.setText("Next");
                mBackBt.setText("");
            }else if (page == mDots.length-1) {
                mNextBt.setEnabled(true);
                mBackBt.setEnabled(true);
                mBackBt.setVisibility(View.VISIBLE);

                mNextBt.setText("Finish");
                mBackBt.setText("Black");

            }else {
                mNextBt.setEnabled(true);
                mBackBt.setEnabled(true);
                mBackBt.setVisibility(View.VISIBLE);

                mNextBt.setText("Next");
                mBackBt.setText("Back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
