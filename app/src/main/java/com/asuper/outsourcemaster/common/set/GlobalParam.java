package com.asuper.outsourcemaster.common.set;

import android.os.Environment;

import com.asuper.outsourcemaster.moduel.home.bean.ConfigBean;
import com.asuper.outsourcemaster.moduel.home.bean.MyTerm;
import com.asuper.outsourcemaster.moduel.home.bean.MyUrgency;
import com.asuper.outsourcemaster.moduel.login.bean.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 静态全局参数，变量
 *
 * @author super
 */
public class GlobalParam {

    public static UserBean CurUser;

    public static String userToken;
    /**
     * 系统版本号
     */
    public static int versionCode = 0;
    /**
     * 系统版本名称
     */
    public static String versionName = "";
    /**
     * 系统版本名称
     */
    public static String macAddress;
    /**
     * 客户端当前纬度
     */
    public static double latitude = 0;
    /**
     * 客户端当前经度
     */
    public static double longitude = 0;
    /**
     * 客户端当前定位出的城市名称
     */
    public static String locationCityStr = "武汉";
    /**
     * 客户端当前定位出的区域名称
     */
    public static String locationCountryStr = "武昌区";
    /**
     * 客户端当前用户选择的城市名称
     */
    public static String chooseCityStr = "郑州市";
    /**
     * 客户端当前用户选择的城市数据库编号
     */
    public static String chooseCityCode = "187";
    /**
     * 当前用户信息
     */
//    public static UserBean currentUser;
    /**
     * 请求头x_sign
     */
    public static String x_sign;
    /**
     * tencent appid
     */
    public static final String TENCENT_APP_ID = "101409387";// "222222"1104835049;101409387 1106198344
    /**
     * weixin appid
     */
    public static final String WX_APP_ID = "wxc49c9261e1fb7f90";// 测试：wx9f6a8153fff62089;正式：wx753971e884df0fe0 wx916e2ad3b3a08c7f
    /**
     * weixin AppSecret
     */
    public static final String WX_APP_SECRET = "53239507e762413c3c5b8b5202fa8920";//f7ba5401d15a648788e547ad590e0dc9

    /**
     * 登录类型
     */
    public static int LOGIN_TYPE = 0;// 061区用户登录；1联合登陆

    /**
     * 当前评论条数
     */
    public static int CUR_COMTS_NUM = 0;

    /***
     * 4.4以下(也就是kitkat以下)的版本
     */
    public static final int KITKAT_LESS = 0;
    /***
     * 4.4以上(也就是kitkat以上)的版本,当然也包括最新出的5.0棒棒糖
     */
    public static final int KITKAT_ABOVE = 1;

    /***
     * 裁剪图片成功后返回
     */
    public static final int INTENT_CROP = 2;

    public static String cur_sk_tab = "QUESTION";

    /**
     * 敏感词
     */
    public static List<String> badWordList = new ArrayList<>();

    public static int RefreshRate = 0;

    public static HashMap<Integer, String> termMap = new HashMap<>();

    public static HashMap<Integer, String> urgencyMap = new HashMap<>();
}
