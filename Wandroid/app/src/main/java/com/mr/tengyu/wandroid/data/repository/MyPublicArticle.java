package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.PublicArticleBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPublicArticle implements PublicContanst2.PublicModel2 {

    @Override
    public void getData(int id, final int page, final IBaseCallBack baseCallBack) {
        Observable<PublicArticleBean> dataPublicArticleData = MyDataService.getMyRetrofitService ( )
                .getDataPublicArticleData ( id, page );
        dataPublicArticleData.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<PublicArticleBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PublicArticleBean publicArticleBean) {
                        if (publicArticleBean!=null){
                            baseCallBack.onSuccess ( publicArticleBean );
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
