package com.cap.admin.secondpractice.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cap.admin.secondpractice.Diff;
import com.cap.admin.secondpractice.R;
import com.cap.admin.secondpractice.Service.PlayMusicService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 2017/1/28.
 */
public class ServiceTestActivity extends AppCompatActivity {
    private Button playMp3;
    private Button downloadLog;
    private ImageView logImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        initView();
        playMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlay(1);
                Toast.makeText(ServiceTestActivity.this, "!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        playMp3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startPlay(2);
                return false;
            }
        });
        downloadLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlay(3);
                Intent intent=new Intent(ServiceTestActivity.this, PlayMusicService.class);
                stopService(intent);
            }
        });
    }

    private void startPlay(int state) {
        Intent intent=new Intent(this, PlayMusicService.class);
        Bundle bundle=new Bundle();
        bundle.putInt("state",state);
        intent.putExtras(bundle);
        startService(intent);
        String a=" [\n" +
                " { \n" +
                "  \"id\": 100010,\n" +
                "  \"name\": \"Lisa\"\n" +
                " },\n" +
                " { \n" +
                "  \"id\": 100013,\n" +
                "  \"name\": \"Mike\"\n" +
                " },\n" +
                " { \n" +
                "  \"id\": 200014,\n" +
                "  \"name\": \"Alice\"\n" +
                " }\n" +
                "]";
        String b=" [\n" +
                " { \n" +
                "  \"id\": 100009,\n" +
                "  \"name\": \"Bob\"\n" +
                " },\n" +
                " { \n" +
                "  \"id\": 100013,\n" +
                "  \"name\": \"Mike\"\n" +
                " }\n" +
                "]";
        try {
            //调用方法
            DifferentItem(a,b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void DifferentItem(String a,String b) throws JSONException {
        //存不同元素的集合
        ArrayList<Diff> diffs=new ArrayList<>();
        JSONArray ja=new JSONArray(a);
        JSONArray jb=new JSONArray(b);
        //得到集合
        ArrayList<Diff> lista=getList(ja);
        ArrayList<Diff> listb=getList(jb);
        //比较的方法
        compaerItem(lista,listb);
       
    }
    //比较
    private ArrayList<Diff> compaerItem(ArrayList<Diff> a,ArrayList<Diff> b) {
        //存放不同元素的集合
        ArrayList<Diff> differentList=new ArrayList<>();
        //相互遍历，找出不同的袁术
        for(Diff diff:a){
            if(!b.contains(diff)){
                differentList.add(diff);
                Log.i("msg", "compaerItem: "+diff.toString());
            }
        }
        for(Diff diff:b){
            if(!a.contains(diff)&&!differentList.contains(diff)){
                differentList.add(diff);
                Log.i("msg", "compaerItem: "+diff.toString());
            }
        }

        return differentList;
    }

    //获取集合
    private ArrayList<Diff> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Diff> list=new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            //从JSONArray里拿出来
            JSONObject obj= (JSONObject) jsonArray.get(i);
            int id=obj.getInt("id");
            String name=obj.getString("name");
            list.add(new Diff(id,name));
        }
        return list;
    }


    private void initView() {
        playMp3 = (Button) findViewById(R.id.play_mp3);
        downloadLog = (Button) findViewById(R.id.download_log);
        logImg = (ImageView) findViewById(R.id.log_img);
    }
}
