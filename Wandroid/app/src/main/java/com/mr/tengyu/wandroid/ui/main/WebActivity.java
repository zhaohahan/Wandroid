package com.mr.tengyu.wandroid.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.utils.Logger;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_web );
        initView ( );

    }

    private void initView() {
        web = (WebView) findViewById ( R.id.web );
        web.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent ( );
        String link  = intent.getStringExtra ( "link" );
        Logger.logD ( "url",link );
        web.setWebViewClient ( new WebViewClient () );
        web.loadUrl(link);
     }
}
