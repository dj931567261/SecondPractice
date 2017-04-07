package com.cap.admin.secondpractice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cap.admin.secondpractice.R;

/**
 * @author 邓杰
 * @version 1.0
 * @description 请输入
 * @created 2017/4/7.
 */
public class ViewPagerTestActivity extends AppCompatActivity {
    private ViewPager vp;
    private PagerAdapter adapter;
    int img[]={R.mipmap.img8,R.mipmap.img18,R.mipmap.img22,R.mipmap.img53};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp_test);
        //间距
        vp.setPageMargin(20);
        //设置缓存数量
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter=new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view=new ImageView(ViewPagerTestActivity.this);
                view.setImageResource(img[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return img.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
    }
}
