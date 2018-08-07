package com.example.user.ramen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    //news slider
    private ViewPager vSlideViewPager;
    private HomeSlideAdapter aSliderAdapter;
    private LinearLayout lDotLayout;
    private TextView[] mDots;
    private int nCurrentPage;

    //promotion slider
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //new slider
        vSlideViewPager = (ViewPager) findViewById(R.id.home_slide_vp_news);
        lDotLayout = (LinearLayout) findViewById(R.id.home_slide_dots);
        aSliderAdapter = new HomeSlideAdapter(this);
        vSlideViewPager.setAdapter(aSliderAdapter);
        addDotsIndicator(0);
        vSlideViewPager.addOnPageChangeListener(viewListener);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(),2000,4000);

        //promotion slider
        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();


    }

    //create dot in news slider
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

    //chang news slider
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int coutpage, float v, int i1) { }

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
        public void onPageScrollStateChanged(int i) { }
    };

    //auto news slider
    public class SetAutoSlider extends TimerTask{

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
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

    //add data in promotion
    private  void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageResources.add(R.drawable.ramen1);
        mNames.add("1");

        mImageResources.add(R.drawable.ramen2);
        mNames.add("2");

        mImageResources.add(R.drawable.ramen3);
        mNames.add("3");

        mImageResources.add(R.drawable.ramen4);
        mNames.add("4");

        initRecyclerView();

    }

    //set promotion on layout
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerivew.");
        RecyclerView recyclerView = findViewById(R.id.test_recyclerview);
        TestRecyclerViewAdapter adapter = new TestRecyclerViewAdapter(this,mNames,mImageResources);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

}
