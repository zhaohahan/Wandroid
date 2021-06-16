package com.mr.tengyu.wandroid.base;

public interface IBaseCallBack<T> {
    void onSuccess(T t);
    void onFail(String str);
}
