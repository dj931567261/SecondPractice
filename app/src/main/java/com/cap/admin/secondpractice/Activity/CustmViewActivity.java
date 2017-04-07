package com.cap.admin.secondpractice.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cap.admin.secondpractice.R;
import com.cap.admin.secondpractice.Tools.CustomView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/30.
 * 滑动删除
 */
public class CustmViewActivity extends AppCompatActivity {
    private CustomView cvCustom;
    private CustomViewAdapter cva;
    //内容
    private List<String> contentList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        initView();
        initContentList();
        cvCustom.setOnDeleteListener(new CustomView.onDeleteLister() {
            @Override
            public void Delete(int index) {
                contentList.remove(index);
                cva.notifyDataSetChanged();
            }
        });
        cva=new CustomViewAdapter(this,0,contentList);
        cvCustom.setAdapter(cva);
    }

    private void initContentList() {
        for (int i = 0; i < 20; i++) {
            contentList.add("内容项" + i);
        }
    }

    @Override
    public void onBackPressed() {
        if(cvCustom.isDeleteShown()){
            cvCustom.hideDelete();
            return;
        }
        super.onBackPressed();
    }

    private void initView() {
        cvCustom = (CustomView) findViewById(R.id.cv_custom);
    }

    class CustomViewAdapter extends ArrayAdapter<String> {

        public CustomViewAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.item_custom_test, null);
            } else {
                view = convertView;
            }
            TextView tv = (TextView) view.findViewById(R.id.custom_tv);
            tv.setText(getItem(position));
            return view;
        }
    }
}
