package com.cap.admin.secondpractice;

import android.app.Application;

import com.zhy.changeskin.SkinManager;

/**
 * Created by admin on 2017/1/12.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
    }
}
