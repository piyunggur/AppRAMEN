package com.example.user.ramen;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.user.ramen.R.color.MainColor;

public class activity_login extends AppCompatActivity {

    private TextView tHead;
    private EditText eUser;
    private EditText ePassword;
    private Button bSubmit;
    private Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tHead = (TextView) findViewById(R.id.login_text_head);
        eUser = (EditText) findViewById(R.id.login_add_user);
        ePassword = (EditText) findViewById(R.id.login_add_password);
        bSubmit = (Button) findViewById(R.id.login_button_submit);
        bRegister = (Button) findViewById(R.id.login_button_register);

        Typeface font_head = Typeface.createFromAsset(getAssets(),"fonts/Kanit-SemiBold.ttf");
        Typeface font_data = Typeface.createFromAsset(getAssets(),"fonts/Kanit-Light.ttf");
        tHead.setTypeface(font_head);
        eUser.setTypeface(font_data);
        ePassword.setTypeface(font_data);
        bSubmit.setTypeface(font_data);
        bRegister.setTypeface(font_data);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                bSubmit.setTextColor(MainColor);
            }
        });


    }
}
