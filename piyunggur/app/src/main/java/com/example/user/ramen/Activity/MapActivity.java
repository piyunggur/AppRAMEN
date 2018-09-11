package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;


public class MapActivity extends AppCompatActivity {


    TextView mTextHead;
    Button mSummit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mTextHead = (TextView) findViewById(R.id.map_tvhead);
        mSummit = (Button) findViewById(R.id.map_summit);

        mTextHead.setTypeface(CustomFont.getInstance().getFontData(this));
        mSummit.setTypeface(CustomFont.getInstance().getFontData(this));


    }
}
