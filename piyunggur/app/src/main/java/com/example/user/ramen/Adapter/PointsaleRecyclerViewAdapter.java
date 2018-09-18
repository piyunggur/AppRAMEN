package com.example.user.ramen.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class PointsaleRecyclerViewAdapter extends RecyclerView.Adapter<PointsaleRecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> arr_text = new ArrayList<>();
    private ArrayList<String> arr_point = new ArrayList<>();
    private Context mContext;


    public PointsaleRecyclerViewAdapter(Context mContext, ArrayList<String> arr_point
        ,ArrayList<String> arr_text){


        this.arr_text = arr_text;
        this.arr_point = arr_point;

        this.mContext = mContext;
        }


    @Override
    public PointsaleRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_pointsale, parent,false);
        PointsaleRecyclerViewAdapter.ViewHolder holder = new PointsaleRecyclerViewAdapter.ViewHolder(view);
        return holder;


        }


    @Override
    public void onBindViewHolder(PointsaleRecyclerViewAdapter.ViewHolder holder, final int position) {


        holder.point.setText(arr_point.get(position));
        holder.text.setText(arr_text.get(position));

        holder.point.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        holder.text.setTypeface(CustomFont.getInstance().getFontData(mContext));

        }


    @Override
    public int getItemCount() {
        return arr_text.size();
        }


    public class ViewHolder extends RecyclerView.ViewHolder{


        Button point;
        TextView text;


    public ViewHolder(View itemView){
        super(itemView);

        point = itemView.findViewById(R.id.pointsale_sale);
        text = itemView.findViewById(R.id.pointsale_data);
    }

    }

}
