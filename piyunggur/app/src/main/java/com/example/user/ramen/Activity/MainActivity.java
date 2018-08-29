package com.example.user.ramen.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.ramen.Adapter.MainSlideAdapter;
import com.example.user.ramen.R;

public class MainActivity extends AppCompatActivity {


    ViewPager page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);


        page = (ViewPager) findViewById(R.id.main_viewpage);
        MainSlideAdapter adapter = new MainSlideAdapter(getSupportFragmentManager(),this);
        page.setAdapter(adapter);


        BottomNavigationView bottomNav = findViewById(R.id.main_bottonnavigation);
        bottomNav.setOnNavigationItemSelectedListener(navigationList);


    }



    private BottomNavigationView.OnNavigationItemSelectedListener navigationList =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                    if(item.getItemId() == R.id.bottomnav_itemhome){
                        page.setCurrentItem(0);

                    }else if(item.getItemId() == R.id.bottomnav_itemshopping){
                        page.setCurrentItem(1);

                    }else if(item.getItemId() == R.id.bottomnav_itemuser) {
                        page.setCurrentItem(2);
                    }



                    return true;
                }
            };


}
