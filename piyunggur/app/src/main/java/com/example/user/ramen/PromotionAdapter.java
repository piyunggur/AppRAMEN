package com.example.user.ramen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PromotionAdapter extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;

    public PromotionAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.promotion_test_1,
            R.drawable.promotion_test_2,
            R.drawable.promotion_test_1
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.promotion_cradview,null);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.cradview_promotion_iv);

        slideImageView.setImageResource(slide_images[position]);
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }
}
