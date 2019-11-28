package com.mr.tengyu.wandroid.ui.project;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface Projectconstant2 {
    interface ProjectPresenter2 extends IBasePresenter<ProjectView2>{
        void getData();
    }
    interface ProjectView2 <T> extends IBaseView<ProjectPresenter2>{
        void OnSuccess(Object o);
        void OnFail(String str);
    }
    interface ProjectModel2{
        void getData(int page,int cid,IBaseCallBack baseCallBack);
    }
}
