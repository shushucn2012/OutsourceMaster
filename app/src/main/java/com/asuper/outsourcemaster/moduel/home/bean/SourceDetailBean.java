package com.asuper.outsourcemaster.moduel.home.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shubei on 2017/9/20.
 */

public class SourceDetailBean {


    /**
     * id : 0001F80S110WTMD4
     * short : 0001F80S110WTMD4
     * name : 互联网产品UI设计
     * type : 8
     * title :
     * industry : 5
     * kind : 0
     * tags :
     * price : 99
     * view_count : 2776
     * down_count : 0
     * summary : 外包大师更专业，更懂你的UI设计服务已上线。覆盖全行业设计，更有三种方案提供选择。
     * intro : <p><img alt="UI设计.001.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f74417fc84.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.002.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f7441a04e5.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.003.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f74415fb4e.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.004.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f7441e034a.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.005.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f744229d12.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.006.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592f74426b52b.png?imageView2/0/w/1600" width="1600" height="900"/><img alt="UI设计.008.png" src="http://ohwstz5oc.bkt.clouddn.com/20170601/592fe30bc9637.png?imageView2/0/w/1600" width="1600" height="667"/><br/></p>
     * status : 0
     * is_index_show : 1
     * main_pic : http://ohwstz5oc.bkt.clouddn.com/20170601/1020/pic-cover.png
     * pic1 : http://ohwstz5oc.bkt.clouddn.com/20170601/1020/pic-1.png
     * pic2 : http://ohwstz5oc.bkt.clouddn.com/20170601/1020/pic-2.png
     * pic3 : http://ohwstz5oc.bkt.clouddn.com/20170601/1020/pic-3.png
     * listorder : 99
     * create_time : 1496283644
     * update_time : 1503454485
     */

    private String id;
    @SerializedName("short")
    private String shortX;
    private String name;
    private int type;
    private String title;
    private int industry;
    private int kind;
    private String tags;
    private String price;
    private int view_count;
    private int down_count;
    private String summary;
    private String intro;
    private int status;
    private int is_index_show;
    private String main_pic;
    private String pic1;
    private String pic2;
    private String pic3;
    private int listorder;
    private int create_time;
    private int update_time;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getDown_count() {
        return down_count;
    }

    public void setDown_count(int down_count) {
        this.down_count = down_count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_index_show() {
        return is_index_show;
    }

    public void setIs_index_show(int is_index_show) {
        this.is_index_show = is_index_show;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public int getListorder() {
        return listorder;
    }

    public void setListorder(int listorder) {
        this.listorder = listorder;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }
}
