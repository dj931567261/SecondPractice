package com.cap.admin.secondpractice.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cap.admin.secondpractice.MainActivity;
import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2016/12/21.
 */
public class FragmentThree extends Fragment implements MainActivity.AAA{
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frg_three,null);
        tv= (TextView) v.findViewById(R.id.frag_three_tv);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BBB b= (BBB) getActivity();
                b.showTime("QwQ");
            }
        });

    }

    @Override
    public void sss(String str) {
        tv.setText(str);
    }
}
