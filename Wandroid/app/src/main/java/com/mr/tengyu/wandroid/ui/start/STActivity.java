package com.mr.tengyu.wandroid.ui.start;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.ui.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class STActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private int count = 2;
    private Handler handler = new Handler ( new Handler.Callback ( ) {
        @Override
        public boolean handleMessage(Message msg) {
            int count = msg.arg1;

            if (count == 0) {
                Intent intent = new Intent ( STActivity.this, MainActivity.class );
                startActivity ( intent );
                finish();
                timer.cancel ( );
            } else {
                btn.setText ( "" + count );
            }
            return false;
        }
    } );
    private Timer timer;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_st );
        initView ( );
        iniData ( );
    }

    private void iniData() {
        runOnUiThread ( new Runnable ( ) {
            @Override
            public void run() {
                timer = new Timer ( );
                TimerTask timerTask = new TimerTask ( ) {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage ( );
                        message.arg1 = count;
                        if (count != -1) {
                            count--;
                        } else {
                            return;
                        }

                        handler.sendMessage ( message );
                    }
                };
                timer.schedule ( timerTask, 1000, 1000 );
            }
        } );

        //Glide.with ( this ).load ( R.drawable.a ).into ( video );
        video.setVideoURI( Uri.parse("android.resource://com.mr.tengyu.wandroid/" + R.raw.cc_1));
         video.start();
     }

    private void initView() {
        btn = (Button) findViewById ( R.id.btn );
        btn.setOnClickListener ( this );
        video = (VideoView) findViewById ( R.id.video );
        video.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.btn:
                //点击跳转项目首页
                Intent intent = new Intent ( STActivity.this, MainActivity.class );
                startActivity ( intent );
                break;
        }
    }
}
