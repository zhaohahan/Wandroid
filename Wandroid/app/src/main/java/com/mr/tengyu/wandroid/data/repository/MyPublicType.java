package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.PublicTypeBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPublicType implements PublicContanst.PublicModel {
    @Override
    public void getData(final IBaseCallBack baseCallBack) {
        Observable<PublicTypeBean> publicTypeData = MyDataService.getMyRetrofitService ( )
                .getPublicTypeData ( );
        publicTypeData.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread ())
                .subscribe ( new Observer<PublicTypeBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PublicTypeBean publicTypeBean) {
                        if (publicTypeBean!=null){
                            baseCallBack.onSuccess ( publicTypeBean );
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
