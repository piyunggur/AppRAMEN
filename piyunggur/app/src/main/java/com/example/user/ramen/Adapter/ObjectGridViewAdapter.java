package com.example.user.ramen.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.ramen.R;

import java.util.ArrayList;

public class ObjectGridViewAdapter extends RecyclerView.Adapter<ObjectGridViewAdapter.ViewHolder> {



    private ArrayList<Integer> arr_image = new ArrayList<>();
    private Context mContext;


    public ObjectGridViewAdapter(Context mContext,ArrayList<Integer> image){
        this.arr_image.addAll(image);
        this.mContext = mContext;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_object, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.data_imge.setImageResource(arr_image.get(position));

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView data_imge;
        CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            data_imge = itemView.findViewById(R.id.object_ivobject);
            parentLayout = itemView.findViewById(R.id.object_listitem);
        }
    }
}
