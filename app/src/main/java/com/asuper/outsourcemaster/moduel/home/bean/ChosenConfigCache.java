package com.asuper.outsourcemaster.moduel.home.bean;

import com.asuper.outsourcemaster.common.tool.ImageManager;

/**
 * Created by shubei on 2017/9/13.
 */

public class ChosenConfigCache {

    private static ChosenConfigCache chosenConfigCache;

    public static ChosenConfigCache getInstance() {
        if (chosenConfigCache == null) {
            chosenConfigCache = new ChosenConfigCache();
        }
        return chosenConfigCache;
    }

    public String package_id;
    public int category_1;
    public int industry_1;
    public int term;
    public int urgency;
    public String budget;
    public String name;
    public String description;
    public String demo_website;

    public void clear() {
        package_id = "";
        category_1 = 0;
        industry_1 = 0;
        term = 0;
        urgency = 0;
        budget = "";
        name = "";
        description = "";
        demo_website = "";
    }

}
