package com.cap.admin.secondpractice.Entity;

import java.util.List;

/**
 * Created by admin on 2017/1/22.
 */
public class Financial {

    /**
     * code : 200
     * data : [{"attr":"蓝色 XL 规格3 ","cart_id":"85","goods_num":"1","title":"测试测试23","goods_id":"108","thumb":"/upload/image/20160409/1460187584000455.jpg","goods_price":"100000","goods_storage":"3099","goods_attr_val_ids":"36,44,49"},{"attr":"黄色 ","cart_id":"87","goods_num":"1","title":"测试无规格转有规格","goods_id":"83","thumb":"/upload/image/20160409/1460187425424719.jpg","goods_price":"20000","goods_storage":"3100","goods_attr_val_ids":"90"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * attr : 蓝色 XL 规格3
         * cart_id : 85
         * goods_num : 1
         * title : 测试测试23
         * goods_id : 108
         * thumb : /upload/image/20160409/1460187584000455.jpg
         * goods_price : 100000
         * goods_storage : 3099
         * goods_attr_val_ids : 36,44,49
         */

        private String attr;
        private String cart_id;
        private String goods_num;
        private String title;
        private String goods_id;
        private String thumb;
        private String goods_price;
        private String goods_storage;
        private String goods_attr_val_ids;

        public String getAttr() {
            return attr;
        }

        public void setAttr(String attr) {
            this.attr = attr;
        }

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_storage() {
            return goods_storage;
        }

        public void setGoods_storage(String goods_storage) {
            this.goods_storage = goods_storage;
        }

        public String getGoods_attr_val_ids() {
            return goods_attr_val_ids;
        }

        public void setGoods_attr_val_ids(String goods_attr_val_ids) {
            this.goods_attr_val_ids = goods_attr_val_ids;
        }
    }
}
