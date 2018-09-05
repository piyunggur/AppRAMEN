package com.example.user.ramen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import android.databinding.DataBindingUtil;
//import com.journaldev.searchview.databinding.ActivityMainBinding;

public class TestSearch3Activity extends AppCompatActivity {


//    ActivityMainBinding activityMainBinding;
    TestSearch3ListAdapter adapter;


    List<String> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_test_search3);
//        activityMainBinding = DataBindingUtil.setContenView(this,R.layout.layout_test_search3);


        for (int i = 1; i <= 20; i++) {

            arrayList.add("day"+1);

        }

        adapter = new TestSearch3ListAdapter(arrayList);
//        activityMainBinding.listView.setAdapter(adapter);
//
//
//        activityMainBinding.search.setActivated(true);
//        activityMainBinding.search.QueryHint("Type your keyword here");
//        activityMainBinding.search.onActionViewExpanded();
//        activityMainBinding.search.setIconified(false);
//        activityMainBinding.search.clearFocus();
//
//        activityMainBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//
//
//            @Override
//           public boolean onQueryTextSubmit(String query){
//               return false;
//           }
//
//           @Override
//            public boolean onQueryTextChange(String newText){
//               adapter.getFilter().filter(newText);
//               return  false;
//           }
//
//
//        });



    }
}
