package com.cap.admin.secondpractice.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.cap.admin.secondpractice.R;
import com.john.waveview.WaveView;

/**
 * Created by admin on 2017/1/9.
 */
public class TextZouMaDengActivity extends AppCompatActivity {
    ProgressBar pro;
    WaveView waveView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_zoumadeng);
        pro= (ProgressBar) findViewById(R.id.pro_test);
        waveView= (WaveView) findViewById(R.id.wave_test);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                while(count<=100){
                    count++;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg=new Message();
                    msg.what=0;
                    msg.obj=count;
                    handler.sendMessage(msg);

                }
            }
        }).start();
    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    int a= (int) msg.obj;
                    pro.setProgress(a);
                    waveView.setProgress(a);
                    break;
            }
            return false;
        }
    });
}
