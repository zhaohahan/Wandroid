package com.mr.tengyu.wandroid.ui.project.fragmnet;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.ProjectArticleBean;
import com.mr.tengyu.wandroid.data.repository.MyProjectArticle;
import com.mr.tengyu.wandroid.ui.main.WebActivity;
import com.mr.tengyu.wandroid.ui.project.Projectconstant2;
import com.mr.tengyu.wandroid.ui.project.adapter.MyProjectArticleRV_adapter;
import com.mr.tengyu.wandroid.ui.project.p.MyProjectArticlePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements Projectconstant2.ProjectView2 {

    private int cid;
    private int page = 1;
    private ArrayList<ProjectArticleBean.DataBean.DatasBean> list = new ArrayList<> ( );
    private RecyclerView project_rv;
    private SmartRefreshLayout project_smart;
    private MyProjectArticleRV_adapter myProjectArticleRV_adapter;


    public DetailFragment(int id) {
        this.cid = id;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_detail, container, false );
        initView ( inflate );
        initData();
        return inflate;
    }

    private void initData() {
        MyProjectArticlePresenter myProjectArticlePresenter = new MyProjectArticlePresenter ( new MyProjectArticle ( ), page, cid );
        myProjectArticlePresenter.getData ( );
        setPresenter ( myProjectArticlePresenter );
    }

    private void initView(final View inflate) {
        project_rv = inflate.findViewById ( R.id.project_rv );

        myProjectArticleRV_adapter = new MyProjectArticleRV_adapter ( list, getContext ( ) );
        project_rv.setAdapter ( myProjectArticleRV_adapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getContext ( ) );
        project_rv.setLayoutManager ( linearLayoutManager );
        project_smart = inflate.findViewById ( R.id.project_smart );
        project_smart.setOnLoadMoreListener(new OnLoadMoreListener () {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page ++ ;
                initData ();
                myProjectArticleRV_adapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore(true);//加载完成
            }
        });
        //刷新
        project_smart.setOnRefreshListener(new OnRefreshListener () {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear ( );
                initData ( );
                myProjectArticleRV_adapter.notifyDataSetChanged ( );
                refreshLayout.finishRefresh ( true );//刷新完成
            }
        });
        myProjectArticleRV_adapter.setOnClicklisenter ( new MyProjectArticleRV_adapter.OnClicklisenter ( ) {
            @Override
            public void sendURl(ProjectArticleBean.DataBean.DatasBean datasBean) {
                String link = datasBean.getLink ( );
                Intent intent = new Intent ( getActivity ( ), WebActivity.class );
                intent.putExtra ( "link",link );
                startActivity ( intent );

            }
        } );

    }

    @Override
    public void OnSuccess(Object o) {
        ProjectArticleBean projectArticleBean = (ProjectArticleBean) o;
        List<ProjectArticleBean.DataBean.DatasBean> datas = projectArticleBean.getData ( ).getDatas ( );
        list.addAll ( datas );
        myProjectArticleRV_adapter.setList ( list );
        myProjectArticleRV_adapter.notifyDataSetChanged ();
    }

    @Override
    public void OnFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }
}
