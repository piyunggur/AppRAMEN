package com.example.user.ramen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.ramen.Custom.CustomFont;

public class PreOrderActivity extends AppCompatActivity {


    TextView Head;
    TextView Name;
    TextView At;
    TextView Headmenu;
    Button Menu1;
    Button Menu2;
    Button Menu3;
    Button Menu4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pre_order);


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


        Head = (TextView) findViewById(R.id.pre_order_head);
        Name = (TextView) findViewById(R.id.pre_order_name);
        At = (TextView) findViewById(R.id.pre_order_at);
        Headmenu = (TextView) findViewById(R.id.pre_order_headmenu);
        Menu1 = (Button) findViewById(R.id.pre_order_menu1);
        Menu2 = (Button) findViewById(R.id.pre_order_menu2);
        Menu3 = (Button) findViewById(R.id.pre_order_menu3);
        Menu4 = (Button) findViewById(R.id.pre_order_menu4);


        Head.setTypeface(CustomFont.getInstance().getFontHead(this));
        Name.setTypeface(CustomFont.getInstance().getFontData(this));
        At.setTypeface(CustomFont.getInstance().getFontData(this));
        Headmenu.setTypeface(CustomFont.getInstance().getFontHead(this));
        Menu1.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu2.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu3.setTypeface(CustomFont.getInstance().getFontData(this));
        Menu4.setTypeface(CustomFont.getInstance().getFontData(this));


    }

}
