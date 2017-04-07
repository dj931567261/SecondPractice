package com.cap.admin.secondpractice.Activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cap.admin.secondpractice.MainActivity;
import com.cap.admin.secondpractice.R;
import com.cap.admin.secondpractice.Tools.ParticleView;

/**
 * Created by admin on 2017/1/9.
 */
public class AnmiTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anmi_test);
        Button button= (Button) findViewById(R.id.anmi_test_btn);
        final ParticleView particleAnimator = new ParticleView(AnmiTestActivity.this,3000);//3000为动画持续时间
        particleAnimator.setOnAnimationListener(new ParticleView.OnAnimationListener() {
            @Override
            public void onAnimationStart(View view,Animator animation) {
                //动画开始
                view.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onAnimationEnd(View view,Animator animation) {
                //动画结束
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                particleAnimator.boom(v);
            }
        });
    }
}
