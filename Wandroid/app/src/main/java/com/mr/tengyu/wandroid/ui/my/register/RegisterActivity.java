package com.mr.tengyu.wandroid.ui.my.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mr.tengyu.wandroid.R;

import org.greenrobot.eventbus.EventBus;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_name_register;
    private EditText password_register;
    private Button login_register;
    private EditText password1;
    private ImageView cannel_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
        initView ( );
    }

    private void initView() {
        user_name_register = (EditText) findViewById ( R.id.user_name_register );
        password_register = (EditText) findViewById ( R.id.password_register );
        login_register = (Button) findViewById ( R.id.login_register );
        password1 = (EditText) findViewById ( R.id.password1 );
        password1.setOnClickListener ( this );
        cannel_regist = (ImageView) findViewById ( R.id.cannel_regist );
        cannel_regist.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.login_register:
                submit ( );
                break;
        }
    }


    private void submit() {
        // validate
        String registerName = user_name_register.getText ( ).toString ( ).trim ( );
        if (TextUtils.isEmpty ( registerName )) {
            Toast.makeText ( this, "  账号", Toast.LENGTH_SHORT ).show ( );
            return;
        }

        String register_psw = password_register.getText ( ).toString ( ).trim ( );
        if (TextUtils.isEmpty ( register_psw )) {
            Toast.makeText ( this, "  密码", Toast.LENGTH_SHORT ).show ( );
            return;
        }

        // TODO validate success, do something

        String pswString = password1.getText ( ).toString ( ).trim ( );
        if (TextUtils.isEmpty ( pswString )) {
            Toast.makeText ( this, "  密码", Toast.LENGTH_SHORT ).show ( );
            return;
        }
        if (register_psw.equals ( pswString )) {
            SharedPreferences sp = getSharedPreferences ( "use", MODE_PRIVATE );
            SharedPreferences.Editor edit = sp.edit ( );
            edit.putString ( "name", registerName );
            edit.putString ( "psw", pswString );
            edit.putBoolean ( "ISCHECK", true );
            edit.commit ( );
            Toast.makeText ( this, "注册成功", Toast.LENGTH_SHORT ).show ( );
            Intent intent = getIntent ( );
            intent.putExtra ( "na", registerName );
            intent.putExtra ( "ps", pswString );
            setResult ( 2, intent );
            finish ( );

        } else {
            Toast.makeText ( this, "两次密码不一致，请重新输入密码", Toast.LENGTH_SHORT ).show ( );
            password_register.setText ( null );
            password1.setText ( null );
        }


    }

}
