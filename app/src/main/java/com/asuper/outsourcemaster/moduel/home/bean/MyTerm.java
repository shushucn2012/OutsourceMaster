package com.asuper.outsourcemaster.moduel.home.bean;

/**
 * Created by shubei on 2017/9/14.
 */

public class MyTerm {

    private int id;
    private String name;

    public MyTerm(){

    }

    public MyTerm(int id, String name) {
        this.id = id;
        this.name = name;
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
