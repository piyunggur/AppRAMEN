package com.example.user.ramen;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PromotionRecyclerViewAdapter extends RecyclerView.Adapter<PromotionRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Integer> arr_Img = new ArrayList<>();
    private ArrayList<String> arr_datatext = new ArrayList<>();
    private ArrayList<String> arr_price = new ArrayList<>();
    private Context mContext;

    public PromotionRecyclerViewAdapter(Context mContext, ArrayList<String> arr_datatext, ArrayList<Integer> arr_Image, ArrayList<String> arr_prices) {
        this.arr_Img.addAll(arr_Image);
        this.arr_datatext = arr_datatext;
        this.arr_price = arr_prices;
//        for (int i = 0; i < arr_datatext.size(); i++) {
//            System.out.println(arr_Img.get(i));
//        }
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_listitem_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.img.setImageResource(arr_Img.get(position));
        holder.data_text.setText(arr_datatext.get(position));
        holder.data_price.setText(arr_price.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on : " + arr_datatext.get(position));

                Toast.makeText(mContext, arr_datatext.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr_datatext.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView data_text;
        TextView data_price;
        CardView parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.img_card);
            data_text = itemView.findViewById(R.id.text_card);
            data_price = itemView.findViewById(R.id.text_price);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

}
