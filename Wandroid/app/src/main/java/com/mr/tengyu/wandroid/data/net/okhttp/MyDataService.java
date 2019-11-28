package com.mr.tengyu.wandroid.data.net.okhttp;

import com.mr.tengyu.wandroid.base.Appcontast;
import com.mr.tengyu.wandroid.data.net.MyRetrofitService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyDataService {
    private static volatile MyRetrofitService myRetrofitService;
    public static MyRetrofitService getMyRetrofitService(){
       if (myRetrofitService==null){
          synchronized (MyDataService.class){
              if (myRetrofitService==null){
                  Retrofit retrofit = new Retrofit.Builder ( )
                          .baseUrl ( Appcontast.BASE_URL )
                          .client ( OkhttpManager.getClient () )
                          .addCallAdapterFactory ( RxJava2CallAdapterFactory.create ( ) )
                          .addConverterFactory ( GsonConverterFactory.create ( ) )
                          .build ( );
                  myRetrofitService = retrofit.create ( MyRetrofitService.class );
              }
          }
       }
        return  myRetrofitService;

    }

}
