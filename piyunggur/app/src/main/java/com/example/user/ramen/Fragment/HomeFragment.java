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

import com.example.user.ramen.Adapter.RamenGridViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.Adapter.NewsSlideAdapter;
import com.example.user.ramen.Adapter.ManuRecyclerViewAdapter;
import com.example.user.ramen.Adapter.PromotionRecyclerViewAdapter;
import com.example.user.ramen.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {



    //news slider
    private ViewPager vSlideViewPager;
    private NewsSlideAdapter aSliderAdapter;
    private LinearLayout lDotLayout;
    private TextView[] mDots;
    private int nCurrentPage;
    private final int delay = 3000;
    private final int period = 3000;
    private Timer timer;


    //promotion slider
    private static final String TAG = "HomeFragment";
    private ArrayList<String> promotion_Names = new ArrayList<>();
    private ArrayList<Integer> promotion_ImageResources = new ArrayList<>();
    private ArrayList<String> promotion_Price = new ArrayList<>();


    //set main manu
    private Button main_menu1;
    private Button main_menu2;
    private Button main_menu3;
    private TextView main_menu;


    //set ramen slide
    private ArrayList<Integer> ramen_Image = new ArrayList<>();
    private ArrayList<String> ramen_Name = new ArrayList<>();
    private ArrayList<Integer> ramen_Price = new ArrayList<>();


    //data ramen
    private ArrayList<Integer> bgKcal = new ArrayList<>();
    private ArrayList<Float> Kcal = new ArrayList<>();
    private ArrayList<Integer> bgSale = new ArrayList<>();
    private ArrayList<Integer> Sale = new ArrayList<>();


    //manu slider
    private static final String tag = "Manu";
    private ArrayList<String> mNameMenu = new ArrayList<>();


    private Context mContext = getContext();



    @Override
    public void onResume() {
        super.onResume();
        mContext = getContext();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        mContext = getContext();
        Log.d("TEST","mContext" + mContext);


        //news slider
        vSlideViewPager = v.findViewById(R.id.homefm_newsslide);
        lDotLayout = v.findViewById(R.id.homefm_dotsslide);
        aSliderAdapter = new NewsSlideAdapter(mContext);
        vSlideViewPager.setAdapter(aSliderAdapter);

        addDotsSlider(0);
        vSlideViewPager.addOnPageChangeListener(viewListener);


        //set time auto slider news
        timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(getActivity()),delay,period);


        //setfont in main menu
        main_menu1 = v.findViewById(R.id.homefm_main_menu1);
        main_menu2 = v.findViewById(R.id.homefm_main_menu2);
        main_menu3 = v.findViewById(R.id.homefm_main_menu3);
        main_menu = v.findViewById(R.id.homefm_text_sale);
        main_menu1.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu2.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu3.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        main_menu.setTypeface(CustomFont.getInstance().getFontHead(mContext));

        //makePromotion
        Log.d(TAG, "onCreate: started ImageBitmaps.");
        addPromotion(v);


        //manu slider
        Log.d(tag,"onCreate: started AdddataMenu.");
        AddMenu(v);


        //
        Log.d(tag,"onCreate: started addTestGrid3.");
        addRamen(v);


        return v;
    }


    //create dot in news slider
    public void addDotsSlider(int position){
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
    private View addPromotion(View v){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        int count_data = 4;
        int set_price = 0;
        int set_sale = 0;


        for (int i = 0; i < count_data; i++) {


            if(i == 0){
                promotion_ImageResources.add(R.drawable.ramen1);
            }else if(i == 1){
                promotion_ImageResources.add(R.drawable.ramen2);
            }else if(i == 2){
                promotion_ImageResources.add(R.drawable.ramen3);
            }else if(i == 3){
                promotion_ImageResources.add(R.drawable.ramen4);
            }

            set_price = (i+1)*200;
            set_sale = set_price-(i+1)*50;

            promotion_Names.add("พิเศษสั่ง 2 ถ้วยจากราคา "+set_price+" ฿ เหลือ "+set_sale+" ฿");
            promotion_Price.add(set_sale+"฿");


        }


        setRecyclerViewOnPromotion(v);

        return v;

    }



    //set promotion on layout
    private View setRecyclerViewOnPromotion(View v){
        Log.d(TAG, "initRecyclerView: init recyclerivew.");


        RecyclerView recyclerView = v.findViewById(R.id.homefm_promotion_recyclerview);
        PromotionRecyclerViewAdapter adapter = new PromotionRecyclerViewAdapter(mContext, promotion_Names, promotion_ImageResources, promotion_Price);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);


        return v;
    }



    //add data in menu
    private  View AddMenu(View v){
        Log.d(tag, "initImageBitmaps: preparing bitmaps.");


        mNameMenu.add("โชยุราเมง");
        mNameMenu.add("มิโสะราเมง");
        mNameMenu.add("ชิโอะราเมง");
        mNameMenu.add("ทงคตสึราเมง");
        mNameMenu.add("สึเคเมง");


        setRecyclerViewOnMenu(v);

        return v;
    }


    //set manu on layout
    private View setRecyclerViewOnMenu(View v){


        Log.d(tag, "initRecyclerView: init recyclerivew.");
        RecyclerView recyclerView = v.findViewById(R.id.homefm_manu_recyclerview);
        ManuRecyclerViewAdapter adapter = new ManuRecyclerViewAdapter(mContext, mNameMenu);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return v;

    }

    private View addRamen(View v){

        for (int i = 0; i < 10; i++) {


            if(i == 0){
                ramen_Image.add(R.drawable.ramens1);
            }else if(i == 1){
                ramen_Image.add(R.drawable.ramens2);
            }else if(i == 2){
                ramen_Image.add(R.drawable.ramens3);
            }else if(i == 3){
                ramen_Image.add(R.drawable.ramens4);
            }else if(i == 4){
                ramen_Image.add(R.drawable.ramens5);
            }else if(i == 5){
                ramen_Image.add(R.drawable.ramens6);
            }else if(i == 6){
                ramen_Image.add(R.drawable.ramens1);
            }else if(i == 7){
                ramen_Image.add(R.drawable.ramens2);
            }else if(i == 8){
                ramen_Image.add(R.drawable.ramens3);
            }else if(i == 9){
                ramen_Image.add(R.drawable.ramens4);
            }else if(i == 10){
                ramen_Image.add(R.drawable.ramens5);
            }


            ramen_Name.add("ราเมง"+i);
            ramen_Price.add(155);
            bgKcal.add(R.color.colorKcal);
            Kcal.add(436.2f);
            bgSale.add(R.color.colorSale);
            Sale.add(10);


        }


        setRecyclerViewOnRamen(v);

        return v;
    }




    private View setRecyclerViewOnRamen(View v){


        RecyclerView gridView = v.findViewById(R.id.homefm_ramen_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        RamenGridViewAdapter testGrid3Adapter = new RamenGridViewAdapter(mContext, ramen_Image, ramen_Name,
                ramen_Price, bgKcal, Kcal, bgSale, Sale);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(testGrid3Adapter);


        return v;

    }



}
