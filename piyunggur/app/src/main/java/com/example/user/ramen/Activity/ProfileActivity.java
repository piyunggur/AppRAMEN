package com.example.user.ramen.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

public class ProfileActivity extends AppCompatActivity {


    TextView hUser;
    EditText eUser;
    TextView hEmail;
    EditText eEmail;
    TextView hPhone;
    EditText ePhone;
    TextView hGender;
    EditText eGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);


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
        textView.setText("ข้อมูลส่วนตัว");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        hUser = (TextView) findViewById(R.id.profile_h_user);
        eUser = (EditText) findViewById(R.id.profile_e_user);
        hEmail = (TextView) findViewById(R.id.profile_h_email);
        eEmail = (EditText) findViewById(R.id.profile_e_email);
        hPhone = (TextView) findViewById(R.id.profile_h_phone);
        ePhone = (EditText) findViewById(R.id.profile_e_phone);
        hGender= (TextView) findViewById(R.id.profile_h_gender);
        eGender = (EditText) findViewById(R.id.profile_e_gender);


        hUser.setTypeface(CustomFont.getInstance().getFontHead(this));
        eUser.setTypeface(CustomFont.getInstance().getFontData(this));
        hEmail.setTypeface(CustomFont.getInstance().getFontHead(this));
        eEmail.setTypeface(CustomFont.getInstance().getFontData(this));
        hPhone.setTypeface(CustomFont.getInstance().getFontHead(this));
        ePhone.setTypeface(CustomFont.getInstance().getFontData(this));
        hGender.setTypeface(CustomFont.getInstance().getFontHead(this));
        eGender.setTypeface(CustomFont.getInstance().getFontData(this));


    }



}
