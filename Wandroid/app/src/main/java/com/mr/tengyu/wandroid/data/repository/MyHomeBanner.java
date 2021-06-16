package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.HomeBannerBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.home.Homeconstant;
import com.mr.tengyu.wandroid.utils.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyHomeBanner implements Homeconstant.HomeModel {
    @Override
    public void getdata(final IBaseCallBack baseCallBack) {
        Observable<HomeBannerBean> data_homebanner
                = MyDataService.getMyRetrofitService ( ).getData_Homebanner ( );
        data_homebanner.subscribeOn ( Schedulers.io ( ) )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<HomeBannerBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBannerBean homeBannerBean) {
                        if (homeBannerBean!=null){
                            baseCallBack.onSuccess ( homeBannerBean );
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseCallBack.onFail ( e.getMessage () );
                        Logger.logD ( "onError  ====>homeBannerBean",e.getMessage () );
                        e.printStackTrace ();
                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
