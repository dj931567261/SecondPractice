package com.cap.admin.secondpractice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cap.admin.secondpractice.R;
import com.cap.admin.secondpractice.Tools.MineView;

/**
 * Created by admin on 2017/4/1.
 */
public class MineVIewTestActivity extends AppCompatActivity {

    private MineView mineMine1;
    private MineView mineMine2;
    private MineView mineMine3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_test);
        initView();
        mineMine1.setMineTitle("陈锐是");
        mineMine2.setMineTitle("纱布");
        mineMine3.setMineTitle("?");
    }

    private void initView() {
        mineMine1 = (MineView) findViewById(R.id.mine_mine1);
        mineMine2 = (MineView) findViewById(R.id.mine_mine2);
        mineMine3 = (MineView) findViewById(R.id.mine_mine3);
    }
}
