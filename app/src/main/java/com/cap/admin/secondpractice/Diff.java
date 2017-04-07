package com.cap.admin.secondpractice;

import java.io.Serializable;

/**
 * Created by admin on 2017/3/9.
 */
public class Diff implements Serializable{
    private int id;
    private String name;

    public Diff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Diff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if(o instanceof Diff){
            Diff d= (Diff) o;
            return this.getName().equals(d.getName())&&this.id==d.getId();
        }
        return super.equals(o);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
