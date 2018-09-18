package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Adapter.AlertRecyclerViewAdapter;
import com.example.user.ramen.Adapter.PointsaleRecyclerViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class PointsaleActivity extends AppCompatActivity {


    //set object in pointsaleadapter
    private ArrayList<String> Point = new ArrayList<>();
    private ArrayList<String> TextData = new ArrayList<>();


    TextView Pointsale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pointsale);


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
        textView.setText("คะแนนสะสม");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        Pointsale = (TextView) findViewById(R.id.pointsale_point);
        Pointsale.setTypeface(CustomFont.getInstance().getFontHead(this));


        initPointsale();

    }


    private void initPointsale(){
//       Log.d(TAG,"initAddOrder");

        for (int i = 0; i < 10; i++) {

            Point.add("25p ใช้");
            TextData.add("แลกรับส่วนลดราเมน 5 บาท");

        }

        setPointsale();
    }


    private void setPointsale(){
//        Log.d("TEST","mContext = " + mContext);

        RecyclerView recyclerView = findViewById(R.id.pointsale_recyclerview);
        PointsaleRecyclerViewAdapter adapter = new PointsaleRecyclerViewAdapter(this, Point, TextData);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }




}
