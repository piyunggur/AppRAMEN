package com.example.user.ramen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewHomeActivity extends AppCompatActivity {

    ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhome_layout);

        page = (ViewPager) findViewById(R.id.newhome_viewpage);
        NewHomeSlideAdapter adapter = new NewHomeSlideAdapter(getSupportFragmentManager());
        page.setAdapter(adapter);

    }
}
