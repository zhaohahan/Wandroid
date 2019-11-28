package com.mr.tengyu.wandroid.ui.publicer.p;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst;

import java.util.Calendar;

public class MyPublicTypePresenter implements PublicContanst.PublicPresenter {
    private PublicContanst.PublicModel model;
    private PublicContanst.PublicView view;

    public MyPublicTypePresenter(PublicContanst.PublicModel model) {
        this.model = model;
    }

    @Override
    public void getData() {
        model.getData ( new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null)
                    view.OnSuccess ( o );
            }

            @Override
            public void onFail(String str) {
                if (view!=null)
                    view.OnFail ( str);
            }
        } );
    }

    @Override
    public void attachView(PublicContanst.PublicView publicView) {
        view = publicView;


    }

    @Override
    public void deaschView() {
        view = null;

    }
}
