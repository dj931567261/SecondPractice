package com.cap.admin.secondpractice.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cap.admin.secondpractice.MainActivity;
import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2016/12/21.
 */
public class FragmentTest extends Fragment {
    //创建
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("msg", "Fragment绑定");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("msg", "Fragment创建");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_second,null);

        Log.i("msg", "Fragment创建视图");
        btn= (Button) v.findViewById(R.id.frag_second_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);//跳转页面
                //得到绑定的那个activity
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return v;

    }
    Button btn;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("msg", "父Activity创建");
    }
    //启动
    @Override
    public void onStart() {
        super.onStart();
        Log.i("msg", "Fragment启动");
    }
    //运行

    @Override
    public void onResume() {
        super.onResume();
        Log.i("msg", "Fragment运行");
    }
    //暂停

    @Override
    public void onPause() {
        super.onPause();
        Log.i("msg", "Fragment暂停");
    }
    //停止

    @Override
    public void onStop() {
        super.onStop();
        Log.i("msg", "Fragment停止");
    }
    //销毁

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("msg", "Fragment视图销毁");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("msg", "Fragment销毁");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("msg", "Fragment解除绑定");
    }
}
