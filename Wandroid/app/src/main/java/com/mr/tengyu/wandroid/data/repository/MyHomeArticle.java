package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.HomeArticleBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.home.Homeconstant2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyHomeArticle implements Homeconstant2.HomeModel {

    @Override
    public void getdata(int page, final IBaseCallBack baseCallBack) {
        Observable<HomeArticleBean> data = MyDataService.getMyRetrofitService ( )
                .getProjectTypeData ( page );
        data.subscribeOn ( Schedulers.io ( ) )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<HomeArticleBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeArticleBean homeArticleBean) {
                        if (homeArticleBean!=null){
                            baseCallBack.onSuccess ( homeArticleBean );
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseCallBack.onFail ( e.getMessage () );
                        e.printStackTrace ();

                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
