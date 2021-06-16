package com.mr.tengyu.wandroid.ui.start;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.ui.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button jump;
    private int i = 0;
    private int TIME = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_start );
        initView ( );

        timer.schedule(task, 1000, 1000); // 1s后执行task,经过1s再次执行

    }


   private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                jump.setText(Integer.toString(i++));
            }
            super.handleMessage(msg);
        };
    };
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            // 需要做的事:发送消息
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    private void initView() {
        jump = (Button) findViewById ( R.id.jump );

        jump.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.jump:
                Intent intent = new Intent ( StartActivity.this, MainActivity.class );
                startActivity ( intent );
                break;
        }
    }
}
