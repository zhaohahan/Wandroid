package com.mr.tengyu.wandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    private BaseActivity mBaseActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 防止别的activity 没有 extends BaseActivity
        Activity activity = getActivity();
        if(activity instanceof BaseActivity){
            mBaseActivity = (BaseActivity) activity;
        }

    }

  /*  *//**
     * 获取 daosession
     * @return
     *//*
    public DaoSession getDaoSession(){
        if(mBaseActivity != null){
            return mBaseActivity.getDaoSession();
        }else{
            if(getActivity() == null){
                return null;
            }
            return  ((ZhiHuApplication)getActivity().getApplication()).getDaoSession();

        }
    }

*/
    public void showToast(@NonNull String msg){

        if(getContext() != null){
            Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
        }

    }
    public void showToast(@StringRes int resId){
        if(getContext() != null){
            Toast.makeText(getContext(), resId, Toast.LENGTH_LONG).show();
        }
    }
}
