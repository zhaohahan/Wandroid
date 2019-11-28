package com.mr.tengyu.wandroid.ui.project.p;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.ui.project.Projectconstant;

public class MyProjectPresenter implements Projectconstant.ProjectPresenter {

    private Projectconstant.ProjectView view;
    private Projectconstant.ProjectModel model;

    public MyProjectPresenter(Projectconstant.ProjectModel model) {
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
                    view.OnFail ( str );
            }
        } );
    }

    @Override
    public void attachView(Projectconstant.ProjectView projectView) {

        view= projectView;
    }

    @Override
    public void deaschView() {

        view= null;
    }
}
