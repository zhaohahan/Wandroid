package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.ProjectArticleBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.project.Projectconstant2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyProjectArticle implements Projectconstant2.ProjectModel2 {
    @Override
    public void getData(final int page, int cid, final IBaseCallBack baseCallBack) {
        Observable<ProjectArticleBean> projectArticleData
                = MyDataService.getMyRetrofitService ( ).getProjectArticleData ( page, cid );
        projectArticleData.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<ProjectArticleBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProjectArticleBean projectArticleBean) {
                        if (projectArticleBean !=null){
                            baseCallBack.onSuccess ( projectArticleBean );
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
