package com.mr.tengyu.wandroid.ui.publicer.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.PublicTypeBean;
import com.mr.tengyu.wandroid.data.repository.MyPublicType;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst;
import com.mr.tengyu.wandroid.ui.publicer.adapter.MyPublicVP_adapter;
import com.mr.tengyu.wandroid.ui.publicer.p.MyPublicTypePresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFragment extends Fragment  implements PublicContanst.PublicView {


    private TabLayout public_tab;
    private ViewPager public_vp;
    private ArrayList<Fragment> list = new ArrayList<> (  );

    public PublicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_public, container, false );
        initView ( inflate );
        MyPublicTypePresenter myPublicTypePresenter = new MyPublicTypePresenter ( new MyPublicType ( ) );
        myPublicTypePresenter.getData ();
        setPresenter(myPublicTypePresenter);
        return inflate;
    }

    private void initView(View inflate) {
        public_tab = inflate.findViewById ( R.id.public_tab );
        public_vp = inflate.findViewById ( R.id.public_vp );


    }

    @Override
    public void OnSuccess(Object o) {
        PublicTypeBean publicTypeBean = (PublicTypeBean) o;
        List<PublicTypeBean.DataBean> data = publicTypeBean.getData ( );
        for (int i = 0; i < data.size (); i++) {
            PublicTypeBean.DataBean dataBean = data.get ( i );
            list.add( new DetilsFragment (dataBean.getId ()) );
            public_tab.addTab ( public_tab.newTab ().setText ( dataBean.getName () ) );

        }
        public_tab.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener ( ) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                public_vp.setCurrentItem ( tab.getPosition () );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        public_vp.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( public_tab ) );
        MyPublicVP_adapter myPublicVP_adapter = new MyPublicVP_adapter ( getChildFragmentManager ( ), list );
        public_vp.setAdapter ( myPublicVP_adapter );


    }

    @Override
    public void OnFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }
}
