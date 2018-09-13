package com.example.user.ramen.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.ramen.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {


    ListView search_food;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);


        search_food = (ListView) findViewById(R.id.search_food);


        ArrayList<String> arrayFood = new ArrayList<>();
        arrayFood.addAll(Arrays.asList(getResources().getStringArray(R.array.my_foods)));


        adapter = new ArrayAdapter<String>(
                SearchActivity.this,
                android.R.layout.simple_list_item_1,
                arrayFood
        );


        search_food.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


//        old code
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu2,menu);
//        MenuItem item = menu.findItem(R.id.search_food);
//        SearchView searchView = (SearchView)item.getActionView();


//        new code by web : stack overflow : Why setOnQueryTextListener()get"on a null object reference error"
        getMenuInflater().inflate(R.menu.search_menu2,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        Log.d("Test" , ""+searchManager);
        Log.d("Value",""+searchManager.getSearchableInfo(getCallingActivity()));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getCallingActivity()));
        searchView.setQueryHint(getResources().getString(R.string.app_name));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("test1", "test click");
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
