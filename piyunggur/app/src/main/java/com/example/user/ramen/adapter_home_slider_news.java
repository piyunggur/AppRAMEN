package com.example.user.ramen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class adapter_home_slider_news extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public adapter_home_slider_news(Context context){
        this.context = context;
    }

    // arrays
    public int[] slide_images = {
            R.drawable.home_img_news,
            R.drawable.home_img_news,
            R.drawable.home_img_news
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_slide_news,null);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.home_slide_img);

        slideImageView.setImageResource(slide_images[position]);
        container.addView(view,0);
        return view;
    }

    @Override
    public void  destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);

    }

}