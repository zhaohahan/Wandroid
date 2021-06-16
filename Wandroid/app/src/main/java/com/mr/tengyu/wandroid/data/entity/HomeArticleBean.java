package com.mr.tengyu.wandroid.data.entity;

import java.util.List;

public class HomeArticleBean {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9727,"link":"https://juejin.im/post/5da6ce99f265da5ba532b6a8","niceDate":"14小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236379000,"selfVisible":0,"shareDate":1571213070000,"shareUser":"星星y","superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"【译】你的Android库是否还在Application中初始化？","type":0,"userId":15603,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":455,"chapterName":"反射","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9726,"link":"https://juejin.im/post/5da33b2351882509334fc0d3","niceDate":"14小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236353000,"selfVisible":0,"shareDate":1571209373000,"shareUser":"ZYLAB","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"大家都说 Java 反射效率低，你知道原因在哪里么","type":0,"userId":10577,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9729,"link":"https://www.jianshu.com/p/95deb46fba6a?utm_source=desktop&amp;utm_medium=timeline","niceDate":"14小时前","niceShareDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236340000,"selfVisible":0,"shareDate":1571236008000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android仿美团地址选择","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9730,"link":"https://www.jianshu.com/p/ffb1cc684507?utm_source=desktop&amp;utm_medium=timeline","niceDate":"14小时前","niceShareDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236303000,"selfVisible":0,"shareDate":1571236130000,"shareUser":"鸿洋","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 面试经验 - 大厂 OPPO 面","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"lifeidroid","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"Flutter高仿玩Android客户端，适合新手学习练手用。","envelopePic":"https://www.wanandroid.com/blogimgs/1cd80531-67b7-46f2-8a3e-25bce4a57dff.png","fresh":false,"id":9705,"link":"https://www.wanandroid.com/blog/show/2689","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/lifeidroid/play_android","publishTime":1571154530000,"selfVisible":0,"shareDate":1571154530000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"仿玩Android客户端Flutter版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9689,"link":"https://juejin.im/post/5d6d1155e51d4561ea1a94a4","niceDate":"1天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571154472000,"selfVisible":0,"shareDate":1571104895000,"shareUser":"深红骑士","superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"连载 | Android之Camera1实现相机开发","type":0,"userId":29303,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":75,"chapterName":"插件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9699,"link":"https://blog.csdn.net/huangliniqng/article/details/89643106","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154426000,"selfVisible":0,"shareDate":1571119742000,"shareUser":"Huanglinqing","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android Hook告诉你 如何启动未注册的Activity","type":0,"userId":31874,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":335,"chapterName":"应用内更新","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9703,"link":"https://juejin.im/post/5da491535188255a31329231","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154404000,"selfVisible":0,"shareDate":1571153479000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"【需求解决系列之四】Android App在线自动更新Library（V2.0）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9704,"link":"https://juejin.im/post/5d9d539ee51d45780f0604fa","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154375000,"selfVisible":0,"shareDate":1571153486000,"shareUser":"鸿洋","superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"看完这篇还不清楚缓存，求你打我（有彩蛋）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>编译的时候，我们经常遇到一些错误，比如 merge dex failed，很多时候是因为依赖冲突引起的：<\/p>\r\n<ol>\r\n<li>我们如何排查是否是依赖冲突引起的？<\/li>\r\n<li>对于依赖相同库的不同版本，我们该如何处理？<\/li>\r\n<li>对于依赖了不同的 sdk 里面，竟然有相同的类（包名也一致），这种伤脑筋的情况，我们又该怎么处理？<\/li>\r\n<\/ol>\r\n<p>本周1/1<\/p>","envelopePic":"","fresh":false,"id":9655,"link":"https://www.wanandroid.com/wenda/show/9655","niceDate":"1天前","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"","publishTime":1571153179000,"selfVisible":0,"shareDate":1570980274000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 哪些依赖相关的问题会导致编译失败，该如何处理？","type":0,"userId":2,"visible":1,"zan":7},{"apkLink":"","audit":1,"author":"soulqw","chapterId":383,"chapterName":"相机","collect":false,"courseId":13,"desc":"1.一行代码完成从系统相机拍照或者系统相册选择图片\r\n2.链式调用、配置灵活、方便理解\r\n3.支持多种图片压缩策略，并可自定义压缩程度\r\n4.支持Activity、Fragment,图片压缩异步处理自动绑定相关容器的生命周期\r\n5.完全基于Kotlin编写，与Java兼容","envelopePic":"https://www.wanandroid.com/blogimgs/0e390133-8048-4e8a-ae3f-dfbff7fa330e.png","fresh":false,"id":9679,"link":"https://www.wanandroid.com/blog/show/2688","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/soulqw/CoCo","publishTime":1571068703000,"selfVisible":0,"shareDate":1571068703000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=383"}],"title":"CoCo-一行代码为你从系统相机或者系统相册获取图片","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9663,"link":"https://juejin.im/post/5c8b1bd56fb9a049e12b1692","niceDate":"2天前","niceShareDate":"2019-10-14","origin":"","prefix":"","projectLink":"","publishTime":1571068635000,"selfVisible":0,"shareDate":1571013526000,"shareUser":"AprilEyon","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 高级开发面试题以及答案整理","type":0,"userId":3559,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":155,"chapterName":"SystemServer启动过程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9669,"link":"https://juejin.im/post/5da341f451882561ba64b9da","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068609000,"selfVisible":0,"shareDate":1571034037000,"shareUser":"秉心说___","superChapterId":171,"superChapterName":"framework","tags":[],"title":"Zygote家的大儿子 &mdash;&mdash; SystemServer","type":0,"userId":22057,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9676,"link":"https://www.jianshu.com/p/3ba0dee1732f?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068590000,"selfVisible":0,"shareDate":1571068381000,"shareUser":"鸿洋","superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"Android Camera旋转角度分析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":265,"chapterName":"反射","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9677,"link":"https://juejin.im/post/5da33b2351882509334fc0d3","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068576000,"selfVisible":0,"shareDate":1571068434000,"shareUser":"鸿洋","superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"大家都说 Java 反射效率低，你知道原因在哪里么","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":484,"chapterName":"okhttp","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9678,"link":"https://juejin.im/post/5da32c9a5188255aa15d4312","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068540000,"selfVisible":0,"shareDate":1571068496000,"shareUser":"鸿洋","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"android: 使用okhttp可能引发OOM的一个点","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"wuyr","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"搅拌咖啡下拉刷新动画","envelopePic":"https://www.wanandroid.com/blogimgs/355aed02-2076-41b6-aee1-5b8b0153e713.png","fresh":false,"id":9659,"link":"https://www.wanandroid.com/blog/show/2687","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/wuyr/CoffeeDrawable","publishTime":1570981610000,"selfVisible":0,"shareDate":1570981610000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"CoffeeDrawable（搅拌咖啡下拉刷新动画）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"yangpeixing","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"高仿小红书图片剪裁框架，高仿微信图片选择框架。两套框架完全支持UI自定义，可迅速实现类似马蜂窝、知乎等不同样式的选择器。本框架aar大小不超过300K，无so库，无任何第三方开源库。选择回调采用嵌入fragment方式替换原始ActivityResult+requestCode，使代码更加简洁，使调用更加方便。","envelopePic":"https://www.wanandroid.com/blogimgs/e2722d90-b2af-4238-836e-0d899c512a69.png","fresh":false,"id":9658,"link":"https://www.wanandroid.com/blog/show/2686","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/yangpeixing/YImagePicker","publishTime":1570981566000,"selfVisible":0,"shareDate":1570981566000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"小红书图片剪裁框架+微信图片选择器+超高清大图预览+自定义比例剪裁，支持UI自定义、支持跨进程回调","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"fairytale110","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"纯Kotlin实现的自定义选择器，浮动气球效果，界面清爽、API友好，采用Kotlin开发，库内已有demo","envelopePic":"https://www.wanandroid.com/blogimgs/70a86286-d316-409d-89e5-9fa926c72ea2.png","fresh":false,"id":9657,"link":"https://www.wanandroid.com/blog/show/2685","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/fairytale110/BalloonPicker","publishTime":1570981282000,"selfVisible":0,"shareDate":1570981282000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"Android 自定义控件之 气球选择器","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xing16","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"WanAndroid-Kotlin是基于 Kotlin + MVP + RxJava + OkHttp 实现好用好看的学习阅读类客户端, 包括首页，项目，体系，干货，搜索，收藏，妹子等功能","envelopePic":"https://www.wanandroid.com/blogimgs/b4714e97-deb4-4cd4-bf63-e365afe60189.png","fresh":false,"id":9656,"link":"https://www.wanandroid.com/blog/show/2684","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/xing16/WanAndroid-Kotlin","publishTime":1570981232000,"selfVisible":0,"shareDate":1570981232000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"Kotlin 实现美观好用的 WanAndroid 客户端","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":364,"size":20,"total":7269}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9727,"link":"https://juejin.im/post/5da6ce99f265da5ba532b6a8","niceDate":"14小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236379000,"selfVisible":0,"shareDate":1571213070000,"shareUser":"星星y","superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"【译】你的Android库是否还在Application中初始化？","type":0,"userId":15603,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":455,"chapterName":"反射","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9726,"link":"https://juejin.im/post/5da33b2351882509334fc0d3","niceDate":"14小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236353000,"selfVisible":0,"shareDate":1571209373000,"shareUser":"ZYLAB","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"大家都说 Java 反射效率低，你知道原因在哪里么","type":0,"userId":10577,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9729,"link":"https://www.jianshu.com/p/95deb46fba6a?utm_source=desktop&amp;utm_medium=timeline","niceDate":"14小时前","niceShareDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236340000,"selfVisible":0,"shareDate":1571236008000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android仿美团地址选择","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":9730,"link":"https://www.jianshu.com/p/ffb1cc684507?utm_source=desktop&amp;utm_medium=timeline","niceDate":"14小时前","niceShareDate":"14小时前","origin":"","prefix":"","projectLink":"","publishTime":1571236303000,"selfVisible":0,"shareDate":1571236130000,"shareUser":"鸿洋","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 面试经验 - 大厂 OPPO 面","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"lifeidroid","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"Flutter高仿玩Android客户端，适合新手学习练手用。","envelopePic":"https://www.wanandroid.com/blogimgs/1cd80531-67b7-46f2-8a3e-25bce4a57dff.png","fresh":false,"id":9705,"link":"https://www.wanandroid.com/blog/show/2689","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/lifeidroid/play_android","publishTime":1571154530000,"selfVisible":0,"shareDate":1571154530000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"仿玩Android客户端Flutter版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9689,"link":"https://juejin.im/post/5d6d1155e51d4561ea1a94a4","niceDate":"1天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571154472000,"selfVisible":0,"shareDate":1571104895000,"shareUser":"深红骑士","superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"连载 | Android之Camera1实现相机开发","type":0,"userId":29303,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":75,"chapterName":"插件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9699,"link":"https://blog.csdn.net/huangliniqng/article/details/89643106","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154426000,"selfVisible":0,"shareDate":1571119742000,"shareUser":"Huanglinqing","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android Hook告诉你 如何启动未注册的Activity","type":0,"userId":31874,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":335,"chapterName":"应用内更新","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9703,"link":"https://juejin.im/post/5da491535188255a31329231","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154404000,"selfVisible":0,"shareDate":1571153479000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"【需求解决系列之四】Android App在线自动更新Library（V2.0）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9704,"link":"https://juejin.im/post/5d9d539ee51d45780f0604fa","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1571154375000,"selfVisible":0,"shareDate":1571153486000,"shareUser":"鸿洋","superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"看完这篇还不清楚缓存，求你打我（有彩蛋）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>编译的时候，我们经常遇到一些错误，比如 merge dex failed，很多时候是因为依赖冲突引起的：<\/p>\r\n<ol>\r\n<li>我们如何排查是否是依赖冲突引起的？<\/li>\r\n<li>对于依赖相同库的不同版本，我们该如何处理？<\/li>\r\n<li>对于依赖了不同的 sdk 里面，竟然有相同的类（包名也一致），这种伤脑筋的情况，我们又该怎么处理？<\/li>\r\n<\/ol>\r\n<p>本周1/1<\/p>","envelopePic":"","fresh":false,"id":9655,"link":"https://www.wanandroid.com/wenda/show/9655","niceDate":"1天前","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"","publishTime":1571153179000,"selfVisible":0,"shareDate":1570980274000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 哪些依赖相关的问题会导致编译失败，该如何处理？","type":0,"userId":2,"visible":1,"zan":7},{"apkLink":"","audit":1,"author":"soulqw","chapterId":383,"chapterName":"相机","collect":false,"courseId":13,"desc":"1.一行代码完成从系统相机拍照或者系统相册选择图片\r\n2.链式调用、配置灵活、方便理解\r\n3.支持多种图片压缩策略，并可自定义压缩程度\r\n4.支持Activity、Fragment,图片压缩异步处理自动绑定相关容器的生命周期\r\n5.完全基于Kotlin编写，与Java兼容","envelopePic":"https://www.wanandroid.com/blogimgs/0e390133-8048-4e8a-ae3f-dfbff7fa330e.png","fresh":false,"id":9679,"link":"https://www.wanandroid.com/blog/show/2688","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/soulqw/CoCo","publishTime":1571068703000,"selfVisible":0,"shareDate":1571068703000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=383"}],"title":"CoCo-一行代码为你从系统相机或者系统相册获取图片","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9663,"link":"https://juejin.im/post/5c8b1bd56fb9a049e12b1692","niceDate":"2天前","niceShareDate":"2019-10-14","origin":"","prefix":"","projectLink":"","publishTime":1571068635000,"selfVisible":0,"shareDate":1571013526000,"shareUser":"AprilEyon","superChapterId":195,"superChapterName":"热门专题","tags":[],"title":"Android 高级开发面试题以及答案整理","type":0,"userId":3559,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":155,"chapterName":"SystemServer启动过程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9669,"link":"https://juejin.im/post/5da341f451882561ba64b9da","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068609000,"selfVisible":0,"shareDate":1571034037000,"shareUser":"秉心说___","superChapterId":171,"superChapterName":"framework","tags":[],"title":"Zygote家的大儿子 &mdash;&mdash; SystemServer","type":0,"userId":22057,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":95,"chapterName":"相机Camera","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9676,"link":"https://www.jianshu.com/p/3ba0dee1732f?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068590000,"selfVisible":0,"shareDate":1571068381000,"shareUser":"鸿洋","superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"Android Camera旋转角度分析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":265,"chapterName":"反射","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9677,"link":"https://juejin.im/post/5da33b2351882509334fc0d3","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068576000,"selfVisible":0,"shareDate":1571068434000,"shareUser":"鸿洋","superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"大家都说 Java 反射效率低，你知道原因在哪里么","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":484,"chapterName":"okhttp","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9678,"link":"https://juejin.im/post/5da32c9a5188255aa15d4312","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1571068540000,"selfVisible":0,"shareDate":1571068496000,"shareUser":"鸿洋","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"android: 使用okhttp可能引发OOM的一个点","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"wuyr","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"搅拌咖啡下拉刷新动画","envelopePic":"https://www.wanandroid.com/blogimgs/355aed02-2076-41b6-aee1-5b8b0153e713.png","fresh":false,"id":9659,"link":"https://www.wanandroid.com/blog/show/2687","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/wuyr/CoffeeDrawable","publishTime":1570981610000,"selfVisible":0,"shareDate":1570981610000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"CoffeeDrawable（搅拌咖啡下拉刷新动画）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"yangpeixing","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"高仿小红书图片剪裁框架，高仿微信图片选择框架。两套框架完全支持UI自定义，可迅速实现类似马蜂窝、知乎等不同样式的选择器。本框架aar大小不超过300K，无so库，无任何第三方开源库。选择回调采用嵌入fragment方式替换原始ActivityResult+requestCode，使代码更加简洁，使调用更加方便。","envelopePic":"https://www.wanandroid.com/blogimgs/e2722d90-b2af-4238-836e-0d899c512a69.png","fresh":false,"id":9658,"link":"https://www.wanandroid.com/blog/show/2686","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/yangpeixing/YImagePicker","publishTime":1570981566000,"selfVisible":0,"shareDate":1570981566000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"小红书图片剪裁框架+微信图片选择器+超高清大图预览+自定义比例剪裁，支持UI自定义、支持跨进程回调","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"fairytale110","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"纯Kotlin实现的自定义选择器，浮动气球效果，界面清爽、API友好，采用Kotlin开发，库内已有demo","envelopePic":"https://www.wanandroid.com/blogimgs/70a86286-d316-409d-89e5-9fa926c72ea2.png","fresh":false,"id":9657,"link":"https://www.wanandroid.com/blog/show/2685","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/fairytale110/BalloonPicker","publishTime":1570981282000,"selfVisible":0,"shareDate":1570981282000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"Android 自定义控件之 气球选择器","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xing16","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"WanAndroid-Kotlin是基于 Kotlin + MVP + RxJava + OkHttp 实现好用好看的学习阅读类客户端, 包括首页，项目，体系，干货，搜索，收藏，妹子等功能","envelopePic":"https://www.wanandroid.com/blogimgs/b4714e97-deb4-4cd4-bf63-e365afe60189.png","fresh":false,"id":9656,"link":"https://www.wanandroid.com/blog/show/2684","niceDate":"2019-10-13","niceShareDate":"2019-10-13","origin":"","prefix":"","projectLink":"https://github.com/xing16/WanAndroid-Kotlin","publishTime":1570981232000,"selfVisible":0,"shareDate":1570981232000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"Kotlin 实现美观好用的 WanAndroid 客户端","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 364
         * size : 20
         * total : 7269
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author :
             * chapterId : 198
             * chapterName : 基础概念
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : true
             * id : 9727
             * link : https://juejin.im/post/5da6ce99f265da5ba532b6a8
             * niceDate : 14小时前
             * niceShareDate : 20小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1571236379000
             * selfVisible : 0
             * shareDate : 1571213070000
             * shareUser : 星星y
             * superChapterId : 168
             * superChapterName : 基础知识
             * tags : []
             * title : 【译】你的Android库是否还在Application中初始化？
             * type : 0
             * userId : 15603
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private int audit;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int selfVisible;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(int selfVisible) {
                this.selfVisible = selfVisible;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
