package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.SquareBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.square.SquareConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MySquare implements SquareConstant.SquareModel {
    @Override
    public void gatData(int page, final IBaseCallBack iBaseCallBack) {
        Observable<SquareBean> squareData = MyDataService.getMyRetrofitService ( )
                .getSquareData ( page );
        squareData.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<SquareBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SquareBean squareBean) {
                        if (squareBean!=null){
                            iBaseCallBack.onSuccess ( squareBean );
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iBaseCallBack.onFail ( e.getMessage () );
                        e.printStackTrace ();
                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
