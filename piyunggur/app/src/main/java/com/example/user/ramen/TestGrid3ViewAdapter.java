package com.example.user.ramen;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestGrid3ViewAdapter extends RecyclerView.Adapter<TestGrid3ViewAdapter.ViewHolder>{

//    private static final String TAG = "TestGrid3ViewAdapter";
    private ArrayList<String> arr_name = new ArrayList<>();
    private ArrayList<Integer> arr_price = new ArrayList<>();
    private ArrayList<Integer> arr_image = new ArrayList<>();
    private ArrayList<Integer> arr_bgkcal = new ArrayList<>();
    private ArrayList<Float> arr_kcal = new ArrayList<>();
    private ArrayList<Integer> arr_bgsale = new ArrayList<>();
    private ArrayList<Integer> arr_sale = new ArrayList<>();
    private Context mContext;

    public TestGrid3ViewAdapter(Context mContext,ArrayList<Integer> images,ArrayList<String> names,ArrayList<Integer> prices,
                                ArrayList<Integer> bgkcals, ArrayList<Float> kcals,ArrayList<Integer> bgsales, ArrayList<Integer> sales) {
        this.arr_image.addAll(images);
        this.arr_name = names;
        this.arr_price = prices;
        this.mContext = mContext;
        this.arr_bgkcal = bgkcals;
        this.arr_kcal = kcals;
        this.arr_bgsale = bgsales;
        this.arr_sale = sales;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allmanu_listitem, parent, false);
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

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on : " + arr_name.get(position));

                Toast.makeText(mContext, arr_name.get(position), Toast.LENGTH_SHORT).show();
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

        public ViewHolder(View itemView){
            super(itemView);
            data_image = itemView.findViewById(R.id.testgrid3_image);
            data_name = itemView.findViewById(R.id.testgrid3_text);
            data_price = itemView.findViewById(R.id.testgrid3_price);
            parentLayout = itemView.findViewById(R.id.testgrid3_listitem);

            data_bgkcal = itemView.findViewById(R.id.testgrid3_bgkcal);
            data_kcal = itemView.findViewById(R.id.testgrid3_kcal);
            data_bgsale = itemView.findViewById(R.id.testgrid3_bgsale);
            data_sale = itemView.findViewById(R.id.testgrid3_sale);

        }

    }

}
