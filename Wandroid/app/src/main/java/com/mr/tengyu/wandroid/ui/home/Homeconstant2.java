package com.mr.tengyu.wandroid.ui.home;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface Homeconstant2 {
    interface HomePresent extends IBasePresenter<HomeView>{
        void getData();
    }
    interface HomeView<T> extends IBaseView<HomePresent>{
        void onSuccess2(T data);
        void OnFail2(String data);

    }
    interface HomeModel{
        void getdata(int page ,IBaseCallBack baseCallBack);
    }
}
