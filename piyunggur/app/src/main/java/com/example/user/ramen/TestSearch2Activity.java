package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestSearch2Activity extends AppCompatActivity {


//    ActivityMainBinding activityMainBinding;
    ListAdapter adapter;

    List<String> arrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_search2);
//        activityMainBinding = DataBindingUtil.setContentView(this,
//                R.layout.layout_test_search2);

        arrayList.add("item1");
        arrayList.add("item2");
        arrayList.add("item3");
        arrayList.add("item4");
        arrayList.add("item5");
        arrayList.add("item6");
        arrayList.add("item7");
        arrayList.add("item8");
        arrayList.add("item9");
        arrayList.add("item10");
        arrayList.add("item11");
        arrayList.add("item12");
        arrayList.add("item13");
        arrayList.add("item14");
        arrayList.add("item15");
        arrayList.add("item16");
        arrayList.add("item17");



    }
}
