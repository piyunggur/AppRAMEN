package com.example.user.ramen.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

public class LoginActivity extends AppCompatActivity {


    private TextView mHead;
    private EditText mUser;
    private EditText mPassword;
    private Button mSubmit;
    private Button mRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);


        mHead = (TextView) findViewById(R.id.login_head);
        mUser = (EditText) findViewById(R.id.login_user);
        mPassword = (EditText) findViewById(R.id.login_password);
        mSubmit = (Button) findViewById(R.id.login_submit);
        mRegister = (Button) findViewById(R.id.login_register);


        mHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        mUser.setTypeface(CustomFont.getInstance().getFontData(this));
        mPassword.setTypeface(CustomFont.getInstance().getFontData(this));
        mSubmit.setTypeface(CustomFont.getInstance().getFontData(this));
        mRegister.setTypeface(CustomFont.getInstance().getFontData(this));


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }
}
