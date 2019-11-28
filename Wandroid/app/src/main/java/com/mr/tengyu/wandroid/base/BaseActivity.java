package com.mr.tengyu.wandroid.base;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {
  /*  protected ZhiHuApplication mZhiHuApplication;*/
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
       /* mZhiHuApplication = (ZhiHuApplication) getApplication();*/
    }


/*
    */
/**
     * 获取 daosession
     * @return
     *//*

    public DaoSession getDaoSession(){
        return mZhiHuApplication.getDaoSession();
    }
*/


    public void showToast(@NonNull String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    public void showToast(@StringRes int resId){
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    // 封装公共的添加Fragment的方法
    public void addFragment(Class<? extends BaseFragment> zClass, int layoutId, Bundle bundle){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        String tag =  zClass.getName();

        // 从 fragmentManager中查找这个fragment是否存在，
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);

        if(fragment != null){ // 如果存在就不用重新创建
            if(fragment.isAdded()){ // 如果 fragment 已经被添加
                if(fragment.isHidden()){ // 如果fragment 已经被添加，并且处于隐藏状态，那么显示
                    fragment.setArguments(bundle);// 设置参数
                    transaction.show(fragment); // 显示 fragment

                    hideOtherPage(transaction,fragment); // 隐藏其他fragment
                }
            }else{ // 如果 fragment存在，但是没有被添加到activity，那么执行下面添加，（这种一般发生在activity 横竖屏切换）
                fragment.setArguments(bundle);// 设置参数
                transaction.add(layoutId, fragment);
                hideOtherPage(transaction, fragment);
            }
        }else{
            // 如果没有从fragmentManager 中通过tag 找到fragment,那么创建一个新的fragment 实例
            try {
                fragment = zClass.newInstance();
                fragment.setArguments(bundle); // 设置参数
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if(fragment != null){

                transaction.add(layoutId, fragment,tag);
                hideOtherPage(transaction, fragment);

            }
        }



        transaction.commit();
    }


    // 隐藏除了将要显示的fragment 以外的其他所有fragment
    private void hideOtherPage(FragmentTransaction transaction, Fragment willShowFragment){

        List<Fragment> fragments =  mFragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != willShowFragment){
                transaction.hide(fragment);
            }
        }

    }
}
