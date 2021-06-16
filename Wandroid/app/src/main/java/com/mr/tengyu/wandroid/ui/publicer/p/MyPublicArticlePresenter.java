package com.mr.tengyu.wandroid.ui.publicer.p;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst;
import com.mr.tengyu.wandroid.ui.publicer.PublicContanst2;

public class MyPublicArticlePresenter implements PublicContanst2.PublicPresenter2 {
    private PublicContanst2.PublicModel2 model;
    private PublicContanst2.PublicView2 view;
    private int id;
    private  int page;

    public MyPublicArticlePresenter(PublicContanst2.PublicModel2 model, int id, int page) {
        this.model = model;
        this.id = id;
        this.page = page;
    }

    @Override
    public void getData() {
        model.getData ( id, page, new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null)
                    view.OnSuccess ( o );
            }

            @Override
            public void onFail(String str) {
                if (view!=null)
                    view.OnFail ( str );

            }
        } );
    }

    @Override
    public void attachView(PublicContanst2.PublicView2 publicView2) {
        view = publicView2;
    }

    @Override
    public void deaschView() {
        view =null;

    }
}
