package com.mr.tengyu.wandroid.ui.publicer;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface PublicContanst2 {
    interface PublicPresenter2 extends IBasePresenter<PublicView2>{
        void  getData();
    }
    interface  PublicView2 <T> extends IBaseView<PublicPresenter2>{
        void OnSuccess(Object o);
        void OnFail(String str);
    }
    interface  PublicModel2{
        void getData(int id,int page,IBaseCallBack baseCallBack);
    }
}
