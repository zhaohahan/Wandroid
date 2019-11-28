package com.mr.tengyu.wandroid.ui.project;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface Projectconstant {
    interface ProjectPresenter extends IBasePresenter<ProjectView>{
        void getData();
    }
    interface ProjectView <T> extends IBaseView<ProjectPresenter>{
        void OnSuccess(Object o);
        void OnFail(String str);
    }
    interface ProjectModel{
        void getData(IBaseCallBack baseCallBack);
    }
}
