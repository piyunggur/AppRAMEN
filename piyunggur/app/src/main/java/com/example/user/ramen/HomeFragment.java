package com.example.user.ramen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    //news slider
    private ViewPager vSlideViewPager;
    private HomeSlideAdapter aSliderAdapter;
    private LinearLayout lDotLayout;
    private TextView[] mDots;
    private int nCurrentPage;
    private final int delay = 2000;
    private final int period = 4000;

    private Context mContext;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        nCurrentPage = vSlideViewPager.getCurrentItem();
    }

    @Override
    public void onResume() {
        super.onResume();
        mContext = getContext();
        vSlideViewPager.setCurrentItem(nCurrentPage);
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
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SetAutoSlider(getActivity()),delay,period);

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
                        nCurrentPage = vSlideViewPager.getCurrentItem();
                    }else if (vSlideViewPager.getCurrentItem() == 1){
                        vSlideViewPager.setCurrentItem(2);
                        nCurrentPage = vSlideViewPager.getCurrentItem();
                    } else{
                        vSlideViewPager.setCurrentItem(0);
                        nCurrentPage = vSlideViewPager.getCurrentItem();
                    }
                }
            });
        }
    }





}
