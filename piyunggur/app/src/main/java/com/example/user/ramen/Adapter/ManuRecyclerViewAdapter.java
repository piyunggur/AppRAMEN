package com.example.user.ramen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ramen.Activity.Manu1Activity;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class ManuRecyclerViewAdapter extends RecyclerView.Adapter<ManuRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "ManuRecyclerViewAdapter";
    private ArrayList<String> arr_manu = new ArrayList<>();
    private Context mContext;

    public ManuRecyclerViewAdapter(Context mContext, ArrayList<String> arr_name) {
        this.arr_manu = arr_name;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_menu, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.data_name.setText(arr_manu.get(position));
        holder.data_name.setTypeface(CustomFont.getInstance().getFontData(mContext));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on : " + arr_manu.get(position));
                mContext.startActivities(new Intent[]{new Intent(mContext, Manu1Activity.class)});
                Toast.makeText(mContext, arr_manu.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr_manu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView data_name;
        CardView parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            data_name = itemView.findViewById(R.id.name_manu);
            parentLayout = itemView.findViewById(R.id.manu_layout);
        }

    }

}
