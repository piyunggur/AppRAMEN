package com.example.user.ramen;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class activity_home extends AppCompatActivity {

    private ViewPager vSlideViewPager;
    private LinearLayout lDotLayout;
    private adapter_home_slider_news aSliderAdapter;
    private TextView[] mDots;
    private int nCurrentPage;
    private int coutpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vSlideViewPager = (ViewPager) findViewById(R.id.home_slide_vp_news);
        lDotLayout = (LinearLayout) findViewById(R.id.home_slide_dots);
        aSliderAdapter = new adapter_home_slider_news(this);

        vSlideViewPager.setAdapter(aSliderAdapter);
        addDotsIndicator(0);
        vSlideViewPager.addOnPageChangeListener(viewListener);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(),2000,4000);

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.MainColor));

            lDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor((getResources().getColor(R.color.colorWhite)));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int coutpage, float v, int i1) {

        }

        @Override
        public void onPageSelected(int page) {

            for (int i = 0; i < mDots.length; i++) {

                if (i==page){
                    mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));
                }else
                    mDots[i].setTextColor(getResources().getColor(R.color.MainColor));

            }
            nCurrentPage = page;

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    public class SetAutoSlider extends TimerTask{

        @Override
        public void run() {

            activity_home.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(vSlideViewPager.getCurrentItem() == 0){
                        vSlideViewPager.setCurrentItem(1);
                    }else if (vSlideViewPager.getCurrentItem() == 1){
                        vSlideViewPager.setCurrentItem(2);
                    } else{
                        vSlideViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}
