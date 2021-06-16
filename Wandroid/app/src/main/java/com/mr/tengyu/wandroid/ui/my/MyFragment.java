package com.mr.tengyu.wandroid.ui.my;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.ui.my.login.LoginActivity;
import com.mr.tengyu.wandroid.utils.AppSharePreference;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener {


    private ImageView imageView;
    private TextView me_name;
    private TextView me_info;
    private TextView me_integral;
    private LinearLayout me_integralLinear;
    private LinearLayout me_collect;
    private LinearLayout me_article;
    private LinearLayout me_todo;
    private LinearLayout me_about;
    private LinearLayout me_join;
    private LinearLayout me_setting;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_my, container, false );
        initView ( inflate );
            EventBus.getDefault ( ).register ( this );

        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void asd(String a) {
        me_name.setText ( a );
    }

    @Override
    public void onDestroy() {
        super.onDestroy ( );
        EventBus.getDefault ( ).unregister ( this );
    }

    private void initView(View inflate) {
        imageView = inflate.findViewById ( R.id.imageView );
        me_name = inflate.findViewById ( R.id.me_name );
        me_info = inflate.findViewById ( R.id.me_info );
        me_integral = inflate.findViewById ( R.id.me_integral );
        me_integralLinear = inflate.findViewById ( R.id.me_integralLinear );
        me_collect = inflate.findViewById ( R.id.me_collect );
        me_article = inflate.findViewById ( R.id.me_article );
        me_todo = inflate.findViewById ( R.id.me_todo );
        me_about = inflate.findViewById ( R.id.me_about );
        me_join = inflate.findViewById ( R.id.me_join );
        me_setting = inflate.findViewById ( R.id.me_setting );

        imageView.setOnClickListener ( this );
        me_name.setOnClickListener ( this );
        me_info.setOnClickListener ( this );
        me_integralLinear.setOnClickListener ( this );
        me_collect.setOnClickListener ( this );
        me_article.setOnClickListener ( this );
        me_todo.setOnClickListener ( this );
        me_about.setOnClickListener ( this );
        me_join.setOnClickListener ( this );
        me_setting.setOnClickListener ( this );


    }


    @Override
    public void onClick(View v) {
        Boolean success = (Boolean) AppSharePreference.get ( getContext ( ), "success", false );
        int id = v.getId ( );
        switch (id) {
            //上传头像
            case R.id.imageView:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //用户名
            case R.id.me_name:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {
                    Toast.makeText ( getContext ( ), me_name.getText ( ).toString ( ), Toast.LENGTH_SHORT ).show ( );
                } else {

                    intent ( );
                }
                break;
            //排名
            case R.id.me_info:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {
                    Toast.makeText ( getContext ( ), me_info.getText ( ).toString ( ), Toast.LENGTH_SHORT ).show ( );
                } else {

                    intent ( );
                }
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //我的积分
            case R.id.me_integralLinear:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //我的收藏
            case R.id.me_collect:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //我的文章
            case R.id.me_article:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //代办清单
            case R.id.me_todo:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //开源中国
            case R.id.me_about:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //加入我们
            case R.id.me_join:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );
                }
                break;
            //设置
            case R.id.me_setting:
                if (!me_name.getText ( ).toString ( ).equals ( "请先登录~" ) && success) {

                } else {

                    intent ( );

                }
                break;


        }

    }

    private void intent() {
        Intent intent = new Intent ( getActivity ( ), LoginActivity.class );
        startActivity ( intent );
    }


}
