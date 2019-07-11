package com.asuper.outsourcemaster.moduel.home.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shubei on 2017/9/13.
 */

public class ProjectBean {

    /**
     * id : 0003VGQJDD3XX8G8
     * name : 324
     * short : 0003VGQJDD3XX8G8
     * full_status : 未沟通
     * category_1 : {"id":7,"name":"创意设计"}
     * industry_1 : {"id":17,"name":"体育运动"}
     * term : 3
     * create_time : 1504145510
     * budget : 423
     * package_id : 0
     */

    private String id;
    private String name;
    @SerializedName("short")
    private String shortX;
    private String full_status;
    private Category1Bean category_1;
    private Industry1Bean industry_1;
    private int term;
    private int create_time;
    private int budget;
    private int package_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortX() {
        return shortX;
    }

    public void setShortX(String shortX) {
        this.shortX = shortX;
    }

    public String getFull_status() {
        return full_status;
    }

    public void setFull_status(String full_status) {
        this.full_status = full_status;
    }

    public Category1Bean getCategory_1() {
        return category_1;
    }

    public void setCategory_1(Category1Bean category_1) {
        this.category_1 = category_1;
    }

    public Industry1Bean getIndustry_1() {
        return industry_1;
    }

    public void setIndustry_1(Industry1Bean industry_1) {
        this.industry_1 = industry_1;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public static class Category1Bean {
        /**
         * id : 7
         * name : 创意设计
         */

        private int id;
        private String name;

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

    public static class Industry1Bean {
        /**
         * id : 17
         * name : 体育运动
         */

        private int id;
        private String name;

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
}
