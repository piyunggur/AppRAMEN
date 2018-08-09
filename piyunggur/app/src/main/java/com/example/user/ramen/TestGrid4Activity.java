package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class TestGrid4Activity extends AppCompatActivity {

    RecyclerView recyclerviewTestGrid4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testgrid4_layout);

        recyclerviewTestGrid4 = (RecyclerView) findViewById(R.id.testgrid4_view);


    }
}
