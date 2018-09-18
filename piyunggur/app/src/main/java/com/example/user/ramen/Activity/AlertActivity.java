package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Adapter.AlertRecyclerViewAdapter;
import com.example.user.ramen.Adapter.OrderRecyclerViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class AlertActivity extends AppCompatActivity {


    //set object in order
    private ArrayList<Integer> ImageNews = new ArrayList<>();
    private ArrayList<String> DataNews = new ArrayList<>();
    private ArrayList<Integer> Line = new ArrayList<>();

    TextView HeadNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_alert);


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
        textView.setText("การแจ้งเตือน");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        HeadNews = (TextView) findViewById(R.id.alert_text_head);


        HeadNews.setTypeface(CustomFont.getInstance().getFontHead(this));


        initAlert();

    }


    private void initAlert(){
//       Log.d(TAG,"initAddOrder");

        for (int i = 0; i < 10; i++) {

            ImageNews.add(R.drawable.box);
            DataNews.add("ออเดอรหมายเลข 123456 ส่งถึงสถานที่ ที่กำหนดแล้ว\nกรุณายืนยันสิ้นค้าเพื่อส่งมอบเงิน");
            Line.add(R.color.colorMain);

        }

        setAlert();
    }


    private void setAlert(){
//        Log.d("TEST","mContext = " + mContext);

        RecyclerView recyclerView = findViewById(R.id.alert_recyclerview);
        AlertRecyclerViewAdapter adapter = new AlertRecyclerViewAdapter(this, ImageNews, DataNews, Line);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }




}
