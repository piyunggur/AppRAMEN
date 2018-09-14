package com.example.user.ramen.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.ramen.Fragment.Menu1Fragment;
import com.example.user.ramen.Fragment.Menu2Fragment;
import com.example.user.ramen.Fragment.Menu3Fragment;
import com.example.user.ramen.Fragment.Menu4Fragment;
import com.example.user.ramen.Fragment.Menu5Fragment;
import com.example.user.ramen.R;

public class MenuSaleActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_sale);


        //set actionbar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setCustomView(R.layout.custom_action_bar_layout);
//
//        View view = actionBar.getCustomView();
//        TextView textView = (TextView)view.findViewById(R.id.custom_bar_text);
//        ImageButton imageButton = (ImageButton)view.findViewById(R.id.custom_bar_back);
//        ImageButton imageButton2 = (ImageButton)view.findViewById(R.id.custom_bar_safe);
//
//        textView.setTypeface(CustomFont.getInstance().getFontHead(this));
//        textView.setText("เมนูราเมน");
//        imageButton2.setBackgroundResource(R.color.colorNull);
//
//        imageButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                finish();
//            }
//        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("เมนูราเมน");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_sale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

//    deleted PlaceholderFragment class form here

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    Menu1Fragment menu1 = new Menu1Fragment();
                    return menu1;
                case 1:
                    Menu2Fragment menu2 = new Menu2Fragment();
                    return menu2;
                case 2:
                    Menu3Fragment menu3 = new Menu3Fragment();
                    return menu3;
                case 3:
                    Menu4Fragment menu4 = new Menu4Fragment();
                    return menu4;
                case 4:
                    Menu5Fragment menu5 = new Menu5Fragment();
                    return menu5;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "โชยุราเมง";
                case 1:
                    return "มิโสะเมง";
                case 2:
                    return "ชิโอะเมง";
                case 3:
                    return "ทงคตสึเมง";
                case 4:
                    return "สึเคเมง";
            }


            return null;
        }
    }
}
