package com.asuper.outsourcemaster.moduel.home.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shubei on 2017/9/21.
 */

public class ProjectDetailBean {


    /**
     * id : 0002SJPCKCBX8O4G
     * short : 0002SJPCKCBX8O4G
     * name : V5咯了
     * full_status : 100
     * category_1 : {"id":3,"name":"微信开发"}
     * category_2 : null
     * category_3 : null
     * industry_1 : {"id":5,"name":"专科门户"}
     * industry_2 : null
     * industry_3 : null
     * demo_website : 屠龙xxxl
     * service_type : 0
     * tech_stack1 : []
     * db :
     * front_description : null
     * front_attachment : null
     * bid_status : 0
     * province_id : null
     * city_id : null
     * is_resident : 0
     * is_secret : 0
     * keywords :
     * old_name : V5咯了
     * term : 2
     * create_time : 1505868957
     * budget : 2
     * urgency : 1
     * description : 屠龙悟空
     * use_type_1 : null
     * use_type_2 : null
     * use_type_3 : null
     * manager : {"mobile":"010-57026742","true_name":"正在匹配中"}
     * bid_end_time : 0小时 0分钟
     * package_id : 0
     * status : 未沟通
     */

    private String id;
    @SerializedName("short")
    private String shortX;
    private String name;
    private int full_status;
    private Category1Bean category_1;
    private Object category_2;
    private Object category_3;
    private Industry1Bean industry_1;
    private Object industry_2;
    private Object industry_3;
    private String demo_website;
    private int service_type;
    private String tech_stack1;
    private String db;
    private Object front_description;
    private Object front_attachment;
    private int bid_status;
    private Object province_id;
    private Object city_id;
    private int is_resident;
    private int is_secret;
    private String keywords;
    private String old_name;
    private int term;
    private int create_time;
    private int budget;
    private String urgency;
    private String description;
    private Object use_type_1;
    private Object use_type_2;
    private Object use_type_3;
    private ManagerBean manager;
    private String bid_end_time;
    private int package_id;
    private String status;

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

    public int getFull_status() {
        return full_status;
    }

    public void setFull_status(int full_status) {
        this.full_status = full_status;
    }

    public Category1Bean getCategory_1() {
        return category_1;
    }

    public void setCategory_1(Category1Bean category_1) {
        this.category_1 = category_1;
    }

    public Object getCategory_2() {
        return category_2;
    }

    public void setCategory_2(Object category_2) {
        this.category_2 = category_2;
    }

    public Object getCategory_3() {
        return category_3;
    }

    public void setCategory_3(Object category_3) {
        this.category_3 = category_3;
    }

    public Industry1Bean getIndustry_1() {
        return industry_1;
    }

    public void setIndustry_1(Industry1Bean industry_1) {
        this.industry_1 = industry_1;
    }

    public Object getIndustry_2() {
        return industry_2;
    }

    public void setIndustry_2(Object industry_2) {
        this.industry_2 = industry_2;
    }

    public Object getIndustry_3() {
        return industry_3;
    }

    public void setIndustry_3(Object industry_3) {
        this.industry_3 = industry_3;
    }

    public String getDemo_website() {
        return demo_website;
    }

    public void setDemo_website(String demo_website) {
        this.demo_website = demo_website;
    }

    public int getService_type() {
        return service_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }

    public String getTech_stack1() {
        return tech_stack1;
    }

    public void setTech_stack1(String tech_stack1) {
        this.tech_stack1 = tech_stack1;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public Object getFront_description() {
        return front_description;
    }

    public void setFront_description(Object front_description) {
        this.front_description = front_description;
    }

    public Object getFront_attachment() {
        return front_attachment;
    }

    public void setFront_attachment(Object front_attachment) {
        this.front_attachment = front_attachment;
    }

    public int getBid_status() {
        return bid_status;
    }

    public void setBid_status(int bid_status) {
        this.bid_status = bid_status;
    }

    public Object getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Object province_id) {
        this.province_id = province_id;
    }

    public Object getCity_id() {
        return city_id;
    }

    public void setCity_id(Object city_id) {
        this.city_id = city_id;
    }

    public int getIs_resident() {
        return is_resident;
    }

    public void setIs_resident(int is_resident) {
        this.is_resident = is_resident;
    }

    public int getIs_secret() {
        return is_secret;
    }

    public void setIs_secret(int is_secret) {
        this.is_secret = is_secret;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getOld_name() {
        return old_name;
    }

    public void setOld_name(String old_name) {
        this.old_name = old_name;
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

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getUse_type_1() {
        return use_type_1;
    }

    public void setUse_type_1(Object use_type_1) {
        this.use_type_1 = use_type_1;
    }

    public Object getUse_type_2() {
        return use_type_2;
    }

    public void setUse_type_2(Object use_type_2) {
        this.use_type_2 = use_type_2;
    }

    public Object getUse_type_3() {
        return use_type_3;
    }

    public void setUse_type_3(Object use_type_3) {
        this.use_type_3 = use_type_3;
    }

    public ManagerBean getManager() {
        return manager;
    }

    public void setManager(ManagerBean manager) {
        this.manager = manager;
    }

    public String getBid_end_time() {
        return bid_end_time;
    }

    public void setBid_end_time(String bid_end_time) {
        this.bid_end_time = bid_end_time;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Category1Bean {
        /**
         * id : 3
         * name : 微信开发
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
         * id : 5
         * name : 专科门户
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

    public static class ManagerBean {
        /**
         * mobile : 010-57026742
         * true_name : 正在匹配中
         */

        private String mobile;
        private String true_name;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getTrue_name() {
            return true_name;
        }

        public void setTrue_name(String true_name) {
            this.true_name = true_name;
        }
    }
}
