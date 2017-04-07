package com.cap.admin.secondpractice.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cap.admin.secondpractice.Fragment.TestFragment;
import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/3/30.
 */
public class BottomNavBarTestActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNav;
    private RelativeLayout replaceLay;
    private FragmentManager fm;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        fm = getSupportFragmentManager();

        initView();
        toolbar.setTitle("asdf");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setView() {

        toolbar.setBackgroundResource(R.color.test);
        bottomNav.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNav.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNav.setActiveColor(R.color.test);
        bottomNav.addItem(new BottomNavigationItem(R.mipmap.home_def, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.form_def, "报修"))
                .addItem(new BottomNavigationItem(R.mipmap.phone_def, "联系"))
                .addItem(new BottomNavigationItem(R.mipmap.me_def, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNav.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction ft = fm.beginTransaction();
                TestFragment ts = new TestFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", position + "");
                ts.setArguments(bundle);
                ft.replace(R.id.replace_lay, ts);
                ft.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void initView() {

        bottomNav = (BottomNavigationBar) findViewById(R.id.bottom_nav);
        replaceLay = (RelativeLayout) findViewById(R.id.replace_lay);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}
