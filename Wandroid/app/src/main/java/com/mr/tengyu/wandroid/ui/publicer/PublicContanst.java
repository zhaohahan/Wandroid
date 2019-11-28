package com.mr.tengyu.wandroid.ui.publicer;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface PublicContanst {
    interface PublicPresenter extends IBasePresenter<PublicView>{
        void  getData();
    }
    interface  PublicView <T> extends IBaseView<PublicPresenter>{
        void OnSuccess(Object o);
        void OnFail(String str);
    }
    interface  PublicModel{
        void getData(IBaseCallBack baseCallBack);
    }
}
