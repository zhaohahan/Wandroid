package com.mr.tengyu.wandroid.ui.search;

import com.mr.tengyu.wandroid.base.IBaseCallBack;
import com.mr.tengyu.wandroid.data.repository.MySearchModel;

public class MySearchPresenter implements SearchContanst.SearchPresenter {
    private SearchContanst.SearchView view ;
    private MySearchModel mymodel;
    private String author;
    private int page;

    public MySearchPresenter(MySearchModel mySearch, int page, String author) {
        this.mymodel = mySearch;
        this.author = author;
        this.page = page;
    }


    @Override
    public void getData() {
        mymodel.getData ( page, author, new IBaseCallBack ( ) {
            @Override
            public void onSuccess(Object o) {
                if (view!=null){
                    view.OnSuccess ( o );
                }
            }

            @Override
            public void onFail(String str) {
                if (view!=null){
                    view.OnFail ( str );
                }
            }
        } );



    }

    @Override
    public void attachView(SearchContanst.SearchView searchView) {
        view = searchView;
    }

    @Override
    public void deaschView() {

        view = null;
    }
}
