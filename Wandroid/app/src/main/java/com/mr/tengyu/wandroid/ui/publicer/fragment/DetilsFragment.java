package com.mr.tengyu.wandroid.ui.publicer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.PublicArticleBean;
import com.mr.tengyu.wandroid.data.repository.MyPublicArticle;
import com.mr.tengyu.wandroid.ui.main.WebActivity;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst2;
import com.mr.tengyu.wandroid.ui.publicer.adapter.MyPublicRV_adapter;
import com.mr.tengyu.wandroid.ui.publicer.p.MyPublicArticlePresenter;
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
public class DetilsFragment extends Fragment implements PublicContanst2.PublicView2 {


    private RecyclerView public_rv;
    private SmartRefreshLayout public_smart;
    private int id;
    private int page = 1;
    private ArrayList<PublicArticleBean.DataBean.DatasBean> list =new ArrayList<> (  );
    private MyPublicRV_adapter myPublicRV_adapter;

    public DetilsFragment(int id) {
        this.id = id;
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_detils, container, false );
        initVata(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        MyPublicArticlePresenter myPublicArticlePresenter = new MyPublicArticlePresenter ( new MyPublicArticle ( ), id, page );
        myPublicArticlePresenter.getData ();
        setPresenter(myPublicArticlePresenter);
    }

    private void initVata(View inflate) {
        public_rv = inflate.findViewById ( R.id.public_rv );
        myPublicRV_adapter =
                new MyPublicRV_adapter ( list, getContext ( ) );
        public_rv.setAdapter ( myPublicRV_adapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getContext ( ) );
        public_rv.setLayoutManager ( linearLayoutManager );
        public_smart = inflate.findViewById ( R.id.public_smart );

        public_smart.setOnLoadMoreListener(new OnLoadMoreListener () {
                     @Override
                     public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                         page ++ ;
                         initData ();
                         myPublicRV_adapter.notifyDataSetChanged();
                         refreshLayout.finishLoadMore(true);//加载完成
                     }
                 });
                 //刷新
        public_smart.setOnRefreshListener(new OnRefreshListener () {
                     @Override
                     public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                         list.clear ( );
                         initData ( );
                         myPublicRV_adapter.notifyDataSetChanged ( );
                         refreshLayout.finishRefresh ( true );//刷新完成
                     }
        });
        myPublicRV_adapter.setOnClicklisenter ( new MyPublicRV_adapter.OnClicklisenter ( ) {
            @Override
            public void sendURL(PublicArticleBean.DataBean.DatasBean datasBean) {
                String link = datasBean.getLink ( );
                Intent intent = new Intent ( getActivity ( ), WebActivity.class );
                intent.putExtra ( "link",link );
                startActivity ( intent );
            }
        } );



    }

    @Override
    public void OnSuccess(Object o) {
        PublicArticleBean publicArticleBean = (PublicArticleBean) o;
        List<PublicArticleBean.DataBean.DatasBean>
                datas = publicArticleBean.getData ( ).getDatas ( );
        list.addAll ( datas );
        myPublicRV_adapter.setList ( list );
        myPublicRV_adapter.notifyDataSetChanged ();


    }

    @Override
    public void OnFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }
}
