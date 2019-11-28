package com.mr.tengyu.wandroid.ui.my.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.ui.my.register.RegisterActivity;
import com.mr.tengyu.wandroid.utils.AppSharePreference;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView finish;
    private Button login;
    private TextView register;
    private TextView kong;
    private EditText user_name;
    private EditText password;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        initView ( );
    }

    private void initView() {

        finish = (ImageView) findViewById ( R.id.cannel_login );
        finish.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                finish ( );
            }
        } );
        login = (Button) findViewById ( R.id.login );
        register = (TextView) findViewById ( R.id.register );
        login.setOnClickListener ( this );
        register.setOnClickListener ( this );
        user_name = (EditText) findViewById ( R.id.user_name );
        password = (EditText) findViewById ( R.id.password );
        cb = (CheckBox) findViewById ( R.id.cb );
        cb.setOnClickListener ( this );
        SharedPreferences sp = getSharedPreferences ( "use", MODE_PRIVATE );
        if (sp.getBoolean ( "ISCHECK", false )  ){
            String name = sp.getString ( "name", "" );
            String pswa = sp.getString ( "psw", "" );
            user_name.setText ( name );
            password.setText ( pswa );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.login:
                submit();

                finish();
                break;
            case R.id.register:
                Intent intent = new Intent ( this, RegisterActivity.class );
                startActivityForResult ( intent ,2);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult ( requestCode, resultCode, intent );
        if (requestCode== 1 & resultCode==2){
            String name = intent.getStringExtra ( "na" );
            String psw = intent.getStringExtra ( "ps" );
            user_name.setText ( name );
            password.setText ( psw );
        }

    }

    private void submit() {
        // validate
        String usenameString = user_name.getText ( ).toString ( ).trim ( );
        if (TextUtils.isEmpty ( usenameString )) {
            Toast.makeText ( this, "  账号", Toast.LENGTH_SHORT ).show ( );
            return;
        }

        String pswString = password.getText ( ).toString ( ).trim ( );
        if (TextUtils.isEmpty ( pswString )) {
            Toast.makeText ( this, "  密码", Toast.LENGTH_SHORT ).show ( );
            return;
        }
        SharedPreferences sp = getSharedPreferences ( "use", MODE_PRIVATE );
        SharedPreferences.Editor edit = sp.edit ( );
        if (cb.isChecked ()){
            edit.putString ( "name",usenameString );
            edit.putString ( "psw" ,pswString);
            edit.putBoolean ( "ISCHECK",true );
            edit.commit ();
        }
        EventBus.getDefault ().postSticky ( usenameString );
        AppSharePreference.put(this,"success",true);
    }
}
