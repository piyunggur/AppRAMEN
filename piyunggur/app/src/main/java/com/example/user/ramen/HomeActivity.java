package com.example.user.ramen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
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
    private ArrayList<String> mPrice = new ArrayList<>();

    //set button main manu
    private Button main_manu1;
    private Button main_manu2;
    private Button main_manu3;

    //set text main manu
    private TextView main_manu;

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

        //set time auto slider news
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(),2000,4000);

        //promotion slider
        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();

        //set button main manu
        main_manu1 = (Button) findViewById(R.id.home_main_manu1);
        main_manu2 = (Button) findViewById(R.id.home_main_manu2);
        main_manu3 = (Button) findViewById(R.id.home_main_manu3);
        //text
        main_manu = (TextView) findViewById(R.id.text_sale);

        //set font on main manu
        main_manu1.setTypeface(CustomFont.getInstance().getFontHead(this));
        main_manu2.setTypeface(CustomFont.getInstance().getFontHead(this));
        main_manu3.setTypeface(CustomFont.getInstance().getFontHead(this));
        //text
        main_manu.setTypeface(CustomFont.getInstance().getFontHead(this));

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
        mNames.add("พิเศษสั่ง 2 ถ้วยจากราคา 200฿ เหลือ 190฿");
        mPrice.add("190฿");

        mImageResources.add(R.drawable.ramen2);
        mNames.add("พิเศษสั่ง 3 ถ้วยจากราคา 400฿ เหลือ 290฿");
        mPrice.add("290฿");

        mImageResources.add(R.drawable.ramen3);
        mNames.add("พิเศษสั่ง 4 ถ้วยจากราคา 500฿ เหลือ 380฿");
        mPrice.add("380฿");

        mImageResources.add(R.drawable.ramen4);
        mNames.add("พิเศษสั่ง 5 ถ้วยจากราคา 600฿ เหลือ 480฿");
        mPrice.add("148฿");

        initRecyclerView();

    }

    //set promotion on layout
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerivew.");
        RecyclerView recyclerView = findViewById(R.id.test_recyclerview);
        PromotionRecyclerViewAdapter adapter = new PromotionRecyclerViewAdapter(this,mNames,mImageResources,mPrice);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

}
