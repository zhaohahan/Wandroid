package com.mr.tengyu.wandroid.ui.main;

import android.content.Context;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainVp_Adapter extends FragmentPagerAdapter  {
     private Context context;
     private ArrayList<Fragment> list;

    public MainVp_Adapter(FragmentManager fm, Context context, ArrayList<Fragment> list) {
        super ( fm );
        this.context = context;
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
