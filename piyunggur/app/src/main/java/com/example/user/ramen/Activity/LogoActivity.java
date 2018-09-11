package com.example.user.ramen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
//import android.support.v7.app.ActionBar;

import com.example.user.ramen.R;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logo);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        new CountDownTimer(1500,1) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                startActivity(new Intent(LogoActivity.this,LearnActivity.class));
                finish();
            }
        }.start();

    }
}
