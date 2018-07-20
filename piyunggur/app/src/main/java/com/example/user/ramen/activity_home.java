package com.example.user.ramen;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_home extends AppCompatActivity {

    private ViewPager vSlideViewPager;
    private LinearLayout lDotLayout;
    private adapter_home_slider_news aSliderAdapter;
    private TextView[] mDots;
    private int nCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vSlideViewPager = (ViewPager) findViewById(R.id.home_slide_vp_news);
        lDotLayout = (LinearLayout) findViewById(R.id.home_slide_dots);

        Typeface font_head = Typeface.createFromAsset(getAssets(),"fonts/Kanit-SemiBold.ttf");
        Typeface font_data = Typeface.createFromAsset(getAssets(),"fonts/Kanit-Light.ttf");

        aSliderAdapter = new adapter_home_slider_news(this);
        vSlideViewPager.setAdapter(aSliderAdapter);
        addDotsIndicator(0);
        vSlideViewPager.addOnPageChangeListener(viewListener);


    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.BackTextColor));

            lDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor((getResources().getColor(R.color.colorWhite)));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int page) {

            for (int i = 0; i < mDots.length; i++) {

                if (i==page){
                    mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));
                }else
                    mDots[i].setTextColor(getResources().getColor(R.color.BackTextColor));

            }
            nCurrentPage = page;

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
