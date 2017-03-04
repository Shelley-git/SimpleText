package com.zhuoxin.simpletext.Intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.zhuoxin.simpletext.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentActivity extends AppCompatActivity {

    @BindView(R.id.activity_intent)
    RelativeLayout activityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        ButterKnife.bind(this);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
//        } else {
//            callPhone();
//        }



        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
            callPhone();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    callPhone();
                }
                break;
        }
    }

    private void callPhone() {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+88888));
        startActivity(intent);


    }


    //    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case 1:
//                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    callPhone();
//                }
//                break;
//        }
//    }
//
//    private void callPhone() {
//        Intent intent = new Intent();
//        intent.setAction(intent.ACTION_CALL);
//        intent.setData(Uri.parse("tel:" + 10086));
//        startActivity(intent);
//    }

}
