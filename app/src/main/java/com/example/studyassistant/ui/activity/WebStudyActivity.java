package com.example.studyassistant.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.studyassistant.R;

import static com.example.studyassistant.utils.APIManager.COURSERA_URL;
import static com.example.studyassistant.utils.APIManager.IMOOC_URL;
import static com.example.studyassistant.utils.APIManager.MOOC_URL;
import static com.example.studyassistant.utils.APIManager.TENXUNKETANG_URL;
import static com.example.studyassistant.utils.APIManager.WANGYIYUN_URL;
import static com.example.studyassistant.utils.APIManager.XUETANG_URL;

public class WebStudyActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_study);
        setView();
    }
    private void setView(){
        webview = (WebView) findViewById(R.id.webStudy);
        Bundle bundle = this.getIntent().getExtras();
        String url = bundle.getString("url");
        switch (url){
            case "mooc": webview.loadUrl(MOOC_URL);break;
            case "imooc": webview.loadUrl(IMOOC_URL);break;
            case "tenxunketang": webview.loadUrl(TENXUNKETANG_URL);break;
            case "coursera": webview.loadUrl(COURSERA_URL);break;
            case "wangyiyun": webview.loadUrl(WANGYIYUN_URL);break;
            case "xuetang": webview.loadUrl(XUETANG_URL);break;
        }


        webview.setWebViewClient(new WebViewClient(){
        });

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //get the newProgress and refresh progress bar
            }
        });

        //启用支持javascript
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(webview.canGoBack()&&keyCode==KeyEvent.KEYCODE_BACK){
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
