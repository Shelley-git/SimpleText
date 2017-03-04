package com.zhuoxin.simpletext.webView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.zhuoxin.simpletext.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://ai.taobao.com/?pid=mm_33597634_3422071_31742049");
        //设置视图
        setContentView(webView);
    }

    //没有这个方法的话，那么点击返回按钮，就直接返回主页
    //这个方法就是，页面一个一个的返回
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode ==KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return false;
    }
}
