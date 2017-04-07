package com.cap.admin.secondpractice.Entity;

import java.io.Serializable;

/**
 * 购物车的实体类
 */
public class FinancialItem implements Serializable {
    private String Financialimg;//图片
    private String Financialtitle;//商品名字
    private String Financialprice;//商品价格
    private String Financialnum;//商品数量
    private boolean isChoose;//是否被选中

    public FinancialItem(String financialimg, String financialtitle, String financialprice, String financialnum) {
        Financialimg = financialimg;
        Financialtitle = financialtitle;
        Financialprice = financialprice;
        Financialnum = financialnum;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    @Override
    public String toString() {
        return "FinancialItem{" +
                "Financialimg='" + Financialimg + '\'' +
                ", Financialtitle='" + Financialtitle + '\'' +
                ", Financialprice='" + Financialprice + '\'' +
                ", Financialnum='" + Financialnum + '\'' +
                '}';
    }

    public String getFinancialimg() {
        return Financialimg;
    }

    public void setFinancialimg(String financialimg) {
        Financialimg = financialimg;
    }

    public String getFinancialtitle() {
        return Financialtitle;
    }

    public void setFinancialtitle(String financialtitle) {
        Financialtitle = financialtitle;
    }

    public String getFinancialprice() {
        return Financialprice;
    }

    public void setFinancialprice(String financialprice) {
        Financialprice = financialprice;
    }

    public String getFinancialnum() {
        return Financialnum;
    }

    public void setFinancialnum(String financialnum) {
        Financialnum = financialnum;
    }
}
