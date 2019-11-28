package com.mr.tengyu.wandroid.ui.square;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.HomeArticleBean;
import com.mr.tengyu.wandroid.data.entity.SquareBean;
import com.mr.tengyu.wandroid.data.repository.MySquare;
import com.mr.tengyu.wandroid.ui.home.MyRV_adapter;
import com.mr.tengyu.wandroid.ui.main.WebActivity;
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
public class SquareFragment extends Fragment implements SquareConstant.SquareView {


    private RecyclerView square_rv;
    private SmartRefreshLayout square_smart;
    private int page = 1;
    private ArrayList<SquareBean.DataBean.DatasBean> list = new ArrayList<> (  );
    private MySquare_Adapter mySquare_adapter;

    public SquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_square, container, false );
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        MySquarePresenter mySquarePresenter = new MySquarePresenter ( new MySquare ( ), page );
        mySquarePresenter.getData ();
        setPresenter(mySquarePresenter);

    }

    private void initView(View inflate) {
        square_rv = inflate.findViewById ( R.id.square_rv );
        square_smart = inflate.findViewById ( R.id.square_smart );
        mySquare_adapter = new MySquare_Adapter ( getContext ( ), list );
        square_rv.setAdapter ( mySquare_adapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getContext ( ) );
        square_rv.setLayoutManager ( linearLayoutManager );
        square_smart.setOnLoadMoreListener(new OnLoadMoreListener () {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page ++ ;
                initData ();
                mySquare_adapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore(true);//加载完成
            }
        });
        //刷新
        square_smart.setOnRefreshListener(new OnRefreshListener () {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear ( );
                initData ( );
                mySquare_adapter.notifyDataSetChanged ( );
                refreshLayout.finishRefresh ( true );//刷新完成
            }
        });

        mySquare_adapter.setOnClicklisenter ( new MySquare_Adapter.OnClicklisenter ( ) {
            @Override
            public void sendURL(SquareBean.DataBean.DatasBean datasBean) {
                String link = datasBean.getLink ( );
                Intent intent = new Intent ( getActivity ( ), WebActivity.class );
                intent.putExtra ( "link",link );
                startActivity ( intent );
            }
        } );

    }


    @Override
    public void onSuccess(Object o) {
        SquareBean squareBean = (SquareBean) o;
        List<SquareBean.DataBean.DatasBean> datas = squareBean.getData ( ).getDatas ( );
        list.addAll ( datas );
        mySquare_adapter.setList ( list );
        mySquare_adapter.notifyDataSetChanged ();

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }
}
