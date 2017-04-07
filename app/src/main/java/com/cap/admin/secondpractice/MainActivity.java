package com.cap.admin.secondpractice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cap.admin.secondpractice.practice.BBB;
import com.cap.admin.secondpractice.practice.FragmentFive;
import com.cap.admin.secondpractice.practice.FragmentFour;
import com.cap.admin.secondpractice.practice.FragmentSix;
import com.cap.admin.secondpractice.practice.FragmentThree;

public class MainActivity extends AppCompatActivity implements BBB{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle abdt;
    LinearLayout r1,r2,r3;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.sp_myTools);
        drawerLayout= (DrawerLayout) findViewById(R.id.sp_drLa);

        r1= (LinearLayout) findViewById(R.id.first_ye);
        r2= (LinearLayout) findViewById(R.id.second);
        r3= (LinearLayout) findViewById(R.id.three);


        setSupportActionBar(toolbar);//绑定activity
        toolbar.setNavigationIcon(R.drawable.item_drawe);
        toolbar.setTitle("主页");
//        toolbar.setTitle("第一页");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"ic_launcher",Toast.LENGTH_SHORT).show();
            }
        });
//        toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.img));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.sp_one:
                        Toast.makeText(MainActivity.this,"a",Toast.LENGTH_SHORT).show();
                        break;
                    case  R.id.sp_two:
                        Toast.makeText(MainActivity.this,"b",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



        //加了ActionBarDrawerToggle后NavigationIcon的点击事件全部失效
        abdt=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);//与drawerLayout和toolbar绑定
        //强行把NavigationIcon变成三条杠和箭头，NavigationIcon的点击事件全部失效
        // 系统样式不能改，可以用NavigationIcon代替，不写下面的代码
//        abdt.syncState();//初始化
//        drawerLayout.addDrawerListener(abdt);//与drawerLayout绑定
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
//                if(slideOffset>0){
//                    toolbar.setNavigationIcon(R.mipmap.image_h);
//                }else {
//                    toolbar.setNavigationIcon(R.mipmap.image_huaji);
//                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                toolbar.setNavigationIcon(R.mipmap.image_h);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                toolbar.setNavigationIcon(R.mipmap.image_huaji);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        //碎片管理器
        fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        final FragmentThree fragmentThree=new FragmentThree();
        final FragmentFour fragmentFour=new FragmentFour();
        final FragmentFive fragmentFive=new FragmentFive();
        final FragmentSix fragmentSix=new FragmentSix();
        ft.add(R.id.sp_main_drLa,fragmentThree);
        ft.add(R.id.sp_main_drLa,fragmentFour);
        ft.add(R.id.sp_main_drLa,fragmentFive);
        ft.add(R.id.sp_main_drLa,fragmentSix);
        //隐藏碎片
        ft.hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
        ft.show(fragmentSix);
        ft.commit();

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("第一页");
                FragmentTransaction ft=fm.beginTransaction();
                ft.hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
                AAA a=fragmentThree;
                a.sss("QwQ");
                ft.show(fragmentThree);
                ft.commit();
                drawerLayout.closeDrawers();
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("第二页");
                FragmentTransaction ft=fm.beginTransaction();
                ft.hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
//                ft.show(fragmentFour);
                AAA a=fragmentThree;
                a.sss("第二页");
                ft.show(fragmentThree);
                ft.commit();
                drawerLayout.closeDrawers();
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("第三页");
                FragmentTransaction ft=fm.beginTransaction();
                ft.hide(fragmentThree).hide(fragmentFour).hide(fragmentFive).hide(fragmentSix);
//                ft.show(fragmentFive);
                AAA a=fragmentThree;
                a.sss("第三页");
                ft.show(fragmentThree);
                ft.commit();
                drawerLayout.closeDrawers();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sp_toolsbar,menu);
        return true;
    }

    @Override
    public void showTime(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    public interface AAA{
        void sss(String str);
    }

}
