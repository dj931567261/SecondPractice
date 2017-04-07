package com.cap.admin.secondpractice.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/3/30.
 */
public class TestFragment extends Fragment {
    String title;

    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test,container,false);
        textView= (TextView) view.findViewById(R.id.test);
        Bundle bundle=getArguments();
        title=bundle.getString("title");
        textView.setText(title);
        return view;
    }
}
