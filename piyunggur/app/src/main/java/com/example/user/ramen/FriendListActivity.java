package com.example.user.ramen;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


public class FriendListActivity extends Activity implements SearchView.OnQueryTextListener{

    private SenzorApplication application; // What? Function in class OR File java class ??
    private ListView friendListView;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    private FriendListAdapter friendListAdapter;
    private ArrayList<User> friendList; // file java class ??


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list_layout);
        application = (SenzorApplication) this.getApplication();


        setActionBar();
        initFriendList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.test_search_menu);
        searchView = (SearchView) searchMenuItem.getActionView();


        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                FriendListActivity.this.finish();
                FriendListActivity.this.overridePendingTransition(R.anim.stay_in, R.anim.bottom_out);//R.anim??
                ActivityUtils.hideSoftKeyboard(this);// file android class


                return true;
        }


        return super.onOptionsItemSelected(item);

    }


    private void setActionBar(){
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Friends");


        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/vegur_2.otf");
        int titleId = getResources().getIdentifier("action_bar_title","id","android");
        TextView actionBarTitle = (TextView) (this.findViewById(titleId));
        actionBarTitle.setTextColor(getResources().getColor(R.color.colorWhite));
        actionBarTitle.setTypeface(typeface);
    }


    private void initFriendList(){
        friendList = application.getContactList();
        friendListView (ListView) findViewById(R.id.friend_list);
        friendListAdapter = new FriendListAdapter(this, friendList);


        View headerView = View.inflate(this, R.layout.list_header, null);
        View footerView = View.inflate(this,R.layout.list_header,null);
        friendListView.addHeaderView(headerView);
        friendListView.addFooterView(footerView);
        friendListView.setAdapter(friendListAdapter);
        friendListView.setTextFilterEnabled(false);


        // use to enable search view popup text
        // friendListView.setTextFilterEnabled(true);


        //set up click listener
        friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position > 0 && position <= friendList.size()){
                    handelListItemClick(User)friendListAdapter.getItem(position - 1);
                }
            }
        });

    }


    private void handelListItemClick(User user){


        //close search view if its visible
        if (searchView.isShown()){
            searchMenuItem.collapseActionView();
            searchView.setQuery("",false);
        }

        // pass selected use and sensor to share activity
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra("com.score.senzors.pojos.User", user);
        intent.putExtra("com.score.senzors.pojos.Sensor", application.getCurrentSensor());
        this.startActivity(intent);
        this.overridePendingTransition(R.anim.right_in, R.anim.stay_in);

    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.overridePendingTransition(R.anim.stay_in, R.anim.bottom_out);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        friendListAdapter.getFilter().filter(newText);


        // use to enable search view popup text
//        if (TextUtils.isEmpty(newText)) {
//            friendListView.clearTextFilter();
//        }
//        else {
//            friendListView.setFilterText(newText.toString());
//        }

        return true;
    }
}
