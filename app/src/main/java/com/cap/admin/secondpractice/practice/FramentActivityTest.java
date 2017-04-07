package com.cap.admin.secondpractice.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2016/12/21.
 */
public class FramentActivityTest extends AppCompatActivity {
    FragmentManager fm;//管理器
    Button button,btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_act_test);

        button= (Button) findViewById(R.id.frag_act_test_btn);
        btn= (Button) findViewById(R.id.frag_act_test_btn2);
        fm=getSupportFragmentManager();//得到管理器
         FragmentTransaction ft=fm.beginTransaction();//开启事务
        final FragmentTest fragmentTest=new FragmentTest();
        final FragmentThree fragThree=new FragmentThree();
        ft.add(R.id.frag_act_test_rl,fragmentTest);//添加进事务，这里都用的是同一个事务
        ft.add(R.id.frag_act_test_rl,fragThree);
        ft.hide(fragmentTest).hide(fragThree);//隐藏fragment
        ft.show(fragmentTest);//显示fragment
        ft.commit();//提交
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=fm.beginTransaction();//重新声明
                ft.hide(fragmentTest).hide(fragThree);
                ft.show(fragmentTest);
//                ft.replace(R.id.frag_act_test_rl,fragmentTest);
                ft.commit();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=fm.beginTransaction();
                ft.hide(fragmentTest).hide(fragThree);
                ft.show(fragThree);
                ft.commit();
            }
        });


        Log.i("msg", "Activity创建");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("msg", "Activity启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("msg", "Activity运行");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("msg", "Activity暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("msg", "Activity停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("msg", "Activity销毁");
    }
}
