package com.example.user.ramen.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.FriendListActivity;
import com.example.user.ramen.R;
import com.example.user.ramen.SearchActivity;

public class RegisterActivity extends AppCompatActivity {


    private Button mBack;
    private TextView mHead;
    private EditText mUser;
    private EditText mPass1;
    private EditText mPass2;
    private Button mSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);


        //set in actionbar
        setTitle("สมัครสมาชิก");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);




        mBack = (Button) findViewById(R.id.register_btback);
        mHead = (TextView) findViewById(R.id.register_tvhead);
        mUser = (EditText) findViewById(R.id.register_etuser);
        mPass1 = (EditText) findViewById(R.id.register_etpass1);
        mPass2 = (EditText) findViewById(R.id.register_etpass2);
        mSubmit = (Button) findViewById(R.id.register_btsummit);


        mHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        mUser.setTypeface(CustomFont.getInstance().getFontData(this));
        mPass1.setTypeface(CustomFont.getInstance().getFontData(this));
        mPass2.setTypeface(CustomFont.getInstance().getFontData(this));
        mSubmit.setTypeface(CustomFont.getInstance().getFontData(this));


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,SearchActivity.class));
//                startActivity(new Intent(RegisterActivity.this,FriendListActivity.class));
//                finish();
            }
        });



    }
}
