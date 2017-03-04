package com.zhuoxin.simpletext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zhuoxin.simpletext.url.HttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HttpActivity extends AppCompatActivity {

    @BindView(R.id.iv_http)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        ButterKnife.bind(this);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.HttpUtils(imageView);
            }
        });
        thread.start();
    }
}
