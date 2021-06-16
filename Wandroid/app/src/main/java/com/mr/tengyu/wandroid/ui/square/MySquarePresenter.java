package com.mr.tengyu.wandroid.ui.square;

import com.mr.tengyu.wandroid.base.IBaseCallBack;

public class MySquarePresenter implements SquareConstant.SquarePresenter {
    private SquareConstant.SquareModel model;
    private SquareConstant.SquareView view;
    private int page;
    public MySquarePresenter(SquareConstant.SquareModel model,int page) {
        this.model = model;
        this.page  = page;
    }

    @Override
    public void getData() {
        model.gatData ( page, new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null)
                    view.onSuccess ( o);

            }

            @Override
            public void onFail(String str) {
                if (view!=null)
                    view.onFail ( str );

            }
        } );


    }

    @Override
    public void attachView(SquareConstant.SquareView squareView) {
        view = squareView;
    }

    @Override
    public void deaschView() {
        view = null;
    }
}
