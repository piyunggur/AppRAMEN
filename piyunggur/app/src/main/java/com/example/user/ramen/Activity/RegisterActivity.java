package com.example.user.ramen.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;
import com.example.user.ramen.TestBackgroundSerriceActivity;
import com.example.user.ramen.TestForegroundServiceActivity;
import com.example.user.ramen.TestNoticifationActivity;

public class RegisterActivity extends AppCompatActivity {


    private EditText mUser;
    private EditText mPass1;
    private EditText mPass2;
    private Button mSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);


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
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });



        mUser = (EditText) findViewById(R.id.register_etuser);
        mPass1 = (EditText) findViewById(R.id.register_etpass1);
        mPass2 = (EditText) findViewById(R.id.register_etpass2);
        mSubmit = (Button) findViewById(R.id.register_btsummit);


        mUser.setTypeface(CustomFont.getInstance().getFontData(this));
        mPass1.setTypeface(CustomFont.getInstance().getFontData(this));
        mPass2.setTypeface(CustomFont.getInstance().getFontData(this));
        mSubmit.setTypeface(CustomFont.getInstance().getFontData(this));


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, TestForegroundServiceActivity.class));
//                startActivity(new Intent(RegisterActivity.this, TestBackgroundSerriceActivity.class));
//                startActivity(new Intent(RegisterActivity.this, TestNoticifationActivity.class));
//                startActivity(new Intent(RegisterActivity.this, ATMActivity.class));
//                startActivity(new Intent(RegisterActivity.this,SearchActivity.class));
//                startActivity(new Intent(RegisterActivity.this,FriendListActivity.class));
//                finish();
            }
        });



    }
}
