package com.cap.admin.secondpractice.Tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/4/1.
 */
public class MineView extends LinearLayout {
    //设置标题
    private TextView tv;
    public MineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_mine,this);
        tv= (TextView) findViewById(R.id.tv_title_mine);
    }
    public void setMineTitle(String str){
        if(str!=null){
            tv.setText(str);
        }
    }
}
