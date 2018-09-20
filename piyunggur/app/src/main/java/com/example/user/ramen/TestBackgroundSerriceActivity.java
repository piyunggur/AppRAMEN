package com.example.user.ramen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestBackgroundSerriceActivity extends AppCompatActivity implements View.OnClickListener {


    //button objects
    private Button buttonStart;
    private Button buttonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_background_serrice);


        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);


        //attaching onclicklistener to buttons
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

    }


    @Override
    public void onClick(View view){
        if(view == buttonStart){
            //start the service here
            startService(new Intent(this, TestMyService.class));
        }else if(view == buttonStop){
            //stop the service here
            stopService(new Intent(this, TestMyService.class));
        }

    }


}
