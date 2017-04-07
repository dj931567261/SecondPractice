package com.cap.admin.secondpractice.Entity;

/**
 * Created by admin on 2016/12/27.
 */
public class ZhaiYAn {

    /**
     * id : 1572
     * taici : 即使无法实现愿望，在某个地方也会有其他小小的幸福，等待著我们吧。
     * cat : a
     * catcn : 动画
     * show : null
     * source : 蜂蜜与四叶草
     */

    private String id;
    private String taici;
    private String cat;
    private String catcn;
    private Object show;
    private String source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaici() {
        return taici;
    }

    public void setTaici(String taici) {
        this.taici = taici;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatcn() {
        return catcn;
    }

    public void setCatcn(String catcn) {
        this.catcn = catcn;
    }

    public Object getShow() {
        return show;
    }

    public void setShow(Object show) {
        this.show = show;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
