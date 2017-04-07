package com.cap.admin.secondpractice.Tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.cap.admin.secondpractice.R;

/**
 * Created by admin on 2017/3/30.
 * 可以滑动删除的listView
 */
public class CustomView extends ListView implements View.OnTouchListener,GestureDetector.OnGestureListener{
    //手势探测器
    private GestureDetector mgd;
    public interface onDeleteLister{
        void Delete(int index);
    }
    //删除监听
    private onDeleteLister onDeleteLister;
    // 删除按钮
    private View mDeleteBtn;
    // 列表项布局
    private ViewGroup mItemLayout;
    // 选择的列表项
    private int mSelectedItem;
    //是否显示删除
    private boolean isDeleteShown;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建手势监听对象
        mgd=new GestureDetector(getContext(),this);
        setOnTouchListener(this);
    }
    //设置删除监听
    public void setOnDeleteListener(onDeleteLister listener){
        this.onDeleteLister=listener;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if(!isDeleteShown){
            mSelectedItem=pointToPosition((int)e.getX(),(int)e.getY());
        }

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //如果删除按钮没有显示并且x的滑动速度大于Y
        if(!isDeleteShown&&Math.abs(velocityX)>velocityY){
            mDeleteBtn= LayoutInflater.from(getContext()).inflate(R.layout.btn_custom,null);

            mDeleteBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemLayout.removeView(mDeleteBtn);
                    mDeleteBtn=null;
                    isDeleteShown=false;
                    onDeleteLister.Delete(mSelectedItem);
                }
            });
            mItemLayout= (ViewGroup) getChildAt(mSelectedItem-getFirstVisiblePosition());

            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);

            mItemLayout.addView(mDeleteBtn,params);
            isDeleteShown=true;

        }
        return false;
    }

    //触摸监听
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(isDeleteShown){
            hideDelete();
            return false;
        }else {
            return mgd.onTouchEvent(event);
        }

    }
    //隐藏删除按钮
    public void hideDelete() {
        mItemLayout.removeView(mDeleteBtn);
        mDeleteBtn=null;
        isDeleteShown=false;
    }
    public boolean isDeleteShown() {
           return isDeleteShown;
    }
}
