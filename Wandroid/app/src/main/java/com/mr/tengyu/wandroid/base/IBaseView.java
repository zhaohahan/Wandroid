package com.mr.tengyu.wandroid.base;

public interface IBaseView<T extends IBasePresenter> {
     void setPresenter(T t);
}
