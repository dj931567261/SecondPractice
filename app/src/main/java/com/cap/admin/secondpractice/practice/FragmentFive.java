package com.cap.admin.secondpractice.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2016/12/21.
 */
public class FragmentFive extends Fragment {
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frg_three,null);
        tv= (TextView) v.findViewById(R.id.frag_three_tv);
        tv.setText("第三页");
        return v;
    }
}
