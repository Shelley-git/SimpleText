package com.zhuoxin.simpletext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_FragmentOne)
    Button btn_FragmentOne;
    @BindView(R.id.btn_FragmentTwo)
    Button btn_FragmentTwo;
    @BindView(R.id.Fragment)
    FrameLayout Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
}
