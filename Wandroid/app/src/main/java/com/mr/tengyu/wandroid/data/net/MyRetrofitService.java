package com.mr.tengyu.wandroid.data.net;




import com.mr.tengyu.wandroid.data.entity.HomeArticleBean;
import com.mr.tengyu.wandroid.data.entity.HomeBannerBean;
import com.mr.tengyu.wandroid.data.entity.HotSearchbean;
import com.mr.tengyu.wandroid.data.entity.ProjectArticleBean;
import com.mr.tengyu.wandroid.data.entity.ProjectTypeBean;
import com.mr.tengyu.wandroid.data.entity.PublicArticleBean;
import com.mr.tengyu.wandroid.data.entity.PublicTypeBean;
import com.mr.tengyu.wandroid.data.entity.SearchAuthorBean;
import com.mr.tengyu.wandroid.data.entity.SquareBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyRetrofitService {


    @GET("banner/json")
    Observable<HomeBannerBean> getData_Homebanner();
    //首頁文章  https://www.wanandroid.com/article/list/0/json
    @GET("article/list/{page}/json")
    Observable<HomeArticleBean> getProjectTypeData(@Path ("page")int page);
    //project   https://www.wanandroid.com/project/tree/json
    @GET("project/tree/json")
    Observable<ProjectTypeBean> getProjectTypeData();
    //project  列表  https://www.wanandroid.com/project/list/1/json?cid=294
    @GET("project/list/{page}/json?")
    Observable<ProjectArticleBean> getProjectArticleData(@Path ( "page" )int page, @Query ( "cid" ) int cid);
    //public  公众号  https://wanandroid.com/wxarticle/chapters/json
    @GET("wxarticle/chapters/json")
    Observable<PublicTypeBean> getPublicTypeData();
    //public    列表   https://wanandroid.com/wxarticle/list/408/1/json
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<PublicArticleBean> getDataPublicArticleData(@Path ( "id" )int id,@Path ( "page" )int page);
    //Square   https://wanandroid.com/user_article/list/1/json
    @GET("user_article/list/{page}/json")
    Observable<SquareBean> getSquareData(@Path ( "page" ) int  page);
    @GET("hotkey/json")
    Observable<HotSearchbean> getHotSearchData();
///https://wanandroid.com/article/list/0/json?author=鸿洋
    @GET("article/list/{page}/json")
    Observable<SearchAuthorBean> getDataSearchBean(@Path ( "page" )int page, @Query ( "author" )String author);

}
