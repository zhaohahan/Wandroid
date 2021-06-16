package com.mr.tengyu.wandroid.ui.home;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

import java.util.Map;

public interface Homeconstant {
    interface HomePresent extends IBasePresenter<HomeView>{
        void getData();
    }
    interface HomeView<T> extends IBaseView<HomePresent>{
        void onSuccess(T data);
        void OnFail(String data);

    }
    interface HomeModel{
        void getdata( IBaseCallBack baseCallBack);
    }
}
