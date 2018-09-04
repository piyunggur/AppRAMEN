package com.example.user.ramen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSearchActivity extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_search);


        listView = (ListView) findViewById(R.id.test_listview);

        ArrayList<String> arrayfood = new ArrayList<>();
        //use file strings.xml
        arrayfood.addAll(Arrays.asList(getResources().getStringArray(R.array.my_foods)));

        adapter = new ArrayAdapter<String>(
          TestSearchActivity.this,
          android.R.layout.simple_list_item_1,
                arrayfood
        );

        listView.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.test_search, menu);
        MenuItem item = menu.findItem(R.id.test_listview);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}
