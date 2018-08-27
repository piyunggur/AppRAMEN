package com.example.user.ramen.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ramen.R;

import java.util.ArrayList;

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "OrderRecyclerViewAdapter";
    private ArrayList<Integer> arr_Img = new ArrayList<>();
    private ArrayList<String> arr_name = new ArrayList<>();
    private ArrayList<String> arr_textprice = new ArrayList<>();
    private ArrayList<Integer> arr_price = new ArrayList<>();
    private Context mContext;


    public OrderRecyclerViewAdapter(Context mContext, ArrayList<Integer> arr_Img
            ,ArrayList<String> arr_name, ArrayList<String> arr_textprice, ArrayList<Integer> arr_price){
        this.arr_Img.addAll(arr_Img);
        this.arr_name = arr_name;
        this.arr_textprice = arr_textprice;
        this.arr_price.addAll(arr_price);

        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_order, parent,false)
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder {
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView data_name;
        TextView data_textprice;
        TextView data_price;
        CardView parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.order_image);
            data_name = itemView.findViewById(R.id.order_name);
            data_textprice = itemView.findViewById(R.id.order_textprice);
            data_price = itemView.findViewById(R.id.order_price);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

}
