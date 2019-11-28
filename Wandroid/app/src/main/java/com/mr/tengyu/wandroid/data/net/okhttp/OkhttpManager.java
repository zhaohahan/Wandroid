package com.mr.tengyu.wandroid.data.net.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpManager {
    private static final long DEFAULT_TIMEOUT = 20000;
        private static volatile OkHttpClient httpClient;
        public static synchronized OkHttpClient getClient() {
            if (httpClient == null) {
                //http记录拦截器
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                //设置日志记录 水平方向
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);

                httpClient = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .build();
            }

            return httpClient;
        }
}
