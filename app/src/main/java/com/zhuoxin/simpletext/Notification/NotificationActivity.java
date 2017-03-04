package com.zhuoxin.simpletext.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zhuoxin.simpletext.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.btn_notification)
    Button btn_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification=new  NotificationCompat.Builder(NotificationActivity.this)
                        .setContentTitle("通知")
                        .setContentText("天猫超市大促销，全场买200送199")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                notificationManager.notify(1,notification);
            }
        });

    }
}
