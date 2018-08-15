package com.example.user.ramen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NewHomeSlideAdapter extends FragmentPagerAdapter {

    private final int pageNumber = 3;

    public NewHomeSlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new HomeFragment();
        }else if(position == 1){
            return new ShoppingFragment();
        }else if(position == 2){
            return new UserFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}
