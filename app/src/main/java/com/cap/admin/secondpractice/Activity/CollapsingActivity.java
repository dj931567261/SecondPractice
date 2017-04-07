package com.cap.admin.secondpractice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/1/9.
 */
public class CollapsingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collerlayout_test);
        Toolbar toolbar= (Toolbar) findViewById(R.id.test_bar);
        setSupportActionBar(toolbar);
    }
}
