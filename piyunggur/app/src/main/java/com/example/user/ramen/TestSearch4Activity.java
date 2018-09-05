package com.example.user.ramen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

public class TestSearch4Activity extends Activity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener,
Button.OnClickListener{


    private SearchView mSearchView;
    private TextView mStatusView;
    private Button mOpenButton;
    private Button mCloseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_test_search4);


        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.layout_test_search4);
        mStatusView = (TextView) findViewById(R.id.test_status_text);


        mOpenButton = (Button) findViewById(R.id.test_open_button);
        mCloseButton = (Button) findViewById(R.id.test_close_button);
        mOpenButton.setOnClickListener((View.OnClickListener) this);
        mCloseButton.setOnClickListener((View.OnClickListener) this);


    }


    @SuppressLint("NewApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.test_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchItem.getActionView();
        setupSearchView(searchItem);
        return true;
    }


    @SuppressLint({"NewApi","NewApi"})
    private void setupSearchView(MenuItem searchItem){
        if(isAlwaysExpanded()){
            mSearchView.setIconifiedByDefault(false);
        }else{
            searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM
            | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        }
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        if(searchManager != null){
            List<SearchableInfo> searchables = searchManager.getSearchablesInGlobalSearch();
            SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
            for(SearchableInfo inf : searchables){
                if(inf.getSuggestAuthority() != null && inf.getSuggestAuthority().startsWith("applications")){
                    info = inf;
                }
            }
            mSearchView.setSearchableInfo(info);
        }
        mSearchView.setOnQueryTextListener(this);
    }


    @SuppressLint("NewApi")
    @Override
    public void onClick(View arg0) {
        if(arg0 == mCloseButton){
            mSearchView.setIconified(true);
        }else if(arg0 == mOpenButton){
            mSearchView.setIconified(false);
        }
    }


    @Override
    public boolean onClose() {
        mStatusView.setText("Closed!");
        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        mStatusView.setText("Query = " + query + "submitted");
        return false;
    }


    @Override
    public boolean onQueryTextChange(String arg0) {
        mStatusView.setText("Query = " + arg0);
        return false;
    }


    protected boolean isAlwaysExpanded(){
        return false;
    }



}
