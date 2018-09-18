package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Adapter.RamenGridViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class LikeActivity extends AppCompatActivity {


    //set ramen slide
    private ArrayList<Integer> ramen_Image = new ArrayList<>();
    private ArrayList<String> ramen_Name = new ArrayList<>();
    private ArrayList<Integer> ramen_Price = new ArrayList<>();

    //data ramen
    private ArrayList<Integer> ramen_bgKcal = new ArrayList<>();
    private ArrayList<Float> ramen_Kcal = new ArrayList<>();
    private ArrayList<Integer> ramen_bgSale = new ArrayList<>();
    private ArrayList<Integer> ramen_Sale = new ArrayList<>();

    //data heart
    private ArrayList<Integer> ramen_heart1 = new ArrayList<>();
    private ArrayList<Integer> ramen_heart2 = new ArrayList<>();
    private ArrayList<Integer> ramen_heart3 = new ArrayList<>();
    private ArrayList<Integer> ramen_heart4 = new ArrayList<>();
    private ArrayList<Integer> ramen_heart5 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_like);


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
        textView.setText("สิ่งที่คุณถูกใจ");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        addLike();

    }



    private void addLike(){

        int count_heart = 4;

        for (int i = 1; i <= 10; i++) {


            if(i == 1){
                ramen_Image.add(R.drawable.ramens1);
            }else if(i == 2){
                ramen_Image.add(R.drawable.ramens2);
            }else if(i == 3){
                ramen_Image.add(R.drawable.ramens3);
            }else if(i == 4){
                ramen_Image.add(R.drawable.ramens4);
            }else if(i == 5){
                ramen_Image.add(R.drawable.ramens5);
            }else if(i == 6){
                ramen_Image.add(R.drawable.ramens6);
            }else if(i == 7){
                ramen_Image.add(R.drawable.ramens1);
            }else if(i == 8){
                ramen_Image.add(R.drawable.ramens2);
            }else if(i == 9){
                ramen_Image.add(R.drawable.ramens3);
            }else if(i == 10){
                ramen_Image.add(R.drawable.ramens4);
            }

            ramen_Name.add("ราเมง"+i);
            ramen_Price.add(155);
            ramen_bgKcal.add(R.color.colorKcal);
            ramen_Kcal.add(436.2f);
            ramen_bgSale.add(R.color.colorSale);
            ramen_Sale.add(10);

            if(count_heart == 0){
                ramen_heart1.add(R.drawable.like_off);
                ramen_heart2.add(R.drawable.like_off);
                ramen_heart3.add(R.drawable.like_off);
                ramen_heart4.add(R.drawable.like_off);
                ramen_heart5.add(R.drawable.like_off);
            }else if(count_heart == 1){
                ramen_heart1.add(R.drawable.like_on);
                ramen_heart2.add(R.drawable.like_off);
                ramen_heart3.add(R.drawable.like_off);
                ramen_heart4.add(R.drawable.like_off);
                ramen_heart5.add(R.drawable.like_off);
            }else if(count_heart == 2){
                ramen_heart1.add(R.drawable.like_on);
                ramen_heart2.add(R.drawable.like_on);
                ramen_heart3.add(R.drawable.like_off);
                ramen_heart4.add(R.drawable.like_off);
                ramen_heart5.add(R.drawable.like_off);
            }else if(count_heart == 3){
                ramen_heart1.add(R.drawable.like_on);
                ramen_heart2.add(R.drawable.like_on);
                ramen_heart3.add(R.drawable.like_on);
                ramen_heart4.add(R.drawable.like_off);
                ramen_heart5.add(R.drawable.like_off);
            }else if(count_heart == 4){
                ramen_heart1.add(R.drawable.like_on);
                ramen_heart2.add(R.drawable.like_on);
                ramen_heart3.add(R.drawable.like_on);
                ramen_heart4.add(R.drawable.like_on);
                ramen_heart5.add(R.drawable.like_off);
            }else if(count_heart == 5){
                ramen_heart1.add(R.drawable.like_on);
                ramen_heart2.add(R.drawable.like_on);
                ramen_heart3.add(R.drawable.like_on);
                ramen_heart4.add(R.drawable.like_on);
                ramen_heart5.add(R.drawable.like_on);
            }

        }


        setRecyclerViewOnLike();

    }



    private void setRecyclerViewOnLike(){


        RecyclerView gridView = findViewById(R.id.like_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        RamenGridViewAdapter gridViewAdapter = new RamenGridViewAdapter(this, ramen_Image, ramen_Name,
                ramen_Price, ramen_bgKcal, ramen_Kcal, ramen_bgSale, ramen_Sale
                ,ramen_heart1,ramen_heart2,ramen_heart3,ramen_heart4,ramen_heart5);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(gridViewAdapter);

    }


}
