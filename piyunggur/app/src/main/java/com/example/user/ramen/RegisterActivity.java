package com.example.user.ramen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private Button bBack;
    private TextView tHead;
    private EditText eUser;
    private EditText ePass1;
    private EditText ePass2;
    private Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiter_layout);

        bBack = (Button) findViewById(R.id.register_bt_back);
        tHead = (TextView) findViewById(R.id.register_tv_head);
        eUser = (EditText) findViewById(R.id.register_et_user);
        ePass1 = (EditText) findViewById(R.id.register_et_pass1);
        ePass2 = (EditText) findViewById(R.id.register_et_pass2);
        bSubmit = (Button) findViewById(R.id.register_bt_summit);

        tHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        eUser.setTypeface(CustomFont.getInstance().getFontData(this));
        ePass1.setTypeface(CustomFont.getInstance().getFontData(this));
        ePass2.setTypeface(CustomFont.getInstance().getFontData(this));
        bSubmit.setTypeface(CustomFont.getInstance().getFontData(this));

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });



    }
}
