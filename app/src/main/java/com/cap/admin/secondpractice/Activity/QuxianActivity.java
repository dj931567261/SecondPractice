package com.cap.admin.secondpractice.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cap.admin.secondpractice.Entity.ChartView;
import com.cap.admin.secondpractice.Entity.CommonChartView;
import com.cap.admin.secondpractice.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2017/1/12.
 */
public class QuxianActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quxian);
        CommonChartView cc= (CommonChartView) findViewById(R.id.common);
        //线颜色
        ArrayList<Integer> lineColor=new ArrayList<>();
        lineColor.add(Color.GREEN);
        cc.setLineColorList(lineColor);
        //
        ArrayList<List<Float>> pointList = new ArrayList<>();
        ArrayList<String> titleXList = new ArrayList<String>();
        List<Float> pointInList = new ArrayList<Float>();
        for (int j = 0; j < 6; j++) {
            Random r = new Random();
            Float z = r.nextFloat()*100;
            pointInList.add(z);
            titleXList.add("1月" + (j+1) + "日");
        }
        pointList.add(pointInList);
        //点位置
        cc.setPointList(pointList);
        //横坐标标题
        cc.setTitleXList(titleXList);


    }
}
