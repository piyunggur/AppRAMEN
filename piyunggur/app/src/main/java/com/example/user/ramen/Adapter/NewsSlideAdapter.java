package com.example.user.ramen.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.user.ramen.R;

public class NewsSlideAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public NewsSlideAdapter(Context context){
        this.context = context;
    }

    // arrays
    public int[] slide_images = {
            R.drawable.news1,
            R.drawable.news1,
            R.drawable.news1
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
        View view = layoutInflater.inflate(R.layout.listitem_news,null);

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