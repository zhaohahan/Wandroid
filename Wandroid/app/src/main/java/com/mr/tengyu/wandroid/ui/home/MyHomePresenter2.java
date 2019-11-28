package com.mr.tengyu.wandroid.ui.home;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.utils.Logger;

public class MyHomePresenter2 implements Homeconstant2.HomePresent {
    private Homeconstant2.HomeView view ;
    private Homeconstant2.HomeModel model;
    private int  page;

    public MyHomePresenter2(Homeconstant2.HomeModel model,int  page) {
        this.model = model;
        this.page = page;
    }

    @Override
    public void getData() {
        model.getdata ( page, new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null)
                    view.onSuccess2 ( o );
            }

            @Override
            public void onFail(String str) {
                if (view!=null)
                    view.onSuccess2 ( str );

            }
        } );
     }

    @Override
    public void attachView(Homeconstant2.HomeView homeView) {
        view = homeView;
    }

    @Override
    public void deaschView() {
        view = null;

    }
}
