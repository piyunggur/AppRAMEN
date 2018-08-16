package com.example.user.ramen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NewHomeSlideAdapter extends FragmentPagerAdapter{

    private final int pageNumber = 3;
    private Context context;
    public NewHomeSlideAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
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

        //LockableViewPager lockableViewPager = new LockableViewPager(context);
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }


//    public class LockableViewPager extends ViewPager {
//        private boolean swipeable;
//        public LockableViewPager(Context context) {
//            super(context);
//            setSwipeable(false);
//        }
//
//        public LockableViewPager(Context context, AttributeSet attrs) {
//            super(context, attrs);
//            this.swipeable = true;
//            setSwipeable(false);
//        }
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//            if (this.swipeable) {
//                return super.onTouchEvent(event);
//            }
//            return false;
//        }
//
//        @Override
//        public boolean onInterceptTouchEvent(MotionEvent event) {
//            if (this.swipeable) {
//                return super.onInterceptTouchEvent(event);
//            }
//            return false;
//        }
//
//        public void setSwipeable(boolean swipeable) {
//            this.swipeable = swipeable;
//        }
//    }

}
