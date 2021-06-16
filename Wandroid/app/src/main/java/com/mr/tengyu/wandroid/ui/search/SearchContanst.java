package com.mr.tengyu.wandroid.ui.search;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface SearchContanst {
    interface SearchPresenter extends IBasePresenter<SearchView> {
        void  getData();
    }
    interface  SearchView <T> extends IBaseView<SearchPresenter> {
        void OnSuccess(Object o);
        void OnFail(String str);
    }
    interface  SearchModel{
        void getData(int page, String author, IBaseCallBack baseCallBack);
    }
}
