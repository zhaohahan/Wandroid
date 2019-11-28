package com.mr.tengyu.wandroid.base;

public interface IBasePresenter<T extends  IBaseView> {
    void attachView(T t);
    void deaschView();
}
