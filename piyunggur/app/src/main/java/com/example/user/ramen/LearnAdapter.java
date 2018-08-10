package com.example.user.ramen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LearnAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public LearnAdapter(Context context){
        this.context = context;
    }

    // arrays
    public int[] slide_images = {
            R.drawable.ramen,
            R.drawable.car,
            R.drawable.sale
    };

    public String[] slide_head = {
            "ราเมง",
            "การส่งสินค้า",
            "ลดราคา"
    };

    public String[] slide_data = {
            "รวมราเมงทั่วญี่ปุ่นรสชาติอร่อย\nไวในแอพนี้",
            "ไม่ว่าอยู่ที่ไหนก็สั่งได้",
            "ทุกครั้งที่มีการสั่งซื้อจะได้รับ point ที่สามารถนำมาแลก\nคูปองส่วนลดได้"
    };

    @Override
    public int getCount() {
        return slide_head.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.learn_slider,container,false);

        ImageView slideImage = (ImageView) view.findViewById(R.id.learn_image);
        TextView slideHead = (TextView) view.findViewById(R.id.learn_head);
        TextView slideData = (TextView) view.findViewById(R.id.learn_data);
        slideHead.setTypeface(CustomFont.getInstance().getFontHead(context));
        slideData.setTypeface(CustomFont.getInstance().getFontData(context));
        slideImage.setImageResource(slide_images[position]);
        slideHead.setText(slide_head[position]);
        slideData.setText(slide_data[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void  destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }

}
