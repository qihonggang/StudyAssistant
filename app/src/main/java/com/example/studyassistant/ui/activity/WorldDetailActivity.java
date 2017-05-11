package com.example.studyassistant.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.studyassistant.R;
import com.example.studyassistant.utils.APIManager;


public class WorldDetailActivity extends AppCompatActivity {


    WebView webview;
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worlddetail);
        
        setupViews();
    }

    private void setupViews() {

        webview = (WebView) findViewById(R.id.webView);
        iv = (ImageView) findViewById(R.id.img);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //开始加载界面
                //隐藏webView,显示动画
                webview.setVisibility(View.GONE);
                iv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //显示webView,隐藏动画
                webview.setVisibility(View.VISIBLE);
                iv.setVisibility(View.GONE);
            }
        });

        webview.setWebChromeClient(new WebChromeClient());
        //加载数据
        webview.loadUrl(APIManager.WORLD_DETAIL);
    }
}
