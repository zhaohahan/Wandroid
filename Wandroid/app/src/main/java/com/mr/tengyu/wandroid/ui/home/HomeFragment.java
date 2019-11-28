package com.mr.tengyu.wandroid.ui.home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.HomeArticleBean;
import com.mr.tengyu.wandroid.data.entity.HomeBannerBean;
import com.mr.tengyu.wandroid.data.repository.MyHomeArticle;
import com.mr.tengyu.wandroid.data.repository.MyHomeBanner;
import com.mr.tengyu.wandroid.ui.main.WebActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Homeconstant.HomeView, Homeconstant2.HomeView {


    //private Banner home_banner;
    private SmartRefreshLayout smart;
    private RecyclerView home_rv;
    private int page = 1;
    private ArrayList<HomeArticleBean.DataBean.DatasBean> list = new ArrayList<> ( );
    private MyRV_adapter myRV_adapter;
    private ImageView home_search;
    private SmartRefreshLayout home_smart;
    private ArrayList<HomeBannerBean.DataBean> bannerList= new ArrayList<> (  );
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_home, container, false );
        initView ( inflate );
        MyHomePresenter myHomePresenter = new MyHomePresenter ( new MyHomeBanner ( ) );
        myHomePresenter.getData ( );
        setPresenter ( myHomePresenter );
        initData();
        return inflate;
    }

    private void initData() {
        MyHomePresenter2 myHomePresenter2 = new MyHomePresenter2 ( new MyHomeArticle ( ), page );
        myHomePresenter2.getData ( );
        setPresenter ( myHomePresenter2 );
    }

    private void initView(final View inflate) {
        //home_banner = inflate.findViewById ( R.id.home_banner );
        home_rv = inflate.findViewById ( R.id.home_rv );
        home_search = inflate.findViewById ( R.id.home_search );
        smart = inflate.findViewById ( R.id.home_smart );

         smart.setOnLoadMoreListener(new OnLoadMoreListener () {
                     @Override
                     public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                         page ++ ;
                         initData ();
                         myRV_adapter.notifyDataSetChanged();
                         refreshLayout.finishLoadMore(true);//加载完成
                     }
                 });
                 //刷新
         smart.setOnRefreshListener(new OnRefreshListener () {
                     @Override
                     public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                         list.clear();
                         initData();
                         myRV_adapter.notifyDataSetChanged();
                         refreshLayout.finishRefresh(true);//刷新完成
                     }
                 });
        myRV_adapter = new MyRV_adapter ( getContext ( ), list ,bannerList);
        home_rv.setAdapter ( myRV_adapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getContext ( ) );
        home_rv.setLayoutManager ( linearLayoutManager );

        myRV_adapter.setOnClicklisenter ( new MyRV_adapter.OnClicklisenter ( ) {
            @Override
            public void sendURL(HomeArticleBean.DataBean.DatasBean datasBean) {
                String link = datasBean.getLink ( );
                Intent intent = new Intent ( getActivity ( ), WebActivity.class );
                intent.putExtra ( "link",link );
                startActivity ( intent );
            }
        } );

    }

    @Override
    public void onSuccess(final Object data) {
        HomeBannerBean  homeBannerBean = (HomeBannerBean) data;
        final List<HomeBannerBean.DataBean>  list = homeBannerBean.getData ( );
        bannerList.addAll ( list );
       /* home_banner.setImages (  list )
                .setImageLoader ( new ImageLoader ( ) {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBannerBean.DataBean dataBean = (HomeBannerBean.DataBean) path;
                        Glide.with ( getContext ( ) ).load ( dataBean.getImagePath ( ) ).into ( imageView );
                    }
                } ).start ( );*/

    }

    @Override
    public void OnFail(String data) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }

    @Override
    public void onSuccess2(Object data) {
        HomeArticleBean homeArticleBean = (HomeArticleBean) data;
        List<HomeArticleBean.DataBean.DatasBean> article_list = homeArticleBean.getData ( ).getDatas ( );
        list.addAll ( article_list );
        myRV_adapter.setList ( list );
        myRV_adapter.notifyDataSetChanged ( );

    }

    @Override
    public void OnFail2(String data) {

    }
}
