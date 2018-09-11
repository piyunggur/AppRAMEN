package com.example.user.ramen.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.user.ramen.Adapter.ObjectGridViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.Custom.Ramen;
import com.example.user.ramen.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RamenActivity extends AppCompatActivity {


    Button mBack;
    TextView mHead;
    TextView mName;
    Button btSale;
    TextView mDataRamen;
    TextView mHeadObject;
    TextView mNoteObject;

    //menu below
    Button mLike;
    TextView mSave;
    TextView mSale;
    TextView mTotal;
    TextView mPrice;


    boolean like ;

    private ArrayList<Integer> mObject_image = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ramen);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mBack = (Button) findViewById(R.id.ramen_back);
        mHead = (TextView) findViewById(R.id.ramen_tvhead);
        mName = (TextView) findViewById(R.id.ramen_tvname);
        btSale = (Button) findViewById(R.id.ramen_shopping);
        mDataRamen = (TextView) findViewById(R.id.ramen_data_ramen);
        mHeadObject = (TextView) findViewById(R.id.ramen_tvobject);
        mNoteObject = (TextView) findViewById(R.id.ramen_tvnote);

        //menu below
        mLike = (Button) findViewById(R.id.ramen_addlike);
        mSave = (TextView) findViewById(R.id.ramen_tvsave);
        mSale = (TextView) findViewById(R.id.ramen_tvsale);
        mTotal = (TextView) findViewById(R.id.ramen_tvtotal);
        mPrice = (TextView) findViewById(R.id.ramen_total_price);

        //set font
        mHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        mName.setTypeface(CustomFont.getInstance().getFontHead(this));
        mDataRamen.setTypeface(CustomFont.getInstance().getFontData(this));
        mHeadObject.setTypeface(CustomFont.getInstance().getFontHead(this));
        mNoteObject.setTypeface(CustomFont.getInstance().getFontData(this));

        //set font menu below
        mLike.setTypeface(CustomFont.getInstance().getFontData(this));
        mSale.setTypeface(CustomFont.getInstance().getFontData(this));
        mSave.setTypeface(CustomFont.getInstance().getFontData(this));
        mTotal.setTypeface(CustomFont.getInstance().getFontData(this));
        mPrice.setTypeface(CustomFont.getInstance().getFontData(this));

        Bundle bundle = getIntent().getExtras();
        mHead.setText(bundle.getString("NameRamen"));
        mName.setText(bundle.getString("NameRamen"));
//        mPrice.setText(bundle.getString("Price")+" ฿");


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


        like = false;
        mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(like){
                    mLike.setBackgroundResource(R.drawable.like_add);
                }else{
                    mLike.setBackgroundResource(R.drawable.like_add_pass);
                }
                like = !like;

            }
        });


        btSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RamenActivity.this,ShoppingCarActivity.class));

            }
        });

        mSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RamenActivity.this,ShoppingCarActivity.class));

            }
        });



        addObject();
    }


    private void addObject(){

        for (int i = 0; i < 6; i++) {


            if(i == 0){
                mObject_image.add(R.drawable.object1);
            }else if(i == 1){
                mObject_image.add(R.drawable.object2);
            }else if(i == 2){
                mObject_image.add(R.drawable.object3);
            }else if (i == 3){
                mObject_image.add(R.drawable.object4);
            }else if(i == 4){
                mObject_image.add(R.drawable.object5);
            }else if(i == 5){
                mObject_image.add(R.drawable.object6);
            }
        }

        setRecyclerViewOnObject();

    }


    private void setRecyclerViewOnObject(){

        Log.d("TEST ObjectGVA","am setting");

        RecyclerView gridView = findViewById(R.id.ramen_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        ObjectGridViewAdapter gridAdapter = new ObjectGridViewAdapter(this, mObject_image);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(gridAdapter);


    }


}
