package com.example.user.ramen.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.ramen.Adapter.ObjectGridViewAdapter;
import com.example.user.ramen.Adapter.RamenGridViewAdapter;
import com.example.user.ramen.Custom.CustomFont;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class RamenActivity extends AppCompatActivity {


    TextView mHead;
    TextView mName;
    TextView mDataRamen;
    TextView mHeadObject;
    TextView mNoteObject;

    private ArrayList<Integer> mObject = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ramen);


        mHead = (TextView) findViewById(R.id.ramen_tvhead);
        mName = (TextView) findViewById(R.id.ramen_tvname);
        mDataRamen = (TextView) findViewById(R.id.ramen_data_ramen);
        mHeadObject = (TextView) findViewById(R.id.ramen_tvobject);
        mNoteObject = (TextView) findViewById(R.id.ramen_tvnote);


        mHead.setTypeface(CustomFont.getInstance().getFontHead(this));
        mName.setTypeface(CustomFont.getInstance().getFontHead(this));
        mDataRamen.setTypeface(CustomFont.getInstance().getFontData(this));
        mHeadObject.setTypeface(CustomFont.getInstance().getFontHead(this));
        mNoteObject.setTypeface(CustomFont.getInstance().getFontData(this));


        Bundle bundle = getIntent().getExtras();
        mHead.setText(bundle.getString("NameRamen"));
        mName.setText(bundle.getString("NameRamen"));

        addObject();
    }


    private void addObject(){

        for (int i = 0; i < 5; i++) {


            if(i == 0){
                mObject.add(R.drawable.object1);
            }else if(i == 1){
                mObject.add(R.drawable.object2);
            }else if(i == 2){
                mObject.add(R.drawable.object3);
            }else if(i == 3){
                mObject.add(R.drawable.object4);
            }else if(i == 4){
                mObject.add(R.drawable.object5);
            }else if(i == 5){
                mObject.add(R.drawable.object6);
            }
        }

        setRecyclerViewOnObject();

    }


    private void setRecyclerViewOnObject(){


        RecyclerView gridView = findViewById(R.id.ramen_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        ObjectGridViewAdapter testGrid3Adapter = new ObjectGridViewAdapter(this, mObject);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(testGrid3Adapter);

    }


}
