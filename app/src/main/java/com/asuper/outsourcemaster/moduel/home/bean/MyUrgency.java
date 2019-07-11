package com.asuper.outsourcemaster.moduel.home.bean;

/**
 * Created by shubei on 2017/9/14.
 */

public class MyUrgency {
    private int id;
    private String name;

    public MyUrgency() {
    }

    public MyUrgency(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
