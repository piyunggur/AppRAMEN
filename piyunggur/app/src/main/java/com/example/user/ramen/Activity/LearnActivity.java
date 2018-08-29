package com.example.user.ramen.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.Adapter.LearnAdapter;
import com.example.user.ramen.R;

public class LearnActivity extends AppCompatActivity {


    private ViewPager viewpagerSlide;
    private LinearLayout layoutDot;
    private TextView[] arr_dot;
    private LearnAdapter sliderAdapter;
    private Button buttonNext;
    private Button buttonBack;
    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_learn);


        viewpagerSlide = (ViewPager) findViewById(R.id.learnslider_view);
        layoutDot = (LinearLayout) findViewById(R.id.learn_dots);

        buttonNext = (Button) findViewById(R.id.learn_next);
        buttonBack = (Button) findViewById(R.id.learn_back);

        buttonNext.setTypeface(CustomFont.getInstance().getFontData(this));
        buttonBack.setTypeface(CustomFont.getInstance().getFontData(this));


        sliderAdapter = new LearnAdapter(this);
        viewpagerSlide.setAdapter(sliderAdapter);


        //make dots slide
        addDotsIndicator(0);


        //add function chang slide
        viewpagerSlide.addOnPageChangeListener(viewListener);


        //OnclickListeners
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Button set_bt_next = (Button)view;
                String text_bt_next = set_bt_next.getText().toString();

                if(text_bt_next.equalsIgnoreCase("ดำเนินการต่อ")){
                    startActivity(new Intent(LearnActivity.this,LoginActivity.class));
                    finish();
                }

                viewpagerSlide.setCurrentItem(mCurrentPage + 1);
            }
        });


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpagerSlide.setCurrentItem(mCurrentPage - 1);
            }
        });
    }


    public void  addDotsIndicator(int position){

        arr_dot = new TextView[3];


        for (int i = 0; i < arr_dot.length; i++) {
            arr_dot[i] = new TextView(this);
            arr_dot[i].setText(Html.fromHtml("&#8226;"));
            arr_dot[i].setTextSize(45);
            arr_dot[i].setTextColor(getResources().getColor((R.color.colorBackText)));
            layoutDot.addView(arr_dot[i]);
        }


        if(arr_dot.length > 0){
            arr_dot[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }



    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int i, float v, int i1) { }


        @Override
        public void onPageSelected(int page) {

            for(int i = 0; i < arr_dot.length ; i++) {
                if (i==page)
                    arr_dot[i].setTextColor(getResources().getColor(R.color.colorWhite));
                else
                    arr_dot[i].setTextColor(getResources().getColor(R.color.colorBackText));
            }


            mCurrentPage = page;

            if(page == 0){
                buttonBack.setEnabled(false);
                buttonNext.setEnabled(true);
                buttonBack.setVisibility(View.INVISIBLE);
                buttonNext.setText("ต่อไป");

            }else if (page == arr_dot.length-1) {
                buttonBack.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setText("ย้อนกลับ");
                buttonNext.setText("ดำเนินการต่อ");

            }else {
                buttonBack.setEnabled(true);
                buttonBack.setVisibility(View.VISIBLE);
                buttonNext.setEnabled(true);
                buttonBack.setText("ย้อนกลับ");
                buttonNext.setText("ต่อไป");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {}

    };


}
