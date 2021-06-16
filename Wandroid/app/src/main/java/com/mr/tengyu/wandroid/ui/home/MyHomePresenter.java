package com.mr.tengyu.wandroid.ui.home;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.repository.MyHomeBanner;
import com.mr.tengyu.wandroid.utils.Logger;

public class MyHomePresenter implements Homeconstant.HomePresent {
    private Homeconstant.HomeView view ;
    private Homeconstant.HomeModel model;

    public MyHomePresenter(Homeconstant.HomeModel model) {
        this.model = model;
    }

    @Override
    public void getData() {
        model.getdata ( new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null)
                    view.onSuccess ( o );
                Logger.logD ( "banner",o.toString () );
            }

            @Override
            public void onFail(String str) {
                if (view!=null)
                    view.OnFail ( str );
                Logger.logD ( "banner",str );
            }
        } );
    }

    @Override
    public void attachView(Homeconstant.HomeView homeView) {
        view =homeView;
    }

    @Override
    public void deaschView() {
        view =null;
    }
}
