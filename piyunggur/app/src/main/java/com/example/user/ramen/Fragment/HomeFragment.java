package com.example.user.ramen.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.Adapter.HomeSlideAdapter;
import com.example.user.ramen.Adapter.ManuRecyclerViewAdapter;
import com.example.user.ramen.Adapter.PromotionRecyclerViewAdapter;
import com.example.user.ramen.R;
import com.example.user.ramen.Adapter.TestGrid3ViewAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    //news slider
    private ViewPager vSlideViewPager;
    private HomeSlideAdapter aSliderAdapter;
    private LinearLayout lDotLayout;
    private TextView[] mDots;
    private int nCurrentPage;
    private final int delay = 3000;
    private final int period = 3000;
    private Timer timer;

    //promotion slider
    private static final String TAG = "HomeFragment";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();

    //set main manu
    private Button main_menu1;
    private Button main_menu2;
    private Button main_menu3;
    private TextView main_menu;

    //set allmanu slide
    private ArrayList<Integer> arraylistImage_testgrid3 = new ArrayList<>();
    private ArrayList<String> arraylistName_testgrid3 = new ArrayList<>();
    private ArrayList<Integer> arraylistPrice_testgrid3 = new ArrayList<>();

    private ArrayList<Integer> arrayListbgKcal = new ArrayList<>();
    private ArrayList<Float> arrayListKcal = new ArrayList<>();
    private ArrayList<Integer> arrayListbgSale = new ArrayList<>();
    private ArrayList<Integer> arrayListSale = new ArrayList<>();

    //manu slider
    private static final String tag = "Manu";
    private ArrayList<String> mNameManu = new ArrayList<>();

    private Context mContext;

    @Override
    public void onResume() {
        super.onResume();
        mContext = getContext();
//        vSlideViewPager.setCurrentItem(nCurrentPage);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.homefragment_layout, container, false);

        //new slider
        vSlideViewPager = v.findViewById(R.id.homefm_newsslide);
        lDotLayout = v.findViewById(R.id.homefm__dotsslide);
        aSliderAdapter = new HomeSlideAdapter(inflater.getContext());
        vSlideViewPager.setAdapter(aSliderAdapter);
        addDotsIndicator(0);
        vSlideViewPager.addOnPageChangeListener(viewListener);

        //set time auto slider news
        timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(getActivity()),delay,period);
        //v.animate().translationY(0);

        //setfont in main menu
        main_menu1 = v.findViewById(R.id.homefm_main_menu1);
        main_menu2 = v.findViewById(R.id.homefm_main_menu2);
        main_menu3 = v.findViewById(R.id.homefm_main_menu3);
        main_menu = v.findViewById(R.id.homefm_text_sale);
        main_menu1.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu2.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu3.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu.setTypeface(CustomFont.getInstance().getFontHead(mContext));

        Log.d(TAG, "onCreate: started ImageBitmaps.");
        initImageBitmaps(v);

        //manu slider
        Log.d(tag,"onCreate: started AdddataMenu.");
        AdddataMenu(v);

        Log.d(tag,"onCreate: started addTestGrid3.");
        addTestGrid3(v);

        return v;
    }

    //create dot in news slider
    public void addDotsIndicator(int position){
        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(getActivity());
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorMain));

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
                    mDots[i].setTextColor(mContext.getResources().getColor(R.color.colorWhite));
                }else
                    mDots[i].setTextColor(mContext.getResources().getColor(R.color.colorMain));

            }
            nCurrentPage = page;
        }

        @Override
        public void onPageScrollStateChanged(int i) { }
    };

    //auto news slider
    public class SetAutoSlider extends TimerTask {

        private Activity context;

        public SetAutoSlider(Activity context){
            this.context = context;
        }

        @Override
        public void run() {

            context.runOnUiThread(new Runnable() {
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

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }

    //add data in promotion
    private View initImageBitmaps(View v){
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

        initRecyclerView(v);

        return v;

    }

    //set promotion on layout
    private View initRecyclerView(View v){
        Log.d(TAG, "initRecyclerView: init recyclerivew.");

        RecyclerView recyclerView = v.findViewById(R.id.homefm_promotion_recyclerview);
        PromotionRecyclerViewAdapter adapter = new PromotionRecyclerViewAdapter(mContext,mNames,mImageResources,mPrice);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    //add data in manu
    private  View AdddataMenu(View v){
        Log.d(tag, "initImageBitmaps: preparing bitmaps.");

        mNameManu.add("โชยุราเมง");

        mNameManu.add("มิโสะราเมง");

        mNameManu.add("ชิโอะราเมง");

        mNameManu.add("ทงคตสึราเมง");

        mNameManu.add("สึเคเมง");

        setRecyclerViewOnManu(v);

        return v;
    }

    //set manu on layout
    private View setRecyclerViewOnManu(View v){
        Log.d(tag, "initRecyclerView: init recyclerivew.");
        RecyclerView recyclerView = v.findViewById(R.id.homefm_manu_recyclerview);
        ManuRecyclerViewAdapter adapter = new ManuRecyclerViewAdapter(mContext,mNameManu);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return v;

    }

    private View addTestGrid3(View v){

        for (int i = 0; i < 10; i++) {

            arraylistImage_testgrid3.add(R.drawable.ramens1);
            arraylistName_testgrid3.add("ราเมง"+i);
            arraylistPrice_testgrid3.add(155);
            arrayListbgKcal.add(R.color.colorKcal);
            arrayListKcal.add(436.2f);
            arrayListbgSale.add(R.color.colorSale);
            arrayListSale.add(10);
        }

        setTestGrid3(v);

        return v;
    }

    private View setTestGrid3(View v){

        RecyclerView gridView = v.findViewById(R.id.homefm_testgrid3_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);

        TestGrid3ViewAdapter testGrid3Adapter = new TestGrid3ViewAdapter(mContext,arraylistImage_testgrid3,arraylistName_testgrid3,
                arraylistPrice_testgrid3, arrayListbgKcal, arrayListKcal, arrayListbgSale, arrayListSale);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(testGrid3Adapter);

        return v;
    }

}
