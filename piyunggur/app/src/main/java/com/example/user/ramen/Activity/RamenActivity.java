package com.example.user.ramen.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

public class RamenActivity extends AppCompatActivity {


    TextView mHead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ramen);


        mHead = (TextView) findViewById(R.id.ramen_tvhead);


        mHead.setTypeface(CustomFont.getInstance().getFontHead(this));

    }
}
