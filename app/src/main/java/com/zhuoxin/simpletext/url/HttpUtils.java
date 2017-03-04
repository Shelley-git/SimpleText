package com.zhuoxin.simpletext.url;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/2/25.
 */

public class HttpUtils {
//    public static void HttpUtils(final ImageView imageView){
//        try {
//            URL url=new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488599230&di=2c24bce31d60f03292b08468530764ef&imgtype=jpg&er=1&src=http%3A%2F%2Fdesk.3987.com%2Fuploadfile%2F2015%2F0105%2F20150105043021703.jpg");
//            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//            connection.setConnectTimeout(3000);
//            connection.setReadTimeout(3000);
//            int responseCode = connection.getResponseCode();
//            if (responseCode==200){
//                InputStream inputStream=connection.getInputStream();
//                final Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
//                imageView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void HttpUtils(final ImageView imageView){
        try {
            URL url=new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488020052881&di=de09639c92cad0d200cc06fa58170bcc&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201605%2F01%2F20160501171647_sCPyt.jpeg");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            if (connection.getResponseCode()==200){
                InputStream inputStream=connection.getInputStream();
                final Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
