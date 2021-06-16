package com.mr.tengyu.wandroid.ui.project.fragmnet;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.ProjectTypeBean;
import com.mr.tengyu.wandroid.data.repository.MyProject_projecter;
import com.mr.tengyu.wandroid.ui.project.adapter.MyProjectVP_adapter;
import com.mr.tengyu.wandroid.ui.project.p.MyProjectPresenter;
import com.mr.tengyu.wandroid.ui.project.Projectconstant;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment implements Projectconstant.ProjectView {


    private TabLayout project_tab;
    private ViewPager project_vp;
    private ArrayList<Fragment> list = new ArrayList< > ( );

    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_project, container, false );
        initView ( inflate );
        MyProjectPresenter myProjectPresenter = new MyProjectPresenter ( new MyProject_projecter ( ) );
        myProjectPresenter.getData ( );
        setPresenter ( myProjectPresenter );

        return inflate;
    }

    private void initView(View inflate) {
        project_tab = inflate.findViewById ( R.id.project_tab );
        project_vp = inflate.findViewById ( R.id.project_vp );

    }

    @Override
    public void OnSuccess(Object o) {
        ProjectTypeBean projectTypeBean = (ProjectTypeBean) o;
        List<ProjectTypeBean.DataBean> data = projectTypeBean.getData ( );
        for (int i = 0; i < data.size ( ); i++) {
            ProjectTypeBean.DataBean dataBean = data.get ( i );
            String name = dataBean.getName ( );
            int id = dataBean.getId ( );
            list.add ( new DetailFragment ( id ) );
            project_tab.addTab ( project_tab.newTab ( ).setText ( name ) );
        }
        project_tab.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener ( ) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                project_vp.setCurrentItem ( tab.getPosition ( ) );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        project_vp.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( project_tab ) );
        MyProjectVP_adapter myProjectRV_adapter = new MyProjectVP_adapter (  getFragmentManager (), list );
        project_vp.setAdapter ( myProjectRV_adapter );
    }

    @Override
    public void OnFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }
}
