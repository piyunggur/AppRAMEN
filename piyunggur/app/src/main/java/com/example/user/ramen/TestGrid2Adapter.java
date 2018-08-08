package com.example.user.ramen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TestGrid2Adapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Ramen> arrs;

    //constructor
    public TestGrid2Adapter(Context mContext,ArrayList<Ramen> arrss) {
        this.mContext = mContext;
        this.arrs = arrss;
    }


    @Override
    public int getCount() {
        return arrs.size();
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
        TextView textname = new TextView(mContext);
        textname.setText(String.valueOf(position));
        final Ramen arr = arrs.get(position);

        if(convertView == null){
            final LayoutInflater layoutInflater= LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.testlinearlayout_grid2,null);
        }

        final ImageView imageView =
                (ImageView)convertView.findViewById(R.id.test2_imageview_coverart);
        final TextView nameTextView =
                (TextView)convertView.findViewById(R.id.test2_textview_bookname);
        final TextView priceTextView =
                (TextView)convertView.findViewById(R.id.test2_textview_bookauthor);
        final ImageView imageViewFavorite =
                (ImageView)convertView.findViewById(R.id.test2_imageview_favorite);

        imageView.setImageResource(arr.getImage());
        nameTextView.setText(arr.getName());
        priceTextView.setText(arr.getPrice()+"");

        return convertView;
    }
}
