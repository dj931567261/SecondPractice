package com.cap.admin.secondpractice.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cap.admin.secondpractice.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by admin on 2017/1/3.
 */
public class RecyleViewTestAdapter extends RecyclerView.Adapter{
    public static final int TYPE_TOP=0;
    public static final int TYPE_ITEM=1;
    public static final int TYPE_BOTTOM=2;
    Context context;
    ArrayList<String> list;

    public RecyleViewTestAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_ITEM:
                View view= LayoutInflater.from(context).inflate(R.layout.item_recyle_view,null);
                MyViewHolder mvh=new MyViewHolder(view);
                return mvh;
            case TYPE_TOP:
                View view1= LayoutInflater.from(context).inflate(R.layout.item_head,null);
                MyViewHolderHead mvh1=new MyViewHolderHead(view1);
                return mvh1;
            case TYPE_BOTTOM:
                View view2= LayoutInflater.from(context).inflate(R.layout.item_bottom,null);
                MyViewHolderBottom mvh2=new MyViewHolderBottom(view2);
                return mvh2;
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_TOP;
        }else if(position==list.size()+1){
            return TYPE_BOTTOM;
        }
        return TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyViewHolder){
            //瀑布流必须设置item的宽高，随机的
            int width=300;
            int height=new Random().nextInt(300)+300;
            //设置宽高
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(width,height);
            holder.itemView.setLayoutParams(lp);
            ((MyViewHolder) holder).tv.setText(list.get(position-1));

            if(oc!=null){
                //回调实现点击和长按
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oc.onItemClick(position-1);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        oc.onItemLongClick(position-1);
                        return true;
                    }
                });
            }

        }else if(holder instanceof MyViewHolderHead){
            ((MyViewHolderHead) holder).tv.setText("This is Head");
        }else if(holder instanceof  MyViewHolderBottom){
            ((MyViewHolderBottom) holder).tv.setText("This is Bottom");
        }




    }

    @Override
    public int getItemCount() {
        return list.size()+2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.recyle_view_test_tv);
        }
    }
    class MyViewHolderHead extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolderHead(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.recyle_view_test_tv_head);
        }
    }
    class MyViewHolderBottom extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolderBottom(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.recyle_view_test_tv_bottom);
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    //回调接口
    onClick oc;

    public onClick getOc() {
        return oc;
    }

    public void setOc(onClick oc) {
        this.oc = oc;
    }



    public interface onClick{
        void onItemClick(int position);
        void onItemLongClick(int position);
    }
}
