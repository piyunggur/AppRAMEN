package com.example.user.ramen;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LearnActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private LearnAdapter sliderAdapter;

    private Button mNextBt;
    private Button mBackBt;

    private TextView sTextHead;
    private TextView sTextDesc;



    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.learn_layout);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBt = (Button) findViewById(R.id.bt_next);
        mBackBt = (Button) findViewById(R.id.bt_back);
        sTextHead = (TextView) findViewById(R.id.slide_heading);
        sTextDesc = (TextView) findViewById(R.id.slide_desc);

        mNextBt.setTypeface(CustomFont.getInstance().getFontData(this));
        mBackBt.setTypeface(CustomFont.getInstance().getFontData(this));


        sliderAdapter = new LearnAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnclickListeners

        mNextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button set_bt_next = (Button)view;
                String text_bt_next = set_bt_next.getText().toString();
                if(text_bt_next.equalsIgnoreCase("ดำเนินการต่อ")){
                    startActivity(new Intent(LearnActivity.this,LoginActivity.class));
                    finish();
                }
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

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
            mDots[i].setTextSize(45);
            mDots[i].setTextColor(getResources().getColor((R.color.BackTextColor)));

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
                    mDots[i].setTextColor(getResources().getColor(R.color.BackTextColor));
            }

            mCurrentPage = page;

            if(page == 0){
                mBackBt.setEnabled(false);
                mNextBt.setEnabled(true);
                mBackBt.setVisibility(View.INVISIBLE);

                mBackBt.setText("");
                mNextBt.setText("ต่อไป");
            }else if (page == mDots.length-1) {
                mBackBt.setEnabled(true);
                mNextBt.setEnabled(true);
                mBackBt.setVisibility(View.VISIBLE);

                mBackBt.setText("ย้อนกลับ");
                mNextBt.setText("ดำเนินการต่อ");
            }else {
                mBackBt.setEnabled(true);
                mBackBt.setVisibility(View.VISIBLE);
                mNextBt.setEnabled(true);

                mBackBt.setText("ย้อนกลับ");
                mNextBt.setText("ต่อไป");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
