package com.mr.tengyu.wandroid.ui.square;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.base.IBaseView;

public interface SquareConstant {
    interface  SquarePresenter extends IBasePresenter<SquareView>{
        void  getData();
    }
    interface SquareView<T> extends IBaseView<SquarePresenter>{
        void  onSuccess(Object o);
        void  onFail(String  str);
    }
    interface SquareModel{
        void gatData(int page, IBaseCallBack iBaseCallBack);
    }
}
