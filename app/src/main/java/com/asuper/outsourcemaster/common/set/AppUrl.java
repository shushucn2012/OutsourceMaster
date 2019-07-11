package com.asuper.outsourcemaster.common.set;

/**
 * APP通信地址
 *
 * @author super
 */
public class AppUrl {
    /**
     * app通信访问主地址
     */
    public static String host = "";

    public static String releaseHost = "";

    /**
     * app通信访问测试地址
     */
//    public static final String demoHost = "http://101.201.155.117:8677";//测试服务器
    public static final String demoHost = "http://59.110.44.184:8677";

    //public static final String demoHost = "http://www.cs.waibaodashi.com";
    public static final String demoHost_share = "http://www.waibaodashi.com";

    public static final String SHARE_APP_ICON = "http://a3.qpic.cn/psb?/4b8a92ff-3677-40b5-80ba-465cc9ff57bc/CBXG4gVqXhGaKiqYHMD2RkGgLBRTAWX4mXfR6eTYvFQ!/b/dIUBAAAAAAAA&bo=rACsAAAAAAADByI!&rf=viewer_4";


    public static final String package_lists = "/api/package/lists";

    public static final String sendSms = "/api/sendSms";

    public static final String login = "/api/login";

    public static final String project_lists = "/api/project/lists";

    public static final String config = "/api/open/config";

    public static final String store = "/api/project/store";

    public static final String package_detail = "/api/package/detail";

    public static final String project_detail = "/api/project/detail";

    public static final String getCurrentTime = "/api/getCurrentTime";

}
