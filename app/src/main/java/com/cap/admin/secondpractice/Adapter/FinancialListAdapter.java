package com.cap.admin.secondpractice.Adapter;
import com.cap.admin.secondpractice.Entity.FinancialItem;
import com.cap.admin.secondpractice.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

/**
 * 购物车listView的适配器
 */
public class FinancialListAdapter extends BaseAdapter {
    Context context;
    ArrayList<FinancialItem> list;
    FinancialListimpl fimpl;//回调的接口

    public FinancialListimpl getFimpl() {
        return fimpl;
    }

    public void setFimpl(FinancialListimpl fimpl) {
        this.fimpl = fimpl;
    }

    /**
     * 适配器的构造函数
     * @param context 上下文对象
     */
    public FinancialListAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public ArrayList<FinancialItem> getList() {
        return list;
    }

    public void setList(ArrayList<FinancialItem> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        FinancialItemViewHolder fvh=null;
        if(view==null){//布局复用
            fvh=new FinancialItemViewHolder();
            //加载布局
            view= LayoutInflater.from(context).inflate(R.layout.list_item,null);
            fvh.ch= (CheckBox) view.findViewById(R.id.list_item_financial_chekbox);
            fvh.img= (ImageView) view.findViewById(R.id.list_item_financial_img);
            fvh.title= (TextView) view.findViewById(R.id.list_item_financial_title_tv);
            fvh.price= (TextView) view.findViewById(R.id.list_item_financial_price_tv);
            fvh.num= (TextView) view.findViewById(R.id.list_item_financial_num_tv);
            fvh.del= (ImageView) view.findViewById(R.id.list_item_financial_del_img);
            view.setTag(fvh);//绑定标签
        }else {
            fvh= (FinancialItemViewHolder) view.getTag();
        }
        FinancialItem fi=list.get(position);
        fvh.title.setText(fi.getFinancialtitle());//加载商品的名字
        fvh.price.setText("￥"+fi.getFinancialprice());//加载商品的价格

        //设置checkBox的监听，防止乱序
        fvh.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).setChoose(isChecked);
            }
        });
        fvh.ch.setChecked(fi.isChoose());//设置checkBox
        fvh.num.setText(fi.getFinancialnum());//设置数量
        //用glide加载图片

        //删除的监听
        fvh.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回调设置监听事件
                fimpl.onClickDelImg(position);
            }
        });


        return view;
    }
    //缓存类
    class FinancialItemViewHolder{
        TextView title,num,price;
        ImageView img,del;
        CheckBox ch;
    }
    /**
     * 回调的接口
     */
    public interface FinancialListimpl{
        void onClickDelImg(int position);
    }
}
