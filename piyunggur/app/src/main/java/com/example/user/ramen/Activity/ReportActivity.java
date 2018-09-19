package com.example.user.ramen.Activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.user.ramen.R.layout.item_spinner_report;

public class ReportActivity extends AppCompatActivity {


    Spinner Toppic;
    TextView SetTextSpinner;
    EditText Text;
    Button Submit;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_report);


        //set actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar_layout);

        View view = actionBar.getCustomView();
        TextView textView = (TextView)view.findViewById(R.id.custom_bar_text);
        ImageButton imageButton = (ImageButton)view.findViewById(R.id.custom_bar_back);
        ImageButton imageButton2 = (ImageButton)view.findViewById(R.id.custom_bar_safe);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        textView.setTypeface(CustomFont.getInstance().getFontHead(this));
        textView.setText("ติดต่อ RAMEN");
        imageButton2.setBackgroundResource(R.color.colorNull);


        Submit = (Button) findViewById(R.id.report_submit);
        Text = (EditText) findViewById(R.id.report_text);

        Submit.setTypeface(CustomFont.getInstance().getFontData(this));
        Text.setTypeface(CustomFont.getInstance().getFontData(this));

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        SPINNER2();



    }

    public <ViewGroup> void SPINNER2(){

        List<String> list = new ArrayList<>();
        list.add("ระบบมีข้อผิดพลาด");
        list.add("การจัดส่งล่าช้่า");
        list.add("ข้อแนะนำ");

        Spinner Toppic = (Spinner) findViewById(R.id.report_toppic);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,R.layout.item_spinner_report,list){
            public View getView(int position, View convertView, android.view.ViewGroup parent){
                TextView textView = (TextView) super.getView(position, convertView, parent);
                Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Kanit-Light.ttf");
                textView.setTypeface(typeface);
                return textView;
            }

            public  View getDropDownView(int position, View convertView,
                                          android.view.ViewGroup parent){
                TextView textView = (TextView) super.getView(position, convertView, parent);
                Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Kanit-Light.ttf");
                textView.setTypeface(typeface);
                return textView;
            }
        };

        adapter.setDropDownViewResource(R.layout.item_spinner_report_pass);
        Toppic.setAdapter(adapter);

    }



}
