package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.SearchAuthorBean;
import com.mr.tengyu.wandroid.data.net.MyRetrofitService;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.search.SearchContanst;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MySearchModel implements SearchContanst.SearchModel {
    @Override
    public void getData(int page, String author, final IBaseCallBack baseCallBack) {
        MyRetrofitService myRetrofitService = MyDataService.getMyRetrofitService ( );
        Observable<SearchAuthorBean> dataSearchBean = myRetrofitService.getDataSearchBean ( page, author );
        dataSearchBean.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<SearchAuthorBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchAuthorBean searchAuthorBean) {
                        baseCallBack.onSuccess ( searchAuthorBean );
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
