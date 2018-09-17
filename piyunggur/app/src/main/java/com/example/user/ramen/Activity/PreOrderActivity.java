package com.example.user.ramen.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Adapter.OrderRecyclerViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class PreOrderActivity extends AppCompatActivity {


    TextView Head;
    TextView Name;
    TextView At;
    TextView Headmenu;
    Button Menu1;
    Button Menu2;
    Button Menu3;
    Button Menu4;
    Button ATM;


    //set object in order
    private static final  String TAG = "OrderRecyclerViewAdapter";
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mTextPrice = new ArrayList<>();
    private ArrayList<Integer> mPrice = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pre_order);


        //set actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar_layout);

        View view = actionBar.getCustomView();
        TextView textView = (TextView)view.findViewById(R.id.custom_bar_text);
        ImageButton imageButton = (ImageButton)view.findViewById(R.id.custom_bar_back);
        ImageButton imageButton2 = (ImageButton)view.findViewById(R.id.custom_bar_safe);


        textView.setTypeface(CustomFont.getInstance().getFontHead(this));
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        Head = (TextView) findViewById(R.id.pre_order_head);
        Name = (TextView) findViewById(R.id.pre_order_name);
        At = (TextView) findViewById(R.id.pre_order_at);
        Headmenu = (TextView) findViewById(R.id.pre_order_headmenu);
        Menu1 = (Button) findViewById(R.id.pre_order_menu1);
        Menu2 = (Button) findViewById(R.id.pre_order_menu2);
        Menu3 = (Button) findViewById(R.id.pre_order_menu3);
        Menu4 = (Button) findViewById(R.id.pre_order_menu4);
        ATM = (Button) findViewById(R.id.pre_order_atm);


        Head.setTypeface(CustomFont.getInstance().getFontHead(this));
        Name.setTypeface(CustomFont.getInstance().getFontData(this));
        At.setTypeface(CustomFont.getInstance().getFontData(this));
        Headmenu.setTypeface(CustomFont.getInstance().getFontHead(this));
        Menu1.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu2.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu3.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu4.setTypeface(CustomFont.getInstance().getFontData(this));
        ATM.setTypeface(CustomFont.getInstance().getFontData(this));

        initOrder();


        ATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(PreOrderActivity.this,ATMActivity.class));

            }
        });

    }



    @SuppressLint("LongLogTag")
    private void initOrder(){
        Log.d("PreOrder","initAddOrder");

        for (int i = 0; i < 5; i++) {

            mImageResources.add(R.drawable.ramens1);
            mName.add("ramen"+i);
            mTextPrice.add("ราคา");
            mPrice.add(150);

        }

        setOrder();

    }

    private void setOrder(){


        RecyclerView recyclerView = findViewById(R.id.pre_order_recyclerview);
        OrderRecyclerViewAdapter adapter = new OrderRecyclerViewAdapter(this,mImageResources,mName,
                mTextPrice,mPrice);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


    }


}
