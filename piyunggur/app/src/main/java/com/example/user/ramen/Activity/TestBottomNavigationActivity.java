package com.example.user.ramen.Activity;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.ramen.Fragment.HomeFragment;
import com.example.user.ramen.R;
import com.example.user.ramen.Fragment.ShoppingFragment;
import com.example.user.ramen.Fragment.UserFragment;

public class TestBottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_testbottomnavigation);

        Fragment selectedFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.bottomnavigation_fragment,selectedFragment)
                .commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomnavigation_view);
        bottomNav.setOnNavigationItemSelectedListener(navigationList);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationList =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment =null;

                    if(item.getItemId() == R.id.bottomnav_itemhome){
                        selectedFragment = new HomeFragment();

                    }else if(item.getItemId() == R.id.bottomnav_itemshopping){
                        selectedFragment = new ShoppingFragment();

                    }else if(item.getItemId() == R.id.bottomnav_itemuser) {
                        selectedFragment = new UserFragment();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.bottomnavigation_fragment,selectedFragment)
                            .commit();

                    return true;
                }
            };

}
