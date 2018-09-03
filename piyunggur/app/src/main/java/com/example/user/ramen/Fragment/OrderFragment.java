package com.example.user.ramen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.ramen.Activity.MapActivity;
import com.example.user.ramen.Adapter.OrderRecyclerViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class OrderFragment extends Fragment {


    //set object in order
    private static final  String TAG = "OrderRecyclerViewAdapter";
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mTextPrice = new ArrayList<>();
    private ArrayList<Integer> mPrice = new ArrayList<>();

    private Context mContext = getContext();


    //set object in shopping
    private TextView textMenu;
    private Button buttonUseCode;
    private TextView textTotal;
    private TextView mTotal;
    private Button mNext;



    @Override
    public void onResume() {
        super.onResume();
        mContext = getContext();
//        vSlideViewPager.setCurrentItem(nCurrentPage);
    }

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        //set text and set type face (type font)
        textMenu = view.findViewById(R.id.shoppingfm_text_menu);
        buttonUseCode = view.findViewById(R.id.shoppingfm_use);
        textTotal = view.findViewById(R.id.shoppingfm_text_total);
        mTotal = view.findViewById(R.id.shoppingfm_total);
        mNext = view.findViewById(R.id.shoppingfm_next);

        textMenu.setTypeface(CustomFont.getInstance().getFontHead(mContext));
        buttonUseCode.setTypeface(CustomFont.getInstance().getFontData(mContext));
        textTotal.setTypeface(CustomFont.getInstance().getFontData(mContext));
        mTotal.setTypeface(CustomFont.getInstance().getFontData(mContext));
        mNext.setTypeface(CustomFont.getInstance().getFontData(mContext));

        Log.d(TAG,"onCreate: started initAddOrder");
        initOrder(view);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), MapActivity.class));


            }
        });



        return view;
    }

    @SuppressLint("LongLogTag")
    private View initOrder(View v){
        Log.d(TAG,"initAddOrder");

        for (int i = 0; i < 5; i++) {

            mImageResources.add(R.drawable.ramens1);
            mName.add("ramen"+i);
            mTextPrice.add("ราคา");
            mPrice.add(150);

        }

        setOrder(v);

        return v;
    }

    private View setOrder(View v){
        mContext = getContext();
        Log.d("TEST","mContext = " + mContext);

        RecyclerView recyclerView = v.findViewById(R.id.order_recyclerview);
        OrderRecyclerViewAdapter adapter = new OrderRecyclerViewAdapter(mContext,mImageResources,mName,
                mTextPrice,mPrice);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        return v;
    }



}
