package com.mr.tengyu.wandroid.ui.publicer.adapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPublicVP_adapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public MyPublicVP_adapter(FragmentManager fm, ArrayList<Fragment> list) {
        super ( fm );
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get ( position );
    }

    @Override
    public int getCount() {
        return list.size ();
    }
}
