package com.example.user.ramen.Adapter;


import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder> {

    //private static final String TAG = "OrderRecyclerViewAdapter";
    private static final String TAG = "RecyclerViewAdapter";
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_order, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.img.setImageResource(arr_Img.get(position));
        holder.data_name.setText(arr_name.get(position));
        holder.data_textprice.setText(arr_textprice.get(position));
        holder.data_price.setText(arr_price.get(position)+" ฿");

        holder.data_name.setTypeface(CustomFont.getInstance().getFontData(mContext));
        holder.data_textprice.setTypeface(CustomFont.getInstance().getFontData(mContext));
        holder.data_price.setTypeface(CustomFont.getInstance().getFontData(mContext));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on : " + arr_name.get(position));
                Log.d(TAG,"mContext = "+mContext);
                Toast.makeText(mContext, arr_name.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return arr_name.size();
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
            parentLayout = itemView.findViewById(R.id.order_listitem);
        }

    }

}
