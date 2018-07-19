package com.example.user.ramen;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_login extends AppCompatActivity {

    private TextView tHead;
    private EditText eUser;
    private EditText ePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tHead = (TextView) findViewById(R.id.login_text_head);
        eUser = (EditText) findViewById(R.id.login_add_user);
        ePassword = (EditText) findViewById(R.id.login_add_password);

        Typeface font_head = Typeface.createFromAsset(getAssets(),"fonts/Kanit-SemiBold.ttf");
        Typeface font_data = Typeface.createFromAsset(getAssets(),"fonts/Kanit-Light.ttf");
        tHead.setTypeface(font_head);
        eUser.setTypeface(font_data);
        ePassword.setTypeface(font_data);

    }
}
