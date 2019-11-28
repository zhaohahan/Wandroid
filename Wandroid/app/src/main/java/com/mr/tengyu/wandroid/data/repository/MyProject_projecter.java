package com.mr.tengyu.wandroid.data.repository;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.entity.ProjectTypeBean;
import com.mr.tengyu.wandroid.data.net.okhttp.MyDataService;
import com.mr.tengyu.wandroid.ui.project.Projectconstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyProject_projecter implements Projectconstant.ProjectModel {
    @Override
    public void getData(final IBaseCallBack baseCallBack) {
        Observable<ProjectTypeBean> projectTypeData =
                MyDataService.getMyRetrofitService ( ).getProjectTypeData ( );
        projectTypeData.subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer<ProjectTypeBean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProjectTypeBean projectTypeBean) {
                        if (projectTypeBean!=null){
                            baseCallBack.onSuccess ( projectTypeBean );
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
