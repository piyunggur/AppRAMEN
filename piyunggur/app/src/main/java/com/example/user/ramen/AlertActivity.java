package com.example.user.ramen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;

import java.util.ArrayList;

public class AlertActivity extends AppCompatActivity {


    //set object in order
    private ArrayList<Integer> ImageNews = new ArrayList<>();
    private ArrayList<String> DataNews = new ArrayList<>();
    private ArrayList<Integer> Line = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_alert);


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
        textView.setText("การแจ้งเตือน");
        imageButton2.setBackgroundResource(R.color.colorNull);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


    }
}
