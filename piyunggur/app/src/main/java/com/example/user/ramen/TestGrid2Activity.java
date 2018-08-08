package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class TestGrid2Activity extends AppCompatActivity {

    ArrayList<Ramen> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testgrid2_layout);

        arr = new ArrayList<>();

        Ramen ramen1 = new Ramen();
        ramen1.setImage(R.drawable.ramens1);
        ramen1.setName("ramens1");
        ramen1.setPrice(290);

        Ramen ramen2 = new Ramen("ramens2",290,R.drawable.ramens2);

        arr.add(ramen1);
        arr.add(ramen2);

        GridView gridView = (GridView)findViewById(R.id.testgridview2);
        TestGrid2Adapter testgrid2Adapter = new TestGrid2Adapter(this, arr);
        gridView.setAdapter(testgrid2Adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
//                arr = arrs[position];
//                arr.toggleFavorite();
//
//                TestGrid2Adapter.notifyDataSetChanged();
            }
        });
    }
}
