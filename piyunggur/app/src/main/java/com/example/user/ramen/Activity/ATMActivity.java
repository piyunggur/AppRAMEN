package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

public class ATMActivity extends AppCompatActivity {


    TextView textHead;
    TextView textDataBank1;
    TextView textDataBank2;
    Button buttonUpload;
    TextView textImageName;
    Button buttonNextDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_atm);


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
        textView.setText("ชำระเงินผ่าน ATM");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });



        //set item
        textHead = (TextView) findViewById(R.id.atm_head);
        textDataBank1 = (TextView) findViewById(R.id.atm_data_bank1);
        textDataBank2 = (TextView) findViewById(R.id.atm_data_bank2);
        buttonUpload = (Button) findViewById(R.id.atm_upload);
        textImageName = (TextView) findViewById(R.id.atm_image_name);
        buttonNextDay = (Button) findViewById(R.id.atm_nextday);


        //set font
        textHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        textDataBank1.setTypeface(CustomFont.getInstance().getFontData(this));
        textDataBank2.setTypeface(CustomFont.getInstance().getFontData(this));
        buttonUpload.setTypeface(CustomFont.getInstance().getFontData(this));
        textImageName.setTypeface(CustomFont.getInstance().getFontData(this));
        buttonNextDay.setTypeface(CustomFont.getInstance().getFontData(this));


        textDataBank1.setText("ชื่อบัญชี ราเมงนะเนี้ย\n" +
                "ธนาคารไทยพาณิชย์\n" +
                "เลขที่บัญชี 000 0000 000");

        textDataBank2.setText("ชื่อบัญชี ราเมงนะเนี้ย\n" +
                "ธนาคารกรุงเทพ\n" +
                "เลขที่บัญชี 000 0000 000");




    }




}
