package com.asuper.outsourcemaster.moduel.home.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shubei on 2017/9/12.
 */

public class SourceBean implements Serializable {


    /**
     * id : 0003BD56FI3PE040
     * short : 0003BD56FI3PE040
     * price : 50000
     * name : 在线考试系统
     * main_pic : http://ohwstz5oc.bkt.clouddn.com/20170729/1928/pic-11_1.jpg
     * summary : 针对各类学校、企事业单位、政府部门和各种培训机构而设计的新一代纯B/S架构的在线考试系统，可实现网上考核和测评、自动评分和阅卷、答卷和成绩管理，智能组卷与随机出题，支持人工录入与纯文本导入。
     */

    private String id;
    @SerializedName("short")
    private String shortX;
    private String price;
    private String name;
    private String main_pic;
    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortX() {
        return shortX;
    }

    public void setShortX(String shortX) {
        this.shortX = shortX;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
