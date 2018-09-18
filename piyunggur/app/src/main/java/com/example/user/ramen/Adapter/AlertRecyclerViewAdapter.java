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
import android.widget.Toast;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class AlertRecyclerViewAdapter extends RecyclerView.Adapter<AlertRecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "AlertAdapter";
    private ArrayList<Integer> arr_Img = new ArrayList<>();
    private ArrayList<String> arr_data = new ArrayList<>();
    private ArrayList<Integer> arr_line = new ArrayList<>();
    private Context mContext;


    public AlertRecyclerViewAdapter(Context mContext, ArrayList<Integer> arr_Img
            ,ArrayList<String> arr_data, ArrayList<Integer> arr_line){
        this.arr_Img.addAll(arr_Img);
        this.arr_data = arr_data;
        this.arr_line.addAll(arr_line);

        this.mContext = mContext;
    }

    @Override
    public AlertRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_alert, parent,false);
        AlertRecyclerViewAdapter.ViewHolder holder = new AlertRecyclerViewAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(AlertRecyclerViewAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.img.setImageResource(arr_Img.get(position));
        holder.data_data.setText(arr_data.get(position));
        holder.data_line.setImageResource(arr_line.get(position));

        holder.data_data.setTypeface(CustomFont.getInstance().getFontData(mContext));

//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG,"onClick: clicked on : " + arr_name.get(position));
//                Toast.makeText(mContext, arr_name.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return arr_data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView data_data;
        ImageView data_line;
        CardView parentLayout;

        public ViewHolder(View itemView){
            super(itemView);

            img = itemView.findViewById(R.id.alert_image);
            data_data = itemView.findViewById(R.id.alert_data);
            data_line = itemView.findViewById(R.id.alert_line);
            parentLayout = itemView.findViewById(R.id.alert_listitem);
        }

    }

}
