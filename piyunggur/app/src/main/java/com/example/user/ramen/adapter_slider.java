package com.example.user.ramen;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class adapter_slider extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public adapter_slider(Context context){
        this.context = context;
    }

    // arrays
    public int[] slide_images = {
            R.drawable.learn_ic_ramen,
            R.drawable.learn_ic_car,
            R.drawable.learn_ic_sale
    };

    public String[] slide_headings = {
            "ราเมง",
            "การส่งสินค้า",
            "ลดราคา"
    };

    public String[] slide_desc = {
            "รวมราเมงทั่วญี่ปุ่นรสชาติอร่อย\nไวในแอพนี้",
            "ไม่ว่าอยู่ที่ไหนก็สั่งได้",
            "ทุกครั้งที่มีการสั่งซื้อจะได้รับ point ที่สามารถนำมาแลก\nคูปองส่วนลดได้"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideHeading.setTypeface(CustomFont.getInstance().getFontHead(context));
        slideDescription.setTypeface(CustomFont.getInstance().getFontData(context));

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void  destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }

}
