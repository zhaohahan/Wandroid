package com.mr.tengyu.wandroid.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class BanViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public BanViewPager(Context context) {

        super( context );

    }

    public BanViewPager(Context context, AttributeSet attrs) {

        super( context, attrs );

    }

    public void setNoScroll(boolean noScroll) {

        this.isCanScroll = noScroll;

    }

    @Override

    public void scrollTo(int x, int y) {

        super.scrollTo( x, y );

    }

    @Override

    public boolean onTouchEvent(MotionEvent arg0) {

        if (isCanScroll) {

            return false;

        } else {
            return super.onTouchEvent( arg0 );

        }

    }

    @Override

    public boolean onInterceptTouchEvent(MotionEvent arg0) {

        if (isCanScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent( arg0 );
        }
    }

}