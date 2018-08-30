package com.example.user.ramen.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.ramen.Adapter.RamenGridViewAdapter;
import com.example.user.ramen.Custom.Ramen;
import com.example.user.ramen.R;

import java.util.ArrayList;

public class Manu1Activity extends AppCompatActivity {

    //set allmanu slide
    private ArrayList<Integer> arraylistImage_testgrid3 = new ArrayList<>();
    private ArrayList<String> arraylistName_testgrid3 = new ArrayList<>();
    private ArrayList<Integer> arraylistPrice_testgrid3 = new ArrayList<>();

    private ArrayList<Integer> arrayListbgKcal = new ArrayList<>();
    private ArrayList<Float> arrayListKcal = new ArrayList<>();
    private ArrayList<Integer> arrayListbgSale = new ArrayList<>();
    private ArrayList<Integer> arrayListSale = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu1);

        addTestGrid3();
    }

    private void addTestGrid3(){

        for (int i = 0; i < 10; i++) {

            arraylistImage_testgrid3.add(R.drawable.ramens1);
            arraylistName_testgrid3.add("ราเมง"+i);
            arraylistPrice_testgrid3.add(75);
            arrayListbgKcal.add(R.color.colorKcal);
            arrayListKcal.add(436.2f);
            arrayListbgSale.add(R.color.colorSale);
            arrayListSale.add(5);
        }

        setTestGrid3();
    }

    private void setTestGrid3(){

        RecyclerView gridView = findViewById(R.id.nanu1allmanu_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        RamenGridViewAdapter testGrid3Adapter = new RamenGridViewAdapter(this,arraylistImage_testgrid3,arraylistName_testgrid3,
                arraylistPrice_testgrid3, arrayListbgKcal, arrayListKcal, arrayListbgSale, arrayListSale);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(testGrid3Adapter);


    }
}
