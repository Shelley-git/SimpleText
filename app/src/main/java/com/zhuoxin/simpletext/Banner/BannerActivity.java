package com.zhuoxin.simpletext.Banner;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.ExtractedText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuoxin.simpletext.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/*
    轮播图
 */
public class BannerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private List<ImageView> imageViews;//存放图片的集合
    //存放文字描述的集合
    private String[] titles = new String[]{
            "黄垚", "吴鑫", "叫我索大人"
    };

    private List<View> dots;//存放小点点的集合
    private TextView title;//图片的标题
    //存放图片id的集合
    private int[] imageIds = new int[]{
            R.drawable.aaa,
            R.drawable.bb,
            R.drawable.cc,
    };

    private int oldPosition;
    private ScheduledExecutorService scheduledExecutorService;
    private int currentItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        mViewPager = (ViewPager) findViewById(R.id.vp);

        //显示图片的集合
        imageViews = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViews.add(imageView);
        }

        //显示小点点的集合
        dots = new ArrayList<>();
        dots.add(findViewById(R.id.dot_0));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_1));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_2));//单行复制 ctrl + d
        dots.get(oldPosition).setBackgroundResource(R.drawable.dot_focesed);

        title = (TextView) findViewById(R.id.tv);//显示图片标题
        title.setText(titles[0]);

        mAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mAdapter);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_focesed);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                oldPosition=position;   //再次变化时，position变为久的oldposition
                currentItem=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),2,2, TimeUnit.SECONDS);
    }

    private class ViewPagerTask implements Runnable{
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            handler.sendEmptyMessage(0);
        }

    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPager.setCurrentItem(currentItem);
        }
    };


    private class ViewPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
