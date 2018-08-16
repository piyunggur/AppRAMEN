package com.example.user.ramen;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class NewHomeActivity extends AppCompatActivity {

    ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhome_layout);

        page = (ViewPager) findViewById(R.id.newhome_viewpage);
        NewHomeSlideAdapter adapter = new NewHomeSlideAdapter(getSupportFragmentManager());
        page.setAdapter(adapter);

        BottomNavigationView bottomNav = findViewById(R.id.newhome_bottonnavigation);
        bottomNav.setOnNavigationItemSelectedListener(navigationList);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationList =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment =null;

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
