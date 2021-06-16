package com.mr.tengyu.wandroid.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.base.Appcontast;
import com.mr.tengyu.wandroid.base.IBasePresenter;
import com.mr.tengyu.wandroid.data.entity.Bean;
import com.mr.tengyu.wandroid.data.entity.HotSearchbean;
import com.mr.tengyu.wandroid.data.entity.SearchAuthorBean;
import com.mr.tengyu.wandroid.data.local_db.MyDatabaseHelper;
import com.mr.tengyu.wandroid.data.net.MyRetrofitService;
import com.mr.tengyu.wandroid.data.net.okhttp.OkhttpManager;
import com.mr.tengyu.wandroid.data.repository.MySearchModel;
import com.mr.tengyu.wandroid.utils.FlowLayout_zhao;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements SearchContanst.SearchView, View.OnClickListener {

    private ImageView search_back;
    private SearchView search_text;
    private FlowLayout_zhao flKeyword;
    private ImageView img_search_searcher;
    private List<Bean> list;
    private MyDatabaseHelper myDatabaseHelper;
    private ListView search_lv;
    private RelativeLayout search_greendao_rl;
    private SearchViewGreenDaoAdapter searchViewGreenDaoAdapter;
    private String name = "";
    private TextView cleanAll;
    private String  author;
    private int page;
    private ArrayList<SearchAuthorBean.DataBean.DatasBean> author_list =new ArrayList (  );
    private Search_adapter search_adapter;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_search );
        initView ( );

        //初始化数据库
        initDbHelp ( );
        initData ( );
        search_lv.setTextFilterEnabled ( true );
    }

    private void initData() {
        updateList ( );

        final List<String> list_s = new ArrayList<> ( );

        Retrofit retrofit = new Retrofit.Builder ( )
                .baseUrl ( Appcontast.BASE_URL )
                .client ( OkhttpManager.getClient ( ) )
                .addConverterFactory ( GsonConverterFactory.create ( ) )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create ( ) )
                .build ( );
        MyRetrofitService myRetrofitService = retrofit.create ( MyRetrofitService.class );
        Observable<HotSearchbean> hotSearchData = myRetrofitService.getHotSearchData ( );
        hotSearchData.subscribeOn ( Schedulers.io ( ) )
                .observeOn ( AndroidSchedulers.mainThread ( ) )
                .subscribe ( new Observer<HotSearchbean> ( ) {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotSearchbean hotSearchbean) {
                        if (hotSearchbean != null) {
                            List<HotSearchbean.DataBean> data = hotSearchbean.getData ( );
                            for (int i = 0; i < data.size ( ); i++) {
                                list_s.add ( data.get ( i ).getName ( ) );
                            }
                        }

                        flKeyword.setFlowLayout ( list_s, new FlowLayout_zhao.OnItemClickListener ( ) {
                            @Override
                            public void onItemClick(String content) {
                                MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getMyDatabaseHelper ( );
                                Bean bean = new Bean ( null, content );
                                myDatabaseHelper.insert ( bean );
                                updateList();
                           //     Toast.makeText ( SearchActivity.this, "添加成功", Toast.LENGTH_SHORT ).show ( );
                            }
                        } );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText ( SearchActivity.this, e.getMessage ( ), Toast.LENGTH_SHORT ).show ( );
                        e.printStackTrace ( );
                    }

                    @Override
                    public void onComplete() {

                    }
                } );
        //搜索文本监听
        search_text.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //点击搜索
            public boolean onQueryTextSubmit(String query) {
                name = query;
                MySearchPresenter mySearchPresenter = new MySearchPresenter ( new MySearchModel ( ), page, name );
                setPresenter(mySearchPresenter);


                Log.e("name--------", name + "");
                myDatabaseHelper.insert ( new Bean ( null,name ) );
                return false;
            }

            @Override
            //当搜索内容改变
            public boolean onQueryTextChange(String newText) {
                name = newText;
                Log.e("newText---------", newText);
                if (name.equals("")) {
//                    searchGreendaoLv.setFilterText(name);
                } else {
//                    insertDB();
//                    searchGreendaoLv.clearTextFilter();
                }
                return false;
            }
        });


    }

    private void setPresenter(MySearchPresenter mySearchPresenter) {
        mySearchPresenter.attachView (this );

    }

    private void updateList() {
        list = myDatabaseHelper.queryAll ( );
        //这里用于判断是否有数据
        if (list.size ( ) == 0) {
            search_greendao_rl.setVisibility ( View.VISIBLE );
            cleanAll.setVisibility ( View.GONE );
        } else {
            search_greendao_rl.setVisibility ( View.GONE );
            cleanAll.setVisibility ( View.VISIBLE );
        }


        //list倒序排列
        Collections.reverse ( list );

        searchViewGreenDaoAdapter = new SearchViewGreenDaoAdapter ( this, list );
        search_lv.setAdapter ( searchViewGreenDaoAdapter );
        searchViewGreenDaoAdapter.notifyDataSetChanged ( );
    }


    private void initView() {
        search_back = (ImageView) findViewById ( R.id.search_back );
        search_text = (SearchView) findViewById ( R.id.search_text );
        img_search_searcher = (ImageView) findViewById ( R.id.img_search_searcher );

        //流式布局
        flKeyword = (FlowLayout_zhao) findViewById ( R.id.fl_keyword );

        search_lv = (ListView) findViewById ( R.id.search_lv );
        search_greendao_rl = (RelativeLayout) findViewById ( R.id.search_greendao_rl );
        cleanAll = (TextView) findViewById ( R.id.cleanAll );

        search_text.setQueryHint ( "请输入" );
//        searchview.setIconifiedByDefault(false);
        search_text.onActionViewExpanded ( );
        search_text.clearFocus ( );
        search_text.setOnClickListener ( this );

        delectUnderline ( );

        search_back.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                finish ( );
            }
        } );

        img_search_searcher.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.deleteAll ( list );
            }
        } );



        cleanAll.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.deleteAll ( list );
                updateList();
            }
        } );
    }

    private void initDbHelp() {
        myDatabaseHelper = MyDatabaseHelper.getMyDatabaseHelper ( );
    }

    /**
     * 去掉searchview下划线
     */
    private void delectUnderline() {
        if (search_text != null) {
            try {        //--拿到字节码
                Class<?> argClass = search_text.getClass ( );
                //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
                Field ownField = argClass.getDeclaredField ( "mSearchMain" );
                //--暴力反射,只有暴力反射才能拿到私有属性
                ownField.setAccessible ( true );
                View mView = (View) ownField.get ( search_text );
                //--设置背景
                mView.setBackgroundColor ( R.drawable.shape_search );
            } catch (Exception e) {
                e.printStackTrace ( );
            }
        }
    }

    @Override
    public void OnSuccess(Object o) {
        SearchAuthorBean searchAuthorBean = (SearchAuthorBean) o;
        List<SearchAuthorBean.DataBean.DatasBean> datas = searchAuthorBean.getData ( ).getDatas ( );
        author_list.addAll ( datas );
        search_adapter.setList ( author_list  );
        search_adapter.notifyDataSetChanged ();

    }

    @Override
    public void OnFail(String str) {

    }

    @Override
    public void setPresenter(IBasePresenter iBasePresenter) {
        iBasePresenter.attachView ( this );
    }

    @Override
    public void onClick(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item, null);
        popupWindow = new PopupWindow(view);
                        popupWindow.setWidth(200);
                        popupWindow.setHeight(100);
                        popupWindow.setOutsideTouchable(true); //点击外部消失
                        popupWindow.setFocusable(true);  //聚焦，（可点击，可输入）
                        popupWindow.showAtLocation(this.search_text, Gravity.CENTER_VERTICAL,0,0);//设置PopupWindo相对于父控件所展示的位置
        RecyclerView rv = view.findViewById ( R.id.search_author_rv );
        SmartRefreshLayout smart = view.findViewById ( R.id.search_author_smart );
        //取消    父控件.dismiss()
        search_adapter = new Search_adapter ( this, author_list );
        rv.setAdapter ( search_adapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this );
        rv.setLayoutManager ( linearLayoutManager );


    }

    @Override
    protected void onDestroy() {
        super.onDestroy ( );
        popupWindow.dismiss ();
    }
}
