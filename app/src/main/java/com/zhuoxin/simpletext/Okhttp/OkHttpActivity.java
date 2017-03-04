package com.zhuoxin.simpletext.Okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhuoxin.simpletext.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    @BindView(R.id.btn_okHttp)
    Button btn_okHttp;
    @BindView(R.id.tv_okHttp)
    TextView tv_okHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
        btn_okHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestOkHttp();
            }
        });
    }

    public void requestOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request request=new Request.Builder().url("http://hao.826826.com/").build();
                    Response response=okHttpClient.newCall(request).execute();
                    String data = response.body().string();
                    showData(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showData(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_okHttp.setText(response);
            }
        });

    }
}
