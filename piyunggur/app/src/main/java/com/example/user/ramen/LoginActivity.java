package com.example.user.ramen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView tHead;
    private EditText eUser;
    private EditText ePassword;
    private Button bSubmit;
    private Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        tHead = (TextView) findViewById(R.id.login_head);
        eUser = (EditText) findViewById(R.id.login_user);
        ePassword = (EditText) findViewById(R.id.login_password);
        bSubmit = (Button) findViewById(R.id.login_submit);
        bRegister = (Button) findViewById(R.id.login_register);

        tHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        eUser.setTypeface(CustomFont.getInstance().getFontData(this));
        ePassword.setTypeface(CustomFont.getInstance().getFontData(this));
        bSubmit.setTypeface(CustomFont.getInstance().getFontData(this));
        bRegister.setTypeface(CustomFont.getInstance().getFontData(this));

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }
}
