package com.cap.admin.secondpractice.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.cap.admin.secondpractice.Adapter.RecyleViewTestAdapter;
import com.cap.admin.secondpractice.R;
import com.yalantis.phoenix.PullToRefreshView;
import com.zhy.changeskin.SkinManager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2017/1/3
 */
public class RecyleViewTest extends AppCompatActivity {
    RecyclerView rv;
    RecyleViewTestAdapter rvta;
    ArrayList<String> list;
    int count;
    PullToRefreshView mPullToRefreshView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyle_view_test);
        SkinManager.getInstance().register(this);

        rvta=new RecyleViewTestAdapter(this);
        Button button= (Button) findViewById(R.id.change);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkinManager.getInstance().changeSkin("white");

            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SkinManager.getInstance().changeSkin("start");
                return false;
            }
        });

        iniData();
        count=27;
        rv= (RecyclerView) findViewById(R.id.recyle_view_test);
        //布局管理器，瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);//设置布局管理器
        rv.setAdapter(rvta);
        //回调设置监听
        rvta.setOc(oc);
        //加载数据源
        rvta.setList(list);
        rvta.notifyDataSetChanged();

        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    rvta.notifyDataSetChanged();
                    break;
            }

            return false;
        }
    });
    RecyleViewTestAdapter.onClick oc=new RecyleViewTestAdapter.onClick() {
        @Override
        public void onItemClick(int position) {
            //点击添加
            ArrayList<String> a=rvta.getList();
            a.add(position,"这是"+count+"个！");
            count++;
            rvta.setList(a);

            rvta.notifyItemInserted(position);//带动画的刷新
            Timer t=new Timer();
            TimerTask timerTask=new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            };
            t.schedule(timerTask,200);

        }

        @Override
        public void onItemLongClick(int position) {
            //长按删除
            ArrayList<String> a=rvta.getList();
            a.remove(list.get(position));
            rvta.setList(a);

            rvta.notifyItemRemoved(position);//带动画的刷新
            Timer t=new Timer();
            TimerTask timerTask=new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            };
            t.schedule(timerTask,200);
        }
    };

    private void iniData() {
        list=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add("这是"+i+"个");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().unregister(this);
    }
}
