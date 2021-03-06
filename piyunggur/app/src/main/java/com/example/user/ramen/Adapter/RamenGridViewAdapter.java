package com.example.user.ramen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ramen.Activity.RamenActivity;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class RamenGridViewAdapter extends RecyclerView.Adapter<RamenGridViewAdapter.ViewHolder>{


    //    private static final String TAG = "TestGrid3ViewAdapter";
    private ArrayList<String> arr_name = new ArrayList<>();
    private ArrayList<Integer> arr_price = new ArrayList<>();
    private ArrayList<Integer> arr_image = new ArrayList<>();
    private ArrayList<Integer> arr_bgkcal = new ArrayList<>();
    private ArrayList<Float> arr_kcal = new ArrayList<>();
    private ArrayList<Integer> arr_bgsale = new ArrayList<>();
    private ArrayList<Integer> arr_sale = new ArrayList<>();
    private ArrayList<Integer> arr_heart1 = new ArrayList<>();
    private ArrayList<Integer> arr_heart2 = new ArrayList<>();
    private ArrayList<Integer> arr_heart3 = new ArrayList<>();
    private ArrayList<Integer> arr_heart4 = new ArrayList<>();
    private ArrayList<Integer> arr_heart5 = new ArrayList<>();
    private Context mContext;


    public RamenGridViewAdapter(Context mContext,ArrayList<Integer> images,ArrayList<String> names,ArrayList<Integer> prices,
                                ArrayList<Integer> bgkcals, ArrayList<Float> kcals,ArrayList<Integer> bgsales, ArrayList<Integer> sales,
                                ArrayList<Integer> heart1,ArrayList<Integer> heart2,ArrayList<Integer> heart3,ArrayList<Integer> heart4,ArrayList<Integer> heart5) {


        this.arr_image.addAll(images);
        this.arr_name = names;
        this.arr_price = prices;
        this.mContext = mContext;
        this.arr_bgkcal = bgkcals;
        this.arr_kcal = kcals;
        this.arr_bgsale = bgsales;
        this.arr_sale = sales;
        this.arr_heart1 = heart1;
        this.arr_heart2 = heart2;
        this.arr_heart3 = heart3;
        this.arr_heart4 = heart4;
        this.arr_heart5 = heart5;


    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_ramen, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;


    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Log.d(TAG, "onBindViewHolder: called.");


        holder.data_image.setImageResource(arr_image.get(position));
        holder.data_name.setText(arr_name.get(position));
        holder.data_name.setTypeface(CustomFont.getInstance().getFontData(mContext));
        holder.data_price.setText(arr_price.get(position)+" ฿");
        holder.data_price.setTypeface(CustomFont.getInstance().getFontData(mContext));


        holder.data_bgkcal.setImageResource(arr_bgkcal.get(position));
        holder.data_kcal.setText(arr_kcal.get(position)+" kcal");
        holder.data_kcal.setTypeface(CustomFont.getInstance().getFontData(mContext));
        holder.data_bgsale.setImageResource(arr_bgsale.get(position));
        holder.data_sale.setText(arr_sale.get(position)+" %");
        holder.data_sale.setTypeface(CustomFont.getInstance().getFontData(mContext));

        holder.data_heart1.setImageResource(arr_heart1.get(position));
        holder.data_heart2.setImageResource(arr_heart2.get(position));
        holder.data_heart3.setImageResource(arr_heart3.get(position));
        holder.data_heart4.setImageResource(arr_heart4.get(position));
        holder.data_heart5.setImageResource(arr_heart5.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set go to RamenActivity
                Intent intent = new Intent(mContext,RamenActivity.class);
                intent.putExtra("NameRamen",arr_name.get(position));
                intent.putExtra("Price",arr_price.get(position));
                mContext.startActivity(intent);
//                Toast.makeText(mContext, arr_name.get(position), Toast.LENGTH_SHORT).show();
//                Toast.makeText(mContext,arr_price.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    public int getItemCount() {
        return arr_name.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView data_image;
        TextView data_name;
        TextView data_price;
        CardView parentLayout;

        ImageView data_bgkcal;
        TextView data_kcal;
        ImageView data_bgsale;
        TextView data_sale;

        ImageView data_heart1;
        ImageView data_heart2;
        ImageView data_heart3;
        ImageView data_heart4;
        ImageView data_heart5;


        public ViewHolder(View itemView){
            super(itemView);


            data_image = itemView.findViewById(R.id.ramen_image);
            data_name = itemView.findViewById(R.id.ramen_text);
            data_price = itemView.findViewById(R.id.ramen_price);
            parentLayout = itemView.findViewById(R.id.ramen_listitem);

            data_bgkcal = itemView.findViewById(R.id.ramen_bgkcal);
            data_kcal = itemView.findViewById(R.id.ramen_kcal);
            data_bgsale = itemView.findViewById(R.id.ramen_bgsale);
            data_sale = itemView.findViewById(R.id.ramen_sale);

            data_heart1 = itemView.findViewById(R.id.ramen_ivheart1);
            data_heart2 = itemView.findViewById(R.id.ramen_ivheart2);
            data_heart3 = itemView.findViewById(R.id.ramen_ivheart3);
            data_heart4 = itemView.findViewById(R.id.ramen_ivheart4);
            data_heart5 = itemView.findViewById(R.id.ramen_ivheart5);

        }

    }



}
