package com.asuper.outsourcemaster.moduel.login.bean;


import java.io.Serializable;

/**
 * Created by shubei on 2017/6/24.
 */

public class UserBean implements Serializable{


    /**
     * token : 838939af9dbe2f6e2f0ec35aaba3a5cf.247868
     * has_join : 1
     * is_admin : 0
     */
    private String mobile;
    private String token;
    private int has_join;
    private int is_admin;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getHas_join() {
        return has_join;
    }

    public void setHas_join(int has_join) {
        this.has_join = has_join;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
