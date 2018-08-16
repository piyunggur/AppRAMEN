package com.example.user.ramen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;

public class NewHomeActivity extends AppCompatActivity {

    ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhome_layout);

        page = (ViewPager) findViewById(R.id.newhome_viewpage);
        NewHomeSlideAdapter adapter = new NewHomeSlideAdapter(getSupportFragmentManager(),this);
        page.setAdapter(adapter);
        LockableViewPager lockableViewPager = new LockableViewPager(this);

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

        public class LockableViewPager extends ViewPager {
        private boolean swipeable;
        public LockableViewPager(Context context) {
            super(context);
            setSwipeable(false);
        }

        public LockableViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.swipeable = true;
            setSwipeable(false);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (this.swipeable) {
                return super.onTouchEvent(event);
            }
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (this.swipeable) {
                return super.onInterceptTouchEvent(event);
            }
            return false;
        }

        public void setSwipeable(boolean swipeable) {
            this.swipeable = swipeable;
        }
    }

}
