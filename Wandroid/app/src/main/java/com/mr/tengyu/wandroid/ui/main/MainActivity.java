package com.mr.tengyu.wandroid.ui.main;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.ui.home.HomeFragment;
import com.mr.tengyu.wandroid.ui.my.MyFragment;
import com.mr.tengyu.wandroid.ui.project.fragmnet.ProjectFragment;
import com.mr.tengyu.wandroid.ui.publicer.fragment.PublicFragment;
import com.mr.tengyu.wandroid.ui.square.SquareFragment;
import com.mr.tengyu.wandroid.utils.BanViewPager;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    private TabLayout main_tab;
    private BanViewPager main_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initView ( );
    }

    private void initView() {
        main_tab = (TabLayout) findViewById ( R.id.main_tab );
        main_vp = (BanViewPager) findViewById ( R.id.main_vp );
        ArrayList<Fragment> list = new ArrayList<> ( );
        list.add ( new HomeFragment () );
        list.add ( new ProjectFragment () );
        list.add ( new SquareFragment () );
        list.add ( new PublicFragment () );
        list.add ( new MyFragment () );
        main_tab.addTab ( main_tab.newTab ().setText ( "首页" ).setIcon ( R.drawable.menu_main ) );
        main_tab.addTab ( main_tab.newTab ().setText ( "项目" ).setIcon ( R.drawable.menu_project ));
        main_tab.addTab ( main_tab.newTab ().setText ( "广场" ).setIcon ( R.drawable.menu_tree ) );
        main_tab.addTab ( main_tab.newTab ().setText ( "公众号" ).setIcon ( R.drawable.menu_public ) );
        main_tab.addTab ( main_tab.newTab ().setText ( "我的" ).setIcon ( R.drawable.menu_me ) );
        main_tab.addOnTabSelectedListener ( new TabLayout.BaseOnTabSelectedListener ( ) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                main_vp.setCurrentItem ( tab.getPosition () );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        main_vp.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( main_tab ) );
        MainVp_Adapter mainVp_adapter = new MainVp_Adapter ( getSupportFragmentManager ( ), this, list );
        main_vp.setAdapter ( mainVp_adapter );
    }
}
