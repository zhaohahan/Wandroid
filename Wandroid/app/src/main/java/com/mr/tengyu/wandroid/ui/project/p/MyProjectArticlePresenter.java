package com.mr.tengyu.wandroid.ui.project.p;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.ui.project.Projectconstant2;

public class MyProjectArticlePresenter implements Projectconstant2.ProjectPresenter2 {
    private Projectconstant2.ProjectModel2 model2;
    private Projectconstant2.ProjectView2 view2;
    private int page;
    private  int cid;

    public MyProjectArticlePresenter(Projectconstant2.ProjectModel2 model2, int page, int cid) {
        this.model2 = model2;
        this.page = page;
        this.cid = cid;
    }

    @Override
    public void getData() {
        model2.getData ( page, cid, new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view2!=null)
                    view2.OnSuccess ( o );
            }

            @Override
            public void onFail(String str) {
                if(view2!=null)
                    view2.OnFail ( str );
            }
        } );

    }

    @Override
    public void attachView(Projectconstant2.ProjectView2 projectView2) {
        view2 = projectView2;
    }

    @Override
    public void deaschView() {
        view2 = null;

    }
}
