package com.cap.admin.secondpractice.Service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/2/28.
 */
public class PlayMusicService extends Service {
    public static final String TAG="msg";
    private MediaPlayer mediaPlayer;//音频播放
    int op;
    int state=-1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: onBind");
        return null;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i(TAG, "unbindService: unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: onCreate");
        super.onCreate();
        if(mediaPlayer!=null){
            mediaPlayer=MediaPlayer.create(this, R.raw.silence);
            mediaPlayer.setLooping(false);
            Log.i(TAG, "onCreate: init");

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: onStartCommand");
        if(intent!=null){
            Bundle bundle=intent.getExtras();
            if(bundle!=null){
                op=bundle.getInt("state");
                switch (op){
                    case 1:
                        play();
                        Log.i(TAG, "onStartCommand: play");
                        break;
                    case 2:
                        puse();
                        Log.i(TAG, "onStartCommand: puse");
                        break;
                    case 3:
                        stop();
                        Log.i(TAG, "onStartCommand: stop");
                        break;
                }
            }
            Log.i(TAG, "onStartCommand: "+mediaPlayer.isPlaying());
            
        }
        return START_REDELIVER_INTENT;
    }

    private void stop() {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    private void puse() {
        if(mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }

    private void play() {
        if(mediaPlayer!=null){
            mediaPlayer.start();
        }else {
            mediaPlayer=MediaPlayer.create(this, R.raw.silence);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        }
    }
}
