package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.Fragment.OrderFragment;
import com.example.user.ramen.R;

public class ShoppingCarActivity extends AppCompatActivity {


    private OrderFragment fragmentOrder;
    private TextView mTextHead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_shoppingcar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mTextHead = (TextView) findViewById(R.id.shoppingcar_tvhead);
        mTextHead.setTypeface(CustomFont.getInstance().getFontData(this));


        fragmentOrder = new OrderFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.shoppingcar_fragment,fragmentOrder)
                .commit();

    }
}
