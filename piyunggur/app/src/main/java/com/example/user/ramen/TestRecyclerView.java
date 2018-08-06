package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class TestRecyclerView extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recyclerview_layout);
        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
    }

    private  void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageResources.add(R.drawable.ramen1);
        mNames.add("1");

        mImageResources.add(R.drawable.ramen2);
        mNames.add("2");

        mImageResources.add(R.drawable.ramen3);
        mNames.add("3");

        mImageResources.add(R.drawable.ramen4);
        mNames.add("4");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerivew.");
        RecyclerView recyclerView = findViewById(R.id.test_recyclerview);
        TestRecyclerViewAdapter adapter = new TestRecyclerViewAdapter(this,mNames,mImageResources);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}
