package com.mr.tengyu.wandroid.base;

import android.os.Environment;

import java.io.File;

/**
 * Created by asus on 2019/3/18.
 */

public interface Constants {

    String DATA = "data";

    boolean isDebug = true;
    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
}
