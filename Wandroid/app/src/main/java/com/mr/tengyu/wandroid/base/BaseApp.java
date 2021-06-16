package com.mr.tengyu.wandroid.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by asus on 2019/3/18.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
    }


    public static BaseApp getInstance() {
        return sBaseApp;
    }
    public void hideKeyBoard(Object object) {
        if (null == object) return;
        if (object instanceof Activity) {
            Activity activity = (Activity) object;
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } else if (object instanceof EditText) {
            EditText edit = (EditText) object;
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edit.getWindowToken(), 0); //强制隐藏键盘
        }
    }
}
