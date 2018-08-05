package com.example.user.ramen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    private  Context mContext;

    public CustomAdapter(Context context){
        mContext = context;
    }

    public int getCount(){
        return  24;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(20,20,20,20);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(R.drawable.ramen);
        return imageView;
    }
}
